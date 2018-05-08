package com.example.gradledemo.Domain;

import javax.persistence.*;

@Entity
@Table(name = "not_followingIds")
public class NotFollowing {

    @Id
    @GeneratedValue( strategy =  GenerationType.AUTO)
    private  Integer id;

    @Column(name = "relational_user_id" )
    private Long relationalUserId;

    @Column(name = "user_id" )
    private Long userId;

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




}
