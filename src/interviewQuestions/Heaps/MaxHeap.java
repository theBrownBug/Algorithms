package interviewQuestions.Heaps;

import java.util.PriorityQueue;
import java.util.Vector;

public class MaxHeap {
    private Vector<Integer> A ;
    public MaxHeap(){ this.A = new Vector<>(); }
    public MaxHeap(int a ){ this.A = new Vector<>(a); }

    private int parent(int i){
        if(i== 0 ){ return  0 ; }
        return (i - 1)/2 ;
    }
    private int getLeft(int i){
        return (2* i ) + 1 ;
    }
    private int getRight(int i ){
        return (2 * i ) + 2 ;
    }

    // swap values at 2 indexes

    void swap(int x , int y ){
        Integer temp = A.get(x) ;
        A.setElementAt(A.get(y) , x);
        A.setElementAt(temp , y);
    }

    public int size(){ return A.size() ; }
    public boolean isEmpty(){ return A.isEmpty() ; }

    private void heapifyDown(int i){
        int left = getLeft(i) ;
        int right = getRight(i) ;
        int largest = i;
        if(left < size() && A.get(i) < A.get(left)){ largest = left ; }
        if(right< size() && A.get(i) < A.get(right) ){ largest  = right ; }
        if(largest != i){
            swap( i , largest);
            heapifyDown(largest);
        }
    }

    private void heapifyUp(int i ){
        // check that the node at i and its parent violate the property
        if(i > 0  && A.get(parent(i)) < A.get(i)){
            swap(i , parent(i));
            heapifyUp(parent(i));
        }
    }

    public void add(Integer i ){
        A.addElement(i);
        int index = size() - 1;
        heapifyUp(index);
    }


    public Integer poll(){
        try {
            if(size() == 0){
                System.exit(-1);
            }
            int root = A.firstElement() ;
            // set the root of the with the last element of the vector
            A.setElementAt(A.lastElement() , 0 );
            A.remove(size() - 1) ;
            heapifyDown(0);

            return root ;
        }
        catch (Exception e){
            System.out.println(e);
            return null ;
        }
    }

    // function to return but not remove the number from the heap

    public Integer peek(){
        if(size() == 0){
            System.exit(-1);
        }
        try {
            return A.firstElement();
        }catch (Exception e ){
            System.out.println(e);
            return  null ;
        }
    }

    public void clear(){
        System.out.println("Emptying the queue : ");
        while(!A.isEmpty()){
            System.out.println(poll() + " ");
        }
        System.out.println();
    }

    public boolean contains(Integer i){
        return A.contains(i) ;
    }

}
