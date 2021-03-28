package DynamicProgramming.KnapSackVariations;
import java.util.* ;

public class SubSetSum {


    public static boolean subSetSumNormal(ArrayList<Integer> array , int  target){
        if(target==0){ return true ; }
        if(target!=0 && array.size()==0){ return false; }
        if(target<0){ return false ; }


        for(int counter = 0 ; counter< array.size() ; counter++){
            int remainder = target - (int)array.get(counter);
            ArrayList<Integer> newList = new ArrayList<>(array);

            newList.remove(counter);

            if(subSetSumNormal(newList , remainder)){

                return true ;
            }
        }
        return false;
    }


    public static boolean subSetSumDP(ArrayList<Integer> array , int target){
        HashMap<ArrayList<Integer> , Boolean> map = new HashMap<>() ;

        return subSetSumDPSubRoutine(array , target , map);
    }

    /**
     *  Design needs to improved
     *  Because Using mutable arrayList as a key is not good design
     *
     * */
    public static boolean subSetSumDPSubRoutine(ArrayList<Integer> array , int target , HashMap<ArrayList<Integer> , Boolean> map){
        if(map.containsKey(array)){
            return map.get(array);
        }
        if(target == 0){
            return true ;
        }
        if(target!=0 && array.size()==0){ return false; }
        if(target<0){ return false ; }

        for(int counter = 0  ; counter<array.size()  ; counter++){
            int remainder = target - (int)array.get(counter);
            ArrayList<Integer> newList = new ArrayList<>(array);

            newList.remove(counter);

            if(subSetSumDPSubRoutine(newList , remainder, map)){
                map.put(newList , true);
                return true ;
            }
        }
        map.put(array , false);
        return false;
    }


    public static void main(String args[]){

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,3,5,7,8));
        int target = 10 ;
        System.out.println(subSetSumDP(list , target));

    }
}
