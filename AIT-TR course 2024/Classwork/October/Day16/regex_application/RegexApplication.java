package Day16.regex_application;

public class RegexApplication {
    public static void main(String[] args) {


        String text = "      Java";

        String pattern = " *(J|j)ava([1-9]|[1-9][0-9])?";
        boolean checker = text.matches(pattern);
        System.out.println(checker);

        System.out.println("-----------------------------");
        // damain

        String domain = "A-b-r.a-kadabra.com";
        pattern = "((\\w(-|\\.|\\w)*\\w)|\\w)\\.(com|org|de|il)";
        checker = domain.matches(pattern);
        System.out.println(checker);

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        /*
    1) @ exists and only one (done)
    2) dot after @ (done)
    3) after last dot 2 or more symbols (done)
    4) alphabetic, digits, '_', '-', '.', '@' (done)
*/
        System.out.println("----------------------------------------------------------");
        String email = "peter@mail.Co";
        pattern = "((\\w(-|\\.|\\w)*\\w)|\\w)@[a-zA-Z0-9](\\w|-|\\.)*\\.[A-Za-z]{2,6}";
        checker = email.matches(pattern);
        System.out.println(checker);

    }//end main


}//end class
