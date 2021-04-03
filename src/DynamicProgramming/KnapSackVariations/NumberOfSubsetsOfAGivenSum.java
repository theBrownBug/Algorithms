package DynamicProgramming.KnapSackVariations;

public class NumberOfSubsetsOfAGivenSum {

    public static int numberOfSubsetsWithAGivenSum(int[] array , int target){
        Integer [][] memo = new Integer[array.length+1][target + 1];

        // initialise ;
        for(int c = 0; c<=array.length ; c++){
            memo[c][0] = 1 ;
        }

        return numberOfSubsetsWithAGivenSumDP(array , target , memo , array.length);
    }

    public static int numberOfSubsetsWithAGivenSumDP(int[] array, int target , Integer[][] memo , int index){
        if(target==0){
            return 1 ;
        }
        if(target< 0 || index==0){return 0 ; }
        else if(memo[index][target]!=null){
            return memo[index][target] ;
        }
        else if(array[index - 1]<=target){
            memo[index][target] = numberOfSubsetsWithAGivenSumDP(array , target - array[index - 1] , memo , index - 1) +
                    numberOfSubsetsWithAGivenSumDP(array , target , memo , index - 1) ;
            return memo[index][target];
        }
        else{
            memo[index][target] = numberOfSubsetsWithAGivenSumDP(array , target , memo , index - 1);
            return memo[index][target];
        }
    }

    public static void main(String args[]){

        int[] array  = new int[]{2 , 3  , 5 , 8 , 10} ;
        System.out.println(numberOfSubsetsWithAGivenSum(array , 10));
    }
}
