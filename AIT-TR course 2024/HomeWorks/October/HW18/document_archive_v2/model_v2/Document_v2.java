package HW18.document_archive_v2.model_v2;

import java.util.Objects;

public class Document_v2 {
    public static final int UNIQUENUMBER_LENGHT = 10;

    private String title;
    private String author;
    private int uniqueNumber;
    private int yearOfPublishing;

    public Document_v2(String title, String author, int uniqueNumber, int yearOfPublishing) {
        this.title = title;
        this.author = author;
        setUniqueNumber(uniqueNumber);
        this.yearOfPublishing = yearOfPublishing;
    }

    private int checkUniqueNumber(int uniqueNumber) {
        if(countDigit(uniqueNumber)){
            return uniqueNumber;
        }else return -1;
    }//end checkUniqueNumber

    private boolean countDigit(int uniqueNumber) {
        int counter = 0;
        int temp = uniqueNumber;
        while((temp != 0)){
            temp = temp / 10;
            counter++;
        }//end while
        if(counter == UNIQUENUMBER_LENGHT) return true;
        else return false;
    }//countDigit

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(int uniqueNumber) {
        if(checkUniqueNumber (uniqueNumber) > 0) this.uniqueNumber = uniqueNumber;
        else System.out.println("Unique number is not correct !");
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document_v2 document)) return false;
        return uniqueNumber == document.uniqueNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uniqueNumber);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Document{");
        sb.append("title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", uniqueNumber=").append(uniqueNumber);
        sb.append(", yearOfPublishing=").append(yearOfPublishing);
        sb.append('}');
        return sb.toString();
    }
}//end class