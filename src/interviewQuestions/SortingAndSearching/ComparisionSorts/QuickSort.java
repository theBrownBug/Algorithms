package interviewQuestions.SortingAndSearching.ComparisionSorts;

public class QuickSort {


    int partition(int [] array , int low ,int high){
        int pivot = array[high] ;
        int i = low - 1; // index of smaller element

        for(int j = low ; j < high ; j++){
            if(array[j] <= pivot){
                i++ ;

                int temp = array[i] ;
                array[i] = array[j] ;
                array[j] = temp;
            }

        }

        int swap = array[i+1] ;
        array[i+1] = array[high] ;
        array[high] = swap ;
        return i+1 ;

    }

    void sort(int[] array , int low , int high){
        if(low< high){
            int partitionIndex = partition(array ,low , high) ;
            // recursively sort the elements before and after the partition
            sort(array , low , partitionIndex -1 );
            sort(array , partitionIndex + 1 , high);
        }
    }

}
