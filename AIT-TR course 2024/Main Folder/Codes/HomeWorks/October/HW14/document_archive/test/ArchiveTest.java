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
        Archive archive1 = new Archive(5);
        documents [0] = new Document("About Forests 1", "A1", 0000000001, 2001);
        documents [1] = new Document("About Forests 2", "A2", 0000000002, 2002);
        documents [2] = new Document("About Forests 3", "A3", 0000000003, 2003);
        documents [3] = new Document("About Forests 4", "A4", 0000000004, 2004);
    }

    @Test
    void findDocumentTest (){
        Document foundedDocuments = archive.findDocument(0000000001);
        assertEquals(documents[0], archive.findDocument(0000000001));
    }




}