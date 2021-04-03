package DynamicProgramming.KnapSackVariations;

import java.util.* ;

public class EqualSumPartition {
    /***
     *
     * Given an array , find out whether it can be divided into 2 subArrays whose sum are equal
     *
     * */
    public static int sum(int[] array){
        int s =  0 ;
        for(int counter = 0 ; counter< array.length ; counter++){
            s+= array[counter];
        }
        return s ;
    }

    public static boolean equalSumPartition(int[] array){
        int sum = sum(array);
        if(sum%2!=0){return false; }

        sum/=2 ;
        return SubSetSum.subSetSumDP(array , sum);
    }

}
