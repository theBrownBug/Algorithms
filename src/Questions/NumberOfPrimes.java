package Questions;

public class NumberOfPrimes {

    public static int countPrimes(int n) {
        int numberOfPrimes = 0;
        for(int counter= 0 ; counter < n ; counter++){
            if(NumberOfPrimes.isPrime(counter)){numberOfPrimes+= 1 ; }
        }
        return numberOfPrimes ;
    }
    public static boolean isPrime(int x){
        if(x<2){
            return false ;
        }
        for(int counter = 2 ; counter * counter <= x ; counter++){
            if(x%counter == 0){
                return false;
            }
        }
        return true ;
    }

    public static void main(String args[]){
        System.out.println(NumberOfPrimes.countPrimes(2));


    }
}
