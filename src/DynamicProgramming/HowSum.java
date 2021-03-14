package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class HowSum {
    /**
     * given a target sum  and an array of integers, return any combination of numbers from the array
     * that sum up to the target. You can use same number any number of times
     *
     * if no possible combination exists, return NULL
     * */
    public ArrayList<Integer> howSumNormal(int target , int[] array){
        if(target == 0){
            return new ArrayList<>() ;
        }
        if(target<0){return null ; }

        ArrayList<Integer> out = null ;
        for (int number : array){
            int remainder = target - number ;
            out  = howSumNormal(remainder , array);
            if(out != null){
                out.add(remainder) ;
                return out ;
            }
        }
        return out ;
    }


    public ArrayList<Integer> howSumDP(int target , int[] array){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        return howSumDPSubRoutine(target , array , map);
    }

    public ArrayList<Integer> howSumDPSubRoutine(int target , int[] array , HashMap<Integer , ArrayList<Integer>> map){
        if(map.containsKey(target)){
            return map.get(target);
        }
        if(target == 0){
            return new ArrayList<>();
        }
        if(target<0){
            return null ;
        }

        ArrayList<Integer> result = null ;
        for(int number : array){
            int remainder = target - number;
            result = howSumDPSubRoutine(remainder , array , map);
            if(result != null){
                map.put(remainder , result);
                return result ;
            }
        }

        map.put(target , null );
        return null ;
    }

}
