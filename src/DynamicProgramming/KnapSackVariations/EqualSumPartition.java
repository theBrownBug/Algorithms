package DynamicProgramming.KnapSackVariations;

import java.util.* ;

public class EqualSumPartition {
    /***
     *
     * Given an array , find out whether it can be divided into 2 subArrays whose sum are equal
     *
     * */
    public int sum(int[] array){
        int s =  0 ;
        for(int counter = 0 ; counter< array.length ; counter++){
            s+= array[counter];
        }
        return s ;
    }

    public boolean equalSumPartition(int[] array){
        int sum = sum(array);
        if(sum%2!=0){
            return false;
        }
        else{
            Integer[] a = new Integer[array.length];
            for(int c = 0 ; c< a.length ; c++){
                a[c] = new Integer(array[c]);
            }
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a));

            return SubSetSum.subSetSumDP(list , sum);
        }
    }

}
