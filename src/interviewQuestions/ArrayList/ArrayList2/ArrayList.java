package interviewQuestions.ArrayList.ArrayList2;

import java.util.Arrays;

public class ArrayList<E> {
    public int size = 0 ;
    private final int DEFAULT_CAPACITY = 16 ;
    private Object[] elements ;
    public ArrayList(){ this.elements = new Object[DEFAULT_CAPACITY] ; }

    public void add(E e){
        if(size == elements.length){
            ensureCapacity() ;
        }
        elements[size++] = e ;
    }

    private void ensureCapacity(){
        int newSize= elements.length *2 ;
        elements = Arrays.copyOf(elements , newSize) ;
    }

    public E get(int i){
        if(i>= size || size< 0){ throw new IndexOutOfBoundsException() ; }
        return (E) elements[i] ;
    }



}
