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
        //bad case
        if(employee == null) return false;
        if(size == employees.length) return false;
        if(findEmployee(employee.getId()) != null)return false; // вариант 1, проверяем чтоб не добавить сотрудника который уже есть
        //if ()
        /*for (int i = 0; i < size; i++) {
            if(employee.getId() == employees[i].getId()) return false;  // вариант 1, проверяем чтоб не добавить сотрудника который уже есть
        }//end if */
        //good case
        employees[size] = employee;
        size++;
        return true;

    }//end addEmployee

    @Override
    public Employee removeEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id){
               Employee victim = employees[i];
               employees[i] = employees [size - 1];
                employees [size - 1] = null;
                size--;
                return victim;
            }//end if
        }//end for
        return null;
    }//end removeEmployee

    @Override
    public Employee findEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if(employees[i].getId() == id){
                return employees[i];
            }//end if
        }//end fori
        return null;
    }//end findEmployee

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public int quantity() {
        return size;
    }//quantity

    @Override
    public void printEmployee() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }//end for
    }//end printEmployee

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
