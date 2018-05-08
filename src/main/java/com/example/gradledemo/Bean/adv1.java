package com.example.gradledemo.Bean;

import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.sql.*;
import java.util.ArrayList;

public class adv1 {

    private Twitter twitter;

    public static void main(String[] args) throws InterruptedException {

        new adv1().initConfiguration();
    }

    private void initConfiguration() {

        ConfigurationBuilder builder = new ConfigurationBuilder();

		/*
		builder.setOAuthConsumerKey("3HU9o1x39HKeFfeazCD22F1no");
		builder.setOAuthConsumerSecret("T5cW4HIg4BhgWvR1Lq6PCo88nW4l1melqlgpYCb1YFmu54fCbd");
		builder.setOAuthAccessToken ("1336510088-I5c4BsEkhIhQMb79PIomoz2arkDlRVTgahIjHz3");
		builder.setOAuthAccessTokenSecret ("5x5HhK0wlfsyfagbyGf0Vrn1rAznt4VykhfDFQR0rLWhF");
		 */

        builder.setOAuthConsumerKey("o6O6riSRmObO7XfyRIeYeZfXN");
        builder.setOAuthConsumerSecret("WXfrHdhfP7bzTOdii0j6sPis5dTVRmv5kNZGjhdlhuXqkRVB2C");
        builder.setOAuthAccessToken("1336510088-CBV8bVmH0bJn0IknRUbXbh6BjLusGJf0tqAbmRW");
        builder.setOAuthAccessTokenSecret("O3JyCqpMOUF76GNXdrLApCHkMkgJ4ogoBUkGrthP20LcT");

        Configuration configuration = builder.build();
        TwitterFactory factory = new TwitterFactory(configuration);
        twitter = factory.getInstance();

        String dbUserName = "root";
        String dbPass = "";
        String host = "127.0.0.1";
        String db = "tw_Bot";
        String port = "3307";

        Connection con = null;

        String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("mysql connector not found");
        }

        try {
            con = DriverManager.getConnection(url, dbUserName, dbPass);

        } catch (SQLException e) {
            System.out.println("sql err: " + e.getMessage());
        }

        if (con != null) {
            System.out.println("success.");
        }

        followReadDb(con);

        // removeNotFollowed( con );

    }

    public void followReadDb(Connection con) {

        System.out.println("followReadDb started.");
        try {
            int i = 0;
            String sql = "SELECT * FROM friends where scanned = 1 and status=0 and unfollowed = 0 limit 500";
            //	sql = "SELECT * FROM friends where scanned = 0 limit 5000";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            boolean isUnf = true;
            while (resultSet.next()) {
                long friendId = resultSet.getLong("friend_id");

                if( isUnf )
                {
                    System.out.println( i +" _userId:" + String.valueOf(friendId) );
                    makeUnfollow (con, friendId );
                    rawUpdated2(friendId , con);  // make unfollowed = 1 on DB
                }
                else{
                    UserTwit userTwit = controlFollow(friendId);
                    rawUpdate(userTwit, con);
                    System.out.println( i +" _usertw:" + userTwit.getId() + " " + userTwit.getStatus() + " " + userTwit.getUsername());
                }
                Thread.sleep(5000);
                i++;
            }
            statement.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("ERROR : followReadDb : " + ex.getMessage());
        }

    }

    public UserTwit controlFollow(long friendId)  {
        UserTwit usertw = new UserTwit();
        try {

            Relationship r = twitter.showFriendship(twitter.getId(), friendId);

            usertw.setId(friendId);
            usertw.setUsername(r.getTargetUserScreenName());

            if (!r.isTargetFollowingSource()) {
                usertw.setStatus(0);
                // twitter.destroyFriendship(friendId); //TODO destroy

            } else {
                usertw.setStatus(1);
            }

        } catch (Exception e) {

            System.out.println("ERROR (id: " + friendId + " ) controlFollow:" + e.getMessage() );
        }
        return usertw;

    }
    public void makeUnfollow(Connection con, long friendId ){

        try {
            twitter.destroyFriendship(friendId);  //make unf

        } catch (Exception e) {

            System.out.println("ERROR (id: " + friendId + " ) controlFollow:" + e.getMessage() );
        }

    }



    public void rawUpdate(UserTwit usertw, Connection con) {

        try {
            String updateQuery = "update friends set status = ? , scanned = ? , username = ?  where friend_id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(updateQuery);
            preparedStmt.setInt   (1, usertw.getStatus() );
            preparedStmt.setInt   (2, 1 );
            preparedStmt.setString(3, usertw.getUsername() );
            preparedStmt.setString(4, String.valueOf( usertw.getId()) );

            System.out.println("updateQuery : " + updateQuery );
            preparedStmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("UPDATE ERROR : " + ex.getMessage());
        }

    }
    public void rawUpdated2(long friendId , Connection con) {

        try {
            String updateQuery = "update friends set unfollowed = ?  where friend_id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(updateQuery);
            preparedStmt.setInt   (1, 1 );
            preparedStmt.setString(2, String.valueOf( friendId) );

            System.out.println("updateQuery : " + updateQuery );
            preparedStmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("UPDATE ERROR : " + ex.getMessage());
        }

    }



    public void insertDb(String friendId, int isStatus, int isScanned,
                         Connection con) {

        try {
            String insertSqlQuery = "insert into friends ( friend_id , status , scanned) values ( '"
                    + friendId + "'," + " 0,0)";
            System.out.println(insertSqlQuery);
            PreparedStatement insertRaw = con.prepareStatement(insertSqlQuery);
            insertRaw.executeUpdate();
        } catch (Exception ex) {
            System.out.println("raw error : " + ex.getMessage());
        }

    }

    private void removeNotFollowed(Connection con) {
        System.out.println("function started.");
        // long[] longIds = null;
        long cursor = -1;
        IDs ids;
        // int unfollowedPeople = 0;
        ArrayList<Long> fullFriendList = new ArrayList<Long>();
        // ArrayList<Long> scannedList = new ArrayList<Long>();

        try {
            do {
                ids = twitter.getFriendsIDs(cursor);

                for (long id : ids.getIDs()) {
                    insertDb(String.valueOf(id), 0, 0, con);
                    fullFriendList.add(id);
                }
            } while ((cursor = ids.getNextCursor()) != 0);
            System.out.println("fullFriendList: " + fullFriendList);

        } catch (TwitterException e) {
            e.printStackTrace();
        }

        System.out.println("Friendships: " + fullFriendList.size());

        /*
         * int k = 0; for (int i = 200; i > 0; i--) { long l = longIds[i];
         * System.out.println(k++); try { Relationship r =
         * twitter.showFriendship(twitter.getId(), l);
         *
         * if (!r.isTargetFollowingSource()) { twitter.destroyFriendship(l);
         * System.out.println("unfollowed : " + l); unfollowedPeople++;
         *
         * System.out.println("Tweeters unfollowed " + unfollowedPeople); } if
         * (r.isTargetFollowingSource() && !r.isSourceFollowingTarget()) {
         * twitter.createFriendship(l); } } catch (IllegalStateException |
         * TwitterException e) { e.printStackTrace(); } }
         */

    }



}