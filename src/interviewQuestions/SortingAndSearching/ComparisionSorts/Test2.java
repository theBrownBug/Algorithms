package interviewQuestions.SortingAndSearching.ComparisionSorts;

public class Test2 {
    //==========================================
    public static int  binarySearch(int[] array , int left ,int right , int element){
        if(right>=1){

            int middle = (left + (right -1 ))/2 ;
            if(array[middle] == element){return middle ; }
            else if(element< array[middle]){
                return binarySearch(array , left , middle-1 , element) ;
            }
            return binarySearch(array , middle + 1 , right , element) ;
        }
        return -1 ;
    }

    //==========================================


    public void maxHeapify(int[] array , int heapSize , int root){
        int largest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root+ 2;
        if(leftChild< heapSize && array[leftChild] > array[root]){
            largest = leftChild ;
        }
        if(rightChild< heapSize && array[rightChild]> array[root]){
            largest = rightChild;
        }

        if(largest != root){
            int temp  = array[largest];
            array[largest] = array[root] ;
            array[root] = temp ;
            maxHeapify(array , heapSize, largest);
        }
    }

    public void heapSort(int[] array){
        int length = array.length;
        for(int counter = length/2 -1; counter>=0 ; counter--){
            maxHeapify(array, length , counter);
        }
        // now sort
        for(int counter = length -1 ; counter>=0 ; counter--){
            int temp = array[0] ;
            array[0] = array[counter];
            array[counter] = temp ;
            maxHeapify(array, counter, 0);
        }
    }


    //==========================================

    public void merge(int[] array ,int left , int middle , int right){
        int leftArraySize = middle - left +1;
        int rightArraySize = right - middle ;
        int[] leftArray = new int[leftArraySize] ;
        int[] rightArray = new int[rightArraySize] ;

        // copy the elements
        for(int counter = 0 ; counter< leftArraySize ; counter++){
            leftArray[counter] = array[left+counter];
        }
        for(int counter = 0 ; counter< rightArraySize; counter++){
            rightArray[counter] = array[middle + 1 + counter] ;
        }
        int i = 0 , j = 0 , k = left ;
        while(i< leftArraySize && j< rightArraySize){
            if(leftArray[i]<= rightArray[j]){
                array[k] = leftArray[i] ;
                i++ ;
            }
            else{
                array[k] = rightArray[j];
                j++;
            }
            k++ ;
        }
        //copy the rest of the elements
        while(i< leftArraySize){
            array[k] = leftArray[i] ;
            i++ ; k++ ;
        }
        while(j< rightArraySize){
            array[k] = rightArray[j] ;
            j++ ; k++ ;
        }
    }

    /*
    *
    * */
    public void mergeSort(int[] array ,int left ,int right){
      if(left< right){
          int middle = (left + right)/2;
          mergeSort(array, left , middle);
          mergeSort(array , middle+1 , right);
          merge(array , left , middle , right);
      }
    }

    //=============================================================================

    public void insertionSort(int[] array){
        for(int nextElement = 1 ; nextElement< array.length ; nextElement++){
            int key = array[nextElement] ;
            int j = nextElement -1 ;
            while(j>=0 && key<array[j]){
                array[j+1] = array[j];
                j-- ;
            }
            array[j+1] =key ;
        }
    }
    //=============================================================================

    public void bubbleSort(int[] array){
        for(int counter = 0; counter< array.length - 1; counter++){
            for(int counter2 = 0 ; counter2< array.length - counter - 1 ; counter2++){
                if(array[counter2]> array[counter2 +1]){
                    int swap = array[counter2] ;
                    array[counter2] = array[counter2 + 1] ;
                    array[counter2 +1] = swap ;
                }
            }
        }
    }


    //=============================================================================

    public void selectionSort(int[] array){
        int exchangeVar = 0 ;
        int smallest = 0 ;
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

    //=============================================================================

    public int partition(int[] array ,int low , int high){
        int pivot = array[high] ;
        int i = low - 1;

        for(int counter = low ;counter<high ; counter++){
            if(array[counter]<= pivot){
                i++ ;
                int swap = array[counter] ;
                array[counter] =array[i] ;
                array[i] = swap ;
            }
        }

        int temp = array[i+1] ;
        array[i+1]= array[high] ;
        array[high] = temp ;
        return  i+1 ;
    }

    public void quickSort(int[] array , int low , int high){
        if(low< high){
            int partitionIndex = partition(array , low , high) ;
            quickSort(array, low , partitionIndex - 1);
            quickSort(array , partitionIndex + 1 , high);
        }
    }


   //=============================================================================





}
