package com.example.firebasetest;

public class User {
    private String name;
    private String role;
    public User(){}

    public User(String email, String role){
        this.name=name;
        this.role=role;
    }

    public String getRole(){
        return  role;
    }

    public String getName(){
        return  name;
    }

    public String setRole(){
        return this.role = role;
    }

    public String setName(){
        return this.name = name;
    }
}

