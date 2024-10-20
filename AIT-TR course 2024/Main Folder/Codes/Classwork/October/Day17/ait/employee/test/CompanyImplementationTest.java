package Day17.ait.employee.test;

import Day17.ait.employee.dao_data_axess_object.Company;
import Day17.ait.employee.dao_data_axess_object.CompanyImplementation;
import Day17.ait.employee.model.Employee;
import Day17.ait.employee.model.Manager;
import Day17.ait.employee.model.SalesManager;
import Day17.ait.employee.model.Worker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import static org.junit.jupiter.api.Assertions.*;

class CompanyImplementationTest {

    Company company;
    Employee [] emp;


    @BeforeEach
    void setUp() {
        //create object
        company = new CompanyImplementation(5);
        emp = new Employee[4];

        //fill array to fill object company
        emp [0] = new Manager(1, "N1", "L1", 160,5000, 25);
        emp [1] = new SalesManager(2, "N2", "L2", 160,50000, 0.1);
        emp [2] = new SalesManager(3, "N3", "L3", 160,80000, 0.15);
        emp [3] = new Worker(4, "N4", "L4", 160,20);

        // TODO поместить обьекты  emp[] в обьект company c помощью метода addEmployee
        for (int i = 0; i < 4; i++) {
            company.addEmployee(emp[i]);
        }//end for

    }//end setUp

    @Test
    //@Nested - позволяет определить порядок выполнения тестов
    void addEmployeeTest() {
        //check size
        assertEquals(4, company.quantity());

        //can't add null
        assertFalse(company.addEmployee(null));

        //can't add duplicate
        assertFalse(company.addEmployee(emp[0]));

        //can add new one
        Employee empNew = new Worker(5, "N5", "L5", 160,20);
        assertTrue(company.addEmployee(empNew));

        //check size
        assertEquals(5, company.quantity());

        //can't add one more, when have no free space
        Employee empOneMore = new Worker(5, "N5", "L5", 160,20);
        assertFalse(company.addEmployee(empOneMore));

    }//end addEmployee

    @Test
    void removeEmployeeTest() {
        //can remove exicted employee
        assertEquals(emp[1],company.removeEmployee(2));
        //check size
        assertEquals(3,company.quantity());

        //can't remove absent employee
        assertNull(company.removeEmployee(10));

    }//end removeEmployeeTest

    @Test
    void findEmployeeTest() {
        //find existed
        assertEquals(emp[0], company.findEmployee(1));

        //find absent
        assertNull(company.findEmployee(8));

    }//end findEmployeeTest

    @Test
    void updateEmployeeTest() {
    }

    @Test
    void quantityTest() {
        assertEquals(4, company.quantity());
    }//end quantityTest

    @Test
    void printEmployeeTest() {
        company.printEmployee();
    }//end printEmployeeTest

    @Test
    void totalSalaryTest() {



    }//end totalSalaryTest

    @Test
    void totalSalesTest() {
    }

    @Test
    void findEmployeeHoursGratedThanTest() {
    }

    @Test
    void findEmployeeSalaryRangeTest() {
    }


}//end class