package HW30.event.dao;

import HW30.event.model.Note;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class EventImplementation implements Event {
    private Note[] notes;
    private int size;


    public EventImplementation(int capacity) {
        this.notes = new Note[capacity];
    }

    Comparator<Note> comparator = (p1, p2) -> {
        int res = Integer.compare(p1.getEventId(), p2.getEventId());
        return res != 0 ? res : Integer.compare(p1.getNoteId(), p2.getNoteId());
    };

    @Override
    public boolean addNote(Note note) {
        if (note == null || size == notes.length || getNoteFromEvent(note.getEventId(), note.getNoteId()) != null)
            return false;
        int index = - Arrays.binarySearch(notes, 0, size, note, comparator) - 1;
        //index = - index - 1;
        System.arraycopy(notes, index, notes, index + 1, size - index);
        notes[index] = note;
        size++;
        return true;
    }//end addNote

    @Override
    public boolean removeNote(int eventId, int noteId) {
        for (int i = 0; i < size; i++) {
            if (notes[i].getEventId() == eventId && notes[i].getNoteId() == noteId){
                System.arraycopy(notes, i + 1, notes, i, size - i - 1);
                notes[--size] = null;
                return true;
            }//end if
        }//end for
        return false;
    }//end removeNote

    @Override
    public boolean updateNote(int eventId, int noteId, String url) {
        Note note = getNoteFromEvent(eventId, noteId);
        if(note == null)return false;
        note.setUrl(url);
        return true;
    }//end updateNote

    @Override
    public Note getNoteFromEvent(int eventId, int noteId) {
        for (int i = 0; i < size; i++) {
            if (notes[i].getEventId() == eventId && notes[i].getNoteId() == noteId){
                return notes[i];
            }//end if
        }//end for
        return null;
    }//end getNoteFromEvent

    @Override
    public Note[] getAllNoteFromEvent(int eventId) {
        return getByPredicate(note -> note.getEventId() == eventId );
    }//end getAllNoteFromEvent

    @Override
    public Note[] getNoteBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        //return getByPredicate(n ->  n.getDate().isAfter(dateFrom) && n.getDate().isBefore(dateTo) ); //несоответствие типов
        return getByPredicate(n ->  n.getDate().isAfter(dateFrom.atStartOfDay()) && n.getDate().isBefore(dateTo.atStartOfDay()) ); // вариант решения, когда "границы" не попадают в итог
        //return getByPredicate(n ->  n.getDate().toLocalDate().isAfter(dateFrom) && n.getDate().toLocalDate().isBefore(dateTo.plusDays(1))); // вариант решения, когда в итог попадает правая "граница"
        //return getByPredicate(n ->  n.getDate().toLocalDate().isAfter(dateFrom.minusDays(1)) && n.getDate().toLocalDate().isBefore(dateTo.plusDays(1))); // вариант решения, когда в итог попадают все "границы"
        //return getByPredicate(n ->  n.getDate().isAfter(dateFrom.atStartOfDay().minusDays(1)) && n.getDate().isBefore(dateTo.atStartOfDay().plusDays(1)) ); // вариант решения, когда в итог попадают все "границы"
    }//end getNoteBetweenDate

    public Note [] getByPredicate (Predicate <Note> pred) {
        Note newArray [] = new Note[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if(pred.test(notes[i]))
                newArray[j++] = notes[i];
        }//end for
        return Arrays.copyOf(newArray, j);
    }//end getByPredicate


    @Override
    public void printNote() {
        for (int i = 0; i < size; i++) {
            System.out.println(notes[i]);
        }//end for
    }//end pruntNote

    @Override
    public int size() {
        return size;
    }//end size
}//end class
