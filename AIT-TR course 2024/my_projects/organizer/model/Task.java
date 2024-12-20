package my_projects.organizer.model;

import java.io.Serializable;

public class Task implements  Comparable <Task>, Serializable {

    private int numOfTask;
    private String task;
    private String whenMustBeReady;

    public Task(int numOfTask, String task, String whenMustBeReady) {
        this.numOfTask = numOfTask;
        this.task = task;
        this.whenMustBeReady = whenMustBeReady;
    }

    public int getNumOfTask() {
        return numOfTask;
    }

    public void setNumOfTask(int numOfTask) {
        this.numOfTask = numOfTask;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getWhenMustBeReady() {
        return whenMustBeReady;
    }

    public void setWhenMustBeReady(String whenMustBeReady) {
        this.whenMustBeReady = whenMustBeReady;
    }


    @Override
    public String toString() {
        return "Task " + numOfTask + ". " + task + ". Dedline -> " + whenMustBeReady +".";
    }

    @Override
    public int compareTo(Task o) {
        return this.numOfTask - o.numOfTask;
    }
}//end class


