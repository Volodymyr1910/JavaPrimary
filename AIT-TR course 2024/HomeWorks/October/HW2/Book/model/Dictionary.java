package HW2.Book.model;

public class Dictionary extends Book{

    String language;
    double cost;
    long numberOfPrintedEditions;

    public Dictionary(String ISBN, String title, String author, int yearOfPublishing, String genre, String language, double cost, long numberOfPrintedEditions) {
        super(ISBN, title, author, yearOfPublishing, genre);
        this.language = language;
        this.cost = cost;
        this.numberOfPrintedEditions = numberOfPrintedEditions;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getNumberOfPrintedEditions() {
        return numberOfPrintedEditions;
    }

    public void setNumberOfPrintedEditions(long numberOfPrintedEditions) {
        this.numberOfPrintedEditions = numberOfPrintedEditions;
    }


    public String display() {
        return "Dictionary{" +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                ", language='" + language + '\'' +
                ", numberOfPrintedEditions=" + numberOfPrintedEditions +
                ", cost=" + cost +
                '}';
    }
}//end clas
