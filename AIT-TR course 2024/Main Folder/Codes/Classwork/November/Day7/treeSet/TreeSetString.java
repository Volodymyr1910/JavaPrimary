package Day7.treeSet;

import java.util.Arrays;
import java.util.TreeSet;

public class TreeSetString {


    public static void main(String[] args) {


        TreeSet<String> rivers = new TreeSet<>(Arrays.asList("Volga", "Dnipro", "Lech", "Rein", "Elbe", "Neva", "Dunau", "Isar"));

        System.out.println(rivers.size());
        System.out.println(rivers);

        //итератор показывает абьекты в обьекте river, перебирая-итерируя их по одному. При єтом доступа к обьекту river или к его елементам итератор не дает
        for (String str : rivers) {
            System.out.println(str);
        }//end for

        System.out.println("-------------------------------------------");
        System.out.println(rivers.higher("Rein")); // Volga
        System.out.println(rivers.lower("Isar")); // Elbe

        System.out.println("=============================");
        String str = rivers.ceiling("Dnipro");
        System.out.println(str);


    }//end main
}//end class
