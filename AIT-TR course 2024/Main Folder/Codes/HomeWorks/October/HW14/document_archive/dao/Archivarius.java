package HW14.document_archive.dao;

import HW14.document_archive.model.Document;

public interface Archivarius {

    //Обновить документ
    Document updateDocument (Document document);

    //найти все документы этого автора
     Document [] findAllDocumentsThisAutor ( String autor);

    //найти самые старые по году документы в архиве
    Document [] findTheOldestDocuments ();

}//end interface
