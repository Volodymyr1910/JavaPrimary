package Day13.ait.todoList.dao;

import Day13.ait.todoList.model.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ToDoListImpl implements ToDoList {

    //хранилище
    private List <Task> tasks;
    private int quantity;

    private LocalDate time;


    public ToDoListImpl() {
        this.tasks = new ArrayList<>(); // резиновый список, контроль количества не нужен
        this.quantity = 0;
    }

    @Override
    public boolean addTask(Task task) {
        if(task == null || tasks.contains(task)) {
            return false;
        }//end if
        tasks.add(task); // add из класса ArrayList
        quantity = tasks.size();
        return true;
    }//end addTask

    @Override
    public Task removeTask(int taskNumber) {
        if(taskNumber >= 1 && taskNumber <= quantity) {
            Task victim = tasks.get(taskNumber - 1);
            tasks.remove(victim);
            System.out.println("Task : " + victim.getTask() + " is removed !");
            quantity = tasks.size();
            //quantity--;
            return victim;
        }
        System.out.println("Wrong number od Task.");
        return null;
    }//end removeTask

    @Override
    public void viewTasks() {
        IntStream.range(0, tasks.size())
                .forEach(i -> System.out.println((i + 1) + ". " + tasks.get(i)));

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        /*
        for (Task t : tasks) {
            System.out.println(t);
        }//end for */
    }//end viewTasks

    @Override
    public List<Task> getAllTasks() {
        return tasks.stream().toList();
    }//end getAllTasks

    @Override
    public int quantity() {
        return quantity;
    }//end quantity
}//end class
