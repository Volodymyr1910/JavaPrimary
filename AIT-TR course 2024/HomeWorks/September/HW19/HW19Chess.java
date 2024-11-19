package HW19;

public class HW19Chess {
    //Задача 5. (*) Напечатайте на экране шахматную доску размером 8х8. 0 - белая клеточка, 1 - черная. Левая верхняя клеточка должна быть 0, левая нижняя - 1.
    public static void main(String[] args) {
        int a = 0, b = 1, c = 0, count = 0;

        while (count < 64){
            if (count % 8 ==0) {
                System.out.println();
                if (c == a) {
                    c = b;
                }else {
                    c=a;
                }//end if c

            }//end if count
            if (c == a) {
                System.out.print(b);
                count++;
                c = b;
            }else {
                System.out.print(a);
                count++;
                c = a;
            }//end else


        }//end while count


    }//end main
}//end class
