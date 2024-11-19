package my_projects.document_archive_v2.test_v2;

import my_projects.document_archive_v2.controller_v2.Archive_v2;
import my_projects.document_archive_v2.model_v2.Document_v2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Archive_v2Test {

    Archive_v2 archiveV2;
    Document_v2[] documents;
    int size = 0;

    @BeforeEach
    void setUp() {
        archiveV2 = new Archive_v2(5);
        documents = new Document_v2[5];


        documents[0] = new Document_v2("About Forests 1", "A1", 1000000000, 2001);
        documents[1] = new Document_v2("About Forests 2", "A2", 1000000001, 2000);
        documents[2] = new Document_v2("About Forests 3", "A3", 1000000002, 2000);
        documents[3] = new Document_v2("About Forests 4", "A4", 1000000003, 2004);


        for (int i = 0; i < 4; i++) { //documents.length - 1 -> т.к. массив размером 5 получает 4 элемента, и будет заполнен не полностью
            archiveV2.addDocument(documents[i]);
        }//end for

    }//end setUp

    @Test
    void addDocumentTest() {

        assertFalse(archiveV2.addDocument(null)); // пробуем добавить "пустую" книгу, не существующую

        assertFalse(archiveV2.addDocument(documents[0])); // пробуем добавить дубликат

        //пробуем добавить книгу кoгда на полке есть место
        Document_v2 documents = new Document_v2("About Forests 5", "A5", 1000000005, 2005);
        assertTrue(archiveV2.addDocument(documents));

        //проверяем количество документов в архиве
        assertEquals(5, archiveV2.size());

        //пробуем добавить книгу кoгда на полке нет места
        Document_v2 documentsAgain = new Document_v2("About Forests 6", "A6", 1000000006, 2006);
        assertFalse(archiveV2.addDocument(documents));
    }//end addDocumentTest

    @Test
    void findDocumentTest() {

        assertEquals(documents[0], archiveV2.findDocument(1000000000));

    }//end findDocumentTest

    @Test
    void printDocumentTest() {
        System.out.println("-------------");
        archiveV2.printDocument();

    }//end printDocumentTest

    @Test
    void removeDocumentTest() {

        //удаляем документ которого нет
        assertNull(archiveV2.removeDocument(1000000009));

        //удаляем документ который есть
        assertEquals(documents[2], archiveV2.removeDocument(1000000002));

        //проверяем количество документов в архиве
        assertEquals(3, archiveV2.size());
    }//end removeDocumentTest


    @Test
    void updateDocumentTest() {
        //заносим пустой документ
        assertNull(archiveV2.updateDocument(null));

        //заносим документ не имеющий полного описания
        /* этот тест провести не можем т.к. Document не имеет дочерних классов, расширяющих его поля */

        //обновляем документ которого нет в архиве
        Document_v2 doc1 = new Document_v2("About Forests 10", "A9", 1111122222, 2009);
        assertNull(archiveV2.updateDocument(doc1));

        //обновляем документ который есть в архиве
        Document_v2 doc2 = new Document_v2("About Forests 1", "A9", 1111122222, 3000);
        assertEquals(documents[0], archiveV2.updateDocument(doc2));
        System.out.println(archiveV2.size());
        archiveV2.printDocument();
    }//end

    @Test
    void findTheOldestDocuments() {
        Document_v2 arrayOldestDocuments[] = archiveV2.findTheOldestDocuments(); //приземляем результат работы тестируемого метода
        System.out.println(arrayOldestDocuments[0].toString()); //печатаем для самоконтроля
        System.out.println(arrayOldestDocuments[1].toString()); //печатаем для самоконтроля

        Document_v2 arrayOldestDocumentsTest[] = new Document_v2[2]; // создаем массив с самыми старыми документами
        arrayOldestDocumentsTest[0] = documents[1];
        arrayOldestDocumentsTest[1] = documents[2];

        assertArrayEquals(arrayOldestDocumentsTest, arrayOldestDocuments);

    }//end findTheOldestDocuments

    @Test
    void findAllDocumentsThisAutorTest() {
        String autor = "A3"; // ищем документы этого автора
        Document_v2 thisAutorDocumentsArrayTest[] = new Document_v2[1]; //создаем массив куда попадают документы искомого автора ТЕСТ
        thisAutorDocumentsArrayTest[0] = documents[2]; //кладем документ автора A3 в наш тестовый массив

        Document_v2 fromMethod[] = archiveV2.findAllDocumentsThisAutor(autor); //вызываем тестируемый метод и приземляем его результат работы
        assertEquals(thisAutorDocumentsArrayTest[0], fromMethod[0]); //заранее зная что в массиве будет 1 книга этого автора, сравниваем нулевые элементы тест-массива и массива из тестируемого метода
    }//end findAllDocumentsThisAutorTest

    @Test
    void findAllDocumentsThisYearTest() {
        Document_v2[] doc = {documents[1],documents[2]};
        Document_v2[] act = archiveV2.findAllDocumentsThisYear(2000);
    assertArrayEquals(doc, act);

    }//end findAllDocumentsThisYearTest


}//end class