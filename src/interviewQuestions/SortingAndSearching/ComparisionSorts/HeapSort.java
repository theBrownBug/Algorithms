package interviewQuestions.SortingAndSearching.ComparisionSorts;

public class HeapSort {

    /*
    * heapify function
    * */
    public void maxHeapify(int[] array , int sizeOfHeap , int root ){
            int largest = root ;
            int left    = 2*root +  1 ;
            int right   = 2*root + 2 ;
            if(left< sizeOfHeap && array[left]> array[largest]){ largest = left ; }
            if(right< sizeOfHeap && array[right]> array[largest]){ largest = right ; }
            if(largest!= root){
                int swap=  array[root] ;
                array[root] = array[largest] ;
                array[largest] = swap ;
                maxHeapify(array , sizeOfHeap , largest);
            }
    }

    /*
    *
    */
    public void heapSort(int[] array){
        int n  = array.length ;
        for(int i = n/2 -1 ; i>=0 ; i--){
            maxHeapify(array ,n,i);
        }
        for(int i = n-1 ; i>= 0 ; i--){
            int temp = array[0] ;
            array[0] = array[i] ;
            array[i] = temp ;
            maxHeapify(array , i , 0);
        }
    }



}
