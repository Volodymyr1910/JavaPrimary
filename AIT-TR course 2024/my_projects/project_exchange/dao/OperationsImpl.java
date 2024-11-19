package dao;

import model.Transaction;
import money.model.Money;
import view.CurrencyExchange;
import view.StartMenu;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class OperationsImpl implements Operations {

    Comparator<Transaction> compRes = new Comparator<Transaction>() {
        @Override
        public int compare(Transaction o1, Transaction o2) {
            return Double.compare(o2.getRes(), o1.getRes());
        }
    };


    public static final String STORAGE = "current_exchange_list.dat";
    Scanner scanner;
    List<Transaction> transactions;

    public OperationsImpl(List<Transaction> transactions) {
        this.transactions = transactions;
    }


    public void startMenu() {
        System.out.println("Hello, Friend !");
        StartMenu moneyday[] = StartMenu.values();
        boolean checker = true;

        while (checker) {
            System.out.println("How can I help?");
            StartMenu.printMenu();
            Scanner scanner = new Scanner(System.in);
            int actionNum = scanner.nextInt();
            LocalDate dateFrom;
            LocalDate dateTo;
            switch (actionNum) {
                case 1 -> {
                    System.out.println(actionNum + ". " + moneyday[actionNum - 1].getAction() + " Good !");
                    mainMenu();
                }
                case 2 -> {
                    System.out.println(actionNum + ". " + moneyday[actionNum - 1].getAction() + " Input the number, please:");
                    int num = scanner.nextInt();
                    Transaction findedTrans = findTrans(num);
                    if (findedTrans == null) System.out.println("No such transaction.");
                    else System.out.println(findedTrans);
                }
                case 3 -> {
                    System.out.println(actionNum + ". " + moneyday[actionNum - 1].getAction() + " All transactions:");
                    System.out.println();printTrans();
                }
                case 4 -> {
                    System.out.println(actionNum + ". " + moneyday[actionNum - 1].getAction() + " Forgott something? Input data, please");
                    System.out.println();
                    System.out.println("Start date:");
                    dateFrom = dateFromUserToSystem();
                    System.out.println("Finish date:");
                    dateTo = dateFromUserToSystem();
                    printTrans(findTransByDate(dateFrom, dateTo));
                }
                case 5 -> {
                    System.out.println(actionNum + ". " + moneyday[actionNum - 1].getAction());
                    String valuta = chooseCurrency();
                    System.out.println();
                    int typeChoice = chooseType();
                    boolean typeFin = typeChoice == 1 ? true : false;
                    findTransByType(valuta, typeFin);
                }
                case 6 -> {
                    System.out.println(actionNum + ". " + moneyday[actionNum - 1].getAction() + "Enter the transaction number, you want to update:");
                    int numUpdate = scanner.nextInt();
                    if (updateTrans(numUpdate, transNewData()))System.out.println(" Update Successful !");
                    else System.out.println("No such transaction");
                }
                case 7 -> {
                    System.out.println(actionNum + ". " + moneyday[actionNum - 1].getAction() + " Enter the transaction number, you want to delete:");
                    int numRemove = scanner.nextInt();
                    if (removeTrans(numRemove))System.out.println(" Update Successful !");
                    else System.out.println("No such transaction");
                }
                case 8 -> {
                    checker = false;
                    System.out.println("Wait for you later. Bye !");
                }
                default -> System.out.println("I'm sorry, don't understand you.");

            }//end actionNum
        }//end while checker

    }//end startMenu

    /*
    public boolean updateTrans ( int numUpdate) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;  int tempNum = 0;
        String valuta = null;
        double amount = 0;
        boolean type = false;
        Transaction temp = findTrans(numUpdate);
        if (temp == null) return false;
        else System.out.println(temp);
        System.out.println();
        do {
            System.out.println("press for update: 1 -> new currency, 2 -> new quantity, 3 -> new type , 4 -> exit");
            // запрос через сканер на ввод новой валюты и количества и типа операции
            choice = scanner.nextInt();
            switch (choice){
                case 1 -> {
                    System.out.println("Choose new currency.");
                    temp.setName(chooseCurrency());
                }
                case 2 -> {
                    System.out.println("Input new quantity :");
                    scanner.next();
                    amount = scanner.nextDouble();
                }
                case 3 -> {
                    System.out.println(" Choose new type.");
                   type = chooseType() == 1 ? true : false;
                    temp.setType(type);
                }
                case 4 -> System.out.println("Done.");
                default -> System.out.println("Wrong input !");
            }//end switch
        }while (choice != 4);
        if(tempNum == 2) amount = amount * (-1);
        double newRes =  calcRes(valuta, amount);
        double newMarge =  calcMarge(valuta);
        temp.setRes(newRes);
        temp.setMarge(newMarge);
        return true;
    }//end updateTrans */

    public boolean updateTrans ( int numUpdate, Transaction newTr ) {
        Transaction updateTr = findTrans(numUpdate);
        if (updateTr == null) return false;
        else System.out.println(updateTr);
        System.out.println();
        //приходит c новыми именем, типом, ресом и маржой; локал дейт и номер не должны измениться
        updateTr.setName(newTr.getName());
        updateTr.setType(newTr.isType());
        updateTr.setRes(newTr.getRes());
        updateTr.setMarge(newTr.getMarge());
        return true;
    }//end updateTrans

    public Transaction transNewData (){
        Transaction newTr = new Transaction(0,null,false, null, 0, 0);
        Scanner scanner = new Scanner(System.in);
        int choice = 0;  int tempNum = 0;
        String valuta = null;
        double amount = 0;
        boolean type = false;
        do {
            System.out.println("press for update: 1 -> new currency, 2 -> new quantity, 3 -> new type , 4 -> exit");
            // запрос через сканер на ввод новой валюты и количества и типа операции
            choice = scanner.nextInt();
            switch (choice){
                case 1 -> {
                    System.out.println("Choose new currency.");
                    newTr.setName(chooseCurrency());
                }
                case 2 -> {
                    System.out.println("Input new quantity :");
                    scanner.next();
                    amount = scanner.nextDouble();
                }
                case 3 -> {
                    System.out.println(" Choose new type.");
                    type = chooseType() == 1 ? true : false;
                    newTr.setType(type);
                }
                case 4 -> System.out.println("Done.");
                default -> System.out.println("Wrong input !");
            }//end switch
        }while (choice != 4);
        if(tempNum == 2) amount = amount * (-1);
        double newRes =  calcRes(valuta, amount);
        double newMarge =  calcMarge(valuta);
        newTr.setRes(newRes);
        newTr.setMarge(newMarge);
        return newTr; // c новыми именем, типом, ресом и маржой; локал дейт и номер не должны измениться
    }//end transNewData

    public int chooseType() {
        // если сумма 'amount' положительная — это покупка, если отрицательная — это продажа.
        Scanner scanner = new Scanner(System.in);
        int typeChoice;
        do {
            System.out.println(" Press 1 - for sell, or 2 - for buy:");
            typeChoice = scanner.nextInt();
        } while (typeChoice < 1 || typeChoice > 2);
        return typeChoice;
    }//end chooseType


    public String chooseCurrency() {
        Scanner scanner = new Scanner(System.in);
        int currencyChoise;
        String valuta = null;
        do {
            System.out.println("Choose currency, please:");
            int tempNum = 1;
            for (CurrencyExchange choise : CurrencyExchange.values()) {
                System.out.println(" press " + tempNum++ + " - for " + choise.getCurrency_codes());
            }//end for
            currencyChoise = scanner.nextInt();
        } while (currencyChoise < 1 || currencyChoise > 6);
        switch (currencyChoise) {
            case 1 -> valuta = "USD";
            case 2 -> valuta = "AUD";
            case 3 -> valuta = "EGP";
            case 4 -> valuta = "KZT";
            case 5 -> valuta = "GBP";
            case 6 -> valuta = "FJD";
        }//end switch
        return valuta;
    }//end chooseCurrency

    public LocalDate dateFromUserToSystem() {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = null;
        String dateTemp;
        do {
            System.out.println("Enter the  date (example 12-12-2022):");
            dateTemp = scanner.nextLine();
            if (!checkDateFormat(dateTemp)) {
                System.out.println("Incorect date format.");
            }//end if
        } while (!checkDateFormat(dateTemp));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("[dd:MM:yyyy][dd/MM/yyyy][dd-MM-yyyy][dd.MM.yyyy][dd,MM,yyyy][dd_MM_yyyy]");
        try {
            date = LocalDate.parse(dateTemp, dtf);
        } catch (
                DateTimeParseException e) {
            System.out.println("Incorrect date format. Please try again.");
        }
        return date;
    }//end dateFromUserToSystem

    public boolean checkDateFormat(String str) {
        return str.matches("((((([0][1-9]|[1-2][0-9]|[3][0-1]))(-|.|/||:|,|_)(12))|(([0][1-9]|[1][0-9]|[2][0-8])(-|.|/||:|,|_)(02))|(([0][1-9]|[1-2][0-9]|30)(-|.|_)((01|[0][3-9]|[1][0-1])|)))(-|.|/||:|,|_)(([0-9][0-9][0-9][1-9]|[0-9][0-9][1-9][0-9]|[0-9][1-9][0-9][0-9]|[1-9][0-9][0-9][0-9])))");
    }//end checkDateFormatEU

    @Override
    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's work a little bit :)");
        int mainChoise;

        double amountChoise = 0;
        String valuta = null;
        do {
            int typeChoice = chooseType();
            do {
                System.out.println("Input quantity: ");
                amountChoise = scanner.nextDouble();
            } while (amountChoise < 1);
            valuta = chooseCurrency();
            // если сумма 'amount' положительная — это покупка, если отрицательная — это продажа.
            if(typeChoice == 2) amountChoise = amountChoise * (-1);
                double result = calcRes(valuta, amountChoise);
            double margeResult = calcMarge(valuta);

            // true or 1 -  продажа, false or 2 - покупка
            boolean typeFin = typeChoice == 1 ? true : false;
            //Collections.sort(transactions);
            int transactionNum = 0;
            if (transactions.isEmpty()) transactionNum = 1;
            else transactionNum = transactions.size();
            //int transactionNum = transactions.size() == 0 ? 1 : transactions.size();
            addTrans(transactionNum, valuta, typeFin, null, result, margeResult);
            do {
                System.out.println(" Press 1 - for continue, or 0 - for exit:");
                mainChoise = scanner.nextInt();
            } while ( mainChoise != 0);  //(mainChoise != 1 || mainChoise != 0);
            if (mainChoise == 0) System.out.println(" See you soon ;)");
        } while (mainChoise != 0);

    }//end mainMenu



    @Override
    public Transaction addTrans(int num, String name, boolean type, LocalDate date, double res, double marge) {
        transactions.add(transactions.size(), new Transaction(num, name, type, date, res, marge));
        return transactions.get(transactions.size()-1);
    }//end addTrans

    @Override
    public boolean removeTrans(int num) {
        // Ищем транзакцию по номеру и удаляем
        return transactions.removeIf(transaction -> transaction.getNumber() == num);
    }

    @Override
    public Transaction findTrans(int num) {
        // Возвращаем транзакцию по номеру
        for (Transaction transaction : transactions) {
            if (transaction.getNumber() == num) {
                return transaction;
            }
        }
        return null; // Если не найдена
    }

    @Override
    public List<Transaction> findTransByDate(LocalDate dateFrom, LocalDate dateTo) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactions) {
            LocalDate date = transaction.getDate();
            if ((date.isEqual(dateFrom) || date.isAfter(dateFrom)) &&
                    (date.isEqual(dateTo) || date.isBefore(dateTo))) {
                result.add(transaction);
            }
        }
        return result;
    }

    @Override
    public List<Transaction> findTransByType(String valuta, boolean type) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.isType() == type && transaction.getName().equals(valuta)) {
                result.add(transaction);
            }
        }
        transactions.sort(compRes);
        return result;
    }//end findTransByType


    @Override
    public int quantity() {
        return transactions.size();
    }


    @Override
    public double calcRes(String name, double amount) // название валюты и сумма для обмена
    // если сумма 'amount' положительная — это покупка, если отрицательная — это продажа.
    {
        CurrencyExchange currency = null; // ищем курс в enum
        for (CurrencyExchange ce : CurrencyExchange.values())
        {
            if (ce.getCurrency_codes().equals(name)) // название валюты "name" передано в этот метод
            {
                currency = ce;
                break;
            }
        }
        // если валюта не найдена, сообщаем об этом и возвращаем 0
        if (currency == null) {
            System.out.println("Currency " + name + " not found.");
            return 0;
        }
        // получили курс из enum для валюты
        double rate = currency.getCurrent_exchange();
        // маржа для курса валюты, через метод calcMarge
        double margin = calcMarge(name);
        double rateWithMargin = 0; // курс с маржей
        if (amount < 0) { //  если < 0 = продажа, иначе покупка
            rateWithMargin = rate - margin;  // если продажа, то маржа вычитается
        } else {
            rateWithMargin = rate + margin;  // если покупка, то маржа добавляется
        }
        //  результат обмена с учетом маржи
        double result = 0;
        if (amount < 0) {  // опять, если сумма отрицательная — это продажа
            result = Math.abs(amount) * rateWithMargin;  // продаем валюту и получаем евро
        } else {  // Покупка
            result = Math.abs(amount) / rateWithMargin;  // покупаем валюту за евро
        }
        System.out.println("Result of the exchange " + result + " EUR");
        return result;
    }
    @Override
    public double calcMarge(String currencyName)
    {
        //  курс по названию валюты
        CurrencyExchange currency = null;
        for (CurrencyExchange ce : CurrencyExchange.values()) {
            if (ce.getCurrency_codes().equals(currencyName)) {
                currency = ce;
                break;
            }
        }
        //  валюта не найдена, тогда -> 0
        if (currency == null) {
            System.out.println("Currency " + currencyName + " not found.");
            return 0;
        }
        // вытаскиваем курс для данной валюты
        double rate = currency.getCurrent_exchange();
        //  маржа (5% от курса)
        double margin = rate * 0.05;
        return margin;
    }


    @Override
    public void printTrans() {
        if (transactions.isEmpty()) {
            System.out.println("The transaction list is empty.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    public void printTrans(List <Transaction> newList) {
        if (newList.isEmpty()) {
            System.out.println("The transaction list is empty.");
        } else {
            for (Transaction transaction : newList) {
                System.out.println(transaction);
            }
        }
    }

    //файл Насти
    public static OperationsImpl loadTransactions() {
        File file = new File(STORAGE);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                System.out.println("Load Data from storage...");
                OperationsImpl ops = (OperationsImpl) ois.readObject();
                if (ops.transactions == null) {
                    ops.transactions = new ArrayList<>(); // Инициализируем список, если он пуст
                }
                return ops;
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading data: " + e.getMessage());
            }
        }
        // Если файла не существует
        System.out.println("Create new organizer...");
        return new OperationsImpl(new ArrayList<>()); // Инициализируем пустой список
    }
        /*
    public static OperationsImpl loadTransactions() {
        File file = new File(STORAGE);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                System.out.println("Load Data from storage...");
                return (OperationsImpl) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading data: " + e.getMessage());
            }
        }
        // Если файла не существует
        System.out.println("Create new organizer...");
        return new OperationsImpl(null);
    }//loadTransactions */

    public static void saveTransactions(OperationsImpl note) {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(STORAGE))) {
            System.out.println("Saving data to storage...");
            ous.writeObject(note);
        } catch (IOException e) {
            System.out.println("Error while saving data: " + e.getMessage());
        }
    }//saveTransactions

} // end of class