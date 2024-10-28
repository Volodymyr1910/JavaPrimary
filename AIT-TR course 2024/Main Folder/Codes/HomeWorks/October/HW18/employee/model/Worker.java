package HW18.employee.model;

public class Worker extends Employee {

private int grade;


    public Worker(int id, String name, String secondName, double hours, int grade) {
        super(id, name, secondName, hours);
        this.grade = grade;
    }


    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Worker{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append(", hours=").append(hours);
        sb.append(", salary=").append(calcSalary());
        sb.append(", grade=").append(grade);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public double calcSalary() {
        double salary = hours * grade;
        return ensureSalary(salary);
    }



}//end class

