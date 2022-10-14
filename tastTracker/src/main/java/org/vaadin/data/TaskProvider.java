package org.vaadin.data;

import org.vaadin.assignee.Assignee;
import org.vaadin.enums.Priority;
import org.vaadin.reporter.Reporter;
import org.vaadin.work.Task;

import java.util.HashMap;

public class TaskProvider {
    private static HashMap<Integer,Task> taskMap;

    public HashMap<Integer, Task> getTaskMap() {
        return taskMap;
    }

    public static HashMap<Integer,Task> createTaskMap(){
        taskMap = new HashMap<>();
        for(int i=0; i<10; i++){
            Task task = new Task(i, Priority.HIGH,new Assignee(),new Reporter(),"11.11.2022");
            taskMap.put(i,task);
        }
        return taskMap;
    }

}
