package com.example.temporal.service;


import com.example.temporal.workflow.UserWorkflow;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    @Autowired
    WorkflowClient workflowClient;

    public String startworkflow(){
        WorkflowOptions options = WorkflowOptions.newBuilder().setTaskQueue("123")
                .setWorkflowId("Case_1").build();
        UserWorkflow workflow =  workflowClient.newWorkflowStub(UserWorkflow.class, options);
        String ashish = "Ashish";
        //WorkflowClient.start(workflow::userGreeting,ashish);
        return workflow.userGreeting(ashish);
        //return "success";
    }
}
