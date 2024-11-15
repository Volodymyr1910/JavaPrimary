package my_projects.organizer.controller;

import MyMethods.array_methods.ArrayMethods_Object;
import my_projects.organizer.dao.Operations;
import my_projects.organizer.model.Organizer;
import my_projects.organizer.model.Task;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Predicate;

public class YourOrganizer implements Operations, Serializable {
    //Scanner scanner = new Scanner(System.in);

    Task[] tasks;
    int size;


    public YourOrganizer(int capasity) {
        this.tasks = new Task[capasity];
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
                    System.out.println(actionNum + ". " + book[actionNum - 1].getAction() + "Enter the note number, you want to update:");
                    updateTask();
                }
                case 5 -> {
                    System.out.println(actionNum + ". " + book[actionNum - 1].getAction() + " Enter the note number, you need:");
                    Task temp = findTaskByNumber();
                    if (temp != null) {System.out.println(temp); System.out.println();}
                    else System.out.println("No notifications with your number!");
                }
                case 6 -> {
                    System.out.println(actionNum + ". " + book[actionNum - 1].getAction() + " What date are you looking for?");
                    //Task temp [] = new Task[size];
                    //temp = findTaskByReadyDate();
                    Task temp [] = findTaskByReadyDate();
                    if (temp != null) {
                        System.out.println("All notes with your searched date:");
                        Arrays.stream(temp).forEach(task -> System.out.println(task));
                        System.out.println();
                    }else System.out.println("No notifications with your date!");
                }

