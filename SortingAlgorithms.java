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


    public static void mergeSort(int[] array){

        

    }


}
