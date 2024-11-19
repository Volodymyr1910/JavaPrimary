package Day13.input_output_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteOutputApplication {

    public static void main(String[] args) {
        //. - текущий каталог; .. - на уровень выше;
        try (FileOutputStream fout = new FileOutputStream("data.txt")) {

            fout.write(65);
            fout.write(66);
            fout.write(67);
            fout.write(10); // 10 - аски код enter - переход на другую строчку
            for (int i = 0; i < 26; i++) {
                fout.write(65 + i);
            }





        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }//end main

}//end class
