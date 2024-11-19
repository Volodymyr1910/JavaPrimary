package MyMethods.work_with_TimeAPI.time.test;

import MyMethods.work_with_TimeAPI.time.utils.DateOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DateOperatiomTest {

    @Test
    void getAge() {
        assertEquals(63, DateOperation.getAge("12/04/1961"));
        assertEquals(62, DateOperation.getAge("1961-11-28"));
    }




    @Test
    void sortStringDates() {
        String[] dates = {"2000-12-01", "10/12/2000", "1970-08-12", "2010-10-05"};
        String[] actual = DateOperation.sortStringDates(dates);
        String[] expected = {"1970-08-12", "2000-12-01", "10/12/2000", "2010-10-05"};
        assertArrayEquals(expected, actual);
    }



}//end class




