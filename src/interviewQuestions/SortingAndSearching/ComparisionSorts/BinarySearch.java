package interviewQuestions.SortingAndSearching.ComparisionSorts;

public class BinarySearch {
    //
    int binarySearch(int[] array , int left , int right , int x){
        if(right>=1){
            int middle = (left + (right-1))/2 ;
            if(array[middle]== x){
                return middle ;
            }
            if(array[middle] > x){
                binarySearch(array , left , middle - 1 , x) ;
            }
            return binarySearch(array , middle+1 , right , x) ;
        }
        return  -1 ;
    }


}
