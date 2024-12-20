package Day29.album.dao;

import Day29.album.model.Photo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;


public class AlbumImpementation implements Album {

    private Photo[] photos;
    private int size;

    public AlbumImpementation( int capacity) {
        this.photos =  new Photo[capacity];
    }

    Comparator<Photo> comparator = (p1, p2) -> {
        int res = Integer.compare(p1.getAlbomId(), p2.getAlbomId());
        return res != 0 ? res : Integer.compare(p1.getPhotoId(), p2.getPhotoId());
    };


    @Override
    public boolean addPhoto(Photo photo) {
        if (photo == null || size == photos.length || getPhotoFromAlbom(photo.getAlbomId(), photo.getPhotoId()) != null)
            return false;
        int index = Arrays.binarySearch(photos, 0, size, photo, comparator);
        index = - index - 1;
        System.arraycopy(photos, index, photos, index + 1, size - index);
        photos[index] = photo;
        size++;
        return true;
    }//end addPhoto

    @Override
    public boolean removePhoto(int albumId, int photoId) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getAlbomId() == albumId && photos[i].getPhotoId() == photoId){
                System.arraycopy(photos, i + 1, photos, i, size - i - 1);
                photos[--size] = null;
                return true;
            }
        }//end for
        return false;
    }//end removePhoto

    @Override
    public boolean updatePhoto(int albumId, int photoId, String url) {
        Photo photo = getPhotoFromAlbom(albumId, photoId);
        if(photo == null)return false;
        photo.setUrl(url);
        return true;
    }//end updatePhoto

    @Override
    public Photo getPhotoFromAlbom(int albumId, int photoId) {
        for (int i = 0; i < size; i++) {
            if(photos[i].getAlbomId() == albumId && photos[i].getPhotoId() == photoId){
                return photos[i];
            }//end if
        }//end for
        return null;
    }// end

    @Override
    public Photo[] getAllPhotoFromAlbum(int albumId) {
        return getByPredicate(p -> p.getAlbomId() == albumId);
    }//end getAllPhotoFromAlbum

    @Override
    public Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        return getByPredicate(n ->  n.getDate().toLocalDate().isAfter(dateFrom.minusDays(1)) && n.getDate().toLocalDate().isBefore(dateTo.plusDays(1)));
    }//end getPhotoBetweenDate

    public Photo[] getByPredicate (Predicate<Photo> pred) {
        Photo newArray [] = new Photo[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if(pred.test(photos[i]))
                newArray[j++] = photos[i];
        }//end for
        return Arrays.copyOf(newArray, j);
    }//end getByPredicate

    @Override
    public void printPhoto() {
        for (int i = 0; i < size; i++) {
            System.out.println(photos[i]);
        }
    }

    @Override
    public int size() {
        return size;
    }//end size


}//end class
