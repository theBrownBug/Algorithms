public class SearchingAlgorithms {

    /**
     * Linear Search
     * complexity : O(n)
     * */
    public static int linearSearch(int[] array , int elementToBeFound){
        int lengthOfArray = array.length  ;

        for(int counter = 0 ; counter<lengthOfArray; counter++){
            if(array[counter]== elementToBeFound){
                 return counter ;
            }
        }
        return -1 ;
    }

    // the array needs to be sorted for Binary Search to work
    /**
     * Binary Search
     * worst case time complexity : O(log n)
     * */

    public static int binarySearch(int[] array,int leftStart, int rightEnd, int elementToBeFound){

        if(rightEnd>=leftStart){
            int middle = (int) Math.floor((rightEnd + leftStart)/2) ;
            // if the element is present at the middle of the array, return the position of the element
            if(array[middle]== elementToBeFound){
                return middle ;
            }
            else if(elementToBeFound< array[middle]){
               return  binarySearch(array, leftStart,middle -1 ,elementToBeFound) ;
            }
            else{

                return binarySearch(array,leftStart,middle+1 ,elementToBeFound) ;
            }
        }
        return - 1;
    }

    /* Jump Search
     * The array needs to be sorted
     * Jump Search   : Complexity O(n^0.5) ; Auxiliary Space = O(1) ;
     * Best  Jump Step = n^0.5 , where n is the size of the array
     *
     * The Optimal Jump Block Size :
     * In the worst case, we have to do n/m jumps (n= array.size) and m = size of a  jump . Also after finding, the range to do linear search
     * on, we do (m-1) comparisions.
     * Therefore , total comparisons : (n/m  + m-1 )    The value of the function will be minimum when m = n^0.5 ;
     *
     */

     public static int jumpSearch(int[] array, int toBeFound){

         int arraySize = array.length ;
         int stepSize = (int) Math.floor(Math.sqrt(arraySize)) ;      // length of each jump
         int previous = 0 ;

         while(array[Math.min(stepSize,arraySize) -1 ] < toBeFound){

             previous =  stepSize ;
             stepSize+= (int) Math.floor(Math.sqrt(arraySize)) ;
             if(previous > arraySize){
                 return -1 ;
             }

         }

         //performing  a linear Search in a given block
         while(array[previous]<toBeFound){
             previous ++ ;

             // if we reached the end of the block or the end of the array, then the element is not present
             // in the subsection of the array
             if(previous == Math.min(stepSize , arraySize)){
                 return -1 ;
             }
          }

          // if element is found, the location of the 
          if(array[previous]==toBeFound){return previous ; }

          return -1;

     }

     /**
      * Interpolation search is a better version of Binary Search
      * Interpolation Search : Complexity O(log(log(n)))
      * It is a better version where the elements of a sorted array are uniforrmly distributed 
      *
      * */

      public static int interpolationSearch(int[]array , int toBeFound){
        
        int low = 0 , high = array.length - 1 ; 

        //the element should be present in between the high and low indices 
        
        while(toBeFound>= array[low] && toBeFound <= array[high] && low <= high){
                
                int position = ((high - low )/(array[high] - array[low])) * (toBeFound - array[low]) ;

                if(array[position]== toBeFound){return position ; }
                
                // if toBeFound is larger , it is in the upper part  
                if(array[position]<toBeFound){ low = position + 1 ; }

                else{ high = position -1 ; }
        }
        return -1 ; 
      }



}
