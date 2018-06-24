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
        SortingAlgorithms.insertionSort(arrayForBinarySearch); // sorting the array first

        long startBinarySearch = System.nanoTime() ;
        int positionBinarySearch = SearchingAlgorithms.binarySearch(arrayForBinarySearch,0,arrayForBinarySearch.length,toBeFound)  ;
        long endBinarySearch = System.nanoTime() ;
        long differenceBinarySearch = endBinarySearch - startBinarySearch ;

        if(positionBinarySearch==-1){

           System.out.println("The randomly generated element"+ toBeFound+"does not exist in the randomly generated array") ;
           System.out.println("The time for Linear Search ="+ differenceBinarySearch+" nanoSeconds") ;
        }
        else{
           System.out.println("The randomly generated element" + toBeFound + "is present at " + positionBinarySearch + " in the array");
           System.out.println("The time for Binary Search ="+ differenceBinarySearch+" nanoSeconds") ;
        }





        // running JumpSearch
        int[] arrayJumpSearch = TestClass.randomArray(100,sizeOfArray) ;
        SortingAlgorithms.insertionSort(arrayJumpSearch);// sorting the array

        long startTimeJumpSearch = System.nanoTime();
        int positionJumpSearch = SearchingAlgorithms.jumpSearch(arrayJumpSearch,toBeFound) ;
        long endTimeJumpSearch = System.nanoTime() ;
        long differenceJumpSearch = endTimeJumpSearch - startTimeJumpSearch ;

        if(positionJumpSearch==-1){
            System.out.println("The randomly generated element"+toBeFound+" does not exist in the randomly generated array") ;
            System.out.println("The time for Jump Search =" + differenceJumpSearch+" nanoSeconds") ;
        }
        else{
            System.out.println("The randomly generated element"+toBeFound+" is present at "+positionJumpSearch+" in the array") ;
            System.out.println("The time for Jump Search = "+ differenceJumpSearch+" nanoSeconds") ;

        }


        // running interpolation search
        /** Interpolation search requires the the array to be sorted
        *Worst case runtime = O(log(log n ))
         */

        int[] arrayInterpolationSearch = TestClass.randomArray(100,sizeOfArray) ;
        // sorting the array  of elements first
        SortingAlgorithms.insertionSort(arrayInterpolationSearch);
        long startTimeInterpolationSearch = System.nanoTime() ;
        long endTimeInterpolationSearch = System.nanoTime() ;
        // running interpolation search
        int positionInterpolationSearch = SearchingAlgorithms.interpolationSearch(arrayInterpolationSearch, toBeFound) ;
        long differenceInterpolationSearch = endTimeInterpolationSearch - startTimeInterpolationSearch ;

        if(positionInterpolationSearch==-1){
            System.out.println("The randomly generated element"+toBeFound+"is not present in the randomly generated array") ;
            System.out.println("The time for interpolation search is "+ differenceInterpolationSearch+" nanoSeconds") ;
        }
        else{
            System.out.println("The randomly generated element "+ toBeFound+" is present at "+ positionInterpolationSearch +" in the array");
            System.out.println("The time for Interpolation Search is"+ differenceInterpolationSearch+" nanoSeconds") ;
        }





        // running Exponential Search
        int[] arrayExponentialSearch = TestClass.randomArray(100,sizeOfArray) ;
        // Sorting the array first
        SortingAlgorithms.insertionSort(arrayExponentialSearch);
        long startTimeExponentialSearch = System.nanoTime() ;
        int positionExponentialSearch = SearchingAlgorithms.exponentialSearch(arrayExponentialSearch,arrayExponentialSearch.length,toBeFound) ;
        long endTimeExponentialSearch = System.nanoTime();
        long differenceExponentialSearch = endTimeExponentialSearch - startTimeExponentialSearch ;

        if(positionExponentialSearch==-1){
            System.out.println("The randomly generated element"+toBeFound+" is not present in the randomly generated array") ;
            System.out.println("The time for exponential search is"+differenceExponentialSearch+" nanoSeconds") ;

        }
        else{
            System.out.println("The randomly generated element"+ toBeFound+" is present at"+ positionExponentialSearch+" in the array") ;
            System.out.println("The time for exponential search is "+differenceExponentialSearch+" nanoSeconds") ;
        }




        // running Fibonacci Search

        int[] arrayFibonacciSearch = TestClass.randomArray(100, sizeOfArray) ;
        // Sorting the array first
        SortingAlgorithms.insertionSort(arrayFibonacciSearch) ;
        long startFibonacciSearch = System.nanoTime();
        int positionFibonacciSearch = SearchingAlgorithms.fibonacciSearch(arrayFibonacciSearch,toBeFound,arrayFibonacciSearch.length) ;
        long endFibonacciSearch = System.nanoTime() ;
        long differenceFibonacciSearch = endFibonacciSearch - startFibonacciSearch ;

        if(positionFibonacciSearch==-1){
            System.out.println("The randomly Generated element"+toBeFound+" is not present in the radnomly generated array") ;
            System.out.println("The time for exponential search is"+ differenceFibonacciSearch+" nanoSeconds") ;
        }
        else{
            System.out.println("The randomly generated element"+ toBeFound+" is present at"+ positionFibonacciSearch+" in the array") ;
            System.out.println("The time for exponential search is "+ differenceFibonacciSearch+" nanoSeconds") ;
        }



    }
}
