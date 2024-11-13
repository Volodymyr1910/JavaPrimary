package my_projects.organizer;

import my_projects.organizer.controller.YourOrganizer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OrganizerApplication {

    public static void main(String[] args) {


        YourOrganizer note = new YourOrganizer(100);
        note.mainMenu();

        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("my_notes.dat"))){

             ous.writeObject(note);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }//end main


}//end class
