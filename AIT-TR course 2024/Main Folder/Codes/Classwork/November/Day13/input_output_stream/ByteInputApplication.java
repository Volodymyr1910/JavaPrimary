package Day13.input_output_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteInputApplication {

    public static void main(String[] args) {


        try (FileInputStream fin = new FileInputStream("data.txt")) {

            System.out.println(fin.available());
             /*
            // we can read only once
            // READING Option 1
            int x = 0;
            while (x != -1) {
                System.out.println(x);
                x = fin.read(); // будут печататься аски коды символов
            }//end while */

            /*
            // READING Option 2
            int l = fin.available();
            for (int i = 0; i < l; i++) {
                int y = fin.read();
                System.out.println(y);
            } */

            // READING Option 3
            int l = fin.available();
            byte arr [] = new byte[l];
            fin.read(arr);
            for (byte b : arr) {
                System.out.print(b + " ");
            }



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }//end main
}//end class
