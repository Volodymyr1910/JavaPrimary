package test;

import dao.OperationsImpl;
import model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.CurrencyExchange;

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
        Transaction add = operations.addTrans(newTransNum, "AUD", true, LocalDate.now(), 500.0, 2.5);
        assertEquals(newTransNum, add.getNumber());
        assertEquals("AUD", add.getName());
        assertEquals(true, add.isType());
        assertEquals(LocalDate.now(), add.getDate());
        assertEquals(500.0, add.getRes());
        assertEquals(2.5, add.getMarge());

        assertEquals(5, operations.quantity());
        assertEquals(add, operations.findTrans(newTransNum));

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
        assertNotNull(found);
        assertEquals(3,found.getNumber());
        Transaction notFound = operations.findTrans(111);

    }

    @Test
    void UpdateTrans() {
        // successfully update
        Transaction newTr = new Transaction(0, "EGP", true, LocalDate.now().plusDays(3), 500, 3.0);
        boolean resultSuccess = operations.updateTrans(2, newTr);
        assertTrue(resultSuccess, "Update should be successful");

        Transaction updatedTr = operations.findTrans(2);
        assertNotNull(updatedTr, "Updated transaction should't be null");
        assertEquals("EGP", updatedTr.getName());
        assertTrue(updatedTr.isType());
        assertEquals(500, updatedTr.getRes());
        assertEquals(3.0, updatedTr.getMarge());
        assertEquals(2, updatedTr.getNumber());
        assertEquals(LocalDate.now().minusDays(1), updatedTr.getDate());

        //try to update non-existent transaction
        boolean resultNotFound = operations.updateTrans(111, newTr);
        assertFalse(resultNotFound, "Update should fail for non-existent transaction");

        // try update to null transaction
        boolean resultNullTransaction = operations.updateTrans(2, null);
        assertFalse(resultNullTransaction, "Update should fail for null transaction");
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
        // Проверяем продажи для валюты "USD"
        List<Transaction> saleTransactions = operations.findTransByType("USD", true);
        assertEquals(2, saleTransactions.size());
        assertEquals("USD", saleTransactions.get(0).getName());
        assertEquals("USD", saleTransactions.get(1).getName());

        // Проверяем покупки для валюты "EUR"
        List<Transaction> eurBuyingTransactions = operations.findTransByType("EUR", false);
        assertEquals(1, eurBuyingTransactions.size());
        assertEquals("EUR", eurBuyingTransactions.get(0).getName());

        // Проверяем покупки для валюты "GPB"
        List<Transaction> gpbBuyingTransactions = operations.findTransByType("GPB", false);
        assertEquals(1, gpbBuyingTransactions.size());
        assertEquals("GPB", gpbBuyingTransactions.get(0).getName());
    }

    @Test
    void quantity() {
        int count = operations.quantity();
        // узнаем количество транзакций
        assertEquals(4, count);
    }

    @Test
    void calcRes() {
        // тестируем покупку USD
        double actualUsdBuying = operations.calcRes("USD", 100);
        double expectedUsdBuying = 100 / (CurrencyExchange.USD.getCurrent_exchange() + CurrencyExchange.USD.getCurrent_exchange() * 0.05);//узнаем сколько получим с покупки 100 долларов
        assertEquals(expectedUsdBuying, actualUsdBuying, 0.001);
        // продажa USD
        double actualUsdSell = operations.calcRes("USD", -100);
        double expectedUsdSell = 100 * (CurrencyExchange.USD.getCurrent_exchange() - CurrencyExchange.USD.getCurrent_exchange() * 0.05);// узнаем сколько получим с продажи 100 долларов
        assertEquals(expectedUsdSell, actualUsdSell, 0.001);
        // делаем тест на покупку не существующей валюты
        double invalidRes = operations.calcRes("INVALID", 100);
        assertEquals(0, invalidRes);// так как валюты не существует, то и результат получим 0
    }


    @Test
    void calcMarge() {
        // рассчитываем маржу для доллара
        double usdMargin = operations.calcMarge("USD");
        assertEquals(0.05 * CurrencyExchange.USD.getCurrent_exchange(), usdMargin, 0.001);
        // несуществующая валюта
        double invalidMargin = operations.calcMarge("INVALID");
        assertEquals(0, invalidMargin);// так как такой валюты нет, то и маржа будет 0
    }

} // end of class