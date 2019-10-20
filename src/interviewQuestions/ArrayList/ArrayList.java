package interviewQuestions.ArrayList;

import java.util.Arrays;

public class ArrayList<E> {
    private int size = 0 ;
    private static final int DEFAULT_CAPACITY = 10 ;
    private Object elements[] ;

    public ArrayList(){
        this.elements = new Object[DEFAULT_CAPACITY] ;
    }
    public void add(E e){
        if(size==elements.length){
            ensureCapacity() ;
        }
        elements[size++] = e ;
    }

    private void ensureCapacity(){
        int newSize = elements.length *2 ;
        elements = Arrays.copyOf(elements , newSize) ;
    }

    // ???? how does this work

    @SuppressWarnings("unchecked")
    public E get(int i){
        if(i>=size || size< 0){
            throw new IndexOutOfBoundsException("Index "+ i + " size "+ i) ;
        }
        return (E) elements[i] ;
    }



}
