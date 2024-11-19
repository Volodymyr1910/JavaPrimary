package HW16;

public class TriangleWithBoolean {
    public static void main(String[] args) {

        int a = 50;
        int b = 56;
        int c = 20;

        boolean res = checkTriangle(a, b, c);

        if (res) {
            System.out.println("The triangle with sides " + a + ", " + b + " and " + c + " exists!");
        } else {
            System.out.println("The triangle with sides " + a + ", " + b + " and " + c + " can't exist!");

        }
    }//end of main
    private static boolean checkTriangle(int a, int b, int c) {
        return (a < (b + c) && b < (a + c) && c < (b + a));
    }
}//end of class
