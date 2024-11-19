package projectsInProcess.organizer.controller;

import projectsInProcess.organizer.dao.Operations;
import projectsInProcess.organizer.model.Organizer;
import projectsInProcess.organizer.model.Task;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class YourOrganizer implements Operations, Serializable {
    //Scanner scanner = new Scanner(System.in);
    LocalDate now = LocalDate.now();
    public static final String STORAGE = "organizerInProcess.dat";
    // "organizerInProcess.dat"   ------ "organizerInProcess_Alya.dat"
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
                    System.out.println(actionNum + ". " + book[actionNum - 1].getAction() + " Good ! Write the task, please:");
                    addNewtask();
                }
                case 2 -> {
                    System.out.println(actionNum + ". " + book[actionNum - 1].getAction() + " Forgott something? Here is all your notifications:");
                    System.out.println();
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
                    if (temp != null) {
                        System.out.println(temp);
                        System.out.println();
                    } else System.out.println("No notifications with your number!");
                }
                case 6 -> {
                    System.out.println(actionNum + ". " + book[actionNum - 1].getAction() + " What date are you looking for?");
                    //Task temp [] = new Task[size];
                    //temp = findTaskByReadyDate();
                    Task temp[] = findTaskByReadyDate();
                    if (temp != null) {
                        System.out.println("All notes with your searched date:");
                        Arrays.stream(temp).forEach(task -> System.out.println(task));
                        System.out.println();
                    } else System.out.println("No notifications with your date!");
                }

                case 7 -> {
                    checker = false;
                    System.out.println("Wait for you later. Bye !");
                }
                default -> System.out.println("I'm sorry, don't understand you.");

            }//end actionNum
        }//end while checker
    }//end mainMenu

    /*
    //мій метод
    @Override
    public void addNewtask() {
        Scanner scanner = new Scanner(System.in);
        String task = scanner.nextLine();
        if (task.length() == 0) {
            System.out.println("Task is empty, but you can write it later.");
            task = "<   no task   >";
        } else System.out.println("You have add the new task.");
        String s;
        do {
            System.out.println("Do you want to input finish date? y/n :");
            s = scanner.nextLine();
        } while (!(s.equals("y") || s.equals("n")));
        LocalDate finishdate = null;
        if (task.equals("<   no task   >") && s.equals("n")) {
            System.out.println("Notes, without task and finish date, can't be saved!");
            return;
        } else if (s.equals("y")) {
            finishdate = dateFromUserToSystem();
            System.out.println("Finish date added!");
        }//end else-if
        System.out.println("Input topic of your note (by default: <   no topic   >) :");
        String topic = scanner.nextLine();
        if (topic.isEmpty()) topic = "<   no topic   >";
        do {
            System.out.println("Is your note burning? y/n :");
            s = scanner.nextLine();
        } while (!(s.equals("y") || s.equals("n")));
        boolean burn = false;
        if (s.equals("y")) burn = true;
        int n;
        do {
            System.out.println("Choose the priority of your task, please (1 - High, 3 - Low, by default - Normal) :");
            n = scanner.nextInt();
        } while (!Character.isDigit(n));
        String priority;
        switch (n){
            case 1 -> priority = "High";
            case 3 -> priority = "Low";
            default -> priority = "Normal";
        }//end switch n
        System.out.println("Input the place of occuerence (by default - <   no place   >) :");
        String occuerencePlace = scanner.nextLine();
        if (occuerencePlace.isEmpty()) occuerencePlace = "<   no place   >";
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (tasks[i].getTask().equals(task) && tasks[i].getWhenMustBeReady().equals(finishdate)) {
                    System.out.println("You already have such a notification !");
                    return;
                }//end if
            }//end for
        }//end if
        // в случае наличия сортировок, сортировать по номеру перед каждым новым добавлением
        //номер заметки проставляется автоматически, таким образом создавая сортировку в процессе добавления заметок
        int taskNum = size + 1;
        tasks[size] = new Task(taskNum, burn, topic, occuerencePlace, priority, finishdate, task, null);
        System.out.println(tasks[size++] + " Added !");
    }//addNewtask */


    //мій метод з поправками чату
    @Override
    public void addNewtask() {
        if (size >= tasks.length) {
            System.out.println("Task list is full. Cannot add more tasks.");
            return;
        }//end if
        Scanner scanner = new Scanner(System.in);
        String task = scanner.nextLine();
        if (task.length() == 0) {
            System.out.println("Task is empty, but you can write it later.");
            task = "<   no task   >";
        } else System.out.println("You have add the new task.");
        String s;
        do {
            System.out.println("Do you want to input finish date? y/n :");
            s = scanner.nextLine();
        } while (!(s.equals("y") || s.equals("n")));
        LocalDate finishdate = null;
        if (task.equals("<   no task   >") && s.equals("n")) {
            System.out.println("Notes, without task and finish date, can't be saved!");
            return;
        } else if (s.equals("y")) {
            finishdate = dateFromUserToSystem();
            System.out.println("Finish date added!");
        }//end else-if
        System.out.println("Input topic of your note (by default: <   no topic   >) :");
        String topic = scanner.nextLine();
        if (topic.isEmpty()) topic = "<   no topic   >";
        do {
            System.out.println("Is your note burning? y/n :");
            s = scanner.nextLine();
        } while (!(s.equals("y") || s.equals("n")));
        boolean burn = false;
        if (s.equals("y")) burn = true;
        //блок вводу і перевірки приоритету
        int n = 0;
        boolean validInput = false;
        do {
            System.out.println("Choose the priority of your task, please (1 - High, 3 - Low, by default - Normal) :");
            String input = scanner.nextLine();
            try {
                n = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (!validInput);
        String priority;
        switch (n){
            case 1 -> priority = "High";
            case 3 -> priority = "Low";
            default -> priority = "Normal";
        }//end switch n


        System.out.println("Input the place of occuerence (by default - <   no place   >) :");
        String occuerencePlace = scanner.nextLine();
        if (occuerencePlace.isEmpty()) occuerencePlace = "<   no place   >";
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (tasks[i].getTask().equals(task) &&
                        ((tasks[i].getWhenMustBeReady() == null && finishdate == null) ||
                                (tasks[i].getWhenMustBeReady() != null && tasks[i].getWhenMustBeReady().equals(finishdate)))) {
                    System.out.println("You already have such a notification !");
                    return;
                }//end if
            }//end for
        }//end if
        // в случае наличия сортировок, сортировать по номеру перед каждым новым добавлением
        //номер заметки проставляется автоматически, таким образом создавая сортировку в процессе добавления заметок
        int taskNum = size + 1;
        tasks[size] = new Task(taskNum, burn, topic, occuerencePlace, priority, finishdate, task, null);
        System.out.println(tasks[size++] + " Added !");
    }//addNewtask

    /*
    //fully copied from chat
    @Override
    public void addNewtask() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the task description:");
        String task = scanner.nextLine();

        if (task.isEmpty()) {
            System.out.println("Task is empty, but you can write it later.");
            task = "<   no task   >";
        } else {
            System.out.println("You have added the new task.");
        }

        String s;
        do {
            System.out.println("Do you want to input finish date? y/n :");
            s = scanner.nextLine();
        } while (!(s.equals("y") || s.equals("n")));

        LocalDate finishdate = null;
        if (task.equals("<   no task   >") && s.equals("n")) {
            System.out.println("Notes without task and finish date can't be saved!");
            return;
        } else if (s.equals("y")) {
            finishdate = dateFromUserToSystem(); // реалізація цього методу важлива
            System.out.println("Finish date added!");
        }

        System.out.println("Input topic of your note (by default: <   no topic   >) :");
        String topic = scanner.nextLine();
        if (topic.isEmpty()) topic = "<   no topic   >";

        do {
            System.out.println("Is your note burning? y/n :");
            s = scanner.nextLine();
        } while (!(s.equals("y") || s.equals("n")));

        boolean burn = s.equals("y");

        int n = 0;
        boolean validInput = false;
        do {
            System.out.println("Choose the priority of your task, please (1 - High, 3 - Low, by default - Normal) :");
            String input = scanner.nextLine();
            try {
                n = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (!validInput);

        String priority;
        switch (n) {
            case 1 -> priority = "High";
            case 3 -> priority = "Low";
            default -> priority = "Normal";
        }

        System.out.println("Input the place of occurrence (by default - <   no place   >) :");
        String occuerencePlace = scanner.nextLine();
        if (occuerencePlace.isEmpty()) occuerencePlace = "<   no place   >";

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (tasks[i].getTask().equals(task) &&
                        ((tasks[i].getWhenMustBeReady() == null && finishdate == null) ||
                                (tasks[i].getWhenMustBeReady() != null && tasks[i].getWhenMustBeReady().equals(finishdate)))) {
                    System.out.println("You already have such a notification!");
                    return;
                }
            }
        }

        if (size >= tasks.length) {
            System.out.println("Task list is full. Cannot add more tasks.");
            return;
        }

        int taskNum = size + 1;
        tasks[size] = new Task(taskNum, burn, topic, occuerencePlace, priority, finishdate, task, null);
        System.out.println(tasks[size++] + " Added!");
    }//end addNewTask */

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


    public void updateTask() {
    }

    ;
    /*
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
    }//end updateTask  */

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
            if (tasks[i] != null && pred.test(tasks[i])) {
                thisTask[j++] = tasks[i];
            }//end if
        }//end for
        return Arrays.copyOf(thisTask, j);
    }//end findByPredicate

    public static YourOrganizer loadOrganizer() {
        File file = new File(STORAGE);
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
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(STORAGE))) {
            System.out.println("Saving data to storage...");
            ous.writeObject(note);
        } catch (IOException e) {
            System.out.println("Error while saving data: " + e.getMessage());
        }
    }


    public LocalDate dateFromUserToSystem() {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = null;
        String dateTemp;
        do {
            System.out.println("Enter the finish date (example 12-12-2022):");
            dateTemp = scanner.nextLine();
            if (!checkDateFormat(dateTemp)) {
                System.out.println("Incorect date format.");
            }//end if
        } while (!checkDateFormat(dateTemp));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("[dd:MM:yyyy][dd/MM/yyyy][dd-MM-yyyy][dd.MM.yyyy][dd,MM,yyyy][dd_MM_yyyy]");
        try {
            date = LocalDate.parse(dateTemp, dtf);
        } catch (
                DateTimeParseException e) {
            System.out.println("Incorrect date format. Please try again.");
        }
        return date;
    }//end dateFromUserToSystem

    public boolean checkDateFormat(String str) {
        // TODO Homework checkDateFormatEU
        return str.matches("((((([0][1-9]|[1-2][0-9]|[3][0-1]))(-|.|/||:|,|_)(12))|(([0][1-9]|[1][0-9]|[2][0-8])(-|.|/||:|,|_)(02))|(([0][1-9]|[1-2][0-9]|30)(-|.|_)((01|[0][3-9]|[1][0-1])|)))(-|.|/||:|,|_)(([0-9][0-9][0-9][1-9]|[0-9][0-9][1-9][0-9]|[0-9][1-9][0-9][0-9]|[1-9][0-9][0-9][0-9])))");
    }//end checkDateFormatEU

}//end class
