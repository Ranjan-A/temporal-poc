package com.example.temporal.service;

import com.example.temporal.activity.UserActivity;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class TemporalConfig {


    public ActivityOptions activityOptions(){
        return ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(30))
                .build();
    }

    public UserActivity userActivity(){
        return Workflow.newActivityStub(UserActivity.class,this.activityOptions());

    }
}
