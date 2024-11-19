package MyMethods.regex.model;

public class RegexValidator {

    //Номер введен только цифрами -> количество цифр должно быть не менее 8 и не более 16
    // CreditCardNumber
    public static boolean checkCreditCardNumber(String str){
        return str.matches("\\d{8,16}");
    }//end checkCreditCardNumber

    //1. Месяц декабрь должен быть введен цифрой 12 или буквами строго (DEC|DE|Dec|De|dec|de) ->  день должен иметь 2 знака -> два знака не могут быть нолями одновременно -> число не может быть более 31
    //1. Месяц февраль должен быть введен цифрой 02 или буквами строго (FE|FEB|fe|feb|Fe|Feb) -> день должен иметь 2 знака -> два знака не могут быть нолями одновременно -> число не может быть более 28
    //2 Другие месяцы введены цифрами или буквами -> цифра должна иметь 2 знака -> два знака не могут быть нолями одновременно -> должно быть только 01 или от 03 до 11 -> буквами должно быть строго в соответствии с международно принятыми сокращениями (по примеру декабря или февраля), при этом букв может быть две или три -> или все буквы заглавные, или все строчные, или первая - заглавная, последующие - строчные
    //3 Дни других месяцев введены цифрами -> должны иметь 2 знака -> два знака не могут быть нолями одновременно -> число не может быть более 30
    //4 Год введен только цифрами -> должно быть именно 4 цифры -> все цифры не могут быть нулями одновременно ;
    //DateFormatEU - dd-MM-yyyy
    public static boolean checkDateFormatEU(String str){
        // TODO Homework checkDateFormatEU
        return str.matches("((((([0][1-9]|[1-2][0-9]|[3][0-1]))(-|.|_)(DEC|DE|Dec|De|dec|de|12))|(([0][1-9]|[1][0-9]|[2][0-8])(-|.|_)(FE|FEB|fe|feb|Fe|Feb|02))|(([0][1-9]|[1-2][0-9]|30)(-|.|_)((01|[0][3-9]|[1][0-1])|(JA|Ja|ja|JAN|Jan|jan|MA|Ma|ma|MAR|Mar|mar|AP|Ap|ap|APR|Apr|apr|MAY|May|may|JUNE|June|june|JUN|Jun|jun|JULY|July|july|JUL|Jul|jul|AU|Au|au|AUG|Aug|aug|SEPT|Sept|sept|SEP|Sep|sep|OC|Oc|oc|OCT|Oct|oct|NO|No|no|NOV|Nov|nov))))(-|.|_)(([0-9][0-9][0-9][1-9]|[0-9][0-9][1-9][0-9]|[0-9][1-9][0-9][0-9]|[1-9][0-9][0-9][0-9])))");
    }//end checkDateFormatEU


    //DateFormatEU - dd-MM-yyyy дополнительные разделители Латиница + укр.алфавіт
    public static boolean checkDateFormat(String str){
        // TODO Homework checkDateFormatEU
        return str.matches("((((([0][1-9]|[1-2][0-9]|[3][0-1]))(-|.|/||:|,|_)(DEC|DE|Dec|De|dec|de|12))|(([0][1-9]|[1][0-9]|[2][0-8])(-|.|/||:|,|_)(FE|FEB|fe|feb|Fe|Feb|02))|(([0][1-9]|[1-2][0-9]|30)(-|.|_)((01|[0][3-9]|[1][0-1])|(JA|Ja|ja|JAN|Jan|jan|MA|Ma|ma|MAR|Mar|mar|AP|Ap|ap|APR|Apr|apr|MAY|May|may|JUNE|June|june|JUN|Jun|jun|JULY|July|july|JUL|Jul|jul|AU|Au|au|AUG|Aug|aug|SEPT|Sept|sept|SEP|Sep|sep|OC|Oc|oc|OCT|Oct|oct|NO|No|no|NOV|Nov|nov|січ|Січ|СІЧ|лют|Лют|ЛЮТ|берез|бер|Берез|Бер|БЕРЕЗ|БЕР|квіт|кві|Квіт|Кві|КВІТ|КВІ|трав|тра|Трав|Тра|ТРАВ|ТРА|черв|чер|Черв|Чер|ЧЕРВ|ЧЕР|лип|Лип|ЛИП|серп|сер|Серп|Сер|СЕРП|СЕР|верес|вер|Верес|Вер|ВЕРЕС|ВЕР|жовт|жов|Жовт|Жов|ЖОВТ|ЖОВ|листоп|лис|лист|Листоп|Лис|Лист|ЛИСТОП|ЛИС|ЛИСТ|груд|гру|Груд|Гру|ГРУД|ГРУ))))(-|.|/||:|,|_)(([0-9][0-9][0-9][1-9]|[0-9][0-9][1-9][0-9]|[0-9][1-9][0-9][0-9]|[1-9][0-9][0-9][0-9])))");
    }//end checkDateFormatEU

    //1. Год введен только цифрами -> должно быть именно 4 цифры -> все цифры не могут быть нулями одновременно ;
    //2. Месяц введен только цифрами -> должно быть именно 2 цифры -> обе цифры не могут быть нулями одновременно ;
    //3. Месяц введен только буквами -> должно быть 2, 3 или 4 буквы -> или все буквы заглавные, или все строчные, или первая - заглавная, последующие - строчные
    //4. День введен только цифрами -> должно быть именно 2 цифры -> обе цифры не могут быть нулями одновременно -> дней не более 31;
    // DateFormatUS - yyyy-MM-dd
    public static boolean checkDateFormatUS(String str){
        // TODO Homework checkDateFormatUS
        return str.matches("([0-9][0-9][0-9][1-9]|[0-9][0-9][1-9][0-9]|[0-9][1-9][0-9][0-9]|[1-9][0-9][0-9][0-9])(-|.|_)([0][1-9]|[1][1-2]|[a-z][a-z][a-z]|[A-Z][a-z][a-z]|[A-Z][A-Z][A-Z]|[a-z][a-z]|[A-Z][a-z]|[A-Z][A-Z]|[A-Z][A-Z][A-Z][A-Z]|[a-z][a-z][a-z][a-z]|[A-Z][a-z][a-z][a-z])(-|.|_)([0][1-9]|[1-2][0-9]|[3][0-1])"); //проверены год+день+разделители
        //return str.matches("[0][1-9]|[1][1-2]|[a-z][a-z][a-z]|[A-Z][a-z][a-z]|[A-Z][A-Z][A-Z]|[a-z][a-z]|[A-Z][a-z]|[A-Z][A-Z]|[A-Z][A-Z][A-Z][A-Z]|[a-z][a-z][a-z][a-z]|[A-Z][a-z][a-z][a-z]");
    }//checkDateFormatUS

    // начинается с 0 или +49 -> после этого только цифры -> должно быть ровно 11 цифр
    // PhoneNumber
    public static boolean checkPhoneNumber(String str){
        // TODO Homework checkPhoneNumber
        //return str.matches("([0]|(°[+][4][9])){1} \\d{11}");
        return str.matches("(0|([+]49))\\d{11}");
    }// end checkPhoneNumber

    // Номер введен только цифрами -> цифра должна быть одно-, двух-, или трех-значной -> если двух- или трех-значная - то первая цифра не может быть 0 -> итоговая цифра не превышает 255
    // LessEquals255
    public static boolean checkLessEquals255(String str){
        // TODO Homework checkLessEquals255
        return str.matches("[0-9]|[1-9][0-9]|[1-2][0-4][0-9]|[2][5][0-5]");
    }//end checkLessEquals255

}//end class