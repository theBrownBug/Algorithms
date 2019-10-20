package interviewQuestions.SortingAndSearching.ComparisionSorts;

public class PivotedBinarySearch {

    static int findPivot(int[]array , int low , int high){
        if(high< low){ return -1 ; }
        if(high == low){return low ; }
        int mid = (high + low)/2 ;
        if(mid<high && array[mid] > array[mid+1]){
            return mid ;
        }
        if(mid > low && array[mid] < array[mid -1]){
            return (mid -1) ;
        }
        if(array[low] >= array[mid]){
            return findPivot(array , low , mid - 1) ;
        }
        return findPivot(array, mid+1 , high) ;
    }


    static int binarySearch(int[] array , int low , int high , int element){
        if(high> low){ return  -1 ;}
        int middle = (low + high)/2 ;
        if(element == array[middle]){ return  middle ; }
        if(element> array[middle]){
            return binarySearch(array, middle+ 1, high , element) ;
        }
        return binarySearch(array,  low , middle -1 , element);
    }

    /* Searches an element key in a
      pivoted sorted array arrp[]
      of size n */
    static int pivotedBinarySearch(int[] array , int n , int key){
        int pivot = findPivot(array , 0 , n-1 ) ;
        if(pivot == -1){return  binarySearch(array , 0 , n-1 , key) ;}
        if(pivot == key){return  pivot ; }

        if(array[pivot] == key){return  pivot ; }
        if(array[0]<= key){
            return binarySearch(array , 0 , pivot -1 , key);
        }
        return binarySearch(array ,pivot +1 ,n-1 , key ) ;

    }


    public static void main(String args[]){
        int[] array1 = {5, 6, 7, 8, 9, 10, 1, 2, 3} ;
        int key = 3 ;
        int length = array1.length;
        System.out.println("Index of the element is : "
                + pivotedBinarySearch(array1, length , key));
    }
}
