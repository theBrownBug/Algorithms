package interviewQuestions.Heaps;

import java.util.Vector;

public class MaxHeapTest6 {
    public Vector<Integer> A ;
    public MaxHeapTest6(){ this.A = new Vector<>() ; }
    public MaxHeapTest6(int i){this.A = new Vector<>(i) ; }
    public int size(){return  A.size();}
    public boolean isEmpty(){ return A.isEmpty() ; }
    public boolean contains(Integer i){ return A.contains(i) ; }

    public int parent(int i){
        if(i==0){
            return  0 ;
        }
        return (i-1)/2 ;
    }

    public int getLeft(int i){ return 2 * i +1 ; }
    public int getRight(int i){return 2*i + 2 ; }
    public void swap(int x , int y){
        int temp= A.get(x);
        A.setElementAt(A.get(y) , x);
        A.insertElementAt(temp , y);
    }

    public void heapifyDown(int i){
        int largest = i ;
        int left = getLeft(i) ;
        int right = getRight(i) ;
        if(left< size() && A.get(largest)< A.get(left)){
            largest = left ;
        }
        if(right < size() && A.get(largest)< A.get(right)){
            largest =right;
        }
        if(largest != i){
            swap(i , largest);
            heapifyDown(largest);
        }
    }

    public void heapifyUp(int i){
        if(i> 0 && A.get(i)> A.get(parent(i))){
            swap(i , parent(i));
            heapifyUp(parent(i));
        }
    }

    public Integer poll(){
        try{
            if(size() ==0){
                throw new Exception("Heap underflow") ;
            }
            int out = A.firstElement() ;
            A.setElementAt(A.lastElement() , 0);
            A.remove(size() -1 ) ;
            heapifyDown(0);
            return out ;

        }catch (Exception e){
            System.out.println(e);
            return null ;
        }
    }

    public Integer peek(){
        try{
            if(size()==0) {
                throw new Exception("Heap underflow") ;
            }
            return A.firstElement() ;
        }catch (Exception e){
            System.out.println(e);
            return null ;
        }
    }

    
}
