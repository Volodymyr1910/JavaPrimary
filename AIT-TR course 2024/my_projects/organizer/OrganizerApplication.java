package my_projects.organizer;

import my_projects.organizer.controller.YourOrganizer;

import static my_projects.organizer.controller.YourOrganizer.loadOrganizer;
import static my_projects.organizer.controller.YourOrganizer.saveOrganizer;


public class OrganizerApplication {

    public static void main(String[] args) {
        //каждый запуск начинается с загрузки информации
        YourOrganizer note = loadOrganizer();

        //работа с программой
        note.mainMenu();

        // при завершении работы авто-сохранение
        saveOrganizer(note);
    }

}//end class