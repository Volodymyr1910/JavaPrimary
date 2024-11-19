package HW2.Cube;

import HW2.Cube.model.Cube;

public class CubeApplication {

    public static void main(String[] args) {

        Cube cube1 = new Cube(4);
        Cube cube2 = new Cube(14);
        Cube cube3 = new Cube(23);


        cube1.display();
        System.out.println("Perimetr equal -> " + cube1.perimetr(cube1.getCubeSide()) + "; Area equal -> " + cube1.area(cube1.getCubeSide()) + "; Volume equal -> " + cube1.volume(cube1.getCubeSide()));

        cube2.display();
        System.out.println("Perimetr equal -> " + cube2.perimetr(cube2.getCubeSide()) + "; Area equal -> " + cube2.area(cube2.getCubeSide()) + "; Volume equal -> " + cube2.volume(cube2.getCubeSide()));

        cube3.display();
        System.out.println("Perimetr equal -> " + cube3.perimetr(cube3.getCubeSide()) + "; Area equal -> " + cube3.area(cube3.getCubeSide()) + "; Volume equal -> " + cube3.volume(cube3.getCubeSide()));


    }//end main








}//ena class
