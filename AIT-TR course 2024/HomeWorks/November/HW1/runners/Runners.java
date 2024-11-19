package HW1.runners;
//Task 3.(*) There is a protocol of the results of the race of 10 athletes at a distance of 100 meters, in which the last name, first name, registration number of the athlete, club and the result in seconds are recorded. Create an application that will allow you to enter the results of the athletes into the computer and get the final protocol of the competition.
public class Runners implements Comparable <Runners>{

    private String lastName;
    private String firstName;
   private int registrationNumber;
    private String club;
    private double runResult;

    public Runners(String lastName, String firstName, int registrationNumber, String club, double runResult) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.registrationNumber = registrationNumber;
        this.club = club;
        this.runResult = runResult;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public String getClub() {
        return club;
    }

    public double getRunResult() {
        return runResult;
    }

    public void setRunResult(double runResult) {
        this.runResult = runResult;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Runners{");
        sb.append("lastName='").append(lastName).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", registrationNumber=").append(registrationNumber);
        sb.append(", club='").append(club).append('\'');
        sb.append(", runResult=").append(runResult);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Runners o) {
        return Double.compare(this.getRunResult(),o.getRunResult());
    }
}//end class
