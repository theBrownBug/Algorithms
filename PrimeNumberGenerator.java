 
import java.util.* ; 

public class PrimeNumberGenerator{
        private boolean isPrime ; 
        private long upperBound  ; 
        ArrayList<Long> arr ; 

        public PrimeNumberGenerator(long upperBound){
                
                this.upperBound = upperBound ; 
        }

        

        public ArrayList<Long> generate(){
         
                arr = new ArrayList<Long>() ; 
                
                for(long temp=2 ; temp <= upperBound ; temp++){
                
                        if(isPrime(temp)){
                        
                                arr.add(temp) ; 
                        
                        }
                        
                        else{
                                continue ; 
                        }
                }
                

                return arr ; 
        }
        

        public boolean isPrime(long n ){
                       
                isPrime = true ; 
                long sqrt =(long) Math.floor((Math.sqrt(n))) ; 
                
                for(long temp = 2; temp <= sqrt; temp++){
                
                        if(n%temp==0){
                        
                                isPrime= false ; 
                        }
                
                         
                }
                
                return isPrime ; 
                
        
        }

        public String toString(){
                
                return Arrays.toString(arr.toArray()) ; 
        
        
        }       

        public static void main(String args[]){
        
                 
                PrimeNumberGenerator test  = new PrimeNumberGenerator(100) ; 
                
                test.generate() ; 
        
                System.out.println(test.toString()) ; 
        
        }


}
