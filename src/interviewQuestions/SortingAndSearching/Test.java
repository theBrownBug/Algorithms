package interviewQuestions.SortingAndSearching;

public class Test {



    public static int binarySearch(int[] arr , int left , int right , int element){
        if(right>=1){
            int middle = (left + (right-1))/2 ;
            if (arr[middle] == element){ return middle ; }
            else if(element < arr[middle]){
                binarySearch(arr , left , middle-1, element) ;
            }
            else {
                binarySearch(arr , middle+1 , right , element) ;
            }
        }
        return - 1 ;
    }

    public static void bubbleSort(int[]arr){
        for(int i = 0 ; i < arr.length-1 ; i++){
            for(int j = 0 ; j< arr.length - i - 1; j++){
                if (arr[j]< arr[j+1]){
                    int temp = arr[j] ;
                    arr[j] = arr[j+1] ;
                    arr[j+1]= temp ;
                }
            }
        }
    }

    public static void selectionSort(int[]array){
        int min = 0 ;
        int exchangeVar  = 0 ;
        for(int counter = 0 ; counter< array.length-1 ; counter++){
            min = counter ;
            for(int counter2 = counter+1 ; counter2< array.length ; counter2++){
                    if(array[counter2]< array[min]){
                        min = counter2 ;
                    }
            }

            exchangeVar = array[counter] ;
            array[counter] = array[min] ;
            array[min] = array[counter] ;
        }

    }

    public static void merge(int[] arr , int left , int middle , int right){
        int leftArraySize = left-middle + 1 ;
        int rightArraySize  = right - middle ;
        int[] leftArray = new int[leftArraySize] ;
        int[] rightArray = new int[rightArraySize] ;
        // copy the elements
        for(int counter = 0 ; counter< leftArraySize ; counter++){
            leftArray[counter] = arr[left + counter] ;
        }
        for(int counter = 0 ; counter< rightArraySize ; counter++){
            rightArray[counter] = arr[middle+1 + counter] ;
        }

        int i = 0 , j = 0 , k = left ;
        while(i< leftArraySize  && j< rightArraySize){
            if(leftArray[i] <=rightArray[j]){
                arr[k] =  leftArray[i] ;
                i++ ;
            }
            else{
                arr[k] = rightArray[j] ;
                j++ ;
            }
            k++ ;
        }

        while(i < leftArraySize){
            arr[k] = leftArray[i] ;
            i++ ; k++ ;
        }

        while(j<rightArraySize){
            arr[k] = rightArray[j] ;
            j++ ; k++ ;
        }
        // copy the rest of the array


    }

    public static void mergeSort(int[] arr , int left ,int right){
        if(left<right){
            int middle = (left + right)/2;
            mergeSort(arr ,left , middle);
            mergeSort(arr , middle+1 , right);
            merge(arr , left , middle , right ) ;
        }
    }



    public static void insertionSort(int[]arr){
        for(int counter = 1 ; counter< arr.length ; counter++){
            int nextElement = arr[counter] ;
            int current = nextElement - 1;

            while(current>= 0  && nextElement < arr[current]){
                arr[current+1]= arr[current] ;
                current-= 1;
            }
            arr[current+1] = nextElement ;
        }
    }




    public static void maxHeapify(int[] array , int sizeOfHeap , int root){
        int largest = root;
        int left = 2*root + 1;
        int right = 2*root + 2 ;
        if(left<sizeOfHeap && array[left]>array[largest]){
            largest = left ;
        }
        if(right< sizeOfHeap && array[right]> array[largest]){
            largest = right ;
        }

        if(largest != root){
            int swap = array[largest] ;
            array[largest] = array[root] ;
            array[root] =swap ;
            maxHeapify(array , sizeOfHeap , largest);

        }
    }




    public static void heapSort(int[] array){
        int length = array.length ;

        for(int counter = length/2 - 1; counter>=0 ; counter--){
            maxHeapify(array , length , counter) ;
        }
        for(int counter = length-1 ; counter>=0 ; counter--){
            int temp = array[0] ;
            array[0] = array[counter] ;
            array[counter] = temp ;
            maxHeapify(array , counter , 0) ;
        }
    }


    //=========================



}
