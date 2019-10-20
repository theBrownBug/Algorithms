package Questions;

/*
* Maximum difference between two elements such that larger element appears after the smaller number
*
* Given an array arr[] of integers,
* find out the maximum difference between any two elements
* such that larger element appears after the smaller number.
*
* */
public class MaxDiff {

    /**
     * Max difference b/w elements in an array ;
     * O(n^2)
     * */
    static int findDifference(int[] array){
        int i , j ;
        int maxDiff = Integer.MIN_VALUE ;
        for(i = 0 ; i<array.length - 1 ; i++){
            for( j  = i+1 ; j < array.length ; j++){
                if(array[j] - array[i]> maxDiff){
                    maxDiff = array[j] - array[i] ;
                }
            }
        }
        return maxDiff ;
    }


    /**
     * Faster method
     * O(n) complexity
     * */

    static int maxDiffMod(int[] array){
        int minElement = array[0];
        int maxDifference = Integer.MIN_VALUE  ;
        for(int counter = 1  ; counter< array.length ; counter++){
            if(array[counter] - minElement > maxDifference){
                maxDifference = array[counter] - minElement ;
            }
            if(minElement> array[counter]){
                minElement = array[counter];
            }
        }
        return maxDifference ;
    }

    public static void main(String args[]){
        int[] array = {1, 2, 90, 10, 110} ;
        double first = System.nanoTime() ;
        System.out.println(MaxDiff.findDifference(array));
        double second = System.nanoTime() ;
        System.out.println("time taken " + (second - first));
        System.out.println(MaxDiff.maxDiffMod(array));
        double third = System.nanoTime() ;
        System.out.println("time Taken for Mod "  + ( third - second)) ;
    }
}
