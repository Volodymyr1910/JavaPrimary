package HW28.organizer.controller;

import HW28.organizer.dao.Operations;
import HW28.organizer.model.Organizer;
import HW28.organizer.model.Task;
import MyMethods.array_methods.ArrayMethods_Object;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

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
                    System.out.println(actionNum + ". " + book[actionNum - 1].getAction() + "Changes ?");
                    updateTask();
                }
                case 5 -> {
                    System.out.println(actionNum + ". " + book[actionNum - 1].getAction() + " Let's a look.");
                    System.out.println(findTaskByNumber());
                    System.out.println();
                }
                case 6 -> {
                    System.out.println(actionNum + ". " + book[actionNum - 1].getAction() + " Let's a look.");
                    ArrayMethods_Object.printObjectArray(findTaskByReadyDate()," with your searched date");
                    System.out.println();
                }

                case 7 -> {
                    checker = false;
                    System.out.println("Whait for you later. Bye !");
                }
                default -> System.out.println("I'm sorry, don't understand you.");

            }//end actionNum
        }//end while checker

    }//end mainMenu

    @Override
    public void addNewtask() {
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            if (task == null) System.out.println("Task is empty, but you can write it later.");
            else System.out.println("You have add the new task.");
            System.out.println("When it must be funished?");
            String finishdate = scanner.nextLine();
            //номер заметки проставляется автоматически, таким образом создавая сортировку в процессе добавления заметок
            int taskNum = size+1;
            tasks[size] = new Task(taskNum, task, finishdate);
            System.out.println(tasks[size] + "  Added !");
            size++;
        }//addNewtask

    @Override
    public void removeTask() {
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
                }//end if
            }//end for
        }//end removeTask

    @Override
    public Task[] findTaskByReadyDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        String readyDate = scanner.nextLine();
        return findArrayByPredicate(tasks -> tasks.getWhenMustBeReady().equals(readyDate));
    }// end findTaskByReadyDate

    @Override
    public Task findTaskByNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return findByPredicate(tasks -> tasks.getNumOfTask() == number);
    }//end findTaskByNumber

    @Override
    public void updateTask() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            if(tasks[i].getNumOfTask() == num){
                int ch = 0;
                do{
                    System.out.println("1 - update task; 2 - for update finish date; 3 - for update all; 4 - cancel.");
                    ch = scanner.nextInt();
                    switch (ch){
                        case 1 -> {
                            System.out.println(tasks[i].getTask());
                            tasks[i].setTask(scanner.next());
                            System.out.println();
                            System.out.println("Update task complete.");
                        } //ch != 1 || ch != 2 || ch !=3
                        case 2 -> {
                            System.out.println(tasks[i].getWhenMustBeReady());
                            tasks[i].setWhenMustBeReady(scanner.next());
                            System.out.println();
                            System.out.println("Update finish date complete.");
                        }
                        case 3 -> {
                            System.out.println(tasks[i].getTask());
                            tasks[i].setTask(scanner.next());
                            System.out.println();
                            System.out.println("Update task complete.");
                            System.out.println(tasks[i].getWhenMustBeReady());
                            tasks[i].setWhenMustBeReady(scanner.next());
                            System.out.println();
                            System.out.println("Update finish date complete.");
                        }
                        case 4 ->  System.out.println("You can make changes later.");
                        default -> System.out.println("Wrong choise. Try again, please.");
                    }//end if
                }while (ch > 0 && ch < 4);//end while
                i = size;
            }//end if
        }//end for
    }//end updateTask

    public void printTasks() {
        if(size == 0) System.out.println("no notifications yet...");
        for (int i = 0; i < size; i++) {
            System.out.println(tasks[i]);
        }//end for
        System.out.println();
    }//end printTasks


    public int quantity() {
        return size;
    }//end quantity

    public Task findByPredicate (Predicate <Task> pred){
        Task thisTask = null;
        for (int i = 0; i < size; i++) {
            if(pred.test(tasks[i])){
                thisTask = tasks[i];
            }//end if
        }//end for
        return thisTask;
    }//end findByPredicate

    public Task [] findArrayByPredicate (Predicate <Task> pred){
        int j = 0;
        Task thisTask [] = new Task[tasks.length];
        for (int i = 0; j < size; i++) {
            if(pred.test(tasks[i])){
                thisTask[j++]= tasks[i];
            }//end if
        }//end for
        return Arrays.copyOf(thisTask, j);
    }//end findByPredicate

}//end class
