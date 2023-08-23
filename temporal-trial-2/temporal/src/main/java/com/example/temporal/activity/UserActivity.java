package com.example.temporal.activity;

import com.example.temporal.model.UserModel;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface UserActivity {

    String greetingActivity(String name);

    UserModel userGreeting(String name);

    String conveyGreeting(UserModel user);

}
