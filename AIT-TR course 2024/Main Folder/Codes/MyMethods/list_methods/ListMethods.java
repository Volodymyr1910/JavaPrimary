package MyMethods.list_methods;

import java.util.List;

public class ListMethods {

    public static void printList(List list, String s) {
        System.out.println("------------------------ " + " List "  + s + " ------------------------");
        for (int i = 0, count = 0; i < list.size(); i++, count++) {
            System.out.println(count + " " + list.get(i));
        }//end for
    }//end printList




}//end class
