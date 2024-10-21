package Day17.ait.employee.dao_data_axess_object;

import Day17.ait.employee.model.Employee;

public interface Company {

    boolean addEmployee(Employee employee);

    Employee removeEmployee(int id);

    Employee findEmployee (int id);

    Employee updateEmployee (Employee employee);

    int quantity();

    void printEmployee();

    double totalSalary();

    double totalSales(); // метод будет брать поле которое есть не у всех Employee !!!

    double averageSalary();

    Employee [] findEmployeeHoursGratedThan (int hours); // ищет сотрудников которые проработали hours часов

    Employee [] findEmployeeSalaryRange(double min, double max); // ищет сотрудников у которых зп в диапазоне от min до max


}//end interface
