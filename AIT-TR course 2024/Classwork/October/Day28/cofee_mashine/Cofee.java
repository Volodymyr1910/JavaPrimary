package Day28.cofee_mashine;
//**Задача 3.**
//Используя enum, напишите программу для продажи 4-х видов кофе:
//ESPRESSO,
//AMERICANO,
//CAPPUCCINO,
//LATTE
//Предложите пользователю кофе на выбор, по результатам выбора сообщите стоимость напитка.
public enum Cofee {

    ESP("Espresso", 2.5, 1), AMR("Americano", 3, 2), CAP("Capuccino", 4, 3), LAT("Latte", 5, 4)
    ;

    //fields;
   private String title;
    private double price;
    private int choise;

    Cofee(String title, double price, int choise) {
        this.title = title;
        this.price = price;
        this.choise = choise;
    }


    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getChoise() {
        return choise;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cofee{");
        sb.append("title='").append(title).append('\'');
        sb.append(", price=").append(price);
        sb.append(", choise=").append(choise);
        sb.append('}');
        return sb.toString();
    }


}//end ENUM
