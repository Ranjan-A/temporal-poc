package com.example.temporal.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface UserWorkflow {

    @WorkflowMethod
    String userGreeting(String name);
}
