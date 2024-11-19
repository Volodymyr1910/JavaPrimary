package Day13.employee_save_read;

import java.io.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class SaveEmployeeApplication {
    public static void main(String[] args) {


        Address address1 = new Address("Bad Durrenberg", "Strasse1", 12, 10, 06231);
        Address address2 = new Address("Bad Durrenberg", "Strasse2", 21, 35, 06231);

        Employee e1 = new Employee(1, "Peter", LocalDate.of(1987, 10, 19), 5900, address1);
        Employee e2 = new Employee(2, "Jakob", LocalDate.of(1987, 10, 10), 5500, address2);

        Set<Employee> firma = new HashSet<>(Set.of(e1, e2));

        // отправляем в файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.dat"))) {

            oos.writeObject(firma);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }//end main



}//end class
