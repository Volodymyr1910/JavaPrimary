package HW1;

import MyMethods.list_methods.ListMethods;
import my_projects.computer_shop.model.Computer;
import my_projects.computer_shop.model.Laptop;
import my_projects.computer_shop.model.Smartphone;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComputerNew {
    public static void main(String[] args) {

        //Task 1. Based on the Computer class:
        //
        //create your own ArrayList;
        //add at least 6 elements to it;
        //sort the list by brand;
        //sort the list by RAM size, then by SSD size if RAM is equal;
        //calculate the total volume and average SSD value.

        List<Computer> computerList = new ArrayList<>();

        computerList.add(new Computer("i7", 8,256, "Acer", 1200));
        computerList.add(new Computer("i5", 16,256, "HP", 1500));
        computerList.add(new Laptop("Apple", 8,256, "MacBook", 2000,14.3,1.5,10,"White"));
        computerList.add(new Smartphone("Snap Dragon", 8, 128, "Samsung", 400, 7.5,0.150, 20, "Silver",123456789012345l));
        computerList.add(new Computer("AMD", 8,256, "NoName", 2000));
        computerList.add(new Laptop("iCore12", 16,1024, "MacBook Air", 2500,18.3,1.8,12,"Black"));

        computerList.sort(Computer::compareTo);
        ListMethods.printList(computerList, "after native sort");
        System.out.println();

        Comparator<Computer> compBaRAMandSSD = new Comparator<Computer>() {
            @Override
            public int compare(Computer o1, Computer o2) {
                int r = Integer.compare(o1.getRam(), o2.getRam());
                return r != 0 ? r : Integer.compare(o1.getSsd(), o2.getSsd());
            }
        };
        computerList.sort(compBaRAMandSSD);
        ListMethods.printList(computerList, "after sort by RAM and SSD");

        int ssdTotal = 0;
        for (Computer c : computerList) {
            ssdTotal += c.getSsd();
        }//end for
        double avgSSD = (double) ssdTotal / computerList.size();
        System.out.println();
        System.out.println("Total SSD value of all devices in storage is -> " + ssdTotal + ", average value is -> " + avgSSD + ".");





    }//end main

}//end clas
