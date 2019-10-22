package Questions.Facebook;

import java.util.* ;

class MaximumFibonacciSubset{
	//public boolean isFibo(int n){}

	// worst solution ever to find fibonacci numbers
	public int fibonacci(int number){
	    if(number<= 1){
	        return number;
        }
        return fibonacci(number - 1) + fibonacci(number - 2) ;
    }

    //=========================================================================//
    /**
     * O(n) implementation
     * */
    public int[] fastFibonacci(int n){
	    int[] memo = new int[n+1] ;
	    for(int counter = 0 ; counter< n ; counter++){
	        fastFiboSubSequence(counter , memo) ;
        }
        return memo ;
    }

    int fastFiboSubSequence(int n , int[] memo){
	    if(n<= 0){return 0 ; }
	    else if(n== 1 ){return 1 ; }
	    else if(memo[n]> 0){ return memo[n] ; }
	    memo[n] = fastFiboSubSequence(n - 1 , memo) + fastFiboSubSequence(n -2 , memo) ;

	    return memo[n] ;
    }
    //=========================================================================///
    public HashSet<Integer> largestFibonacciSubset(int[] array){
	    HashSet<Integer> out = new HashSet<>() ;
	    ArrayList<Integer> allFibo = new ArrayList<>() ;
	    int max = Integer.MIN_VALUE ;
	    for(int c : array){ if(c>max){max = c ; } }
	    int[] allFibonacci = fastFibonacci(max) ;
	    for(int counter = 0 ; counter< array.length ; counter++){
	        for(int counter2= 0 ; counter2< allFibonacci.length ; counter2++){
	            if(allFibonacci[counter2]==array[counter]){
	                out.add(allFibonacci[counter2]) ;
                }
            }
        }
	    return out ;
	}


	public static void main(String args[]){
	

	
	
	}

}
