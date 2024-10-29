package my_projects.organizer.test;

import my_projects.organizer.controller.YourOrganizer;
import my_projects.organizer.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YourOrganizerTest {
    YourOrganizer notes;
    Task[] tasks;

    @BeforeEach
    void setUp() {
        notes = new YourOrganizer(100);
        tasks = new Task[4];
        tasks[0] = new Task(1, "AAAA", "23.33.100");
        tasks[1] = new Task(2, "BBB", "23.33.200");
        tasks[2] = new Task(3, "CCCC", "23.33.300");
        tasks[3] = new Task(4, "FFF", "23.33.400");

        for (int i = 0; i < 4; i++) {
            notes.addNewtask();
        }

    }//end setup

    @Test
    void mainMenuTest() {
    }//end mainMenuTest

    @Test
    void addNewtaskTest() {
        notes.addNewtask();
        assertEquals(1, notes.quantity());
    }//end addNewtaskTest

    @Test
    void removeTaskTest() {
    }//end removeTaskTest

    @Test
    void findTaskByReadyDateTest() {
    }//end findTaskByReadyDateTest

    @Test
    void findTaskByNumberTest() {
    }//end findTaskByNumberTest

    @Test
    void updateTaskTest() {
    }//end updateTaskTest

    @Test
    void printTasksTest() {
        notes.printTasks();
    }//end printTasksTest

    @Test
    void quantityTest() {
    }//end quantityTest
}