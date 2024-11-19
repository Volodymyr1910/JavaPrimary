package projectsInProcess.organizer.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Task implements  Comparable <Task>, Serializable {
    /*
    private int numOfTask; // автоматически назначается в момент создания, уникальный не повторяется
    private String task;   // все что угодно
    private String whenMustBeReady;  // нужно поменять тип на LocalDate */


    private int numOfTask; // автоматически назначается в момент создания, уникальный не повторяется
    private boolean burn; // горящие true, обычные - false, если не выбрано автоназначение - false
    private String topic;  // при создании заметки прописать тему (String), если не выбрано, автоназначение - <   no topic   >
    private String occuerencePlace; // при создании заметки прописать место событий (String), если не выбрано, автоназначение - <   no place   >
    private String priority; // при создании заметки выбрать 1 - High, 2 - Normal, 3 - Low, если не выбрано автоназначение 2 - Normal
    private LocalDate whenMustBeReady;  // нужно поменять тип на LocalDate
    private String task;   // все что угодно
    private LocalDate creationDate; // автоматически назначается в момент создания

    public Task(int numOfTask, boolean burn, String topic, String occuerencePlace, String priority, LocalDate whenMustBeReady, String task, LocalDate creationDate) {
        this.numOfTask = numOfTask;
        this.burn = burn;
        this.topic = topic;
        this.occuerencePlace = occuerencePlace;
        this.priority = priority;
        this.whenMustBeReady = whenMustBeReady;
        this.task = task;
        this.creationDate = creationDate != null ? creationDate : LocalDate.now();
    }

    public int getNumOfTask() {
        return numOfTask;
    }

    public void setNumOfTask(int numOfTask) {
        this.numOfTask = numOfTask;
    }

    public boolean isBurn() {
        return burn;
    }

    public void setBurn(boolean burn) {
        this.burn = burn;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDate getWhenMustBeReady() {
        return whenMustBeReady;
    }

    public void setWhenMustBeReady(LocalDate whenMustBeReady) {
        this.whenMustBeReady = whenMustBeReady;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getOccuerencePlace() {
        return occuerencePlace;
    }

    public void setOccuerencePlace(String occuerencePlace) {
        this.occuerencePlace = occuerencePlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task1)) return false;
        return Objects.equals(whenMustBeReady, task1.whenMustBeReady) && Objects.equals(task, task1.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(whenMustBeReady, task);
    }

    @Override
    public String toString() {
       // return numOfTask + ". Finish date: " + whenMustBeReady + "; burn: " + burn + " -> " + topic + " <- place: " + occuerencePlace + " ; Note: " + task + ". Priority -> " + priority + " <- created: " + creationDate + ".";
        //return numOfTask + ". burn! -> " + burn + " <- finish date year-month-day: " + whenMustBeReady + "; topic: " + topic + " ; place: " + occuerencePlace + " ; Note: " + task + ". Priority -> " + priority + " <- created: " + creationDate + "." + "\nNote: " + task;
        return numOfTask + ". burn! -> " + burn + " <- finish date year-month-day: " + whenMustBeReady + "; topic: " + topic + " ; place: " + occuerencePlace + " ; Priority -> " + priority + " <- created: " + creationDate + "." + "\nNote: " + task;

    }

    @Override
    public int compareTo(Task o) {
        return this.numOfTask - o.numOfTask;
    }
}//end class


