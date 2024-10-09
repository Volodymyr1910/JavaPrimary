package HW9;

////Задание 3. Напишите приложение, которое выводит минимальные/максимальные числовые значения примитивных типов: byte, short, char, int, long, float, double Типы как объекты String должны браться из аргументов основной функции main. Если в аргументах нет какого-либо типа (не указан тип), приложение должно вывести максимальное/минимальное значения 7 типов (byte, int, short, long, char, float, double). Если аргументы содержат неправильный тип, приложение должно вывести сообщение: Неверный тип.
////
public class MaxAndMinOfAllJavaTipe {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("byte: MIN value -> " + Byte.MIN_VALUE + ", MAX value -> " + Byte.MAX_VALUE + "; short: MIN value -> " + Short.MIN_VALUE + ", MAX value -> " + Short.MAX_VALUE + "; int: MIN value -> " + Integer.MIN_VALUE + ", MAX value -> " + Integer.MAX_VALUE + ".");
            System.out.println("long: MIN value -> " + Long.MIN_VALUE + ", MAX value -> " + Long.MAX_VALUE + "; float: MIN value -> " + Float.MIN_VALUE + ", MAX value -> " + Float.MAX_VALUE + ".");
            System.out.println("double: MIN value -> " + Double.MIN_VALUE + ", MAX value -> " + Double.MAX_VALUE + "; char: MIN value -> " + Character.MIN_VALUE + ", MAX value -> " + Character.MAX_VALUE + ".");
        } else {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "byte" ->
                            System.out.println("Selected type -> " + args[i] + "; Min value -> " + Byte.MIN_VALUE + ", Max value -> " + Byte.MAX_VALUE + ".");
                    case "short" ->
                            System.out.println("Selected type -> " + args[i] + "; Min value -> " + Short.MIN_VALUE + ", Max value -> " + Short.MAX_VALUE + ".");
                    case "char" ->
                            System.out.println("Selected type -> " + args[i] + "; Min value -> " + Character.MIN_VALUE + ", Max value -> " + Character.MAX_VALUE + ".");
                    case "int" ->
                            System.out.println("Selected type -> " + args[i] + "; Min value -> " + Integer.MIN_VALUE + ", Max value -> " + Integer.MAX_VALUE + ".");
                    case "long" ->
                            System.out.println("Selected type -> " + args[i] + "; Min value -> " + Long.MIN_VALUE + ", Max value -> " + Long.MAX_VALUE + ".");
                    case "float" ->
                            System.out.println("Selected type -> " + args[i] + "; Min value -> " + Float.MIN_VALUE + ", Max value -> " + Float.MAX_VALUE + ".");
                    case "double" ->
                            System.out.println("Selected type -> " + args[i] + "; Min value -> " + Double.MIN_VALUE + ", Max value -> " + Double.MAX_VALUE + ".");
                    case null ->
                            System.out.println("byte -> MIN value - " + Byte.MIN_VALUE + ", MAX value - " + Byte.MAX_VALUE + "; short -> MIN value - " + Short.MIN_VALUE + ", MAX value - " + Short.MAX_VALUE + "; int -> MIN value - " + Integer.MIN_VALUE + ", MAX value - " + Integer.MAX_VALUE + "; long -> MIN value - " + Long.MIN_VALUE + ", MAX value - " + Long.MAX_VALUE + "; float -> MIN value - " + Float.MIN_VALUE + ", MAX value - " + Float.MAX_VALUE + "; double -> MIN value - " + Double.MIN_VALUE + ", MAX value - " + Double.MAX_VALUE + "; char -> MIN value - " + Character.MIN_VALUE + ", MAX value - " + Character.MAX_VALUE + ".");
                    default -> System.out.println("Wrong type.");
                }//end switch
            }//end for
        }


    }//end main


}//end class
