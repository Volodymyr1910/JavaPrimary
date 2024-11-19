package Day17.ait.employee.model;

public class Manager extends Employee {

    private double baseSalary;
    private int grade; //некий коэфициент, почасовой оклад


    public Manager(int id, String name, String secondName, double hours, double baseSalary, int grade) {
        super(id, name, secondName, hours);
        this.baseSalary = baseSalary;
        this.grade = grade;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Manager{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append(", hours=").append(hours);
        sb.append(", salary=").append(calcSalary());
        sb.append(", baseSalary=").append(baseSalary);
        sb.append(", grade=").append(grade);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public double calcSalary() {
        double salary = baseSalary + hours * grade;
        return ensureSalary(salary); // проверяем чтоб зп не была меньше минимальной возможной по часам
    }//end calcSalary


}//end class
