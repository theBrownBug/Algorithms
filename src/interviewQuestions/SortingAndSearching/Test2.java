package interviewQuestions.SortingAndSearching;

public class Test2 {


    // =============================== binary Search ===================================================================

    public static int binarySearch(int[] array , int left , int right , int element){
        if(right>=1){
            //  Why right -1 ?
            // at base case :
            //  left = 0 ; right = length of the array
            // therefore: if we dont sub 1 from right we will get 1 element later than middle
            // there we sub 1 to get the int value of the middle index
            int middle = (left+ (right-1))/2 ;
            if (array[middle] == element){
                return element ;
            }
            if(array[middle]> element){
                binarySearch(array , left , middle-1 , element) ;
            }
            else{
                binarySearch(array , middle+1 , right , element) ;
            }
        }
        return -1 ;
    }

    //============================================ MERGE SORT ==========================================================


    public static void merge(int[] array , int left, int middle , int right){
        int leftArraySize = middle- left + 1 ;
        int rightArraySize = right - middle ;
        int[] leftArray = new int[leftArraySize] ;
        int[] rightArray = new int[rightArraySize] ;
        // copy the array's elements to the left and right arrays
        for(int counter = 0  ; counter< leftArraySize ; counter++){
            leftArray[counter] = array[left+counter] ;
        }
        for(int counter= 0 ; counter< rightArraySize ; counter++){
            rightArray[counter] = array[middle+1+counter] ;
        }

        // now merge

        int i  = 0 , j = 0 , k = left ;
        while(i< leftArraySize && j< rightArraySize){
            if(leftArray[i]<= rightArray[j]){
                array[k] = leftArray[i] ;
                i++ ;
            }
            else{
                array[k] = rightArray[j] ;
                j++ ;
            }
            k++ ;
        }
        // copy the rest of the array ;
        while(i< k){
            array[k] = leftArray[i] ;
            i++ ; k++ ;
        }
        while(j<k){
            array[k] = rightArray[i] ;
            i++ ; k++ ;
        }


    }
    public static void mergeSort(int[] array , int left , int right){
        if(left<=right){
            int middle = (left + right)/2 ;
            mergeSort(array , left , middle);
            mergeSort(array, middle+1 , right);
            // add a merge statement
            merge(array , left , middle ,right);
        }

    }

    //=============================================== BUBBLE SORT===========================================================

    public void bubbleSort(int[] array){
        for(int i = 0 ; i < array.length  ; i++){
            for(int j = 0 ; j < array.length- i - 1 ; j++){
                if(array[j]> array[j+1]){
                    int temp = array[j] ;
                    array[j] = array[j+1] ;
                    array[j+1] = temp ;
                }
            }
        }
    }

    //======================================== SELECTION SORT ===========================================================

    public static void selectionSort(int[] array){
        int smallest = 0 ;
        int exchangeVar = 0 ;
        for(int counter = 0 ; counter< array.length-1 ; counter++){
           smallest = counter ;
           for(int counter2  = counter+1 ; counter2< array.length ; counter2++){
               if(array[smallest]> array[counter2]) {
                   smallest = counter2;
               }
           }

           exchangeVar = array[smallest] ;
           array[smallest] = array[counter];
           array[counter] = exchangeVar ;
        }
    }

    //================================= INSERTION SORT =================================================================

    public static void insertionSort(int[] array){
        for(int i = 1 ;i < array.length ; i++){
            int key = array[i] ;
            int j = i - 1  ;

            while(j>= 0 && array[j]> key){
                array[j+1] = array[j] ;
                j-- ;
            }
            array[j+1] = key ;
        }
    }

    //================================ HEAP SORT =======================================================================


    public static void maxHeapify(int[] array  , int sizeOfHeap , int root){
        int largest = root ;
        int leftChild  = 2*root + 1;
        int rightChild = 2*root + 2;
        if(leftChild < sizeOfHeap && array[leftChild]> array[root]){
            largest = leftChild ;
        }
        if(rightChild < sizeOfHeap && array[rightChild]> array[root]){
            largest = rightChild ;
        }
        if(largest != root){
            int swap = array[largest] ;
            array[largest] = array[root] ;
            array[root] = swap ;
        }
    }

    public static void heapSort(int[] array){
        int length = array.length ;
        for(int counter = (length/2) -1 ; counter>= 0 ; counter--){ maxHeapify(array , length , counter) ; }
       for(int counter = array.length-1 ; counter>= 0 ; counter-- ){
           int temp = array[0] ;
           array[0] = array[counter] ;
           array[counter] = temp ;
           maxHeapify(array , length , 0) ;

       }

    }
    //==================================================================================================================


}
