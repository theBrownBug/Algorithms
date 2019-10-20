package interviewQuestions.Heaps;

import interviewQuestions.Graphs.Kruskal.KruskalTest4;

import java.util.Vector;

public class MinHeapTest {
    public Vector<Integer> A ;
    public MinHeapTest(){this.A = new Vector<>(); }
    public MinHeapTest(int v){ this.A = new Vector<>(v) ; }
    public boolean isEmpty(){return A.isEmpty() ; }
    public int size(){return  A.size();}
    public int parent(int i){
        if(i==0){return  0 ; }
        return (i-1)/2 ;
    }
    public int getLeft(int i ){return  (2* i) + 1 ; }
    public int getRight(int i){return  (2*i) + 2 ; }
    public void swap(int x ,int y){
        int temp = A.get(x) ;
        A.setElementAt(A.get(y) , x );
        A.setElementAt(temp, y);
    }

    public void heapifyDown(int root){
        int smallest   = root ;
        int leftChild  = getLeft(root) ;
        int rightChild = getRight(root) ;
        if (leftChild< size() && A.get(smallest)> A.get(leftChild)){
            smallest = leftChild ;
        }
        if(rightChild< size() && A.get(smallest) > A.get(rightChild)){
            smallest = rightChild ;
        }

        if( smallest != root ){
            swap(root , smallest);
            heapifyDown(smallest);
        }
    }

    public void heapifyUp(int i){
        if(i> 0 && A.get(i) < A.get(parent(i))){
            swap(i , parent(i));
            heapifyUp(parent(i));
        }
    }

    public void add(Integer i){
        A.addElement(i);
        heapifyUp(size() -1 );
    }

    public Integer poll(){
        try{
            if(size()==0){ throw new Exception(" HEAP UNDERFLOW ") ; }
            Integer out = A.firstElement() ;
            A.setElementAt(A.lastElement(), 0);
            heapifyDown(0);
            return out;
        }
        catch (Exception e){
            System.out.println(e);
            return null ;
        }
    }

    public Integer peek(){
        try{
            if(size() == 0){ throw new Exception("HEAP UNDERFLOW") ;}
            return A.firstElement() ;
        }
        catch ( Exception e){
            System.out.println(e);
            return null;
        }
    }

    public void clear(){
        System.out.println("Emptying the queue");
        while(size()!=0){
            System.out.println(poll()+" ");
        }
        System.out.println();
    }
    public boolean contains(Integer i){
        return A.contains(i) ;
    }



}
