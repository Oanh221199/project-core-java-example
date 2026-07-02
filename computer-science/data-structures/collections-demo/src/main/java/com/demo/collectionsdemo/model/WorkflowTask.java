package com.demo.collectionsdemo.model;

public class WorkflowTask {

    private String taskName;

    public WorkflowTask(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public String toString() {
        return taskName;
    }
}