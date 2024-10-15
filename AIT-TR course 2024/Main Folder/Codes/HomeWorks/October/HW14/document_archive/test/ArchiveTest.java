package HW14.document_archive.test;

import HW14.document_archive.controller.Archive;
import HW14.document_archive.model.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArchiveTest {

    Archive archive;
    Document [] documents;
    int size = 0;

    @BeforeEach
    void setUp() {
        archive = new Archive(5);
        documents = new Document[5];



        documents [0] = new Document("About Forests 1", "A1", 1234567891, 2001);
        documents [1] = new Document("About Forests 2", "A2", 1234567892, 2002);
        documents [2] = new Document("About Forests 3", "A3", 1234567893, 2003);
        documents [3] = new Document("About Forests 4", "A4", 1234567894, 2004);


        for (int i = 0; i < 4; i++) { //documents.length - 1 -> т.к. массив размером 5 получает 4 элемента, и будет заполнен не полностью
            archive.addDocument(documents[i]);
        }//end for

    }//end setUp

    @Test
    void addDocumentTest (){

        assertFalse(archive.addDocument(null)); // пробуем добавить "пустую" книгу, не существующую

        assertFalse(archive.addDocument(documents[0])); // пробуем добавить дубликат

        //пробуем добавить книгу кoгда на полке есть место
        Document documents = new Document("About Forests 5", "A5", 1234567895, 2005);
        assertTrue(archive.addDocument(documents));

        //проверяем количество документов в архиве
        assertEquals(5, archive.size());

        //пробуем добавить книгу кoгда на полке нет места
        Document documentsAgain = new Document("About Forests 6", "A6", 1234567896, 2006);
        assertFalse(archive.addDocument(documents));
    }//end addDocumentTest

    @Test
    void findDocumentTest (){

        Document foundedDocuments = archive.findDocument(1234567891);
        assertEquals(documents[0], archive.findDocument(1234567891));

    }//end findDocumentTest

    @Test
    void printDocumentTest (){
        System.out.println("-------------");
        archive.printDocument();

    }//end printDocumentTest

    @Test
    void removeDocumentTest(){

        //удаляем документ которого нет
        assertNull( archive.removeDocument(1234567899));

        //удаляем документ который есть
        assertEquals(documents[2], archive.removeDocument(1234567893));

        //проверяем количество документов в архиве
        assertEquals(3, archive.size());
    }//end removeDocumentTest






}//end class