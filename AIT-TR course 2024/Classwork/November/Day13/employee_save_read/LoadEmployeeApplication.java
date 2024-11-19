package Day13.employee_save_read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;

// имеется файл м данными объектов Java
// необходимо его обратно считать для использования в программе
public class LoadEmployeeApplication {

    static Set<Employee> employeeSet = new HashSet<>(); // готовим место, куда приземлить обьект из файла, обьявляем на уровне класса

    public static void main(String[] args) {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.dat"))) {


            employeeSet = (Set <Employee>)ois.readObject();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



        double totalSalary = employeeSet.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total Salary -> " + totalSalary);

    }//end main





}//end class
