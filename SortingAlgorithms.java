public final class SortingAlgorithms {



        // Comparision Sorts

        /*
         * initially the sorted array contains only one element, after each iteration the subarray on the left is always sorted and
         * the rest of the elements are unsorted
         * worst case runtime: O(n^2) best case runtime: O(n)
         * */

    public static void insertionSort(int[] array){
        for(int nextElement = 1 ; nextElement< array.length ; nextElement++){
            // element to be placed in the correct position in the sorted subarray on the left
            int key = array[nextElement] ;
            int currentElement = nextElement- 1;

            // iterating over the sorted subarray to place the (key) in the correct position
            while(currentElement>= 0 && array[currentElement]>key){ // included >= as the first element wasnt compared
                // swapping elements in the array
                array[currentElement +1] = array[currentElement] ;
                currentElement-=1 ;
            }
            // because the pointer is one element back
            array[currentElement+1] = key ;
        }
    }



    /**
     * @param   array   The array to be sorted
     * @param   n       the recursive call parameter
     * */
    public static void recursiveInsertionSort(int[] array , int n){

        // base case if n == 1
        if(n<=1){return ; }

        recursiveInsertionSort(array, n-1) ; // sort the first n-1 elements


        /// doubt
        int last  = array[n-1] ;
        int j = n-2 ;

        while(j>= 0 && array[j]>last){
            array[j+1] = array[j] ;
            j-- ;
        }
        array[j+1] = last  ;
    }

    /**
     * Big O of n^2 (The best and the worst case time)
     * */
        public static void selectionSort(int[] array){

            int length = array.length;

            // initializing smallest
            int smallest = 0;
            int exchangeVar = 0 ;
            for(int counter = 0 ; counter<array.length-1 ; counter++){
                smallest = counter ;
                for(int i = counter+1 ; i<array.length ; i++){
                    if(array[i]<array[smallest]){

                        smallest = i ;
                    }

                }
                // exchanging the variables
                exchangeVar = array[counter] ;
                array[counter] = array[smallest] ;
                array[smallest]= exchangeVar ;
            }

        }

    /**
     * runtime big O(n^2) (worst case)
     *         big Omega(n) (best case)
     * */
    public static void bubbleSort(int[] array){
        for(int counter = 0 ; counter<array.length-2 ; counter++){
            for( int counter2 = array.length-1 ; counter2>0 ; counter2--){
                if(array[counter2]<array[counter2- 1]){
                    // exchange the elements
                    int exchange = array[counter2] ;
                    array[counter2] = array[counter2 -1] ;
                    array[counter2-1] = exchange ;
                }
            }
        }
    }



    /**
     *
     * MERGE SORT :
     *
     * 1.merge subroutine :
     * */

    public static void merge(int[] array , int left , int right , int middle){

        int leftArrSize = middle - left + 1 ;
        int rightArrSize = right - middle;

        int[] leftArray = new int[leftArrSize] ;
        int[] rightArray= new int[rightArrSize];

        // creating the left and right subArrays... takes extra O(n) space
        for(int counter = 0 ; counter <  leftArrSize; counter++){
            leftArray[counter] = array[left+counter] ;
        }
        for(int counter = 0 ; counter<rightArrSize ; counter++){
            rightArray[counter] = array[middle+1+counter] ;
        }

        int i = 0,  j= 0 , k = left ;

        while(i<leftArrSize && j< rightArrSize){

            if(leftArray[i]<= rightArray[j]){
                array[k]  = leftArray[i] ;
                i++ ;
            }
            else{
                array[k] = rightArray[j] ;
                j++ ;
            }
            k++ ;
        }

        // copying the rest of the elements

        while(i<leftArrSize){
                array[k]  = leftArray[i] ;
                i++ ;
                k++ ;
        }

        while(j<rightArrSize){
            array[k] = rightArray[j] ;
            j++ ;
            k++ ;
        }

    }

    /**
     * 2 . sort algorithm
     *
     * */

    public static void mergeSort(int[] array , int left , int right){

        if(left< right){
            int middle = (left+right)/2 ;

            SortingAlgorithms.mergeSort(array, left , middle);
            SortingAlgorithms.mergeSort(array, middle+1 , right);
            SortingAlgorithms.merge(array, left , right , middle);

        }
    }


    /**
     * heapSort Algorithms :
     *
     * */

    public static void heapSort(int[] array){
        int arrayLength =array.length ;
        for(int counter = (arrayLength/2) ; counter>= 0; counter--){
            SortingAlgorithms.maxHeapify(array, counter , arrayLength);
        }

        for(int counter = arrayLength- 1;counter>=0 ; counter--){
            int temp = array[0] ;
            array[0] = array[counter] ;
            array[counter] = temp ;
            // call max - heapify on the reduced heap ...
            SortingAlgorithms.maxHeapify(array,0  , counter );
        }

    }

    /**
     *  Heapify subRoutine
     *
     *  To Heapify
     * */

    public static void maxHeapify(int[] array , int node , int heapSize){
        int largest    = node ;
        int leftChild  = 2*node + 1;
        int rightChild = 2* node + 2 ;

        // if the  left child is larger than the root
        if(leftChild < heapSize && array[leftChild]> array[largest]){

            largest = leftChild;
        }


        if(rightChild< heapSize && array[rightChild]< array[largest]){
            largest = rightChild ;
        }
        // if the largest element is not the original node , then swap the elments and recursively call the method
        // until the heap property is satisfied

        if(largest != node){
            // swap
            int swap = array[node] ;
            array[node] = array[largest] ;
            array[largest] = swap ;

            maxHeapify(array ,largest , heapSize) ;
        }
    }


    public static void shellSort(int[] array){
        int arrayLength = array.length;
        // start with a big gap and reduce the gap

        for(int gap = arrayLength/2 ; gap> 0 ; gap/=2){

            // do insertion sort for each of the gapped size subArrays
            for(int i = gap ; i< arrayLength ; i++){
                int temp = array[i] ;

                int  j ;
                for( j = i ; j>= gap && array[j-gap] > temp ; j-= gap){
                    array[j] = array[j - gap] ;
                }
                array[j] = gap ;
            }
        }
    }



    /*
    * NON COMPARISION SORTS
    * */


    /*
    * Supporting function for counting sort
    *
    */
    public static int maxElement(int[] array){

        int maxElement = 0 ;

        for(int counter = 0 ; counter< array.length ; counter++){
            if(array[counter]>=maxElement){
                maxElement = array[counter] ;
            }
        }

        return maxElement ;
    }

    /**
     *Counting sort
     *
     * @param originalArray : The Array to be Sorted
     * @param resultantArray: The output array
     *
     */

    public static void countingSort(int[] originalArray , int[] resultantArray){

        int maxElement = SortingAlgorithms.maxElement(originalArray) ;
        int[] tempArray = new int[maxElement] ;

        for(int counter = 0 ; counter< tempArray.length ; counter++){
                tempArray[counter] = 0  ;
        }

        // tempArray[i] contains the number of elements equal to i ;
        for(int counter = 0; counter<originalArray.length ; counter++){
            tempArray[originalArray[counter]] = tempArray[originalArray[counter]] + 1 ;
        }

        for(int i = 0 ; i<maxElement ; i++){
            tempArray[i] = tempArray[i] + tempArray[i-1] ;
        }
        // tempArray now contains the number of element less than or equal to i

        for(int counter = originalArray.length -1 ; counter>= 0 ; counter--){
            resultantArray[tempArray[originalArray[counter]]] = originalArray[counter] ;
            tempArray[originalArray[counter]] = tempArray[originalArray[counter]] -1 ;
        }
    }


    /**
     * RADIX SORT : RUN COMPARISION SORT N Number of times ,
     * Counting sort(stable) is a subroutine of Radix Sort
     *
     * */

    public static void radixSort(int[] array){

        int maxElement = SortingAlgorithms.maxElement(array) ;
        // do counting sort for every Digit
        for(int exp= 1 ; maxElement/exp> 0 ; exp*=10){
            SortingAlgorithms.countingSort(array, );
        }
    }

}
