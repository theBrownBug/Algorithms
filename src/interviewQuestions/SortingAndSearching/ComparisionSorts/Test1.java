package interviewQuestions.SortingAndSearching.ComparisionSorts;

public class Test1 {


    /***
     * binary Search
     * Merge Sort
     * Heap Sort
     * Bubble Sort
     * Insertion Sort
     * Selection Sort
     * Quick Sort
     */

    public static int binarySearch(int [] array , int left ,int right , int element){
        if(right>=1){
            int middle = (left + (right - 1)) /2 ;
            if(array[middle] == element){
                return middle ;
            }
            else if(array[middle]> element){
                return binarySearch(array , left , middle -1 , element) ;
            }
            return binarySearch(array , middle+ 1 , right , element) ;
        }
        return -1 ;
    }


    public void maxHeapify(int[] array , int heapSize , int root){
        int largest = root;
        int leftChild = 2 * root +1 ;
        int rightChild = 2 * root + 2 ;
        if(leftChild< heapSize && array[largest]< array[leftChild]){
            largest = leftChild ;
        }
        if(rightChild< heapSize && array[largest] < array[rightChild]){
            largest = rightChild ;
        }

        if(largest != root){
            int temp = array[largest] ;
            array[largest] = array[root] ;
            array[root] = temp ;
            maxHeapify(array , heapSize , largest);
        }
    }


    public void heapSort(int[] array){
        int length = array.length ;
        for(int counter = length/2 -1 ; counter>=0 ; counter--){
            maxHeapify(array , length , counter);
        }
        // now sort
        for(int counter = length - 1; counter>= 0 ; counter--){
            int swap = array[0] ;
            array[0] = array[counter] ;
            array[counter] =swap ;
            maxHeapify(array, counter ,0);
        }
    }



    public static void insertionSort(int[] array){
        for(int nextElement = 1 ; nextElement< array.length ; nextElement++){
            int key = array[nextElement] ;
            int j = nextElement -1 ;
            while(j>= 0 && key<array[j]){
                array[j+1] = array[j] ;
                j-- ;
            }
            array[j+1] = key ;
        }
    }

    public static void selectionSort(int[] array){
        int smallest = 0 ;
        int exchangeVar = 0;
        for(int counter = 0 ; counter< array.length -1 ; counter++){
            smallest = counter ;
            for(int counter2 = counter+1 ; counter2< array.length ; counter2++){
                if(array[counter2]< array[smallest]){
                    smallest = counter2 ;
                }
            }
            exchangeVar = array[smallest] ;
            array[smallest] =array[counter] ;
            array[counter] = exchangeVar ;
        }
    }

    public static void bubbleSort(int[] array){
        for(int counter = 0 ; counter< array.length ; counter++){
            for(int counter2 = 0 ; counter2< array.length -1 - counter  ; counter2++){
                if(array[counter2]> array[counter2+1]){
                    int swap = array[counter2] ;
                    array[counter2] = array[counter2 + 1] ;
                    array[counter2+1] = swap ;
                }
            }
        }
    }


    public void merge(int[] array , int left , int middle , int right){
        int leftArraySize = left - middle + 1;
        int rightArraySize = right - middle ;
        int[] leftArray = new int[leftArraySize] ;
        int[] rightArray= new int[rightArraySize] ;
        // copy the elements of the array
        for(int counter = 0 ; counter< leftArraySize; counter++){
            leftArray[counter] = array[left + counter] ;
        }
        for(int counter = 0 ; counter< rightArraySize ; counter++){
            rightArray[counter] = array[counter+ middle + 1] ;
        }
        int i = 0 ,j = 0 , k= left;
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

        // copy the rest of the elements
        while(i<leftArraySize){
            array[k] = array[leftArraySize] ;
            k++ ; i++ ;
        }
        while(j< rightArraySize){
            array[k] = array[rightArraySize] ;
            k++ ; j++ ;
        }
    }

    public void mergeSort(int[] array ,int left , int right){
        if(left< right){
            int middle = (left + right)/2 ;
            mergeSort(array , left , middle);
            mergeSort(array , middle + 1 , right);
            merge(array , left , middle , right);
        }
    }


    //=================== QUICK SORT =============================================
    public int partition(int[] array , int low , int high){
        int pivot = high  ;
        int i = low - 1;
        for(int counter =  low ; counter< high ; counter++){
            if(array[counter]<=pivot){
                i++ ;
                int swap = array[i] ;
                array[i] = array[counter] ;
                array[counter] = swap ;
            }
        }
        int temp = array[high] ;
        array[high] = array[i+1] ;
        array[i+1] = temp ;
        return i+1;
    }

    public void quickSort(int[] array, int low , int high){
        if(low< high){
            int partitionIndex = partition(array , low , high) ;
            quickSort(array , low , partitionIndex -1 );
            quickSort(array ,partitionIndex +1 , high);
        }
    }

    //==================================================================================================================
}
