package Day31.iList;

import Day31.iList.model.IList;

import java.util.Arrays;
import java.util.Iterator;

public class IListImplementation implements IList {
Object [] elements;
private int size;

    public IListImplementation(int initialCapacity) {
        if(initialCapacity < 0){
            throw  new IllegalArgumentException("Illegal capacity " + initialCapacity);
        }//end if
        elements = new Object[initialCapacity];
    }//end constructor

    /*
    public IList (){
        this(10); // обращаемся к уже имеющемуся конструктору и говорим создай начальный массив на 10 элементов
    } */

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clean() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }//end for
        size = 0;
    }// end clean

    @Override
    public boolean add(Object element) {
        ensureCapasity(); // здесь будет происходить расширение массива
        elements[size++] = element;
        return true;
    }//end add

    private void ensureCapasity() {
        if(size == elements.length){
            if(size == Integer.MAX_VALUE){
                throw new OutOfMemoryError();
            }//end if
            int newCapacity = elements.length + elements.length / 2;
            if(newCapacity < 0){
                newCapacity = Integer.MAX_VALUE;
            }//end if
            elements = Arrays.copyOf(elements, newCapacity);
        }//end if
    }//end ensureCapasity


    @Override
    public boolean add(int index, Object element) {

        return false;
    }// end

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}//end class
