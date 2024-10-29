package my_projects.organizer.dao;

import my_projects.organizer.model.Task;

public interface Operations {

    void addNewtask();

    void removeTask();

    Task[] findTaskByReadyDate();

    Task findTaskByNumber();

    void updateTask();

    void printTasks();

    int quantity();

}// end interface
