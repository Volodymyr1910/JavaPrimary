package HW16.regex_validator.test;

import HW16.regex_validator.model.RegexValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexValidatorTest {

    //Номер введен только цифрами -> количество цифр должно быть не менее 8 и не более 16
    @Test
    void checkCreditCardNumberTest() {
        assertFalse(RegexValidator.checkCreditCardNumber("")); //ничего не введено
        assertFalse(RegexValidator.checkCreditCardNumber("012345addBook")); // есть буквы
        assertFalse(RegexValidator.checkCreditCardNumber("012345------"));// есть символы
        assertFalse(RegexValidator.checkCreditCardNumber("1234567890123456789012345"));//цифра имеет более 16 знаков
        assertFalse(RegexValidator.checkCreditCardNumber("12345"));//цифра имеет менее 8 знаков

        assertTrue(RegexValidator.checkCreditCardNumber("0123456789"));//правильный номер
    }//end checkCreditCardNumberTest

    //Порядок ввода день -> месяц -> год
    //1. Месяц декабрь должен быть введен цифрой 12 или буквами строго (DEC|DE|Dec|De|dec|de) ->  день должен иметь 2 знака -> два знака не могут быть нолями одновременно -> число не может быть более 31
    //1. Месяц февраль должен быть введен цифрой 02 или буквами строго (FE|FEB|fe|feb|Fe|Feb) -> день должен иметь 2 знака -> два знака не могут быть нолями одновременно -> число не может быть более 28
    //2 Другие месяцы введены цифрами или буквами -> цифра должна иметь 2 знака -> два знака не могут быть нолями одновременно -> должно быть только 01 или от 03 до 11 -> буквами должно быть строго в соответствии с международно принятыми сокращениями (по примеру декабря или февраля), при этом букв может быть две или три -> или все буквы заглавные, или все строчные, или первая - заглавная, последующие - строчные
    //3 Дни других месяцев введены цифрами -> должны иметь 2 знака -> два знака не могут быть нолями одновременно -> число не может быть более 30
    //4 Год введен только цифрами -> должно быть именно 4 цифры -> все цифры не могут быть нулями одновременно ;
    @Test
    void checkDateFormatEUTest() {
        assertFalse(RegexValidator.checkDateFormatEU("")); //ничего не введено
        assertFalse(RegexValidator.checkDateFormatEU("30.KAR.1980"));// введен буквами несуществующий месяц
        assertFalse(RegexValidator.checkDateFormatEU("30.20.1980"));// введен цифрами несуществующий месяц

        assertFalse(RegexValidator.checkDateFormatEU("30.01.001"));// год имеет менее 4 знаков
        assertFalse(RegexValidator.checkDateFormatEU("30.01.19805"));// год имеет менее более 4 знаков
        assertFalse(RegexValidator.checkDateFormatEU("30.01.0000"));// год 0000

        assertFalse(RegexValidator.checkDateFormatEU("40.De.1980"));// дней в декабре, введеном буквами -  больше максимума 31
        assertFalse(RegexValidator.checkDateFormatEU("32.12.1980"));// дней в декабре, введеном цифрами -  больше максимума 31
        assertFalse(RegexValidator.checkDateFormatEU("3.Dec.1980"));// дней в декабре, введеном буквами -  имеет 1 знак
        assertFalse(RegexValidator.checkDateFormatEU("9.12.1980"));// дней в декабре, введеном цифрами -  имеет 1 знак
        assertFalse(RegexValidator.checkDateFormatEU("00.DEC.1980"));// дней в декабре, введеном буквами -  имеет 2 знака, но они нули
        assertFalse(RegexValidator.checkDateFormatEU("00.12.1980"));// дней в декабре, введеном цифрами -  имеет 2 знака, но они нули

        assertFalse(RegexValidator.checkDateFormatEU("30.FEB.1980"));// дней в феврале, введеном буквами -  больше максимума 28
        assertFalse(RegexValidator.checkDateFormatEU("30.02.1980"));// дней в феврале, введеном цифрами -  больше максимума 28
        assertFalse(RegexValidator.checkDateFormatEU("5.Feb.1980"));// дней в феврале, введеном буквами -  имеет 1 знак
        assertFalse(RegexValidator.checkDateFormatEU("8.02.1980"));// дней в феврале, введеном цифрами -  имеет 1 знак
        assertFalse(RegexValidator.checkDateFormatEU("00.fe.1980"));// дней в феврале, введеном буквами -  имеет 2 знака, но они нули
        assertFalse(RegexValidator.checkDateFormatEU("00.02.1980"));// дней в феврале, введеном цифрами -  имеет 2 знака, но они нули

        assertFalse(RegexValidator.checkDateFormatEU("38.01.1980"));// дней в других месяцах - больше максимума 30
        assertFalse(RegexValidator.checkDateFormatEU("7.01.1980"));// дней в других месяцах - имеет 1 знак
        assertFalse(RegexValidator.checkDateFormatEU("00.01.1980"));// дней в других месяцах - имеет 2 знака, но они нули

        assertTrue(RegexValidator.checkDateFormatEU("30.01.1980")); // правильная дата
        assertTrue(RegexValidator.checkDateFormatEU("30.JUNE.1980")); // правильная дата
        assertTrue(RegexValidator.checkDateFormatEU("01_DEC-1980"));// декабрь обозначен буквами + тест разделителей
        assertTrue(RegexValidator.checkDateFormatEU("28_feb.1980"));// февраль обозначен буквами + тест разделителей
        assertTrue(RegexValidator.checkDateFormatEU("28.Feb-1980"));// февраль обозначен буквами + тест разделителей
        assertTrue(RegexValidator.checkDateFormatEU("31-12-1980"));// // декабрь обозначен цифрами + тест разделителей
        assertTrue(RegexValidator.checkDateFormatEU("28_02_1980"));// февраль обозначен цифрами + тест разделителей
    }//end checkDateFormatEUTest

    //Порядок ввода год -> месяц -> день
    //1. Год введен только цифрами -> должно быть именно 4 цифры -> все цифры не могут быть нулями одновременно ;
    //2. Месяц введен только цифрами -> должно быть именно 2 цифры -> обе цифры не могут быть нулями одновременно ;
    //3. Месяц введен только буквами -> должно быть 2, 3 или 4 буквы -> или все буквы заглавные, или все строчные, или первая - заглавная, последующие - строчные
    //4. День введен только цифрами -> должно быть именно 2 цифры -> обе цифры не могут быть нулями одновременно -> дней не более 31;
    @Test
    void checkDateFormatUSTest() {
        assertFalse(RegexValidator.checkDateFormatUS("")); //ничего не введено
        assertFalse(RegexValidator.checkDateFormatUS("001.01.30"));// год имеет менее 4 знаков
        assertFalse(RegexValidator.checkDateFormatUS("19805.01.30"));// год имеет менее более 4 знаков
        assertFalse(RegexValidator.checkDateFormatUS("0000.01.30"));// год 0000

        assertFalse(RegexValidator.checkDateFormatUS("1980.KAp.30"));//  месяц буквами введен в некорректном формате
        assertFalse(RegexValidator.checkDateFormatUS("1980.kAp.30"));//  месяц буквами введен в некорректном формате
        assertFalse(RegexValidator.checkDateFormatUS("1980.A.30"));//  месяц имеет только 1 букву
        assertFalse(RegexValidator.checkDateFormatUS("1980.AAAAA.30"));//  месяц имеет более 3 букв
        assertFalse(RegexValidator.checkDateFormatUS("1980.2.30"));// месяц цифрами имеет 1 знак
        assertFalse(RegexValidator.checkDateFormatUS("1980.022.30"));// месяц цифрами имеет более 2 знаков
        assertFalse(RegexValidator.checkDateFormatUS("1980.00.30"));// месяц цифрами 00
        assertFalse(RegexValidator.checkDateFormatUS("1980.25.30"));// введен цифрами несуществующий месяц

        assertFalse(RegexValidator.checkDateFormatUS("1980.11.as"));// день содержит буквы
        assertFalse(RegexValidator.checkDateFormatUS("1980.Dec.--"));// день содержит символы
        assertFalse(RegexValidator.checkDateFormatUS("1980.De.35"));// вееден несуществующий день
        assertFalse(RegexValidator.checkDateFormatUS("1980.De.4"));// день содержит только 1 знак
        assertFalse(RegexValidator.checkDateFormatUS("1980.DEC.445"));// день содержит более 2 знаков
        assertFalse(RegexValidator.checkDateFormatUS("1980.FEB.00"));// день 00

        assertTrue(RegexValidator.checkDateFormatUS("1980.JUNE.25")); // правильная дата
        assertTrue(RegexValidator.checkDateFormatUS("2001_JUNE_30")); // правильная дата + тест разделителей
        assertTrue(RegexValidator.checkDateFormatUS("4026_DEC.01"));// декабрь обозначен буквами + тест разделителей
        assertTrue(RegexValidator.checkDateFormatUS("0155-feb.28"));// февраль обозначен буквами + тест разделителей
        assertTrue(RegexValidator.checkDateFormatUS("0289-Feb_28"));// февраль обозначен буквами + тест разделителей
        assertTrue(RegexValidator.checkDateFormatUS("0027.12-31"));// // декабрь обозначен цифрами + тест разделителей
        assertTrue(RegexValidator.checkDateFormatUS("9999-12-31"));// февраль обозначен цифрами
    }//end checkDateFormatUSTest

    // начинается с 0 или +49 -> после этого только цифры -> должно быть ровно 11 цифр
    @Test
    void checkPhoneNumberTest() {
        assertFalse(RegexValidator.checkPhoneNumber("")); //ничего не введено
        assertFalse(RegexValidator.checkPhoneNumber("116094843005"));//начинается не с нуля и не с +49
        assertFalse(RegexValidator.checkPhoneNumber("x16094843005")); // есть буквы
        assertFalse(RegexValidator.checkPhoneNumber("01609-843005"));// есть символы
        assertFalse(RegexValidator.checkPhoneNumber("+4916094843"));// после вступления, менее 11 цифр
        assertFalse(RegexValidator.checkPhoneNumber("+49160948430055555"));// после вступления, более 11 цифр

        assertTrue(RegexValidator.checkPhoneNumber("016094843005"));//правильный номер 1
        assertTrue(RegexValidator.checkPhoneNumber("+4916094843005"));//правильный номер 2

    }//end checkPhoneNumberTest

    // Номер введен только цифрами -> цифра должно быть одно-, двух-, или трех-значной -> если двух- или трех-значная - то первая цифра не может быть 0 -> итоговая цифра не превышает 255
    @Test
    void checkLessEquals255Test() {
        assertFalse(RegexValidator.checkLessEquals255("")); //ничего не введено
        assertFalse(RegexValidator.checkLessEquals255("ggg")); // есть буквы
        assertFalse(RegexValidator.checkLessEquals255("---"));// есть символы
        assertFalse(RegexValidator.checkLessEquals255("1000"));//цифра имеет более 3 знаков
        assertFalse(RegexValidator.checkLessEquals255("01"));//2-значная цифра и первый знак ноль
        assertFalse(RegexValidator.checkLessEquals255("001"));//3-значная цифра и первый знак ноль
        assertFalse(RegexValidator.checkLessEquals255("280"));// цифра больше 255

        assertTrue(RegexValidator.checkLessEquals255("0")); //правильный номер
        assertTrue(RegexValidator.checkLessEquals255("200"));//правильный номер
    }//end checkLessEquals255Test
}//end class