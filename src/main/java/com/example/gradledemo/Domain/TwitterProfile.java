package com.example.gradledemo.Domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "twitter_profile")
public class TwitterProfile {

    @Id
    @GeneratedValue( strategy =  GenerationType.AUTO)
    private  Integer id;

    @Column(name = "relational_user_id" )
    private Long relationalUserId;

    @Column(name = "user_id" )
    private Long userId;

    @Column(name = "user_name" )
    private  String username;

    @Column(name = "followers" )
    private Integer followers;

    @Column(name = "following" )
    private Integer following;

    @Column(name = "tweets_total" )
    private Integer tweetsTotal;

    @Column(name = "last_tweet_date" )
    private Date lastTweetDate;

    @Column(name = "retweet_total" )
    private Integer retweetTotal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getRelationalUserId() {
        return relationalUserId;
    }

    public void setRelationalUserId(Long relationalUserId) {
        this.relationalUserId = relationalUserId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    public Integer getTweetsTotal() {
        return tweetsTotal;
    }

    public void setTweetsTotal(Integer tweetsTotal) {
        this.tweetsTotal = tweetsTotal;
    }

    public Date getLastTweetDate() {
        return lastTweetDate;
    }

    public void setLastTweetDate(Date lastTweetDate) {
        this.lastTweetDate = lastTweetDate;
    }

    public Integer getRetweetTotal() {
        return retweetTotal;
    }

    public void setRetweetTotal(Integer retweetTotal) {
        this.retweetTotal = retweetTotal;
    }
}
