package Day12.programmers_and_technologies;

import java.util.List;
import java.util.Set;

public class Programmer {

    private  String nickName;
    private List<String> technology; //Set - is also possible;


    public Programmer(String nickName, List<String> technology) {
        this.nickName = nickName;
        this.technology = technology;
    }


    public String getNickName() {
        return nickName;
    }

    public List<String> getTechnology() {
        return technology;
    }

    @Override
    public String toString() {
        return "Programmer: " + nickName + " , technology: " + technology.toString();
    }



}//end class
