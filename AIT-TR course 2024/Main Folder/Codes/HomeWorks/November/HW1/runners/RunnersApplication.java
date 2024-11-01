package HW1.runners;

import MyMethods.list_methods.ListMethods;

import java.util.*;

public class RunnersApplication {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        List<Runners> runnersList = new ArrayList<>();

        runnersList.add(new Runners("Salivan", "Jack",1, "USA", 0));
        runnersList.add(new Runners("Pitt", "Bradd",2, "Great Britain", 0));
        runnersList.add(new Runners("Obrayan", "Scott",3, "Norway", 0));
        runnersList.add(new Runners("Slim", "Djo",4, "France", 0));
        runnersList.add(new Runners("White", "Walter",5, "Australia", 0));
        runnersList.add(new Runners("Lepisevych", "Volodymyr",6, "Ukraine", 0));
        runnersList.add(new Runners("Do", "Fin",7, "Japan", 0));
        runnersList.add(new Runners("Soul", "Rico",8, "Finland", 0));
        runnersList.add(new Runners("List", "Arrny",9, "Italy", 0));
        runnersList.add(new Runners("Monarro", "Pablo",10, "Canada", 0));

        double result = 0;
        for (int i = 0; i < runnersList.size(); i++) {
            System.out.println("Runner " + runnersList.get(i).getFirstName() + " " + runnersList.get(i).getLastName() + ". From " + runnersList.get(i).getClub() + " ...On start line please....Ready? ....3...2...1... GO !!!" );
            //result = scanner.nextDouble();
            result = random.nextDouble(9.58,15);
            runnersList.get(i).setRunResult(result);
            System.out.println(runnersList.get(i).getLastName() + " " + runnersList.get(i).getFirstName() + ". Result -> " + runnersList.get(i).getRunResult());
        }//end for

        Collections.sort(runnersList);
        System.out.println( "Competitiom is over. Here is a winners !");

        for (int i = 2; i >= 0; i--) {
            System.out.println( i + 1 + " place got... " + runnersList.get(i).getClub() + " ...... " + runnersList.get(i).getFirstName() + " " + runnersList.get(i).getLastName() + " with result -> " + runnersList.get(i).getRunResult());
        }

        ListMethods.printList(runnersList, "all results :");
    }//end main

}//end class
