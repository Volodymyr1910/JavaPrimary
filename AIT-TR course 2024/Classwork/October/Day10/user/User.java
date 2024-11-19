package Day10.user;

public class User {

    private String email;
    private String password;

    // нужно включить защиту на уровне конструктора и на уровне сетов
    public User(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isEmaiValid(email)) {
            this.email = email;
        }else {
            System.out.println(email + " is not valid.");
        }//else
    }//end setEmail

    private boolean isEmaiValid(String email) {
        int indexAt = email.indexOf('@'); // index where @ placed
        if(indexAt == -1 || indexAt != email.lastIndexOf('@')){
            return false;
        }
        if(email.indexOf('.', indexAt) == -1){
            return false;
        }
        if(email.lastIndexOf('.') >= email.length() - 2) {
            return false;
        }
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if(!(Character.isAlphabetic(c) || Character.isDigit(c) || c == '_' || c == '-' || c == '.' || c == '@')){
                return false; // ± / |\
            }
        }
        return true;
    }//isEmaiValid

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }






}//end class
