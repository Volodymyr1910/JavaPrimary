package view;

public enum StartMenu {


    START_WORKING(1, "Start a working day."), TRANS_REPORT_BY_DATE (2, "List of transactions by date"), CURRENCY_REPORT (3, "Report on all currencies"), UPDATE_TRANS(4, "Update transaction"), REMOVE_TRANS (5, "Remove transaction"), EXIT (6, "End of the working day.")
    ;


    private int number;
    private String action;


    StartMenu(int number, String action) {
        this.number = number;
        this.action = action;
    }


    public int getNumber() {
        return number;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Task{");
        sb.append("number=").append(number);
        sb.append(", action='").append(action).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static void printMenu (){
        System.out.println("-------------------Choose action by pressing number 1 - 6: -----------------------");
        projectsInProcess.organizer.model.Organizer myO [] = projectsInProcess.organizer.model.Organizer.values();
        for (Object o : myO) {
            System.out.println(o);
        }//end for
        System.out.println();
    }//end printMenu
}//end enum
