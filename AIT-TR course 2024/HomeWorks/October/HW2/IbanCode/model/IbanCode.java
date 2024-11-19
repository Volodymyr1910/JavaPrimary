package HW2.IbanCode.model;

//Задание 3.(*) Номер счета в банке IBAN состоит из букв латинского алфавита и цифр, имеет строго регламентированную длину (в Германии - 22 символа).
// Создать класс IbanCode, в котором определить необходимые поля и реализовать методы:
//
//lengthCode(String code), который возвращает количество символов в счете
//controlCode(String code), который возвращает сумму ASCII-кодов первых двух символов
//isValid(String code), который проверяет штрих-код на правильное количество символов

public class IbanCode {

    private String iBAN;
    private String currentDate;
    private String expirationDate;

    public IbanCode(String iBAN, String currentDate, String expirationDate) {
        this.iBAN = iBAN;
        this.currentDate = currentDate;
        this.expirationDate = expirationDate;
    }

    public String getiBAN() {
        return iBAN;
    }

    public void setiBAN(String iBAN) {
        this.iBAN = iBAN;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getexpirationDate() {
        return expirationDate;
    }

    public void setexpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void display(String iBanForLooking) {
        System.out.println("The current date is -> " + currentDate + "; The expiration date is -> " + expirationDate + ".");
        System.out.println("Your IBAN is -> " + iBanForLooking + ".");
    }//end display

    public int lengthCode() {
        return iBAN.length();
    }//end lengthCode

    public boolean isValid() {
        boolean flag = false;
        if (Character.isLetter(iBAN.charAt(0)) == true | Character.isLetter(iBAN.charAt(1)) == true) {
            int count = 3;
            while (count <= iBAN.length()) {
                if (Character.isDigit(iBAN.charAt(count-1)) == false) {
                    return false;
                }//end if
                count++;
            }//end while
            flag = true;
        }//end if
        return flag;
    }//end isValid

    //controlCode(String code), который возвращает сумму ASCII-кодов первых двух символов
    public int controlCode() {
        String  temp = iBAN.substring(0, 2);
        return (int) temp.charAt(0) + (int) temp.charAt(1) ;
    }//end controlCode


}//end class
