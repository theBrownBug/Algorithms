package interviewQuestions.Heaps;

import java.util.Vector;

public class MaxHeapTest2 {
    public Vector<Integer> A;
    public MaxHeapTest2(){ this.A = new Vector<>() ; }
    public MaxHeapTest2(int a ){ this.A = new Vector<>(a) ;}
    public int size(){return A.size() ; }
    public Boolean isEmpty(){return  A.isEmpty() ; }
    public Boolean contains(Integer i ){return  A.contains(i) ; }
    public int getParent(int i ){
        if(i==0){return  0 ;}
        return (i-1)/2 ;
    }
    public int getLeft(int i){ return (2*i) + 1 ; }
    public int getRight(int i){ return (2*i) +2 ; }
    public void swap(int i , int j){
        Integer temp = A.get(i) ;
        A.setElementAt(A.get(j) , i);
        A.setElementAt(temp , j);
    }

    public void heapifyDown(int root){
        int largest = root ;
        int leftChild = (2 * root) + 1;
        int rightChild = (2*root) + 2 ;
        if(leftChild< size() && A.get(leftChild)> A.get(largest)){ largest = leftChild ; }
        if(rightChild< size() && A.get(rightChild) > A.get(largest)){ largest = rightChild ; }
        if(largest != root){
            swap(largest , root);
            heapifyDown(largest);
        }
    }

    public void heapifyUp(int root){
        if(root> 0 && A.get(getParent(root)) < A.get(root)){
            swap(getParent(root) , root);
            heapifyUp(getParent(root));
        }
    }

    public Integer poll(){
        try{
            if(size()==0){
                throw new Exception("Heap underflow... ") ;
            }
            int root = A.firstElement() ;
            A.setElementAt(A.lastElement(), 0 );
            A.remove(size() -1 ) ;
            heapifyDown(0);
            return root ;
        }
        catch (Exception e){
            System.out.println(e);
            return null ;
        }
    }

    public Integer peek(){
        try{
            if(size() == 0){
                throw new Exception("heap underflow...") ;
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
            int root = poll() ;
            System.out.print(root + " ");
        }
    }


}
