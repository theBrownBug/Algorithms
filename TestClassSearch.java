import java.util.Scanner ;
public class TestClassSearch {



    public static void main(String args[]){

       TestClass object = new TestClass() ;
       int toBeFound = (int)(Math.floor(Math.random())*100) ;
       int sizeOfArray  =   0 ;
       Scanner input = new Scanner(System.in) ;
       System.out.println("Enter the size of the array ");
       try {
           sizeOfArray = input.nextInt();
       } catch(NumberFormatException e){
         System.out.println(e+" is not a number") ;
       }
       // running linear Search
       System.out.println("Running Linear Search ") ;
       int[] arrayForLinearSearch = TestClass.randomArray(100, sizeOfArray) ;
       long startLinearSearch = System.nanoTime() ;
       int position = SearchingAlgorithms.linearSearch(arrayForLinearSearch, toBeFound) ;
       long endLinearSearch = System.nanoTime() ;
       long differenceLinearSearch = endLinearSearch - startLinearSearch ;

       if(position == -1){
           System.out.println("The randomly generated element"+ toBeFound+"does not exist in the randomly generated array") ;
           System.out.println("The time for Linear Search ="+ differenceLinearSearch+" nanoSeconds") ;
       }
       else {
           System.out.println("The randomly generated element" + toBeFound + "is present at " + position + " in the array");
           System.out.println("The time for Linear Search ="+ differenceLinearSearch+" nanoSeconds") ;
       }

       // running Binary Search
        int[] arrayForBinarySearch = TestClass.randomArray(100,sizeOfArray) ;
       long startBinarySearch = System.nanoTime() ;
       int positionBinarySearch = SearchingAlgorithms.binarySearch(arrayForBinarySearch,0,arrayForBinarySearch.length,toBeFound)  ;
       long endBinarySearch = System.nanoTime() ;
       long differenceBinarySearch = endBinarySearch - startBinarySearch ;

       if(positionBinarySearch==-1){

           System.out.println("The randomly generated element"+ toBeFound+"does not exist in the randomly generated array") ;
           System.out.println("The time for Linear Search ="+ differenceBinarySearch+" nanoSeconds") ;
       }
       else{
           System.out.println("The randomly generated element" + toBeFound + "is present at " + position + " in the array");
           System.out.println("The time for Binary Search ="+ differenceBinarySearch+" nanoSeconds") ;
       }

    }
}
