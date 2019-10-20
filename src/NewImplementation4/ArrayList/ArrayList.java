package NewImplementation4.ArrayList;

import java.util.Arrays;

public class ArrayList<E> {
    public final int DEFAULT_SIZE = 1000 ;
    private int size = 0 ;
    Object[] array ;
    public ArrayList(){this.array = new Object[DEFAULT_SIZE] ; }
    public ArrayList(int size) throws Exception{
        try{
            if(size>0 ){
                this.array = new Object[size] ;
            }
            else{
                throw new Exception("The array List should have size > 0  ") ;
            }
        }
        catch (NumberFormatException e){
            System.out.println(e+ "The size of the arraylist has to be a number");
        }
    }

    public void ensureCapacity(){
        if(this.size == array.length){
            int newSize = this.size *  2 ;
            this.array = Arrays.copyOf(array , newSize) ;
        }
    }
    public void add(E element){
        if(this.size == this.array.length){
            ensureCapacity();
        }
        this.array[size++] = element ;
    }

    public E get(int index) throws Exception{
        try {
            if(index<0 || index>this.size){
                throw new Exception("the index is out of bounds" ) ;
            }
            return (E) this.array[index] ;
        }
        catch (NumberFormatException e){
            System.out.println("The index should be a number");
        }
      return null ;
    }
}
