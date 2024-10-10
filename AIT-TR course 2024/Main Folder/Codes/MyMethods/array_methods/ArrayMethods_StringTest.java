package MyMethods.array_methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMethods_StringTest {

    @Test
    void howMuchLettersInArrayTest() {
        String str = "123  --- fghas !";
        String strArray [] = str.split("");
        int expected = 5;
        int actual = ArrayMethods_String.howMuchLettersInArray(strArray);

        assertEquals(expected, actual, "Method Failed !");
    }



}//end class