package HW28.weekDay;

import MyMethods.array_methods.ArrayMethods_Object;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static HW28.weekDay.WeekDay.*;

class WeekDayTest {

    @BeforeEach
    void setUp() {
       //WeekDay [] weekD = WeekDay.values();
    }//end setUp

    @Test
    void findNewDayTest() {
       int n = 3;
    WeekDay thisDay = THU;
    WeekDay findThisDay = thisDay.findNewDay(n);
        System.out.println(n + " day after " + thisDay.getName() + " is -> " + findThisDay.getName() + ".");

    }//end findNewDayTest

}//end class