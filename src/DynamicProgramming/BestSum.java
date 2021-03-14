package DynamicProgramming;
import java.util.* ;

public class BestSum {
    /**
     *
     * Given an array and a target sum,
     * find the shortest possible array of numbers that sum up to the target
     * If multiple shortest array exist return any 1
     * If none exist, return null
     *
     * */

    public ArrayList<Integer> bestSum(int target , int[] array){
        if (target==0){return new ArrayList<>(); }
        if(target<0){
            return null ;
        }
        ArrayList<Integer> smallest = null ;
        for(int number : array){
            int remainder = target - number ;
            ArrayList<Integer> out = bestSum(remainder , array) ;
            if(out != null){
                out.add(number);
                if(smallest== null || smallest.size()> out.size()){
                    smallest = out ;
                }
            }

        }

        return smallest ;
    }


    public ArrayList<Integer> bestSumDP(int target , int[] array){
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
        return bestSumDPSubRoutine( target , array , map);
    }



    public ArrayList<Integer> bestSumDPSubRoutine(int target, int[] array ,HashMap<Integer , ArrayList<Integer>> map){
        if(map.containsKey(target)){return map.get(target); }
        if(target ==0 ){ return new ArrayList<>() ; }
        if(target<0){return null ; }

        ArrayList<Integer>smallest = null;
        for(int number : array){
            int remainder = target - number;
            ArrayList<Integer> out = bestSumDPSubRoutine(remainder , array , map);
            if(out!=null){
                out.add(number);
                if(smallest== null || smallest.size()> out.size()){
                    smallest = out ;

                }
            }
        }
        map.put(target, smallest);
        return smallest ;

    }


}
