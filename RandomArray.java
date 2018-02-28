import java.lang.reflect.Array;

public class RandomArray {
        
        private int [] array  ; 
        public RandomArray(int i , int maxBound){
        
                array = new int[i] ; 


                for(int temp = 0 ; temp < array.length ; temp++){
                
                        array[temp] = (int)Math.floor(Math.random() *maxBound) ; 
                
                }
        
        }

        public String toString(){
                
                System.out.println("The unsorted array is :") ; 
                String r = "[" ; 
                for(int temp = 0 ;  temp < array.length ; temp++){
                      
                		if(temp< array.length -1) {
                        r+=" "+array[temp]+"," ; 
                		}
                		
                		else {
                			
                			r+=" "+array[temp]+"" ; 
                		}
                	
                }
                
                
               String q = r+"]" ; 
               // System.out.println() ;
               return  q ; 
        
        } 
        
        
        // test case 
       /* public static void main(String args[]){
        
        
                RandomArray  test = new RandomArray(10,1000) ;

                System.out.println(test.toString()) ;       
        } */


}
