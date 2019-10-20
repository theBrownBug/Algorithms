package interviewQuestions.SortingAndSearching;

public class Test3 {


    public static int binarySearch(int[] array, int left , int right , int element){
        if(right>=1){
            int middle = (left + (right - 1))/2 ;
            if (array[middle] == element){ return middle ; }
            else if(element< array[middle]){
                binarySearch(array , left , middle-1 , element) ;
            }
            else{
                binarySearch(array , middle +1 , right , element) ;
            }

        }
        return  -1 ;
    }

    public static void bubbleSort(int[] array){
        for(int counter = 0 ; counter< array.length -1 ; counter++){
            for(int counter2 = 0 ; counter2< array.length- counter - 1 ; counter2++){
                if(array[counter2]> array[counter2+1]){
                    int temp = array[counter2] ;
                    array[counter2] = array[counter2+1] ;
                    array[counter2+ 1] = temp ;
                }
            }
        }
    }

    public static void selectionSort(int[] array){
        int smallest = 0 ;
        int exchangeVar = 0 ;
        for(int counter = 0 ; counter< array.length - 1 ; counter++){
            smallest = counter ;
            for(int counter2 = counter+1 ; counter2< array.length ; counter2++){
                if(array[counter2]< array[smallest]){ smallest = counter2 ; }
            }
            exchangeVar = array[smallest] ;
            array[smallest] = array[counter] ;
            array[counter] = exchangeVar ;
        }
    }

    public static void insertionSort(int[] array){
        for(int nextElement = 1 ; nextElement< array.length ; nextElement++){
            int key = array[nextElement] ;
            int current = nextElement -1 ;
            while(current>= 0 && array[current]>key){
                array[current+1] = array[current] ;
                current-=1 ;
            }
            array[current+1] = key ;
        }
    }


    public static void merge(int[] array , int left , int middle , int right){
        int leftArraySize = middle - left +1 ;
        int rightArraySize = right - middle ;
        int[] leftArray = new int[leftArraySize] ;
        int[] rightArray = new int[rightArraySize] ;

        // copy the elements
        for(int counter = 0 ; counter<leftArraySize ; counter++){
            leftArray[counter]  = array[left +counter] ;
        }
        for(int counter = 0 ; counter< rightArraySize ; counter++){
            rightArray[counter] = array[middle+ 1 + counter] ;
        }

        // now start merging
        int i = 0 , j = 0 , k= left ;
        while(i < leftArraySize && j < rightArraySize){
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

        // now merge the remaining arrays

        while(i<leftArraySize){
            array[k] = leftArray[i] ; i++ ; k++ ;
        }

        while(j <rightArraySize){
            array[k] = rightArray[j] ; j++ ; k++ ;
        }
    }
    public static void mergeSort(int[] array , int left , int right){
        if(left< right){
            int middle = (left + right)/2 ;
            mergeSort(array , left , middle);
            mergeSort(array , middle+1 , right);
            merge(array , left , middle , right ) ;
        }
    }

   public static void maxHeapify(int[] array , int sizeOfHeap ,int root){
        int largest = root ;
        int leftChild = 2 * largest + 1;
        int rightChild = 2 * largest + 2;
        if(leftChild< sizeOfHeap && array[largest]< array[leftChild]){
            largest = leftChild ;
        }
        if(rightChild< sizeOfHeap && array[largest]< array[rightChild]){
            largest = rightChild;
        }

        if(largest != root){
            int swap = array[root] ;
            array[root] = array[largest] ;
            array[largest] = swap ;
            maxHeapify(array , sizeOfHeap , largest);
        }
   }

   public static void heapSort(int[] array){
        int length = array.length ;
        for(int counter = length/2 -1 ; counter>= 0 ; counter--){
            maxHeapify(array , length , counter);
        }
        for(int counter = length - 1; counter>= 0 ; counter--){
            int swap = array[0];
            array[0] = array[counter] ;
            array[counter] = swap ;
            maxHeapify(array ,  counter ,0 );
        }

   }

}
