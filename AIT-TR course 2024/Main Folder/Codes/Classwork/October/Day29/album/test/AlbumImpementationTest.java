package Day29.album.test;

import Day29.album.dao.Album;
import Day29.album.dao.AlbumImpementation;
import Day29.album.model.Photo;
import MyMethods.array_methods.ArrayMethods_Object;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;

class AlbumImpementationTest {
    Album album;
    Photo[] photos;
    LocalDateTime now = LocalDateTime.now();


    //Comparator sort by albumId, than by photoId
    Comparator<Photo> comparator = (p1, p2) -> {
        int res = Integer.compare(p1.getAlbomId(), p2.getAlbomId());
        return res != 0 ? res : Integer.compare(p1.getPhotoId(), p2.getPhotoId());
    };

    @BeforeEach
    void setUp() {
        album = new AlbumImpementation(7);
        photos = new Photo[6];

        /*photos[0] = new Photo(1, 4, "t6", "url6", now.minusDays(2));
        photos[1] = new Photo(2, 1, "t1", "url4", now.minusDays(7));
        photos[2] = new Photo(1, 2, "t2", "url2", now.minusDays(7));
        photos[3] = new Photo(2, 2, "t2", "url5", now.minusDays(5));
        photos[4] = new Photo(1, 3, "t3", "url3", now.minusDays(5));
        photos[5] = new Photo(1, 1, "t1", "url1", now.minusDays(10));*/

        photos[0] = new Photo(1, 1, "t1", "url1", now.minusDays(10));
        photos[1] = new Photo(1, 2, "t2", "url2", now.minusDays(7));
        photos[2] = new Photo(1, 3, "t3", "url3", now.minusDays(5));
        photos[3] = new Photo(2, 1, "t1", "url4", now.minusDays(7));
        photos[4] = new Photo(2, 3, "t2", "url5", now.minusDays(5));
        photos[5] = new Photo(2, 2, "t6", "url6", now.minusDays(2));

        for (int i = 0; i < 6; i++) {
            album.addPhoto(photos[i]);
        }

    }//end setUp

    @Test
    void addPhotoTest() {
        assertFalse(album.addPhoto(null));
        assertFalse(album.addPhoto(photos[0]));

        Photo photo = new Photo(1, 4, "t7", "url7", now.minusDays(2));
        assertTrue(album.addPhoto(photo));
        assertEquals(7, album.size());
       album.printPhoto();
        photo = new Photo(2, 5, "t8", "url8", now.minusDays(4));
        assertFalse(album.addPhoto(photo));
    }//end addPhotoTest

    @Test
    void removePhotoTest() {
        assertTrue(album.removePhoto(1, 1));
        assertFalse(album.removePhoto(5, 1));
        assertEquals(5, album.size());
    }//end removePhotoTest

    @Test
    void updatePhotoTest() {
        assertTrue(album.updatePhoto(1, 1, "newUrl"));
        assertEquals("newUrl", album.getPhotoFromAlbom(1, 1).getUrl());
    }//end updatePhotoTest

    @Test
    void getPhotoFromAlbomTest() {
        assertEquals(photos[1], album.getPhotoFromAlbom(1, 2));
        assertNull(album.getPhotoFromAlbom(3, 4));
    }//end getPhotoFromAlbomTest

    @Test
    void getAllPhotoFromAlbumTest() {
        Photo[] exp = {photos[3], photos[5], photos[4]};
        Photo[] act = album.getAllPhotoFromAlbum(2);
        assertArrayEquals(exp, act);
    }//end getAllPhotoFromAlbumTest

    @Test
    void getPhotoBetweenDateTest() {
        LocalDate today = LocalDate.now();
        Photo[] act = album.getPhotoBetweenDate(today.minusDays(6), today.minusDays(2));
        Arrays.sort(act, comparator);
        Photo[] exp = {photos[2], photos[4], photos[5]};
        Arrays.sort(exp, comparator);
        assertArrayEquals(exp, act);
    }//end getPhotoBetweenDateTest

    @Test
    void printPhotoTest() {
        album.printPhoto();
    }//end printPhotoTest

    @Test
    void sizeTest() {
        assertEquals(6, album.size());
    }//end sizeTest
}