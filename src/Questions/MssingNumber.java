package Questions;

import java.util.HashSet;

public class MssingNumber {

    public static int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>() ;
        for(int counter = 0 ; counter < nums.length ; counter++){
            set.add(nums[counter]) ;
        }
        int toReturn = Integer.MAX_VALUE ;
        for(int counter = 0 ; counter < nums.length+1 ; counter++){
            if(!set.contains(counter)){
                toReturn = counter ;
            }
        }
        return toReturn ;
    }

    public static void main(String args[]){
        int[] array1 = {3 , 0 , 1} ;
        int[] array2 = {9,6,4,2,3,5,7,0,1} ;
        System.out.println(MssingNumber.missingNumber(array1));
        System.out.println(MssingNumber.missingNumber(array2));

    }
}
