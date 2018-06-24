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
      * The array needs to be sorted as well
      *
      * */


     public static int interpolationSearch(int[] array , int toBeFound){

         int low = 0 ,  high = array.length-1  ;

         // the element should be present in between high and low because the array is already sorted 
         while(low<= high && toBeFound >= array[low] && toBeFound<= array[high]){

             // why ??
                int position = low + ((high -low)/(array[high]-array[low])) * (toBeFound - array[low]) ;

                if(array[position]== toBeFound){return position ; }

                // if x is larger , it is in the upper part
                if(array[position]<toBeFound){low = position +1 ; }

                // if x is smaller , it is in the smaller part
                else{high = position - 1 ; }
                
         }
         return -1 ; 

     }

     /*
      *Exponential Search
      * Time Complexity : O(log n )
      *
      * Involves 2 steps :
      * 1. Find a particular range of elements in which the desired element resides
      * 2. Do a binary Search on the range
      *
      * Basic Idea : Start with the subarray size = 1 , compare the element with x , keep doubling until suitable range is not found
      *
      * Once we find an index i > toBeFound , the element must lie b/w i/2 and i because, if it didnt then we would have stopped at i/2
      * and tried to find it b/w i/4 and i/2
      * */

     public static int exponentialSearch(int[] array, int arrayLength , int toBeFound){

         if(array[0]==toBeFound){ return 0 ; }

         int multiplicationFactor = 1 ;
         // find the range
         while(multiplicationFactor<arrayLength && array[multiplicationFactor]<= toBeFound){
             // keep multiplying the factor by 2
             multiplicationFactor*=2  ;
         }
         return SearchingAlgorithms.binarySearch(array,multiplicationFactor/2,Math.min(multiplicationFactor,arrayLength), toBeFound) ; 

     }





      /*
      * Fibonacci Search algorithm : A comparison based algo
      * Works on sorted arrays
      * Uses divide and conquer technique
      * Time Complexity = Big O( log(n)) ;
      *
      * Differences compared with binary Search :
      * 1. Divides an array in unequal parts
      *
      * nth Fibonacci term :
      * to remember: F(n) = F(n-1)+ F(n-2)
      *
      * Basic working Scheme :
      * Find  the first fibonacci number that is greater than the length of the array 
      *
      **/

      public static int fibonacciSearch(int[] array , int toBeFound , int arrayLength){

          // initialize the fibonacci numbers
          int firstFibo = 0 ;
          int secondFibo= 1 ;

          // nth fibonacci Number
          int fiboNth = firstFibo + secondFibo ;

          // while the fibonacci number is smaller than the length of the array,
          // 
          while(fiboNth < arrayLength){
               firstFibo = secondFibo ;
               secondFibo = fiboNth ;
               fiboNth = firstFibo+secondFibo ;

          }
          // marks the eliminated range from front
          int offset = -1 ;

          /*
           * while there are elements to be inspected, we compare array[secondFibo] with toBeFound 
           *
           **/

          while(fiboNth>1){

              int validLocation = (int) Math.min(offset+firstFibo, arrayLength) ;

              if(array[validLocation]  < toBeFound){

                  fiboNth = secondFibo ;
                  secondFibo = firstFibo ;
                  firstFibo = fiboNth -secondFibo ;
                  offset = validLocation ; 
              }

              // if x is greater than the value at the index, firstFibo , cut the subarray after i+1 ;
              else if(array[validLocation]> toBeFound){

                  fiboNth = firstFibo;
                  secondFibo = secondFibo - firstFibo ;
                  firstFibo = fiboNth - secondFibo ;
              }
              else {return validLocation ; }
          }

          // comparing the last element with toBeFound
          if(secondFibo==1 && array[offset+1]==toBeFound){
              return offset+1 ; 
          }
              return -1 ;
      }

    


}
