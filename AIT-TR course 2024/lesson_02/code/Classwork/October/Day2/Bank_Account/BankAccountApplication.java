package Day2.Bank_Account;

import Day2.Bank_Account.model.BankAccount;

public class BankAccountApplication {
    public static void main(String[] args) {

        BankAccount account001 = new BankAccount(101L,"Jack Forward","Sparkasse", 87, 100);
        account001.display();

        System.out.println(account001.toString());

        BankAccount account002 = new BankAccount(102L, "Pit Brosnan", "Sparkasse", 87);
        account002.display();

        BankAccount account003 = new BankAccount(103L,"Sparkasse", 87,300000);
        account003.display(); //"null" - пустая ссылка, хранится в стеке, никуда не ведет

        account001.deposit(500);
        account001.display();
        account002.deposit(300);
        account002.display();
        System.out.println("-------------withdraw------------");
        account001.withdraw(500);
        account001.display();
        account001.withdraw(200);
        account001.display();
        account001.withdraw(100);
        account001.display();


    }//end main


}//end class