                case 7 -> {
                    checker = false;
                    System.out.println("Wait for you later. Bye !");
                }
                default -> System.out.println("I'm sorry, don't understand you.");

            }//end actionNum
        }//end while checker

    }//end mainMenu

    @Override
    public void addNewtask() {
        Scanner scanner = new Scanner(System.in);
        String task = scanner.nextLine();
        if (task.length() == 0) {
            System.out.println("Task is empty, but you can write it later.");
            task = "<task isn't defined>";
        } else System.out.println("You have add the new task.");
        System.out.println("When it must be finished?");
        String finishdate = scanner.nextLine();
        System.out.println();
        if (task.equals("<task isn't defined>") && finishdate.length() == 0) {
            System.out.println("Empty notes can't be saved!");
            return;
        }//end if
        if (finishdate.length() == 0) {
            System.out.println("Finish date is empty, but you can write it later.");
            finishdate = "<date isn't defined>";
        }//end if
        //номер заметки проставляется автоматически, таким образом создавая сортировку в процессе добавления заметок
        if(size > 0) {
            for (int i = 0; i < size; i++) {
                if(tasks[i].getTask().equals(task) && tasks[i].getWhenMustBeReady().equals(finishdate)) {
                    System.out.println("You already have such a notification !");
                    return;
                }//end if
            }//end for
            /*for (Task i : tasks) {
                if (i.getTask().equals(task) && i.getWhenMustBeReady().equals(finishdate)) {
                    System.out.println("You already have such a notification !");
                    return;
                }
            }*/
            /*Iterator<Task> iterator = Arrays.stream(tasks).iterator();
            while (iterator.hasNext()) {
                Task t = iterator.next();
                if (t.getTask().equals(task) && t.getWhenMustBeReady().equals(finishdate)) {
                    System.out.println("You already have such a notification !");
                    return;
                }//end if
            }//end while */
        }//end if
        int taskNum = size + 1;
        tasks[size] = new Task(taskNum, task, finishdate);
        System.out.println(tasks[size++] + "  Added !");

        //size++;
    }//addNewtask

    @Override
    public void removeTask() {
        Scanner scanner = new Scanner(System.in);
        int taskToRemove = scanner.nextInt();
        if (taskToRemove <= 0 || taskToRemove > tasks.length) {
            System.out.println("Number is not correct!");
            return;
        }
        // перед каждым удалением заметки, массив сортируется по умолчанию
        //Arrays.sort(tasks);
        for (int i = 0; i < size; i++) {
            if (tasks[i].getNumOfTask() == taskToRemove) {
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
        //System.out.println();
        String readyDate = scanner.nextLine();
        if (!readyDate.isEmpty()) return findArrayByPredicate(tasks -> tasks.getWhenMustBeReady().equals(readyDate));
        else return null;
    }// end findTaskByReadyDate

    @Override
    public Task findTaskByNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number > 0 && number < size) return findByPredicate(tasks -> tasks.getNumOfTask() == number);
        else return null;
    }//end findTaskByNumber

    @Override
    public void updateTask() {
        boolean f = false;
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            if (tasks[i].getNumOfTask() == num) {
                int ch = 0;
                do {
                    System.out.println("1 - update task; 2 - for update finish date; 3 - for update all; 4 - cancel.");
                    ch = scanner.nextInt();
                    switch (ch) {
                        case 1 -> {
                            scanner.nextLine();
                            System.out.println("Your task: " + tasks[i] + ".");
                            System.out.println(" Input new task data:");
                            tasks[i].setTask(scanner.nextLine());
                            System.out.println();
                            System.out.println("Update task complete.");
                        } //ch != 1 || ch != 2 || ch !=3
                        case 2 -> {
                            scanner.nextLine();
                            System.out.println("Your task: " + tasks[i] + ".");
                            System.out.println(" Input new finish date:");
                            tasks[i].setWhenMustBeReady(scanner.nextLine());
                            System.out.println();
                            System.out.println("Update finish date complete.");
                        }
                        case 3 -> {
                            scanner.nextLine();
                            System.out.println("Your task: " + tasks[i] + ".");
                            System.out.println(" Input new task data:");
                            tasks[i].setTask(scanner.nextLine());
                            System.out.println();
                            System.out.println("Update task complete.");
                            //scanner.nextLine();
                            System.out.println("Your task: " + tasks[i] + ".");
                            System.out.println(" Input new finish date:");
                            tasks[i].setWhenMustBeReady(scanner.nextLine());
                            System.out.println();
                            System.out.println("Update finish date complete.");
                        }
                        case 4 -> System.out.println("You can make changes later.");
                        default -> System.out.println("Wrong choise. Try again, please.");
                    }//end if
                } while (ch > 0 && ch < 4);//end while
                i = size;
                f = true;
            }//end if
        }if (f == false)System.out.println("No notifications with your number!");
    }//end updateTask

    public void printTasks() {
        if (size == 0) System.out.println("no notifications yet...");
        for (int i = 0; i < size; i++) {
            System.out.println(tasks[i]);
        }//end for
        System.out.println();
    }//end printTasks


    public int quantity() {
        return size;
    }//end quantity

    public Task findByPredicate(Predicate<Task> pred) {
        Task thisTask = null;
        for (int i = 0; i < size; i++) {
            if (pred.test(tasks[i])) {
                thisTask = tasks[i];
            }//end if
        }//end for
        return thisTask;
    }//end findByPredicate

    public Task[] findArrayByPredicate(Predicate<Task> pred) {
        int j = 0;
        Task thisTask[] = new Task[size];
        for (int i = 0; i < size; i++) {
            if ( tasks[i] != null && pred.test(tasks[i])) {
                thisTask[j++] = tasks[i];
            }//end if
        }//end for
        return Arrays.copyOf(thisTask, j);
    }//end findByPredicate

    public static YourOrganizer loadOrganizer() {
        File file = new File("my_notes.dat");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                System.out.println("Load Data from storage...");
                return (YourOrganizer) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading data: " + e.getMessage());
            }
        }
        // Если файла не существует
        System.out.println("Create new organizer...");
        return new YourOrganizer(1000);
    }

    public static void saveOrganizer(YourOrganizer note) {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("my_notes.dat"))) {
            System.out.println("Saving data to storage...");
            ous.writeObject(note);
        } catch (IOException e) {
            System.out.println("Error while saving data: " + e.getMessage());
        }
    }




}//end class
