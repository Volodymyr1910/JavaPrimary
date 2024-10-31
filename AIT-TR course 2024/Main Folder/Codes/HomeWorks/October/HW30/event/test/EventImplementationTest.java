package HW30.event.test;

import Day29.album.model.Photo;
import HW30.event.dao.Event;
import HW30.event.dao.EventImplementation;
import HW30.event.model.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class EventImplementationTest {
    Event event;
    Note[] notes;
    LocalDateTime now = LocalDateTime.now(); // заметки привязаны ко времени
    // тесты должны работать в любой момент времени, поэтому заводим временную переменную
    Comparator<Note> comparator = (p1, p2) -> {
        int res = Integer.compare(p1.getEventId(), p2.getEventId());
        return res != 0 ? res : Integer.compare(p1.getNoteId(), p2.getNoteId());
    };

    @BeforeEach
    void setUp() {

        event = new EventImplementation(7);
        notes = new Note[6];
        notes[0] = new Note(1,1,"t1", "url1",now.minusDays(5));
        notes[1] = new Note(1,2,"t2", "url2",now.minusDays(3));
        notes[2] = new Note(1,3,"t3", "url3",now.minusDays(1));
        notes[3] = new Note(2,1,"t1", "url4",now.minusDays(4));
        notes[4] = new Note(2,2,"t2", "url5",now.minusDays(8));
        notes[5] = new Note(1,4,"t6", "url6",now.minusDays(3));

        for (int i = 0; i < 6; i++) {
            event.addNote(notes[i]);
        }


    }

    @Test
    void addNoteTest() {
        assertFalse(event.addNote(null));
        assertFalse(event.addNote(notes[0]));

        Note note = new Note(2,3,"t7","url7",now.minusDays(2));
        assertTrue(event.addNote(note));
        assertEquals(7, event.size());

        note = new Note(2,3,"t7","url7",now.minusDays(2));
        assertFalse(event.addNote(note));

    }//end addNoteTest

    @Test
    void removeNoteTest() {
        assertTrue(event.removeNote(1,1));
        assertFalse(event.removeNote(5, 1));
        assertEquals(5, event.size());
    }//end removeNoteTest

    @Test
    void updateNoteTest() {
        assertTrue(event.updateNote(1,1, "newUrl"));
        assertEquals("newUrl", event.getNoteFromEvent(1, 1).getUrl());
    }//end updateNoteTest

    @Test
    void getNoteFromEventTest() {
        assertEquals(notes[1], event.getNoteFromEvent(1, 2));
        assertNull(event.getNoteFromEvent(5, 4));

    }//end getNoteFromEventTest

    @Test
    void getAllNoteFromEventTest() {
        Note [] exp = {notes[3], notes[4]};
        Note [] act = event.getAllNoteFromEvent(2);
        assertArrayEquals(exp,act);
    }//end getAllNoteFromEventTest

    @Test
    void getNoteBetweenDateTest() {
        LocalDate today = LocalDate.now();
        Note [] act = event.getNoteBetweenDate(today.minusDays(2), today.minusDays(6));
        Arrays.sort(act, comparator);
        Note [] exp = {notes[0], notes[1], notes[3],notes[5]};
        Arrays.sort(exp, comparator);
        assertArrayEquals(exp,act);

    }//end getNoteBetweenDateTest

    @Test
    void printNoteTest() {
        event.printNote();
    }//end printNoteTest

    @Test
    void sizeTest() {
        assertEquals(6, event.size());
    }//end sizeTest
}