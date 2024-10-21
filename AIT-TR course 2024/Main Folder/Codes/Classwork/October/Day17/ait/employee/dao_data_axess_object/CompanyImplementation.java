package Day17.ait.employee.dao_data_axess_object;

import Day17.ait.employee.model.Employee;
import Day17.ait.employee.model.SalesManager;
import HW18.document_archive_v2.model_v2.Document_v2;

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
         double totalSalary = 0;
        for (int i = 0; i < size; i++) {
           totalSalary += employees [i].calcSalary();
        }//end for
        return totalSalary;
    }//end totalSalary

    @Override
    public double totalSales() {
        double totalSales = 0;
        for (int i = 0; i < size; i++) {
            if (employees [i] instanceof SalesManager) {
                totalSales += ((SalesManager) employees[i]).getSalesValue();
            }//end if
        }//end for
        return totalSales;
    }//end totalSales

    @Override
    public double averageSalary() {
        return totalSalary() / size;
    }//end averageSalary

    @Override
    public Employee[] findEmployeeHoursGratedThan(int hours) {
       int count = 0;
        for (int i = 0; i < size ; i++) {
            if(employees[i].getHours() > hours){
                count++;
            }//end if
        }//end for
        Employee [] superWorkers = new Employee[count];
        for (int i = 0, j = 0; i < size; i++) {
            if(employees[i].getHours() > hours){
                superWorkers[j] = employees[i];
                j++;
            }//end if
        }//end fori
        return superWorkers;
    }//end findEmployeeHoursGratedThan

    @Override
    public Employee[] findEmployeeSalaryRange(double min, double max) {
        int count = 0;
        for (int i = 0; i < size ; i++) {
            if (employees[i] instanceof SalesManager) {
                if (((SalesManager) employees[i]).getSalesValue() < max && ((SalesManager) employees[i]).getSalesValue() >= min) {
                    count++;
                }//end if
            }//end if
        }//end for
        Employee [] superSalesWorkers = new Employee[count];
        for (int i = 0, j = 0; i < size; i++) {
            if (employees[i] instanceof SalesManager) {
                if (((SalesManager) employees[i]).getSalesValue() < max && ((SalesManager) employees[i]).getSalesValue() >= min) {
                    superSalesWorkers[j] = employees[i];
                    j++;
                }//end if
            }//end if
        }//end fori
        return superSalesWorkers;
    }//end findEmployeeSalaryRange
}//end class
