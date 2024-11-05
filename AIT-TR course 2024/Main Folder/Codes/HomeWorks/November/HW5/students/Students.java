package HW5.students;

import java.util.Objects;

public class Students {

    private String name;
    private boolean math;
    private boolean inform;


    public Students(String name, boolean math, boolean inform) {
        this.name = name;
        this.math = math;
        this.inform = inform;
    }


    public String getName() {
        return name;
    }

    public boolean isMath() {
        return math;
    }

    public boolean isInform() {
        return inform;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Students{");
        sb.append("name='").append(name).append('\'');
        sb.append(", math=").append(math);
        sb.append(", inform=").append(inform);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Students students)) return false;
        return math == students.math && inform == students.inform && Objects.equals(name, students.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, math, inform);
    }
}//end class
