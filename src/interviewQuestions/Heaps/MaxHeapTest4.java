package interviewQuestions.Heaps;

import java.util.Vector;

public class MaxHeapTest4{
    public Vector<Integer> A;
    public MaxHeapTest4(){ this.A = new Vector<>() ; }
    public MaxHeapTest4(int i){ this.A = new Vector<>(i) ; }
    public int size(){ return A.size(); }
    public boolean isEmpty(){ return A.isEmpty() ;}
    public int parent(int i){
        if(i==0){return 0 ; }
        return (i-1)/2 ;
    }
    public int getLeft(int i){return 2*i +1 ; }
    public int getRight(int i){ return  2*i + 2; }
    public void swap(int x , int y){
        int temp = A.get(x) ;
        A.setElementAt(A.get(y) , x);
        A.setElementAt(temp , y);
    }


    public void heapifyDown(int root){
        int largest = root ;
        int leftChild  = getLeft(root) ;
        int rightChild = getRight(root) ;
        if(leftChild< size() && A.get(leftChild)> A.get(root)){
            largest = leftChild ;
        }
        if(rightChild< size() && A.get(rightChild) > A.get(root)){
            largest = rightChild ;
        }

        if(largest != root){
            swap(largest, root);
            heapifyDown(largest);
        }
    }

    public void heapifyUp(int i){
        if(i> 0 && A.get(i)> A.get(parent(i))){
            swap(i , parent(i));
            heapifyUp(parent(i));
        }
    }

    public void add(Integer i){
        A.addElement(i);
        heapifyUp(size() -1 ) ;
    }

    public Integer poll(){
        try{
            if(size() == 0){ throw new Exception(" HEAP UNDERFLOW ") ; }
            Integer out = A.firstElement() ;
            A.setElementAt(A.lastElement(), 0);
            A.remove(size() -1) ;
            return out ;
        }
        catch (Exception e){
            System.out.println(e);
            return null ;
        }
    }

    public Integer peek(){
        try{
            if(size() ==0){ throw new Exception("Heap Underflow ") ;}
            return A.firstElement();
        }
        catch ( Exception e){
            System.out.println(e);
            return null ;
        }
    }

    public void clear(){
        System.out.println("CLEARING THE HEAP");
        while(isEmpty()){
            System.out.println(poll() + " ");
        }
        System.out.println();
    }

    public Boolean contains(Integer i){ return A.contains(i) ; }
}
