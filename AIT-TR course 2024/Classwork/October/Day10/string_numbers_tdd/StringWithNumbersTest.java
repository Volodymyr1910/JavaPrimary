package Day10.string_numbers_tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringWithNumbersTest {

    StringWithNumbers stringWithNumbers; // object for testing


    @BeforeEach
    void setUp() {
        stringWithNumbers = new StringWithNumbers("123 321 10"); // 454
    }//end setUp

    @Test
    void sumOfNumbersInStringTest() {
        String str = "1 2 1";
        int expected = 4;
        int actual = stringWithNumbers.sumOfNumbersInString(str);
        assertEquals(expected, actual);

    }//end sumOfNumbersInStringTest

}//end class