package HW7.citizens_treeSet.dao;

import HW7.citizens_treeSet.model.Person;

public interface Citizens {
    boolean add(Person person);

    boolean remove(int id);

    Person find(int id);

    Iterable<Person> find(int minAge, int maxAge);

    Iterable<Person> find(String lastName);

    Iterable<Person> getAllPersonSortedById();

    Iterable<Person> getAllPersonSortedByLastName();

    Iterable<Person> getAllPersonSortedByAge();

    int size();


}//end class