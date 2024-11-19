package Day31.iList.model;

public interface IList <E> extends Iterable <E>{

    int size();

    default boolean isEmpty (){  // модификатор default уже реализовал метод прямо в интерфейсе
        return  size() == 0;
    };

    void clean();  // нужен для освобождения памяти, убирает весь обьект полностью, ссылка из стека и данные из хипа

    boolean add(E element);

    default  boolean contain (Object o){
        return  indexOf(o) >=0;
    };

    default boolean remove (Object o){
        int index = indexOf(o);
        if(index < 0) return  false;
          remove(index);
          return true;
    };

    boolean add(int index, E element);

    E remove (int index);

    E get (int index);

    int indexOf (Object o);

    int lastIndexOf(Object o);

}//end interface
