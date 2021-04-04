package DynamicProgramming.KnapSackVariations;

import java.util.Arrays;

/**
 * Given an array, partition it in such a way that the
 * difference between the sum of elements in the partitions is minimum
 * */
public class MinSubSetSumDifference {

    public static int minDiff(int[] array){
        /**
         *
         * we know that the sum of two partitions would be the sum of the all the elements in the array
         * Since we are partitioning the array, the sum of the elements in either of the partitions
         * would lie in between (0 , sum of all elements in the array)
         * since the minimum number of elements a partition can have is 0
         * the maximum number of elements a partition can have is all the elements in the array
         *
         *  S1 - S2 = min
         *  S1 - (range - S1) = min
         *  range - 2S1 = min
         *
         * */
        int range = sum(array);
        Integer[] validValuesInRange = subSetSumVariation(array , range);
        int min = Integer.MAX_VALUE ;
        for(int c = 0 ; c<validValuesInRange.length/2 ; c++){
            if(validValuesInRange[c] != null && validValuesInRange[c]==1){
                min = (int)Math.min(min , range - 2*c) ;
            }
        }
        return min ;
    }



    public static Integer[] subSetSumVariation(int[] array , int target){
        Integer[][] memo = new Integer[array.length + 1][target + 1];

        // initialise
        for(Integer[] row: memo){
            Arrays.fill(row , 0);
        }
        for(int c = 0 ; c<memo.length ; c++){
            memo[c][0] = 1;
        }
        int result = subSetSumVariationDP(array , target , memo , array.length);
        Integer[] toReturn = new Integer[memo[0].length];

        for(int row = 0 ; row<memo.length ; row++){
            for(int col = 0 ; col<memo[row].length ; col++){
                System.out.print(String.valueOf(memo[row][col]) + " ");
            }
            System.out.println();
        }
        for(int c = 0 ; c< memo[0].length ; c++){
            toReturn[c] = memo[memo.length-1][c];
        }
        return toReturn;
    }


    public static int subSetSumVariationDP(int[] array , int target , Integer[][]memo , int n){
        if(target==0){
            return 1;
        }
        if(target<0 || n == 0){return 0; }
        else if(memo[n - 1][target]==1){return memo[n - 1][target];}
        else if(array[n-1]<=target){
            memo[n][target] = subSetSumVariationDP(array , target - array[n-1] , memo , n-1) +
                    subSetSumVariationDP(array , target , memo , n-1);
            return memo[n][target];
        }
        else{
            memo[n][target] = subSetSumVariationDP(array , target , memo , n-1);
            return memo[n][target];
        }
    }


    public static int sum(int[] arr){
        int c =0 ;
        int sum = 0 ;
        for(int i : arr){
            sum+= arr[c];
            c++ ;
        }
        return sum ;
    }







    public static void main(String args[]){
        int[] array = new int[]{1 , 2 ,1 ,  7};
        System.out.println(minDiff(array));

    }
}
