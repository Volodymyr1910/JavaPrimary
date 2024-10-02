package HW1.pet.model;

public class Pet {

    int id;
    String type;
    double age;
    String petName;

    public Pet(int id, String type, double age, String petName) {
        this.id = id;
        this.type = type;
        this.age = age;
        this.petName = petName;
    }//end Pet

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", petName='" + petName + '\'' +
                '}';
    }

    public void sleep() {
        System.out.println(type + " " + petName + " is sleeping. So tired, yes?");
    }//end sleep

    public void eat() {
        System.out.println(type + " " + petName + " is eating.");
    }//end eat

    public void makeLoud() {
        System.out.println(type + " " + petName + " making big noise !");
    }//end makeLoud

    public void play() {
        System.out.println(type + " " + petName + " is playing. It's so quite :)");
    }//end play

    public void walking() {
        System.out.println(type + " " + petName + " is walking.");
    }//end walking


}//end clas