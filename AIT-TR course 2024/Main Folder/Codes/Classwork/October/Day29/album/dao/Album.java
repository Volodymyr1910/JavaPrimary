package Day29.album.dao;

import Day29.album.model.Photo;

import java.time.LocalDate;

public interface Album {


    boolean addPhoto(Photo photo);
    boolean removePhoto (int albumId, int photoId);
    boolean  updatePhoto (int albumId, int photoId, String url);
    Photo getPhotoFromAlbom(int albumId, int photoId);
    Photo [] getAllPhotoFromAlbum (int albumId);
    Photo [] getPhotoBetweenDate (LocalDate dateFrom, LocalDate dateTo );
    void printPhoto ();
    int size();


}//end interface
