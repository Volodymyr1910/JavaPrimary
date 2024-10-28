package HW18.employee.test;

import HW18.employee.dao_data_axess_object.Company;
import HW18.employee.dao_data_axess_object.CompanyImplementation;
import HW18.employee.model.Employee;
import HW18.employee.model.Manager;
import HW18.employee.model.SalesManager;
import HW18.employee.model.Worker;
import MyMethods.array_methods.ArrayMethods_Object;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CompanyImplementationTest {

    Company company;
    Employee[] emp;


    @BeforeEach
    void setUp() {
        //create object
        company = new CompanyImplementation(10);
        emp = new Employee[7];

        //fill array to fill object company
        emp[0] = new Manager(1, "N1", "L1", 160, 5000, 25);
        emp[1] = new SalesManager(2, "N2", "L2", 160, 50000, 0.1);
        emp[2] = new SalesManager(3, "N3", "L3", 170, 80000, 0.15);
        emp[3] = new Worker(4, "N4", "L4", 180, 20);
        emp[4] = new SalesManager(5, "N3", "L3", 170, 35000, 0.15);
        emp[5] = new SalesManager(6, "N3", "L3", 170, 43000, 0.15);
        emp[6] = new SalesManager(7, "N3", "L3", 170, 20000, 0.15);

        // TODO поместить обьекты  emp[] в обьект company c помощью метода addEmployee
        for (int i = 0; i < 7; i++) {
            company.addEmployee(emp[i]);
        }//end for

    }//end setUp

    @Test
        //@Nested - позволяет определить порядок выполнения тестов
    void addEmployeeTest() {
        //check size
        assertEquals(7, company.quantity());

        //can't add null
        assertFalse(company.addEmployee(null));

        //can't add duplicate
        assertFalse(company.addEmployee(emp[0]));

        //can add new one
        Employee empNew = new Worker(8, "N5", "L5", 160, 20);
        assertTrue(company.addEmployee(empNew));

        //check size
        assertEquals(8, company.quantity());

        //can't add one more, when have no free space
        Employee empOneMore = new Worker(5, "N5", "L5", 160, 20);
        assertFalse(company.addEmployee(empOneMore));

    }//end addEmployee

    @Test
    void removeEmployeeTest() {
        //can remove exicted employee
        assertEquals(emp[1], company.removeEmployee(2));
        //check size
        assertEquals(6, company.quantity());

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
    @DisplayName("Update employee is working")
    void updateEmployeeTest() {
        Employee updateEmployee = new SalesManager(2, "N2", "newL2", 160, 55000, 0.1);
        assertEquals("newL2", company.updateEmployee(updateEmployee).getSecondName());
        //ArrayMethods_Object.printObjectArray(emp, "after");
        company.printEmployee();

        //assertEquals(55000, company.updateEmployee((SalesManager)updateEmployee).getSalesValue);


    }//end updateEmployeeTest

    @Test
    void quantityTest() {
        assertEquals(7, company.quantity());
    }//end quantityTest

    @Test
    void printEmployeeTest() {
        company.printEmployee();
    }//end printEmployeeTest

    @Test
    void totalSalaryTest() {
        double totalSalary = 44_300; // предположение
        assertEquals(totalSalary, company.totalSalary());

    }//end totalSalaryTest

    @Test
    void totalSalesTest() {
        assertEquals(228_000, company.totalSales());

    }//end totalSalesTest

    @Test
    void averageSalaryTest() {
        double averageSalary = company.totalSalary() / company.quantity();
        assertEquals(averageSalary, company.averageSalary());

    }//end averageSalaryTest


    @Test
    void findEmployeeHoursGratedThanTest() {
        Employee[] any = new Employee[5];
        any[0] = emp[2];
        any[1] = emp[3];
        any[2] = emp[4];
        any[3] = emp[5];
        any[4] = emp[6];


        assertArrayEquals(any, company.findEmployeeHoursGratedThan(160));
    }//end findEmployeeHoursGratedThanTest

    @Test
    void findEmployeeSalesRangeTest() {

        Employee[] any = new Employee[3];

        any[0] = emp[4];
        any[1] = emp[5];
        any[2] = emp[6]; // from 20_000 to 45_000

        assertArrayEquals(any, company.findEmployeeSalesRange(20000, 45000));

    }//end findEmployeeSalesRangeTest

    @Test
    void findEmployeeSalaryRangeTest() {
        company.printEmployee();
        Employee[] any = new Employee[3];

        any[0] = emp[1];
        any[1] = emp[3];
        any[2] = emp[4]; // from 3_000 to 6_000

        assertArrayEquals(any, company.findEmployeeSalaryRange(3000, 6000));

    }//end findEmployeeSalaryRangeTest


    @Test
    void findEmployeeHoursGratedThanUsePredicateTest() {
        Employee[] any = new Employee[5];
        any[0] = emp[2];
        any[1] = emp[3];
        any[2] = emp[4];
        any[3] = emp[5];
        any[4] = emp[6];


        assertArrayEquals(any, company.findEmployeeHoursGratedThanUsePredicate(160));
    }//end findEmployeeHoursGratedThanUsePredicateTest

    @Test
    void findEmployeeSalaryRangeUsePredicateTest() {
        Employee[] any = new Employee[3];

        any[0] = emp[1];
        any[1] = emp[3];
        any[2] = emp[4]; // from 3_000 to 6_000


        Employee[] act = company.findEmployeeSalaryRangeUsePredicate(3000, 6000);
        assertArrayEquals(any, act);
    }//end findEmployeeSalaryRangeUsePredicateTest
}//end class