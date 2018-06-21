

public class InsertionSort{

        RandomArray arr ; 
        public InsertionSort(RandomArray i){
                this.arr = i ; 
        
        }
        
        
        public int[] sort(){
                
                for(int temp =0 ; temp<arr.length ; temp++){
                        int key = arr[temp] ; 

                        int i = temp - 1 ; 
                        
                        while (i> 0 && arr[i]>key){
                                arr[i+1] = arr[i] ; 
                                i -= 1 ; 
                        
                        }
                        arr[i+1] = key ; 
                
                }

                return arr ; 
                
        }
        


        public static void main(String args[]){
        
                // creates an Array of 100000 elements with each element less than 1000         
                RandomArray newArray = new RandomArray(100000,1000) ; 
                
                InsertionSort test = new InsertionSort(newArray) ;

                test.sort() ; 
                System.out.print(test.toString()) ; 
        }

}
