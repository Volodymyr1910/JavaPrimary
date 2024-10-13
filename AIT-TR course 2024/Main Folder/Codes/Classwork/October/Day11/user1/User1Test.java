package Day11.user1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class User1Test {

    User1 user;

    final String email = "peter@mail.de"; // ideal email
    final String password = "123456Az!"; // ideal password

    @BeforeEach
    void setUp() {
        user = new User1(email, password); // create new "fresh" object

    }

    @Test
    void testValidEmail() {
        user.setEmail(email);

        assertEquals("peter@mail.de", user.getEmail());

    }//end testValidEmail

    @Test
    @DisplayName("Здесь можно написать что делает тест")
    void testValidPassword() {
        assertEquals("123456Az!", user.getPassword());
    }//testValidPassword

    @Test
    void setEmailNotAt() {
        String email = "petermail.de"; //wrong email
        user.setEmail(email);
        assertEquals("peter@mail.de", user.getEmail());
    }

    @Test
    void setEmailTwoPunkts() {
        String email = "peter@mail.de"; //wrong email peter@mail..de
        user.setEmail(email);
        assertEquals("peter@mail.de", user.getEmail());
        System.out.println(user.getEmail());
    }
    /*- требования к password:
            1) length >= 8
            2) min one digit
            3) min one symbol in upperCase
            4) min one symbol in lowerCase
            5) min one special symbol (!%@$&)
            6) length < 20 */

    @Test
    void setValidPasswordLenght() {
        user.setPassword("234Az!"); // 7 symbol
        assertEquals("123456Az!", user.getPassword());
        user.setPassword("123456123456123456Az!"); // 21 symbols
        assertEquals("123456Az!", user.getPassword());
    }

    @Test
    void setValidPasswordMinOneDigit () {
        user.setPassword("Asdfghj!"); // no digits
        assertEquals("123456Az!", user.getPassword());
    }

    @Test
    void setValidPasswordMinOneLetterUpperCase () {
        user.setPassword("asdfghj!"); // no upper case letters
        assertEquals("123456Az!", user.getPassword());
    }

    @Test
    void setValidPasswordMinOneLetterLowerCase () {
        user.setPassword("AS45678!"); // no lower case letters
        assertEquals("123456Az!", user.getPassword());
    }

    void setValidPasswordMinOneSpecialSymbol () {
        user.setPassword("As456786"); // no symbols
        assertEquals("123456Az!", user.getPassword());
    }

}//end class