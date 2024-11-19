package HW28.organizer.dao;

import HW28.organizer.model.Task;

public interface Operations {

    void addNewtask();

    void removeTask();

    Task[] findTaskByReadyDate();

    Task findTaskByNumber();

    void updateTask();

    void printTasks();

    int quantity();

}// end interface
