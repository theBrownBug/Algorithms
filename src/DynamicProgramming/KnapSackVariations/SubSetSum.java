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


    public static boolean subSetSumDP(int[] array , int target){
        /*
        * this is a variation of Knapsack
        * */
        Boolean[][] memo = new Boolean[array.length + 1][target+1] ;

        //initialise\
        /**
         * target =0 for all subset sizes will be true by default
         * */
        for(int c = 0 ; c<memo.length ; c++){
            memo[c][0] = Boolean.TRUE ;
        }

        boolean result = subSetSumDPSubRoutine(array, target , memo , array.length);
        for(int row = 0; row<array.length ; row++){
            for(int col = 0 ; col< memo[row].length ; col++){
                System.out.print(memo[row][col] + " ");
            }
            System.out.println();
        }
        return result ;
    }

    public static boolean subSetSumDPSubRoutine(int[] array , int target , Boolean[][] memo , int index){
        if(target==0){
            return true ;
        }
        if(target<0 || index==0){return false; }
        else if(memo[index - 1][target]!=null){
            return memo[index-1][target];
        }
        else if(array[index - 1]<= target){
            memo[index][target] = subSetSumDPSubRoutine(array , target - array[index -1] , memo , index - 1)
                    || subSetSumDPSubRoutine(array, target , memo , index - 1);

            return memo[index][target];
        }
        else{
            memo[index][target] = subSetSumDPSubRoutine(array, target , memo , index - 1) ;
            return memo[index][target];
        }
    }





    public static void main(String args[]){
        int[] list = new int[]{2,3,5,7,8};
        int target = 10 ;
        System.out.println(subSetSumDP(list , target));

    }
}
