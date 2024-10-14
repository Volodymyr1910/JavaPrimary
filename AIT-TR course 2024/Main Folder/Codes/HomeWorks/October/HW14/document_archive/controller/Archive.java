package HW14.document_archive.controller;

import HW14.document_archive.model.Document;

public class Archive {

    private Document [] documents;
    private int size;

    public Archive(int capasity) {
        this.documents = new Document[capasity];
        this.size = size;
    }


    // true or false create (document)
    //boolean addDocument (document)
    //size++

    //Document document findDocument (int uniqueNumber)
    public  Document findDocument (int uniqueNumber){

        Document foundedDocument = null;
        return foundedDocument;

    }//end findDocument



    //read
    // void printDocument



    //boolean update


    //delete
    // boolean removeDocument (int uniqueNumber)
    //size--

    public int size (){
        return size;
    }


}//end class