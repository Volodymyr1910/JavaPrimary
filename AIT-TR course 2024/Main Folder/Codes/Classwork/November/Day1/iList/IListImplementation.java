package Day1.iList;

import Day1.iList.model.IList;

import java.util.Arrays;
import java.util.Iterator;

public class IListImplementation <E> implements IList <E>{
Object [] elements;
private int size;

    public IListImplementation(int initialCapacity) {
        if(initialCapacity < 0){
            throw  new IllegalArgumentException("Illegal capacity " + initialCapacity);
        }//end if
        elements = new Object[initialCapacity];
    }//end constructor


    public IListImplementation (){
        this(10); // обращаемся к уже имеющемуся конструктору и говорим создай начальный массив на 10 элементов
    }

    @Override
    public int size() {
        return size;
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
        //добавление в коней массива
        if(index == size) {
            add(element);
            return true;
        }//end if
        //добавление в середину массива
        checkIndex(index);
        ensureCapasity();
        System.arraycopy(elements, index, elements, index + 1, size++ - index);
        elements[index] = element;
        return true;
    }// end add

    private void checkIndex(int index) {
        //индекс ек может быть меньше 0 и больше size
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Wrong index: " + index);
        }//end if

    }//end checkIndex

    @Override
    public E remove(int index) {
        checkIndex(index);
      E el = (E) elements[index]; // заводим переменную, чтоб вернуть удаляемый элемент
        //удаляем элемент
        System.arraycopy(elements, index + 1, elements, index, size-- - index);
        elements[size] = null;
        return el;
        ////    После выполнения System.arraycopy, когда элементы сдвигаются на одну позицию назад,
        ////    последний элемент становится дублированным на предпоследней позиции.
        ////    Затирание последнего элемента elements[size] = null; выполняется для очистки этой дублированной позиции,
        ////    иначе в списке может остаться ссылка на ненужный объект, что может вызвать утечку памяти.
        ////    Этот шаг необходим для правильной работы списка и предотвращения утечек памяти. В Java объекты не удаляются
        ////    сразу после вызова remove, и сборка мусора может произойти позже. Поэтому затирание последнего элемента является
        ////    хорошей практикой для избежания утечек памяти.
    }//end remove

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }//end get

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E updated = (E) elements[index];
        elements[index] = element;
        return updated;
    }//end set

    @Override
    public int indexOf(Object o) {
        if(o != null){
            for (int i = 0; i < size; i++) {
                if(elements[i].equals(o)) return i;
            }//end for
        }else{
            for (int i = 0; i < size; i++) {
                if(elements[i] == null) return i;
            }//end for
        }//end else
        return -1;
    }// end indexOf

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int i = 0; // указатель на текущий элемент коллекции

            @Override
            public boolean hasNext() {
                return i < size; // true, когда указатель находится внутри коллекции
            }
            @Override
            public Object next() {
                return (E) elements[i++];
            }
        };
    }//end Iterator
}//end class
