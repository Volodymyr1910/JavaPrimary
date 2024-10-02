package HW1.Student;

import HW1.Student.model.Student;

public class StudentApplication {
    public static void main(String[] args) {

        Student student = new Student(1,"Volodymyr", "Loolabay", 1987, "Engineer");
        Student student2 = new Student(2,"Diana", "Choco", 1983, "Mechanic");
        Student student3 = new Student(3,"Sara", "Gellar", 1995, "Electrician");
        Student student4 = new Student(8,"David", "Barracuda", 1985, "Electrician");
        Student student5 = new Student(5,"Oksana", "Pink", 1993, "Engineer");
        Student student6 = new Student(6,"Leonid", "Best", 1991, "Mechanic");
        Student student7 = new Student(7,"Jason", "Statham", 1986, "Engineer");
        Student student8 = new Student(4,"Loli", "Prist", 1987, "Engineer");

        student.teacher();
        System.out.println("First of all, we need to check is everyone is here...");
        System.out.println("So..." + student.getLastName() + " ? " + "Your id is: " + student.getId());
        student.study();
        System.out.println(student2.getLastName() + " ? " + "Your id is: " + student2.getId());
        student.study();
        System.out.println(student3.getLastName() + " ? " + "Id is: " + student3.getId());
        student.study2();
        System.out.println(student4.getLastName() + " ? " + "Id is: " + student4.getId());
        student.study();
        System.out.println("Wait ! I'm sorry, but my id is " + student8.getId() + "!");
        System.out.println("Really? Let's make some correction.");
        int temp = student4.getId();
        student4.setId(4);
        System.out.println("Done !");
        System.out.println("Next... " + student5.getLastName() + " ? " + "Your id: " + student5.getId());
        student.study2();
        System.out.println(student6.getLastName() + " ? " + "Your id: " + student6.getId());
        student.study2();
        System.out.println("Now, " + student7.getLastName() + " ? " + "Id: " + student7.getId());
        student.study();
        System.out.println("And the last one..." + student8.getLastName() + " ? " + "Your id is: " + student8.getId());
        student.study();
        System.out.println("But my id is'nt correct too...");
        System.out.println("What's the right number ? ");
        System.out.println(temp + " that is correct.");
        student8.setId(temp);
        System.out.println("Ok. I maked the correction, " + student8.getName() + " don't worry.");
        System.out.println("Who? " + student8.getName() + " ? I am " + student4.getName() + "! " + student4.getName() + " " + student8.getLastName() + "!");
        System.out.println("Wait, a second, please.....");
        System.out.println("I think we have a problem here ...");
        System.out.println("Here is my list, let's together check everything!");
        System.out.println("-------------------------------");
        System.out.println(student.display());
        System.out.println(student2.display());
        System.out.println(student3.display());
        System.out.println(student4.display());
        System.out.println(student5.display());
        System.out.println(student6.display());
        System.out.println(student7.display());
        System.out.println(student8.display());
        System.out.println("--------------------------------");
        System.out.println("Who found mistakes ?");
        System.out.println("I'm " + student8.getName() + " " + student4.getLastName() + ". Please change !");
        System.out.println("As I sad.... " + student8.getLastName() + " that is mine surname. " + student4.getName() + " " + student8.getLastName() + ".");
        System.out.println("<.....teacher making corrections....>");

        String nameCorrection = student8.getName();
        student8.setName(student4.getName());
        student4.setName(nameCorrection);

        System.out.println("All is corrected ! Let's take a look one more time.");
        System.out.println("But now, you will see the full list.");
        System.out.println(student);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);
        System.out.println(student5);
        System.out.println(student6);
        System.out.println(student7);
        System.out.println(student8);
        System.out.println("--------everyone looks and noods--------------");
        System.out.println("Ok. All is correct now ! Perfect!....What's that? Bell?");
        System.out.println("What's a pity. The lesson is over ..... Bye !");
    }//end main
}//end class
