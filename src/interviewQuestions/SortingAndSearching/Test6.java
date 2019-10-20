package interviewQuestions.SortingAndSearching;

public class Test6 {

    // binary search
    public static int binarySearch(int[] array , int left , int right , int element){
        if(right>=1){
            int middle = (left + (right-1))/2;
            if(array[middle] == element){
                return middle ;
            }
            else if(array[middle]> element){
                return binarySearch(array , left , middle -1  , element) ;
            }
            return binarySearch(array , middle+1 , right , element) ;
        }
        return -1 ;
    }


    // insertion sort
    public static void insertionSort(int[] array){
        for(int nextElement = 1 ; nextElement< array.length ; nextElement++){

            int key = array[nextElement] ;
            int j = nextElement - 1;

            while(j>= 0 && array[j]>key){
                array[j+1] = array[j] ;
                j-- ;
            }
            array[j+1] = key ;
        }
    }

    // check
    public static void bubbleSort(int[] array){
        for(int counter =  0 ; counter< array.length-1 ; counter++){
            for(int counter2 = 0  ; counter2< array.length -1 - counter ; counter2++){
                if(array[counter2]> array[counter2+1]){
                    int swap = array[counter2] ;
                    array[counter2]= array[counter2+1] ;
                    array[counter2 +1 ] = swap ;
                }
            }
        }
    }



    // merge sort


    public void merge(int[] array ,int left  , int middle , int right){
        int leftArraySize = middle - left + 1;
        int rightArraySize = right - middle ;
        // declare the arrays
        int[] leftArray = new int[leftArraySize] ;
        int[] rightArray = new int[rightArraySize] ;

        // copy the elements
        for(int counter = 0 ; counter< leftArraySize ; counter++){
            leftArray[counter] = array[left + counter] ;
        }

        for(int counter = 0 ; counter< rightArraySize ; counter++){
            rightArray[counter]= array[middle + 1 + counter] ;
        }

        // now start merging
        int i = 0 , j = 0 , k = left ;
        while(i < leftArraySize && j < rightArraySize){
            if(leftArray[i]<= rightArray[j]){
                array[k] = leftArray[i] ;
                i++ ;
            }
            else{
                array[k] = rightArray[j];
                j++ ;
            }
            k++ ;
        }

        // copy the rest of the elements
        while(i<leftArraySize){
            array[k] = leftArray[i] ;
            i++ ; k++ ;
        }
        while(j< rightArraySize){
            array[k] = rightArray[j] ;
            j++ ; k++ ;
        }


    }


    public void mergeSort(int[] array , int left, int right){
        if(left< right){
            int middle = (left + right)/2 ;
            mergeSort(array , left , middle);
            mergeSort(array , middle +1 , right );
            merge(array , left , middle , right) ;
        }
    }



    // selection sort
   public static void selectionSort(int[] array){
        int exchangeVar = 0 ;
        int smallest = 0 ;

        for(int counter = 0; counter< array.length - 1 ; counter++){
            smallest = counter ;
            for(int counter2 = counter + 1 ; counter2< array.length ; counter2++){
                if(array[counter2]< array[smallest]){
                    smallest= counter2 ;
                }
            }
            exchangeVar = array[counter] ;
            array[counter] = array[smallest] ;
            array[smallest] = exchangeVar ;
        }
   }

   //=================== HEAP SORT ========================================================

    public void maxHeapify(int[] array , int heapSize, int root){
        int largest   = root ;
        int leftChild = 2 * root + 1;
        int rightChild= 2 * root + 2;
        if( leftChild<heapSize && array[leftChild] > array[largest]){
            largest = leftChild ;
        }
        if(rightChild < heapSize && array[rightChild]> array[largest]){
            largest = rightChild ;
        }

        if(largest != root){
            int swap =  array[largest] ;
            array[largest] = array[root] ;
            array[root] = swap ;
            maxHeapify(array , heapSize , largest);
        }
    }

    public void heapSort(int[] array){
        int length=  array.length ;
        for(int counter = length/2 - 1 ; counter>= 0 ; counter--){
            maxHeapify(array , length , counter);
        }
        // now sort
        for(int counter = length -1 ; counter>= 0 ; counter--){
            int swap  = array[0] ;
            array[0] = array[counter] ;
            array[counter] = swap ;
            maxHeapify(array , counter , 0 );
        }

    }


    static  int[] randomArrayGenerator(){
        int size = (int) Math.abs(Math.random() *100) ;
        int[] array = new int[size] ;
        for(int counter = 0  ; counter< array.length ; counter++){
            array[counter] = (int) Math.abs(Math.random()*1000) ;
        }

        return array ;
    }

    public static  void print(int[]array){
        for(int counter = 0 ; counter<array.length ; counter++){
            System.out.print(array[counter] +" , ");
        }
        System.out.println();
    }



    public static void main(String args[]){
        Test6 ob = new Test6() ;


        System.out.println("INSERTION SORT  ");
        int [] array10 = randomArrayGenerator() ;
        print(array10);
        Test6.insertionSort(array10);
        print(array10);
        System.out.println();

        System.out.println("BUBBLE SORT ");
        int [] array11 = randomArrayGenerator() ;
        print(array11);
        Test6.bubbleSort(array11);
        print(array11);
        System.out.println();

        System.out.println("SELECTION SORT ");
        int [] array12 = randomArrayGenerator() ;
        print(array12);
        Test6.selectionSort(array12);
        print(array12);
        System.out.println();



        System.out.println("MERGE SORT ");
        int[] array3 = randomArrayGenerator() ;
        print(array3);
        ob.mergeSort(array3 , 0 , array3.length-1);
        print(array3);
        System.out.println();


        System.out.println("HEAP SORT ");
        int[] array5 = randomArrayGenerator() ;
        print(array5);
        ob.heapSort(array5);
        print(array5);
        System.out.println();
    }
}
