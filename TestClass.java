
import java.util.* ;
public class TestClass {

    public static void main(String args[]){

        // taking input of the size of the array
        Scanner input = new Scanner(System.in) ;
        int numberOfElements = -1 ;
        int upperBound = 0 ;

        System.out.println("enter the number of elements to be sorted") ;
        // enter the number of elements to be generated in the array
        if (input.hasNextInt()){numberOfElements = input.nextInt() ; }
        else{ System.out.println("Not an integer") ; }

        int[] arrayToBeSorted = new int[numberOfElements] ;

        // enter the upperBound of the randomly Generated Elements
        System.out.println("Enter the upper bound of the elements to be sorted(integer)") ;
        if(input.hasNextInt()){ upperBound = input.nextInt() ; }
        else{ System.out.println("Enter a valid upperBound") ; }

        // randomly generating elements in an array and putting it into an array
        System.out.println("The array to be Sorted:") ;
        for(int iterator = 0 ; iterator<numberOfElements; iterator++){
            arrayToBeSorted[iterator] = (int) Math.floor((Math.random()*upperBound)) ;
            System.out.print(arrayToBeSorted[iterator]+" ") ;
        }
        System.out.println() ;
        System.out.println() ;

        // calling insertionSort on the randomly Generated Array of ints
        long startTimeInsertionSort = System.nanoTime() ;
        SortingAlgorithms.insertionSort(arrayToBeSorted);
        long endTimeInsertionSort= System.nanoTime() ;
        long runTimeInsertionSort = endTimeInsertionSort - startTimeInsertionSort  ;

        System.out.println("The sorted elements are as follows: ") ;
        for(int iterator= 0 ; iterator< arrayToBeSorted.length ; iterator++){System.out.print(arrayToBeSorted[iterator]+" ") ;}
        System.out.println();
        System.out.println();
        System.out.println("The runtime for Insertion Sort with "+numberOfElements+" elements is "+runTimeInsertionSort+ " nanoSeconds" ) ;
        System.out.println() ;



    }
}
