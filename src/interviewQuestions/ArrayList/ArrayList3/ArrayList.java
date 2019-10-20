package interviewQuestions.ArrayList.ArrayList3;

import java.util.Arrays;

public class ArrayList<E> {
    private final int DEFAULT_SIZE= 10 ;
    private Object[] elements ;
    int size = 0 ;

    public ArrayList(){
        this.elements = new Object[DEFAULT_SIZE] ;
    }
    public ArrayList(int size){
        if(size>0) {
            this.elements = new Object[size];
        }
    }

    public void add(E e){
        if(this.size == elements.length){
            ensureCapacity();
        }
        elements[size++] = e ;

    }

    private void ensureCapacity(){
        int newSize = elements.length *2 ;
        this.elements = Arrays.copyOf(elements , newSize) ;
    }

    public E get(int i){
        if(i<0 || i>=size){ throw  new IndexOutOfBoundsException(); }
        return (E)elements[i] ;
    }


}
