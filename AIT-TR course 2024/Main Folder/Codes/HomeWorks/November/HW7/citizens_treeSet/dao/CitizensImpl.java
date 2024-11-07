package HW7.citizens_treeSet.dao;

import HW7.citizens_treeSet.model.Person;

import java.util.*;

public class CitizensImpl implements Citizens {

    // статические переменные класса
    private static Comparator<Person> lastNameComparator;
    private static Comparator<Person> ageComparator;

    static {
        lastNameComparator = (p1, p2) -> {
            int res = p1.getLastName().compareTo(p2.getLastName()); // по фамилии
            return res != 0 ? res : Integer.compare(p1.getId(), p2.getId()); // по id
        };
        ageComparator = (p1, p2) -> {
            int res = Integer.compare(p1.getAge(), p2.getAge()); // по возрасту
            return res != 0 ? res : Integer.compare(p1.getId(), p2.getId()); // по id
        };
    }

    // fields
    private TreeSet<Person> idList;
    private TreeSet<Person> lastNameList;
    private TreeSet<Person> ageList;

    public CitizensImpl() {
        idList = new TreeSet<>();
        lastNameList = new TreeSet<>(lastNameComparator);
        ageList = new TreeSet<>(ageComparator);
    }

    public CitizensImpl(List<Person> citizens) {
        this();
        citizens.forEach(p -> add(p));
    }

    // O(1)
    @Override
    public boolean add(Person person) {
        int controller = idList.size();
        if(person == null) return false;
        idList.add(person); // что делаем? // добавляемый новый элемент в структуру
        // что делается в методе далее?
        // у нас 3 списка, idList отсортирован по id, ageList - по возрасту и id, lastNameList - по фамилии и id
        // добавляем элемент во все списки
        ageList.add(person);
        lastNameList.add(person);
        return controller == idList.size() ? false : true;
    }

    // O(n)
    @Override
    public boolean remove(int id) {
        Person victim = find(id);
        if (victim == null) {
            return false;
        }
        idList.remove(victim);
        ageList.remove(victim);
        lastNameList.remove(victim);
        return true;
    }

    // O(n)
    @Override
    public Person find(int id) {
        for (Person p : idList) {
           if( p.getId() == id){
               return p;
           }//end if
        }//end for
        return null;
    }

    // O(n)
    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        TreeSet <Person> age = new TreeSet<>(ageComparator);
        Iterator <Person> iterator = ageList.iterator();
        if(iterator.hasNext()) {
            if (iterator.next().getAge() == minAge || iterator.next().getAge() == maxAge ) {
                age.add(iterator.next());
            }//end if
        } //end if
        return age;
    }//end find

    // O(n)
    @Override
    public Iterable<Person> find(String lastName) {
        TreeSet <Person> last = new TreeSet<>(lastNameComparator);
        for (Person p : lastNameList) {
            if (p.getLastName() == lastName) {
                last.add(p);
            }//end if
        }//end for
        return last;
    }//end find

    // O(1)
    @Override
    public Iterable<Person> getAllPersonSortedById() {
        return idList;
    }

    // O(1)
    @Override
    public Iterable<Person> getAllPersonSortedByLastName() {
        return lastNameList;
    }

    // O(1)
    @Override
    public Iterable<Person> getAllPersonSortedByAge() {
        return ageList;
    }

    // O(1)
    @Override
    public int size() {
        return idList.size();
    }


}//end class