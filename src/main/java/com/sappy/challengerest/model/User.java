package com.sappy.challengerest.model;

import com.sappy.challengerest.view.UserView;
import lombok.Data;
import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Document(collection = "user")
public class User {

    @JsonView(UserView.Internal.class)
    private @Id String id;
    private int seq;

    @JsonView(UserView.Public.class)
    private String name;
    @JsonView(UserView.Public.class)
    private String role;

    public User(){

    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public User(String id, String name, String role) {
        this.name = name;
        this.id = id;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}