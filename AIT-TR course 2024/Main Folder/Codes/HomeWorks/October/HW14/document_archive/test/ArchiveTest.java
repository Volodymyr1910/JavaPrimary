package HW14.document_archive.test;

import HW14.document_archive.controller.Archive;
import HW14.document_archive.model.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArchiveTest {

    Archive archive;
    Document[] documents;
    int size = 0;

    @BeforeEach
    void setUp() {
        archive = new Archive(5);
        documents = new Document[5];


        documents[0] = new Document("About Forests 1", "A1", 1234567891, 2001);
        documents[1] = new Document("About Forests 2", "A2", 1234567892, 2000);
        documents[2] = new Document("About Forests 3", "A3", 1234567893, 2000);
        documents[3] = new Document("About Forests 4", "A4", 1234567894, 2004);


        for (int i = 0; i < 4; i++) { //documents.length - 1 -> т.к. массив размером 5 получает 4 элемента, и будет заполнен не полностью
            archive.addDocument(documents[i]);
        }//end for

    }//end setUp

    @Test
    void addDocumentTest() {

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
    void findDocumentTest() {

        Document foundedDocuments = archive.findDocument(1234567891);
        assertEquals(documents[0], archive.findDocument(1234567891));

    }//end findDocumentTest

    @Test
    void printDocumentTest() {
        System.out.println("-------------");
        archive.printDocument();

    }//end printDocumentTest

    @Test
    void removeDocumentTest() {

        //удаляем документ которого нет
        assertNull(archive.removeDocument(1234567899));

        //удаляем документ который есть
        assertEquals(documents[2], archive.removeDocument(1234567893));

        //проверяем количество документов в архиве
        assertEquals(3, archive.size());
    }//end removeDocumentTest


    @Test
    void updateDocumentTest() {
        //заносим пустой документ
        assertNull(archive.updateDocument(null));

        //заносим документ не имеющий полного описания
        /* этот тест провести не можем т.к. Document не имеет дочерних классов, расширяющих его поля */

        //обновляем документ которого нет в архиве
        Document doc1 = new Document("About Forests 10", "A9", 1111122222, 2009);
        assertNull(archive.updateDocument(doc1));

        //обновляем документ который есть в архиве
        Document doc2 = new Document("About Forests 1", "A9", 1111122222, 3000);
        assertEquals(documents[0], archive.updateDocument(doc2));
        System.out.println(archive.size());

    }//end

    @Test
    void findTheOldestDocuments() {
        Document arrayOldestDocuments[] = archive.findTheOldestDocuments(); //приземляем результат работы тестируемого метода
        System.out.println(arrayOldestDocuments[0].toString()); //печатаем для самоконтроля
        System.out.println(arrayOldestDocuments[1].toString()); //печатаем для самоконтроля

        Document arrayOldestDocumentsTest[] = new Document[2]; // создаем
        arrayOldestDocumentsTest[0] = documents[1];
        arrayOldestDocumentsTest[1] = documents[2];


        assertEquals(arrayOldestDocumentsTest [0].getUniqueNumber(), arrayOldestDocuments [0].getUniqueNumber());
        assertEquals(arrayOldestDocumentsTest[1].getUniqueNumber(), arrayOldestDocuments[1].getUniqueNumber());
        //assertEquals(arrayOldestDocumentsTest, arrayOldestDocuments);


    }//end findTheOldestDocuments


    @Test
    void findAllDocumentsThisAutorTest() {
        String autor = "A3"; // ищем документы этого автора
        Document thisAutorDocumentsArray[] = new Document[1]; //создаем массив куда попадают документы искомого автора ТЕСТ
        thisAutorDocumentsArray[0] = documents[2]; //кладем документ автора A3 в наш тестовый массив

        Document fromMethod[] = archive.findAllDocumentsThisAutor(autor); //вызываем тестируемый метод и приземляем его результат работы
        assertEquals(thisAutorDocumentsArray[0], fromMethod[0]); //заранее зная что в массиве будет 1 книга этого автора, сравниваем нулевые элементы тест-массива и массива из тестируемого метода
    }//end findAllDocumentsThisAutorTest

}//end class