package Day29.album.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Photo implements Comparable <Photo>{

    private int albomId;
    private int photoId;
    private String title;
    private String url;
    private LocalDateTime date;


    public Photo(int albomId, int photoId, String title, String url, LocalDateTime date) {
        this.albomId = albomId;
        this.photoId = photoId;
        this.title = title;
        this.url = url;
        this.date = date;
    }


    public int getAlbomId() {
        return albomId;
    }

    public int getPhotoId() {
        return photoId;
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
        final StringBuilder sb = new StringBuilder("Photo{");
        sb.append("albomId=").append(albomId);
        sb.append(", photoId=").append(photoId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo photo)) return false;
        return albomId == photo.albomId && photoId == photo.photoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(albomId, photoId);
    }

    @Override
    public int compareTo(Photo o) {
        return this.getDate().compareTo(o.getDate());
    }
}//end class
