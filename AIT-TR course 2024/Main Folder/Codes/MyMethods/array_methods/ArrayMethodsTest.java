package MyMethods.array_methods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMethodsTest {

    ArrayMethods arrayMethods;
    int array[] = {13, 25, 8, 0, -3, 50, 24, -18};


    @BeforeEach
    void setUp() {
        arrayMethods = new ArrayMethods();
    }

    @Test
    void minElementInArayTest() {
        int expected = -18;
        int actual = ArrayMethods.MinElementInAray(array);

        assertEquals(expected, actual, "Method Failed");
    }

    @Test
    void maxElementInArayTest() {
        int expected = 50;
        int actual = ArrayMethods.MaxElementInAray(array);

        assertEquals(expected, actual, "Method Failed");
    }

    @Test
    void indexOfMinElementInArayTest() {
        int expected = 7;
        int actual = ArrayMethods.indexOfMinElementInAray(array);

        assertEquals(expected, actual, "Method Failed");
    }

    @Test
    void indexOfMaxElementInArayTest() {
        int expected = 5;
        int actual = ArrayMethods.indexOfMaxElementInAray(array);

        assertEquals(expected, actual, "Method Failed");

    }

    //Задача 1. Реализуйте в классе ArrayMethods следующие методы для массивов целых чисел:

    //сумма всех элементов массива с нечетными индексами;
    //поиск 5-го элемента в массиве.
    // Разработайте тесты для этих методов.
    @Test
    void sumArrayElementsWithOddIndexesTest() {
        int array[] = {1, 2, 1, 2, 1, 2, 1, 2};
        assertEquals(8, ArrayMethods.sumArrayElementsWithOddIndexes(array), "Method Failed");
    }

    @Test
    void sumArrayElementsWithEvenIndexesTest() {
        int array[] = {1, 2, 1, 2, 1, 2, 1, 2};
        assertEquals(4, ArrayMethods.sumArrayElementsWithEvenIndexes(array), "Method Failed");
    }

    @Test
    void returnNumberfromArrayUnderSelectedIndexTest() {
        int array[] = {1, 2, 3, 4, 5, 2, 1, 2};
        assertEquals(2, ArrayMethods.returnNumberfromArrayUnderSelectedIndex(array, 5), "Method Failed");
    }

    @Test
    void returnFifthIndexOfRepeatedElementManySameElements() {
        int array[] = {1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1};
        assertEquals(8, ArrayMethods.returnFifthIndexOfRepeatedElement(array, 1), "Method Failed");
    }

    @Test
    void returnFifthIndexOfRepeatedElementQuantityOfSameElementsLowerThanFive() {
        int array[] = {1, 2, 1, 3, 1, 4, 1};
        assertEquals(6, ArrayMethods.returnFifthIndexOfRepeatedElement(array, 1), "Method Failed");
    }

    @Test
    void returnFifthIndexOfRepeatedElementNoElementsWhatWeLookingFor() {
        int array[] = {0, 2, -1};
        assertEquals(-1, ArrayMethods.returnFifthIndexOfRepeatedElement(array, 1), "Method Failed");
    }

//Задача 2. Создайте массив из 100 случайных целых чисел в интервале от -10 до 10. Подсчитайте, сколько в этом массиве оказалось:

//положительных чисел;
//отрицательных чисел;
//четных чисел;
//нулей.
// Реализуйте все подсчеты методами и напишите для них тесты.

    @Test
    void howMuchPositiveNumbersInArrayTest () {
        int array[] = {10, -5, 0, -8, 12, 20, 0, -2, 4, 1};
        assertEquals(5, ArrayMethods.howMuchPositiveNumbersInArray(array), "Method Failed");
    }

    @Test
    void howMuchNegativeNumbersInArrayTest () {
        int array[] = {10, -5, 0, -8, 12, 20, 0, -2, 4, 1};
        assertEquals(3, ArrayMethods.howMuchNegativeNumbersInArray(array), "Method Failed");
    }

    @Test
    void howMuchEvenNumbersInArrayTest () {
        int array[] = {10, -5, 0, -8, 12, 20, 0, -2, 4, 1};
        assertEquals(4, ArrayMethods.howMuchEvenNumbersInArray(array), "Method Failed");
    }

    @Test
    void howMuchZeroInArrayTest () {
        int array[] = {10, -5, 0, -8, 12, 20, 0, -2, 4, 1};
        assertEquals(2, ArrayMethods.howMuchZeroInArray(array), "Method Failed");
    }


    //Задача 3.(*) Для метода проверки, является ли число простым, написать тест. Использовать assert для логических выражений.
    @Test
    @DisplayName("Для метода проверки, является ли число простым, написать тест. Использовать assert для логических выражений.")
    void howMuchPrimeInArrayTest () {
        int array[] = {0, 1, 2, 3, 4, 5, 6, 7, -3, 13};
        assertEquals(5, ArrayMethods.howMuchPrimeNumbersInArray(array), "Method Failed");
    }



}//end class


