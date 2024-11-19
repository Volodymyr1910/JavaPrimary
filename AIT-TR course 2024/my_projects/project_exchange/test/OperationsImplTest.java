package test;

import dao.OperationsImpl;
import model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationsImplTest {

    private OperationsImpl operations;

    @BeforeEach
    void setUp() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, "USD", true, LocalDate.now(), 100, 1.5)); //продажа
        transactions.add(new Transaction(2, "EUR", false, LocalDate.now().minusDays(1), 200, 2.0)); //покупка
        transactions.add(new Transaction(3, "USD", true, LocalDate.now().minusDays(2), 300, 1.0)); //продажа
        transactions.add(new Transaction(4, "GPB", false, LocalDate.now().minusDays(3), 400, 1.2)); //покупка

        operations = new OperationsImpl(transactions);

    }

    @Test
    void addTrans() {
        int newTransNum = 5;
        Transaction add = operations.addTrans(newTransNum, "USD", true, null, 400, 4);
        assertEquals(newTransNum, add.getNumber());
    }


    @Test
    void removeTrans() {
        boolean res = operations.removeTrans(2);
        assertTrue(res);
        assertNull(operations.findTrans(2));
        boolean resNotFound = operations.removeTrans(111);
    }

    @Test
    void findTrans() {
        Transaction found = operations.findTrans(3);
        assertNull(found);
        assertEquals(3,found.getNumber());
        Transaction notFound = operations.findTrans(111);
    }

    @Test
    void findTransByDate() {
        LocalDate dateFrom = LocalDate.now().minusDays(2);
        LocalDate dateTo = LocalDate.now();
        List<Transaction> foundTrans = operations.findTransByDate(dateFrom, dateTo);
        assertNotNull(foundTrans);
        assertFalse(foundTrans.isEmpty());
        assertEquals(3, foundTrans.size());
    }

    @Test
    void findTransByType() {

        // так как true- продажа, false -покупка, находим транзакции данного типа
        // сначала проверяем, что метод возвращает только продажи
        List<Transaction> saleTransactions = operations.findTransByType("USD",true);
        // исходя из тестового набора данных, ожидается 2 продажи
        assertEquals(2, saleTransactions.size());
        // проверяем валюты продаж
        assertEquals("USD", saleTransactions.get(0).getName());
        assertEquals("USD", saleTransactions.get(1).getName());

        // аналогичныу тесты для покупки
        List<Transaction> buyingTransactions = operations.findTransByType("USD",false);
        assertEquals(0, buyingTransactions.size());
        assertEquals("EUR", buyingTransactions.get(0).getName());
        assertEquals("GPB", buyingTransactions.get(1).getName());

    }

    @Test
    void quantity() {
        int count = operations.quantity();
        // узнаем количество транзакций
        assertEquals(4, count);
    }

    @Test
    void calcRes() {

        double amountToExchange = 100;
        String currencyName = "USD";
        double rate = 0.9178;
        double marge = rate * 0.05;
        // вычитаем маржу для продажи
        double rateWithMarge = rate - marge;
        // ожидаемый результат от продажи
        double expectedResult = amountToExchange * rateWithMarge;

        double actualResult = operations.calcRes(currencyName, amountToExchange, 2);  // для продажи

        assertEquals(expectedResult, actualResult, 0.01);

    }

    @Test
    void calcMarge() {
        String currencyCode = "USD";
        double rate = 0.9178;
        double expectedMarge = rate * 0.05;
        //рассчитываем маржу с помощьюметода
        double actualMarge = operations.calcMarge(currencyCode);
        assertEquals(expectedMarge, actualMarge, 0.01);
    }

} // end of class