package com.example.gradledemo.Domain;

import javax.persistence.*;

@Entity
@Table(name = "connect")
public class Connect {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOAuthConsumerKey() {
        return OAuthConsumerKey;
    }

    public void setOAuthConsumerKey(String OAuthConsumerKey) {
        this.OAuthConsumerKey = OAuthConsumerKey;
    }

    public String getOAuthConsumerSecret() {
        return OAuthConsumerSecret;
    }

    public void setOAuthConsumerSecret(String OAuthConsumerSecret) {
        this.OAuthConsumerSecret = OAuthConsumerSecret;
    }

    public String getOAuthAccessToken() {
        return OAuthAccessToken;
    }

    public void setOAuthAccessToken(String OAuthAccessToken) {
        this.OAuthAccessToken = OAuthAccessToken;
    }

    public String getOAuthAccessTokenSecret() {
        return OAuthAccessTokenSecret;
    }

    public void setOAuthAccessTokenSecret(String OAuthAccessTokenSecret) { this.OAuthAccessTokenSecret = OAuthAccessTokenSecret; }

    public Long getRelationalUserId() { return relationalUserId; }

    public void setRelationalUserId(Long relationalUserId) {  this.relationalUserId = relationalUserId; }

    public String getRelationalUsername() { return relationalUsername; }

    public void setRelationalUsername(String relationalUsername) { this.relationalUsername = relationalUsername; }

    @Column(name = "OAuth_consumer_key")
    private String OAuthConsumerKey;

    @Column(name = "OAuth_consumer_secret")
    private String OAuthConsumerSecret;

    @Column(name = "OAuth_access_token")
    private String OAuthAccessToken;

    @Column(name = "OAuth_access_tokenSecret")
    private String OAuthAccessTokenSecret;

    @Column(name = "relational_user_id")
    private Long relationalUserId;

    @Column(name = "relational_username")
    private String relationalUsername;


}
