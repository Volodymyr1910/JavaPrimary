package my_projects.employee.dao_data_axess_object;

import my_projects.employee.model.Employee;
import my_projects.employee.model.SalesManager;

import java.util.Arrays;
import java.util.function.Predicate;

public class CompanyImplementation implements Company {

    private Employee[] employees;
    private int size;

    //capasity - возможное ко-во сотрудников
    public CompanyImplementation(int capasity) {
        this.employees = new Employee[capasity];
        this.size = size;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        //bad case
        if (employee == null) return false;
        if (size == employees.length) return false;

        // проверяем чтоб не добавить сотрудника который уже есть
        if (findEmployee(employee.getId()) != null) return false;

        //good case
        employees[size] = employee;
        size++;
        return true;

    }//end addEmployee

    @Override
    public Employee removeEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                Employee victim = employees[i];
                //employees[i] = employees[size - 1];
                //employees[size - 1] = null;
                //size--;
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[--size] = null;
                return victim;
            }//end if
        }//end for
        return null;
    }//end removeEmployee

    @Override
    public Employee findEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }//end if
        }//end fori
        return null;
    }//end findEmployee

    @Override
    public Employee updateEmployee(Employee employee) {
        //найти нужный елемент массива по id и обновить поля, забирая "новые" поля из входящего в аргументах employee
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == employee.getId()){
                employees[i] = employee;
                return employees[i];
            }//end if
        }//end for
        return null;
    }//end updateEmployee

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
            totalSalary += employees[i].calcSalary();
        }//end for
        return totalSalary;
    }//end totalSalary

    @Override
    public double totalSales() {
        double totalSales = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i] instanceof SalesManager) {
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
        for (int i = 0; i < size; i++) {
            if (employees[i].getHours() > hours) {
                count++;
            }//end if
        }//end for
        Employee[] superWorkers = new Employee[count];
        for (int i = 0, j = 0; j < superWorkers.length; i++) {
            if (employees[i].getHours() > hours) {
                superWorkers[j++] = employees[i];
            }//end if
        }//end fori
        return superWorkers;
    }//end findEmployeeHoursGratedThan

    @Override
    public Employee[] findEmployeeSalesRange(double min, double max) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i] instanceof SalesManager) {
                if (((SalesManager) employees[i]).getSalesValue() < max && ((SalesManager) employees[i]).getSalesValue() >= min) {
                    count++;
                }//end if
            }//end if
        }//end for
        Employee[] superSalesWorkers = new Employee[count];
        for (int i = 0, j = 0; j < superSalesWorkers.length; i++) {
            if (employees[i] instanceof SalesManager) {
                if (((SalesManager) employees[i]).getSalesValue() < max && ((SalesManager) employees[i]).getSalesValue() >= min) {
                    superSalesWorkers[j++] = employees[i];
                }//end if
            }//end if
        }//end fori
        return superSalesWorkers;
    }//end findEmployeeSalesRange

    @Override
    public Employee[] findEmployeeHoursGratedThanUsePredicate (int hours){
        return findEmployeeByPredicate(e -> e.getHours() > hours);
    }//findEmployeeHoursGratedThanUsePredicate

    public Employee[] findEmployeeSalaryRangeUsePredicate (double min, double max){
        return findEmployeeByPredicate(e -> e.calcSalary() > min && e.calcSalary() < max);
    }//findEmployeeHoursGratedThanUsePredicate


    private Employee[] findEmployeeByPredicate(Predicate <Employee> pred) {
        Employee[] res = new Employee[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (pred.test(employees[i])) {
                res[j++] = employees[i];
            }//end if
        }//end fori
        return Arrays.copyOf(res, j); // обрезаем хвост из нулевых элементов
    }//end findEmployeeSalaryRange

    @Override
    public Employee[] findEmployeeSalaryRange(double min, double max) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            double iSalary = employees[i].calcSalary();
            if (iSalary < max && iSalary > min) {
                count++;
            }//end if
        }//end for
        Employee[] salary = new Employee[count];
        for (int i = 0, j = 0; j < salary.length; i++) {
            double iSalary = employees[i].calcSalary();
            if (iSalary < max && iSalary >= min) {
                salary[j++] = employees[i];
            }//end if
        }//end fori
        return salary;
    }//end findEmployeeSalaryRange

}//end class
