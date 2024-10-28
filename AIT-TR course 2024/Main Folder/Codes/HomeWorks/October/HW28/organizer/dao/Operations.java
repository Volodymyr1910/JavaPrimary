package HW28.organizer.dao;

import HW28.organizer.model.Task;

public interface Operations {

    boolean addNewtask();

    boolean removeTask();

    Task[] findTaskByReadyDate(String readyDate);

    Task findTaskByNumber(String readyDate);

    boolean updateTask(int num);

    void printTasks();

    int quantity();

}// end interface
