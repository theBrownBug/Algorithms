package interviewQuestions.Heaps;

import java.util.Arrays;
import java.util.Vector;

public class MinHeap {
    private Vector<Integer> A ;
    public MinHeap(){this.A = null ; }
    public MinHeap(int i ){this.A = new Vector<>(i)  ; }

    public Integer getParent(int i ){ return (i-1)/2 ; }
    public int getLeft(int i ){ return (2*i)+1 ; }
    public int getRight(int i){return  (2*i) + 2  ; }
    public void swap(int x  , int y){
        int temp = A.get(x) ;
        A.setElementAt(A.get(y) , x);
        A.setElementAt(temp , y );
    }

    public int size(){return  A.size() ; }
    public boolean isEmpty(){ return  A.isEmpty() ; }


    public void heapifyDown(int i ){
        int smallest = i ;
        int leftChild = getLeft(i) ;
        int rightChild = getRight(i);
        if(leftChild< size() && A.get(leftChild)< A.get(smallest)){
            smallest = leftChild;
        }
        if(rightChild< size() && A.get(rightChild) < A.get(smallest)){
            smallest = rightChild ;
        }
        if(smallest != i){
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }
    public void heapifyUp(int i ){
        if(i>0 && A.get(getParent(i)) > A.get(i) ){
            swap(A.get(getParent(i))  , A.get(i));
            heapifyUp(getParent(i));
        }
    }

    public void add(Integer key){
        A.addElement(key);
        int index = size() -1 ;
        heapifyUp(index);
    }


    public Integer poll(){
        try{
            if(size()==0){
                throw new Exception("index out of range ") ;
            }
            int root = A.firstElement() ;
            A.setElementAt(A.lastElement() , 0 );
            A.remove(size() -1) ;
            heapifyDown(0);

            return root ;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public Integer peek(){
        try {
            if(size() == 0){
                throw new Exception("index out of bounds (heap underflow )") ;
            }
            return A.get(0) ;
        }
        catch (Exception e){
            System.out.println(e);
            return null ;
        }
    }

    public void clear(){
        System.out.println("Emptying the queue");
        while(!A.isEmpty() ){
            Integer i = poll() ;
            System.out.print(i +  " ");
        }
    }

    public Boolean contains(Integer i ){
        return A.contains(i) ;
    }

    public static void main(String args[]){

    }


}
