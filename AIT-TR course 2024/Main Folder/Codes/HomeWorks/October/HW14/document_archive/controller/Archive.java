package HW14.document_archive.controller;

import HW14.document_archive.model.Document;

public class Archive {

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
    }


}//end class