package com.example.temporal.workflow;

import com.example.temporal.activity.UserActivity;
import com.example.temporal.model.UserModel;
import io.temporal.activity.ActivityOptions;
import io.temporal.spring.boot.WorkflowImpl;
import io.temporal.workflow.Workflow;

import java.time.Duration;

@WorkflowImpl(taskQueues = "123")
public class UserWorkflowImpl implements UserWorkflow{
    private ActivityOptions options = ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(30))
            .build();

    private UserActivity activity = Workflow.newActivityStub(UserActivity.class,options);
    @Override
    public String userGreeting(String name) {
        String greeting="";
       //String greeting = activity.greetingActivity(name);
        UserModel userModel = activity.userGreeting(name);
        System.out.println(userModel.toString());
        if(userModel.getId()!=null){
            greeting=activity.conveyGreeting(userModel);
        }

       return greeting;
    }
}
