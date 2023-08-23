package com.example.temporal.activity;

import org.springframework.stereotype.Service;

@Service
public class UserAct {

    public String returnGreeting(String name){
        return "Hello "+name;
    }
}
