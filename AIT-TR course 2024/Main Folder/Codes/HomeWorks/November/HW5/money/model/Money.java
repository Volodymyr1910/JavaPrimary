package HW5.money.model;
//Задача 2. Создайте enum с кодами валют и их текущими курсами к евро. Убедитесь, что в списке нет дублирующихся кодов валют. Выведите список валют и их курсов на экран. Реализуйте возможность для пользователя выбрать желаемую валюту, ввести ее количество и узнать, сколько он получит при обмене на евро.
public enum Money {

    USD (1, "USD", "US Dollar", 0.92), UAH (2, "UAH", "Українська гривня", 0.022), CNY (3, "CNY", "Китайський Юань", 0.13), INR (4, "INR", "Індійський Рупій", 0.011), MXN (5, "MXN", "Мексиканське Песо", 0.92);


    private int number;
    private String code;
    private String name;
    private double ratioWithEuro;


    Money(int number, String code, String name, double ratioWithEuro) {
        this.number = number;
        this.code = code;
        this.name = name;
        this.ratioWithEuro = ratioWithEuro;
    }

    public int getNumber() {
        return number;
    }

    public String getCode() {
        return code;
    }

    public double getRatioWithEuro() {
        return ratioWithEuro;
    }

}//end enum
