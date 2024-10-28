package HW28.organizer.dao;

import HW28.organizer.model.Organizer;
import HW28.organizer.model.Task;

import java.util.Arrays;
import java.util.Scanner;

public class YourOrganizer implements Operations {


    Task [] tasks;
    int size;


    public YourOrganizer(int capasity) {
        this.tasks = new Task [capasity];
        this.size = size;
    }

    public void mainMenu() {

        System.out.println("Hi, Cap !");
        Organizer book[] = Organizer.values();
        boolean checker = true;

        while (checker) {
            System.out.println("How can I help?");
            Organizer.printMenu();
            Scanner scanner = new Scanner(System.in);
            int actionNum = scanner.nextInt();


            switch (actionNum) {
                case 1 -> {
                    System.out.println(actionNum + ". " + book[actionNum - 1].getAction() + " Good ! I'm ready:");
                    addNewtask();
                }
                case 2 -> {
                    System.out.println(actionNum + ". " + book[actionNum - 1].getAction() + " Forgott something? Here is all your notifications:");
                    printTasks();
                }

                case 3 -> {
                    System.out.println(actionNum + ". " + book[actionNum - 1].getAction() + "Allready done task ? What's the number ?");
                    removeTask();
                }
                case 4 -> {
                    checker = false;
                    System.out.println("Whait for you later. Bye !");
                }
                default -> System.out.println("I'm sorry, don't understand you.");

            }//end actionNum
        }//end while checker

    }//end mainMenu

    @Override
    public boolean addNewtask() {
        Scanner scanner = new Scanner(System.in);
        String task = scanner.nextLine();
        if (task == null) return false;
        System.out.println("You have add the new task.");
        System.out.println("When it must be funished?");
        String finishdate = scanner.nextLine();
        //номер заметки проставляется автоматически, таким образом создавая сортировку в процессе добавления заметок
        int taskNum = size+1;
        tasks[size] = new Task(taskNum, task, finishdate);
        System.out.println(tasks[size] + "  Added !");
        size++;
        return true;
    }//addNewtask

    @Override
    public boolean removeTask() {
        Scanner scanner = new Scanner(System.in);
        int taskToRemove = scanner.nextInt();
        // перед каждым удалением заметки, массив сортируется по умолчанию
        Arrays.sort(tasks);
        for (int i = 0; i < size; i++) {
            if(tasks[i].getNumOfTask() == taskToRemove){
                System.out.println("Task is deleted: " + tasks[i]);

                // здесь всем заметкам - которые в списке после той, что выбрана на удаление,-  меняется NumOfTask
                for (int j = i + 1; j < size; j++) {
                    tasks[j].setNumOfTask((tasks[j].getNumOfTask()) - 1);
                }//end for

                // непосредственно удаление, и зачистка массива
                System.arraycopy(tasks, i + 1, tasks, i, size - i - 1);
                tasks[size--] = null;
                return true;
            }//end if
        }//end for
        return false;
    }//end removeTask

    @Override
    public Task[] findTaskByReadyDate(String readyDate) {
        return new Task[0];
    }

    @Override
    public Task findTaskByNumber(String readyDate) {
        return null;
    }

    @Override
    public boolean updateTask(int num) {
        return false;
    }

    public void printTasks() {
        if(size == 0) System.out.println("no notifications yet...");
        for (int i = 0; i < size; i++) {
            System.out.println(tasks[i]);
        }//end for
        System.out.println();
    }//end printTasks


    public int quantity() {
        return size;
    }

}//end class
