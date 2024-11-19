import dao.OperationsImpl;

import static dao.OperationsImpl.loadTransactions;
import static dao.OperationsImpl.saveTransactions;


public class CurrencyExchangeAppl {

    public static void main(String[] args) {


        //каждый запуск начинается с загрузки информации
        OperationsImpl transaction = loadTransactions();

        //работа с программой
        transaction.mainMenu();

        // при завершении работы авто-сохранение
        saveTransactions(transaction);


    } // end of main
} // end of class