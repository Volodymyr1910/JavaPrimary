package my_projects.document_archive_v2.controller_v2;

import my_projects.document_archive_v2.dao_v2.Archivarius_v2;
import my_projects.document_archive_v2.model_v2.Document_v2;

import java.util.function.Predicate;

public class Archive_v2 implements Archivarius_v2 {

    private Document_v2[] documents;
    private int size;

    public Archive_v2(int capasity) {
        this.documents = new Document_v2[capasity];
        this.size = 0;
    }

    // true or false create (document)
    //boolean addDocument (document)
    //size++
    public boolean addDocument(Document_v2 document) {
        if (document == null) return false;
        if (size == documents.length) return false;
        if (!((findDocument(document.getUniqueNumber())) == null)) return false;
        documents[size] = document;
        size++;
        return true;
    }//end addDocument

    //Document document findDocument (int uniqueNumber)
    public Document_v2 findDocument(int uniqueNumber) {
        for (int i = 0; i < size; i++) {
            if (uniqueNumber == documents[i].getUniqueNumber()) return documents[i];
        }//end for
        return null;
    }//end findDocument

    //read
    // void printDocument
    public void printDocument() {
        for (int i = 0; i < size; i++) {
            System.out.println(documents[i]);
        }//end for
    }//end printDocument

    //delete
    // Document removeDocument (int uniqueNumber)
    //size--
    public Document_v2 removeDocument(int uniqueNumber) {
        for (int i = 0; i < size; i++) {
            if (documents[i].getUniqueNumber() == uniqueNumber) {
                Document_v2 victim = documents[i];
                documents[i] = documents[size - 1];
                documents[size - 1] = null;
                size--;
                return victim;
            }//end if
        }//end for
        return null;
    }//end removeDocument

    public int size() {
        return size;
    }// end size

    //boolean update
    //делаю допущение что книга была переиздана, а значит получила новые autor, isbn, year of publishing. Старым осталось только название title
    @Override
    public Document_v2 updateDocument(Document_v2 document) {
        if (document == null) return null;
        //if (!(document instanceof Document)) return null; // Document не имеет дочерних классов, расширяющих его поля, поэтому поле выключено
        for (int i = 0; i < size; i++) {
            if (documents[i].getTitle().equals(document.getTitle())) {
                Document_v2 victim = documents[i];
                documents[i] = document;
                return victim;
            }//end if
        }//end for
        return null;
    }//updateDocument

    @Override
    public Document_v2[] findAllDocumentsThisAutor(String autor) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (documents[i].getAuthor().equals(autor)) count++;
        }//end fori
        if (count == 0) return  null;
        Document_v2 thisAutorAllDocuments [] = new Document_v2[count];
        for (int i = 0, j = 0; i < size; i++) {
            if(documents[i].getAuthor().equals(autor)) thisAutorAllDocuments[j] = documents[i];
        }//end for
        return thisAutorAllDocuments;
    }//end findAllDocumentsThisAutor

    @Override
    public Document_v2[] findAllDocumentsThisYear(int year) {
        return findDocumentWithPredicate(documents -> documents.getYearOfPublishing() == year);
    }//end findAllDocumentsThisAutor

    @Override
    public Document_v2[] findTheOldestDocuments() {
        //находим самый старый год документов
        Document_v2 oldDocument = documents [0];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (documents[i].getYearOfPublishing() < oldDocument.getYearOfPublishing()){
                oldDocument = documents [i];
            }//end if
        }//end for
        //считаем сколько документов с самым старым годом
       int oldestYear = oldDocument.getYearOfPublishing();
        for (int i = 0; i < size ; i++) {
            if(documents[i].getYearOfPublishing() == oldestYear){
                count++;
            }//end if
        }//end for
        //переносим все документы со самым старым годом в новый массив
        Document_v2 oldestDocumentsArray [] = new Document_v2[count];
        for (int i = 0, j = 0; i <= oldestDocumentsArray.length; i++) {
            if(documents[i].getYearOfPublishing() == oldestYear){
                oldestDocumentsArray[j] = documents[i];
                j++;
            }//end if
        }//end fori
        return oldestDocumentsArray;
    }//end findTheOldestDocuments

    private Document_v2[] findDocumentWithPredicate (Predicate <Document_v2> pred) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (pred.test(documents[i])) count++;
        }//end for
        Document_v2[] arrayPredicate = new Document_v2[count];
        for (int i = 0, j = 0; j < arrayPredicate.length; i++) {
            if (pred.test(documents[i])){
               arrayPredicate [j] = documents[i];
                j++;
            }//end if
        }//end for
        return arrayPredicate;
    }//end findDocumentWithPredicate





}//end class