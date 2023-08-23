package com.example.temporal.workflow;

import com.example.temporal.activity.UserActivity;
import com.example.temporal.model.UserModel;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.testing.TestWorkflowEnvironment;
import io.temporal.worker.Worker;
import io.temporal.workflow.Workflow;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class UserWorkflowImplTest {

    private TestWorkflowEnvironment testEnv;


    private Worker worker;

    private WorkflowClient client;



    @Before
    public void setUp(){
        testEnv = TestWorkflowEnvironment.newInstance();
        worker = testEnv.newWorker("123");
        worker.registerWorkflowImplementationTypes(UserWorkflowImpl.class);
        client = testEnv.getWorkflowClient();
    }


    @After
    public void tearDown(){
        testEnv.close();
    }

    @Test
    public void testMockedflow(){
        UserActivity userActivity = Mockito.mock(UserActivity.class,Mockito.withSettings().withoutAnnotations());
        UserModel userModel = new UserModel();
        userModel.setId("Ashish");
//        Mockito.when(userActivity.greetingActivity("Ashish")).thenReturn("Hello Ashish");
        Mockito.when(userActivity.userGreeting("Ashish")).thenReturn(userModel);
        Mockito.when(userActivity.conveyGreeting(userModel)).thenReturn("Hello Ashish");
        worker.registerActivitiesImplementations(userActivity);
        testEnv.start();
        UserWorkflow workflow = client.newWorkflowStub(
                UserWorkflow.class, WorkflowOptions.newBuilder().setTaskQueue("123").build()
        );
        String greeting = workflow.userGreeting("Ashish");
        assertEquals("Hello Ashish",greeting);
    }

}