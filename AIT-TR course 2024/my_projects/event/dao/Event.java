package my_projects.event.dao;

import my_projects.event.model.Note;

import java.time.LocalDate;

public interface Event {

    boolean addNote(Note note);
    boolean removeNote (int eventId, int noteId);
    boolean  updateNote (int eventId, int noteId, String url);
    Note getNoteFromEvent(int eventId, int noteId);
    Note[] getAllNoteFromEvent(int eventId);
    Note[] getNoteBetweenDate (LocalDate dateFrom, LocalDate dateTo );
    void printNote ();
    int size();





}//end interface
