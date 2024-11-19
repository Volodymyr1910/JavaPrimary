package projectsInProcess.organizer.dao;

import projectsInProcess.organizer.model.Task;

public interface Operations {

    void addNewtask();

    void removeTask();

    Task[] findTaskByReadyDate();

    Task findTaskByNumber();

    void updateTask();

    void printTasks();

    int quantity();

}// end interface
