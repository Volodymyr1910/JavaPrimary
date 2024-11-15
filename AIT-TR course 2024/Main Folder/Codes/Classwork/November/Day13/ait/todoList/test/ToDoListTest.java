package Day13.ait.todoList.test;
import Day13.ait.todoList.dao.ToDoList;
import Day13.ait.todoList.dao.ToDoListImpl;
import Day13.ait.todoList.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListImplTest {

    ToDoList toDoList;
    LocalDate now = LocalDate.now();

    //тестовый набор данных
    @BeforeEach
    void setUp() {

        toDoList = new ToDoListImpl();
        toDoList.addTask(new Task("Do HomeWork" , now.minusDays(2)));
        toDoList.addTask(new Task("Buy products" , now.minusDays(1)));
        toDoList.addTask(new Task("Walk with pets" , now.minusDays(3)));

        System.out.println(toDoList);

    }

    @Test
    void addTask() {
        // try to add null
        assertFalse(toDoList.addTask(null));
        // try to add duplicate
        assertFalse(toDoList.addTask(new Task("Do HomeWork" , now.minusDays(2))));
        // add new task
        assertTrue(toDoList.addTask(new Task("Clean" , now.minusDays(1))));
        assertEquals(4, toDoList.quantity());

    }//end addTask

    @Test
    void removeTask() {
        toDoList.removeTask(1);
        assertEquals(2, toDoList.quantity());
        toDoList.viewTasks();
    }

    @Test
    void viewTasks() {
        toDoList.viewTasks();
    }

    @Test
    void getAllTasks() {
        //toDoList.getAllTasks();
        toDoList.viewTasks();
    }//end getAllTasks

    @Test
    void quantity() {
        assertEquals(3, toDoList.quantity());
    }//end quantity
}//end class