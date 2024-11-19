package HW7.citizens_arrayList.dao;

import HW7.citizens_arrayList.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    private List<Person> idList;
    private List<Person> lastNameList;
    private List<Person> ageList;

    public CitizensImpl() {
        idList = new ArrayList<>();
        lastNameList = new ArrayList<>();
        ageList = new ArrayList<>();
    }

    public CitizensImpl(List<Person> citizens) {
        this();
        citizens.forEach(p -> add(p));
    }

    // O(log n)
    @Override
    public boolean add(Person person) {
        // что проверяем?
        // что добавляемый элемент не ноль
        if (person == null) {
            return false;
        }
        // что делает этот код?
        // проверяет наличие/отсутствие добавляемого элемента в нашей структуре
        int index = Collections.binarySearch(idList, person); // что делаем?
        if (index >= 0) { // что делаем, если index >= 0?
            return false; // добавление дубликата запрещено
        }
        index = -index - 1; // что делаем с index? зачем? // на этом шаге известно что добавляемого элемента в структуре нет, меняем знак индекса на +
        idList.add(index, person); // что делаем? // добавляемый новый элемент в структуру
        // что делается в методе далее?
        // у нас 3 списка, idList отсортирован по id, ageList - по возрасту и id, lastNameList - по фамилии и id
        // добавляем элемент во все списки
        index = Collections.binarySearch(ageList, person, ageComparator);
        index = index >= 0 ? index : - index - 1;
        ageList.add(index, person);
        index = Collections.binarySearch(lastNameList, person, lastNameComparator);
        index = index >= 0 ? index : -index - 1;
        lastNameList.add(index, person);
        return true;
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

    // O(log n)
    @Override
    public Person find(int id) {
        Person pattern = new Person(id, "", "", LocalDate.now());
        int index = Collections.binarySearch(idList, pattern);
        return index < 0 ? null : idList.get(index);
    }

    // O(log n)
    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        LocalDate now = LocalDate.now();
        Person pattern = new Person(Integer.MIN_VALUE, "", "", now.minusYears(minAge));
        int from = -Collections.binarySearch(ageList, pattern, ageComparator) - 1;
        pattern = new Person(Integer.MAX_VALUE, "", "", now.minusYears(maxAge));
        int to = -Collections.binarySearch(ageList, pattern, ageComparator) - 1;
        return ageList.subList(from, to);
    }

    // O(log n)
    @Override
    public Iterable<Person> find(String lastName) {
        LocalDate now = LocalDate.now();
        Person pattern = new Person(Integer.MIN_VALUE, "", lastName, now);
        int from = -Collections.binarySearch(lastNameList, pattern, lastNameComparator) - 1;
        pattern = new Person(Integer.MAX_VALUE, "", lastName, now);
        int to = -Collections.binarySearch(lastNameList, pattern, lastNameComparator) - 1;
        return lastNameList.subList(from, to);
    }

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