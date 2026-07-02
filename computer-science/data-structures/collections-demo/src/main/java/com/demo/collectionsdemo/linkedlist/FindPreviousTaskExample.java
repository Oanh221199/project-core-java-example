package com.demo.collectionsdemo.linkedlist;

import com.demo.collectionsdemo.model.WorkflowTask;

import java.util.LinkedList;

public class FindPreviousTaskExample {

    public static void main(String[] args) {

        LinkedList<WorkflowTask> workflow = new LinkedList<>();

        workflow.add(new WorkflowTask("Receive"));
        workflow.add(new WorkflowTask("KeyIn"));
        workflow.add(new WorkflowTask("Underwriting"));
        workflow.add(new WorkflowTask("Approval"));
        workflow.add(new WorkflowTask("Issue"));

        String currentTask = "Approval";

        WorkflowTask previousTask = findPreviousTask(workflow, currentTask);

        System.out.println("Current Task : " + currentTask);
        System.out.println("Previous Task: " + previousTask);
    }

    public static WorkflowTask findPreviousTask(
            LinkedList<WorkflowTask> workflow,
            String currentTask) {

        for (int i = 1; i < workflow.size(); i++) {

            if (workflow.get(i).getTaskName().equals(currentTask)) {
                return workflow.get(i - 1);
            }

        }

        return null;
    }
}