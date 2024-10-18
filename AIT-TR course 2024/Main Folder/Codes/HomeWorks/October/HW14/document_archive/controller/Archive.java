package HW14.document_archive.controller;

import HW14.document_archive.dao.Archivarius;
import HW14.document_archive.model.Document;

public class Archive implements Archivarius {

    private Document[] documents;
    private int size;

    public Archive(int capasity) {
        this.documents = new Document[capasity];
        this.size = 0;
    }


    // true or false create (document)
    //boolean addDocument (document)
    //size++
    public boolean addDocument(Document document) {
        if (document == null) return false;
        if (size == documents.length) return false;
        if (!((findDocument(document.getUniqueNumber())) == null)) return false;
        documents[size] = document;
        size++;
        return true;
    }//end addDocument

    //Document document findDocument (int uniqueNumber)
    public Document findDocument(int uniqueNumber) {
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


    //boolean update


    //delete
    // Document removeDocument (int uniqueNumber)
    //size--
    public Document removeDocument(int uniqueNumber) {
        for (int i = 0; i < size; i++) {
            if (documents[i].getUniqueNumber() == uniqueNumber) {
                Document victim = documents[i];
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

    //делаю допущение что книга была переиздана, а значит получила новые autor, isbn, year of publishing. Старым осталось только название title
    @Override
    public Document updateDocument(Document document) {
        if (document == null) return null;
        if (!(document instanceof Document)) return null;
        for (int i = 0; i < size; i++) {
            if (documents[i].getTitle().equals(document.getTitle())) {
                Document victim = documents[i];
                documents[i] = document;
                return victim;
            }//end if
        }//end for
        return null;
    }//updateDocument

    @Override
    public Document[] findAllDocumentsThisAutor(String autor) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (documents[i].getAuthor().equals(autor)) count++;
        }//end fori
        Document thisAutorAllDocuments [] = new Document [count];
        for (int i = 0, j = 0; i < size; i++) {
            if(documents[i].getAuthor().equals(autor)) thisAutorAllDocuments[j] = documents[i];
        }//end for
        return thisAutorAllDocuments;
    }//end findAllDocumentsThisAutor

    @Override
    public Document[] findTheOldestDocuments() {
        //находим самый старый год документов
        Document oldDocument = documents [0];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (documents[i].getYearOfPublishing() < oldDocument.getYearOfPublishing()){
                oldDocument = documents [i];
            }//end if
        }//end for
        //считаем сколько документов с самым старым годом
       int oldestYear = 0;
        for (int i = 0; i < size ; i++) {
            if(documents[i].getYearOfPublishing() == oldDocument.getYearOfPublishing()){
                oldestYear = documents[i].getYearOfPublishing();
                count++;
            }//end if
        }//end for
        //переносим все документы со самым старым годом в новый массив
        Document oldestDocumentsArray [] = new Document [count];
        for (int i = 0, j = 0; i <= oldestDocumentsArray.length; i++) {
            if(documents[i].getYearOfPublishing() == oldestYear){
                oldestDocumentsArray[j] = documents[i];
                j++;
            }//end if
        }//end fori
        return oldestDocumentsArray;
    }//end findTheOldestDocuments
}//end class