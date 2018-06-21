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
      * runtime big O(n^2)
      * */
     public static void bubbleSort(int[] array){}

     /**
      * runTime big O(n ( log(n) ) )
      * */
    public static void mergeSort(int[] array){}


}
