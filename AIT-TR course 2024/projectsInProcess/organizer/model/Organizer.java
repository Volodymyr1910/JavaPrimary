package projectsInProcess.organizer.model;
////Задача 2. Начать реализацию приложения "Список дел".
////
////Использовать enum для организации меню (номер пункта, действие) приложения:
////добавить задачу
////посмотреть все задачи
////удалить задачу (по номеру)
////выйти из меню
////Реализовать метод printMenu().
public enum Organizer {

    ADDnewTASK (1, "Add a new task."), SEEallTASKS (2, "See the tasks list."), REMOVE_TASK (3, "Remove the task."), UPDATE_TASK(4, "Update task."), FIND_TASK_BY_NUMBER (5, "Find task by number."), FIND_TASK_BY_DATE (6, "Find task by finish date."),  EXIT (7, "Go to the previous menu."),
    ;


    private int number;
    private String action;


    Organizer(int number, String action) {
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
        System.out.println("-------------------Choose action by pressing number 1 - 7: -----------------------");
        Organizer myO [] = Organizer.values();
        for (Object o : myO) {
            System.out.println(o);
        }//end for
        System.out.println();
    }//end printMenu


}//end  enum
