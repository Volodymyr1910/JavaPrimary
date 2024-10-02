package Day23;
//**Задача 4.**
//Создайте массив, который содержит возраст студентов группы.
//- какой возраст максимальный?
//- какой возраст минимальный?
public class MinElement {
    public static void main(String[] args) {
        int[] studentAge  = {47, 49,37 ,47 ,52 ,60 ,44 ,34, 38, 59, 18, 38, 35, 41, 18, 43};

        int min = studentAge[0];

        for (int i = 0; i < studentAge.length; i++) {
            if(studentAge[i]<min){
                min = studentAge[i];

            }//end if

        }//end for
        System.out.println("Min age is " + min);

    }//end main
}//end class
