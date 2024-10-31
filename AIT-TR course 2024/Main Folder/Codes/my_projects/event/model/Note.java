package my_projects.event.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Note implements Comparable <Note>{

    private int eventId;
    private int noteId;
    private String title;
    private String url;
    private LocalDateTime date;


    public Note(int eventId, int noteId, String title, String url, LocalDateTime date) {
        this.eventId = eventId;
        this.noteId = noteId;
        this.title = title;
        this.url = url;
        this.date = date;
    }

    public int getEventId() {
        return eventId;
    }

    public int getNoteId() {
        return noteId;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Note{");
        sb.append("eventId=").append(eventId);
        sb.append(", noteId=").append(noteId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note note)) return false;
        return eventId == note.eventId && noteId == note.noteId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, noteId);
    }

    @Override
    public int compareTo(Note o) {
        return this.getDate().compareTo(o.getDate());
    }
}//end class
