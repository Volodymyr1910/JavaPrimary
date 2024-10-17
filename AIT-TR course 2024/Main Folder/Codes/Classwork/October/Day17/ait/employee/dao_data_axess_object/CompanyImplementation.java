package Day17.ait.employee.dao_data_axess_object;

import Day17.ait.employee.model.Employee;

public class CompanyImplementation implements Company{

    private Employee [] employees;
    private int size;

    //capasity - возможное ко-во сотрудников
    public CompanyImplementation(int capasity) {
        this.employees = new Employee[capasity];
        this.size = size;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return false;
    }

    @Override
    public Employee removeEmployee(int id) {
        return null;
    }

    @Override
    public Employee findEmployee(int id) {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public int quantity() {
        return 0;
    }

    @Override
    public void printEmployee() {

    }

    @Override
    public double totalSalary() {
        return 0;
    }

    @Override
    public double totalSales() {
        return 0;
    }

    @Override
    public Employee[] findEmployeeHoursGratedThan(int hours) {
        return new Employee[0];
    }

    @Override
    public Employee[] findEmployeeSalaryRange(double min, double max) {
        return new Employee[0];
    }
}//end class
