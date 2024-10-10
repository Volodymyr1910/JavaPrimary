package MyMethods.array_methods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMethodsTest {

    ArrayMethods arrayMethods;
    int array [] = {13, 25, 8, 0, -3, 50, 24, -18};


    @BeforeEach
    void setUp() {
        arrayMethods = new ArrayMethods();
    }

    @Test
    void minElementInArayTest() {
        int expected = -18;
        int actual = ArrayMethods.MinElementInAray(array);

        assertEquals(expected, actual, "Method Failed");
    }

    @Test
    void maxElementInAray() {
        int expected = 50;
        int actual = ArrayMethods.MaxElementInAray(array);

        assertEquals(expected, actual, "Method Failed");
    }

    @Test
    void indexOfMinElementInAray() {
        int expected = 7;
        int actual = ArrayMethods.indexOfMinElementInAray(array);

        assertEquals(expected, actual, "Method Failed");
    }

    @Test
    void indexOfMaxElementInAray() {
        int expected = 5;
        int actual = ArrayMethods.indexOfMaxElementInAray(array);

        assertEquals(expected, actual, "Method Failed");

    }


}//end class


