package com.example.temporal.model;

public class UserModel {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + id + '\'' +
                '}';
    }
}
