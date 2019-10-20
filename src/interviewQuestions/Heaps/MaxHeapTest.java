package interviewQuestions.Heaps;

import java.util.Vector;

public class MaxHeapTest {
    public Vector<Integer> A ;
    public MaxHeapTest(){ this.A = new Vector<>() ; }
    public MaxHeapTest(int i){ this.A =  new Vector<>(i) ; }

    public int size(){return this.A.size() ;}
    public boolean isEmpty(){return A.isEmpty() ; }

    public int getParent(int i){
        if(i==0){return  0 ; }
        return (i -1)/2 ;
    }
    public int getLeft(int i){return  2*i + 1 ; }
    public int getRight(int i){ return 2*i +2 ; }

    public void swap(int x ,int y){
        int temp = A.get(x);
        A.setElementAt(A.get(y) ,x);
        A.setElementAt(temp , y);
    }

    public void heapifyDown(int root){
        int largest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root  + 2 ;
        if(leftChild < size() && A.get(largest) < A.get(leftChild)){
            largest = leftChild ;
        }
        if(rightChild<size() && A.get(largest)< A.get(rightChild)){
            largest = rightChild;
        }
        if(largest != root){
            swap(root, largest);
            heapifyDown(largest);
        }
    }

    public void heapifyUp(int i){
        if(i> 0 && A.get(i)> A.get(getParent(i))){
            swap(i, getParent(i));
            heapifyUp(getParent(i));
        }
    }

    public Integer poll(){
        try{
            if(size() == 0){
                throw  new Exception("Heap underflow") ;
            }
            Integer out = A.firstElement() ;
            A.setElementAt(A.lastElement() , 0);
            A.remove(size() - 1) ;
            heapifyDown(0);
            return out ;

        }
        catch (Exception e){
            System.out.println(e);
            return null ;
        }
    }

    public Integer peek(){
        try{
            if(size()==0){
                throw new Exception("Heap underflow") ;
            }
            return A.firstElement() ;
        }
        catch (Exception e){
            System.out.println(e);
            return null ;
        }
    }

    public void clear(){
        while(!isEmpty()){
            System.out.println(poll() + " ");
        }
    }

    public void add(Integer i){
        A.addElement(i);
        heapifyUp(size() - 1);

    }

}
