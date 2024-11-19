package MyMethods.enum_variants.month;
//Задайте Enum Month, определите месяца, их наименования и количество в них дней.
//Реализуйте метод, позволяющий прибавлять месяца к выбранному, получая правильный месяц.
//Пример: AUG + 6 month = FEB
//Проверьте работу метода в приложении.
public enum Month {

    JAN ("January", 31), FEB ("February", 28), MAR ("March", 31), APR("April", 30), MAY ("May", 31), JUN ("June", 30), JUL ("July", 31), AUG ("August", 31), SEP ("September", 30), Oct ("October", 31), NOV ("Novemeber", 30), DEC ("December", 31)
    ;

    //fields
    private String name;
    private int days;

    Month(String name, int days) {
        this.name = name;
        this.days = days;
    }


    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Month{");
        sb.append("name='").append(name).append('\'');
        sb.append(", days=").append(days);
        sb.append('}');
        return sb.toString();
    }

    public Month plusMonth (int quantity){
        int index = this.ordinal() + quantity;
        //int res = index % 12;// 12 - это хардкод
        //int res = index % 12;// 12 - это хардкод
        Month[] months = values(); // чтоб не хардкодить, выход перегнать в массив и найти длину
        int res = index % months.length;
        return months[res];
    }//end calcMonth



}//end enum
