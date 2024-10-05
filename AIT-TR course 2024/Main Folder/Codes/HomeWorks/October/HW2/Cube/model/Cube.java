package HW2.Cube.model;

//Задача 2. Создать класс Cube, описывающий куб cо стороной a.
// Реализовать в нем методы определения периметра p (сумма длин всех ребер), площади s (сумма площадей всех граней) и объема v.
// Создать приложение CubeAppl, в котором создать несколько экземпляров класса Cube. Для каждого экземпляра вызвать методы класса Cube и рассчитать p, s и v.
//
public class Cube {

    double cubeSide;


    public Cube(double cubeSide) {
        this.cubeSide = cubeSide;
    }


    public double getCubeSide() {
        return cubeSide;
    }

    public void setCubeSide(double cubeSide) {
        this.cubeSide = cubeSide;
    }

    public void display (){
        System.out.println("The lenght of the side of the cube -> " + getCubeSide());
    }

    public double perimetr (double a){
        return 12 * a;
    }//end perimetr

    public double area (double a){
        return  6 * a * a;
    }//end area

    public double volume (double a){
        return  Math.pow(a, 3);
    }//end volume





}//end class



