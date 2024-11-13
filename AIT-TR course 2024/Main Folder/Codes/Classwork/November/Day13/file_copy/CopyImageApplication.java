package Day13.file_copy;
//пишем утилиту для копирования файла
// имена файлов передаются в аргументах командной строки

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyImageApplication {

    public static void main(String[] args) {

    //String[] args -  он отвечает за получение элементов
    // проверяем чтоб аргументов было 2
        if(args.length != 2){
            System.out.println("Wrong number of arguments.");
        }//end if
        //print file names
        System.out.println("Source file: " + args[0]); //copy from args[0]
        System.out.println("Destination file: " + args[1]); //copy to args[1]

        // читать из файла, пока != -1, пишем в первый файл
        try (FileInputStream fin = new FileInputStream(args[0])) {
            FileOutputStream fout = new FileOutputStream(args[1]);

            int a = fin.read(); // read first byte
            while (a != -1){
                fout.write(a);
                a = fin.read(); // после каждого чтения курсор сдвигается на один байт
            }//end while





        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }//end main

}//end class
