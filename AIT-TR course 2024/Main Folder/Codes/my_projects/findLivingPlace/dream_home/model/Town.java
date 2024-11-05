package my_projects.findLivingPlace.dream_home.model;

import java.util.Objects;

public class Town {

    private String town;
    private String postIndex;


    public Town(String town, String postIndex) {
        setTown(town);
        setPostIndex(postIndex);
    }

    public String getTown() {
        return town;
    }

    public String getPostIndex() {
        return postIndex;
    }

    public void setTown(String town) {
            if (checker1(town))  this.town = town;
            else System.out.println("The proposed town is unaccetable !");
    }

    public void setPostIndex(String postIndex) {
        if (checker2(postIndex)) this.postIndex = postIndex;
        else System.out.println("The proposed post index is unaccetable !");

    }

    @Override
    public String toString() {
        return "Town{" +
                "town='" + town + '\'' +
                ", postIndex='" + postIndex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Town town1)) return false;
        return Objects.equals(town, town1.town) && Objects.equals(postIndex, town1.postIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(town, postIndex);
    }

    //проверяет соответствие требованиям:
    //String town; // Berlin
    public boolean checker1 (String str){
        if(str.equalsIgnoreCase("Berlin")) return true;
        else return false;
    }

    //проверяет соответствие требованиям:
    //String postIndex; // 10117 or 10178 or 10179
    public boolean checker2 (String str){
        if(str.equals("10117") | str.equals("10178") | str.equals("10179")) return true;
        else return false;
    }

}//end class
