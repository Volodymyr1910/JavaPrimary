package HW1.Student.model;

public class Student {

    int id;
    String name;
    String lastName;
    int yearOfBirth;
    String profession;

    public Student(int id, String name, String lastName, int yearOfBirth, String profession) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }


    public String display() {
        return "Student -> " +
                "name is " + name +
                ", lastName is " + lastName +
                ", and id=" + id +
                '.';
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", profession='" + profession + '\'' +
                '}';
    }

    public void study (){
        System.out.println("I'm here.");
    }//end study

    public void study2 (){
        System.out.println("Present.");
    }//end study2

    public void holiday (){
        System.out.println("He is not here. I heared, he took 1 week holidays...");
    }//end holiday

    public void exam () {
        System.out.println("I know everything !!!");
    }//end exam

    public void exam2 () {
        System.out.println("I think, i'm ready.");
    }//end exam

    public void exam3 () {
        System.out.println("I want a good grade ! I hope my knowledges is enouph.... ");
    }//end exam

    public void teacher (){
        System.out.println("Good day everyone ! Let's start !");
    }// end teacher


}//end class
