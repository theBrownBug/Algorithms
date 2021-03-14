package DynamicProgramming;
import java.util.HashMap  ;

public class CanSum {

    /*
    *
    * */
    public boolean canSumNormal(int target , int[] array){
        if (target==0){
            return true ;
        }
        if(target < 0 ){
            return false;
        }
        for(int number: array){
            int remainder = target - number ;
            if(canSumNormal(remainder , array)){
                return true ;
            }
        }
        return false;
    }


    public boolean canSumDP(int target , int[] array){
        HashMap<Integer , Boolean> map = new HashMap<>() ;
        return canSumDPSubRoutine(target , array ,  map);
    }

    public boolean canSumDPSubRoutine(int target  , int[] array , HashMap<Integer , Boolean> map){
        if(map.containsKey(target)){
            if(map.get(target)){return true ; }
            return false;
        }
        if (target == 0){return true  ;}
        if(target< 1){return false ; }

        for(int number : array){
            int remainder = target - number ;
            if(canSumDPSubRoutine(remainder , array , map)){
                map.put(remainder , true);
                return true ;
            }
        }

        map.put( target, false);
        return false;

    }
}
