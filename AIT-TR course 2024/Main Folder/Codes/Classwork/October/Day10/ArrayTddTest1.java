package Day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTddTest1 {

    ArrayTdd arrayTdd; // определяем конструктор
    int [] array = {10, -10, 20, -15, 45, 7}; // определяем и обозначаем массив чтоб он был виден во всем классе

    @BeforeEach
    void setUp() {
        arrayTdd = new ArrayTdd(array); //вызываем конструктор
    }

    @Test
    void countPositiveTest (){
        int expected = 3; // expected
        int actual = arrayTdd.countPositive(array);

        assertEquals(expected, actual, "Bad result."); // печатает в случае падения теста

    }//end countPositiveTest
}