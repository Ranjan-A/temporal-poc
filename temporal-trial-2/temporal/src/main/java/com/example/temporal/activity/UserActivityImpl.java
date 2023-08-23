package com.example.temporal.activity;

import com.example.temporal.model.UserModel;
import io.temporal.spring.boot.ActivityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ActivityImpl(taskQueues = "123")
public class UserActivityImpl implements UserActivity{

    @Autowired
    UserAct userAct;

    @Override
    public String greetingActivity(String name) {
        return userAct.returnGreeting(name);
    }

    @Override
    public UserModel userGreeting(String name) {
        UserModel userModel = new UserModel();
        userModel.setId(name);
        return userModel;
    }

    @Override
    public String conveyGreeting(UserModel user) {
        return "Hello "+user.getId();
    }
}
