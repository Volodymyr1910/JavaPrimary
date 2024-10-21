package HW18.document_archive_v2.dao_v2;

import HW18.document_archive_v2.model_v2.Document_v2;

public interface Archivarius_v2 {

    //Обновить документ
    Document_v2 updateDocument (Document_v2 document);

    //найти все документы этого автора
     Document_v2[] findAllDocumentsThisAutor (String autor);

     Document_v2[] findAllDocumentsThisYear(int year);

    //найти самые старые по году документы в архиве
    Document_v2[] findTheOldestDocuments ();

}//end interface
