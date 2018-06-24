
import java.util.* ;
public class TestClass {

    //Auxilliary functions

    // array generating functions
    public static int[] randomArray(int upperBound , int numberOfElements){

        int[] arrayToBeSorted = new int[numberOfElements]  ;

        for(int iterator = 0 ; iterator<numberOfElements; iterator++){
            arrayToBeSorted[iterator] = (int) Math.floor((Math.random()*upperBound)) ;
            System.out.print(arrayToBeSorted[iterator]+" ") ;
        }
        System.out.println() ;
        System.out.println() ;

        return  arrayToBeSorted ;
    }

    // to be completed -
    public static void printMessage(String name , int elements , long runTime){

        System.out.println() ;
    }

    public static void main(String args[]){

        // taking input of the size of the array
        Scanner input = new Scanner(System.in) ;
        int numberOfElements = -1 ;
        int upperBound = 0 ;

        System.out.println("enter the number of elements to be sorted") ;
        // enter the number of elements to be generated in the array
        if (input.hasNextInt()){numberOfElements = input.nextInt() ; }
        else{ System.out.println("Not an integer") ; }

        int[] arrayToBeSorted ;

        // enter the upperBound of the randomly Generated Elements
        System.out.println("Enter the upper bound of the elements to be sorted(integer)") ;
        if(input.hasNextInt()){ upperBound = input.nextInt() ; }
        else{ System.out.println("Enter a valid upperBound") ; }





        // randomly generating elements in an array and putting it into an array
        System.out.println() ;
        System.out.println("Insertion Sort") ;
        System.out.println("The array to be Sorted:") ;

        // calling insertionSort on the randomly Generated Array of ints
        arrayToBeSorted = TestClass.randomArray(upperBound,numberOfElements)  ;
        long startTimeInsertionSort = System.nanoTime() ;
        SortingAlgorithms.insertionSort(arrayToBeSorted);
        long endTimeInsertionSort= System.nanoTime() ;
        long runTimeInsertionSort = (endTimeInsertionSort - startTimeInsertionSort);

        System.out.println("The sorted elements are as follows: ") ;
        for(int iterator= 0 ; iterator< arrayToBeSorted.length ; iterator++){System.out.print(arrayToBeSorted[iterator]+" ") ;}
        System.out.println();

        System.out.println("The runtime for Insertion Sort with "+numberOfElements+" elements is "+runTimeInsertionSort+ " nanoseconds" ) ;
        System.out.println() ;


        // calling recursive Insertion sort
        System.out.println("Recursive Insertion Sort") ;
        System.out.println("Array to be Sorted") ;
        int[] arrayToBeSortedRecursiveInsertion =  TestClass.randomArray(upperBound,numberOfElements) ;
        long startTimeRecursiveInsertion = System.nanoTime() ;
        // calling the recursive insertion Sort
        SortingAlgorithms.recursiveInsertionSort(arrayToBeSortedRecursiveInsertion, arrayToBeSortedRecursiveInsertion.length);
        long endTimeRecursiveInsertion = System.nanoTime() ;
        long runTimeRecursiveInsertionSort = endTimeRecursiveInsertion - startTimeRecursiveInsertion ;
        for(int counter: arrayToBeSortedRecursiveInsertion){System.out.print(counter+" ") ; }
        System.out.println() ;
        System.out.println("The runtime of Recursive Insertion Sort with "+numberOfElements+" elements is "+ runTimeRecursiveInsertionSort+" nanoSeconds" ) ;
        System.out.println() ;



        // running Selection Sort
        System.out.println("SelectionSort ") ;
        System.out.println("Array to be sorted : ") ;
        int[] arrayToBeSortedSelection = TestClass.randomArray(upperBound,numberOfElements) ;
        long startTimeSelectionSort = System.nanoTime() ;
        SortingAlgorithms.selectionSort(arrayToBeSortedSelection);
        long endTimeSelectionSort = System.nanoTime() ;
        long runTimeSelectionSort = (endTimeSelectionSort - startTimeInsertionSort) ;

        System.out.println("Result") ;
        for(int iterator : arrayToBeSortedSelection){System.out.print(iterator+ " ") ; }
        System.out.println() ;
        System.out.println("The runtime of SELECTION SORT with " + numberOfElements+" elements is "+ runTimeSelectionSort+" nanoseconds") ;






        // running BubbleSort
        //initial array for bubbleSort
        System.out.println() ;
        System.out.println("Bubble Sort: ");
        System.out.println("Array to be sorted") ;
        int[] arrayToBeSortedBubble = TestClass.randomArray(upperBound,numberOfElements) ;

        long startTimeBubbleSort = System.nanoTime() ;
        SortingAlgorithms.bubbleSort(arrayToBeSortedBubble);
        long endTimeBubbleSort   = System.nanoTime() ;
        long runTimeBubbleSort   = (endTimeBubbleSort - startTimeBubbleSort);

        System.out.println("Result") ;
        for(int iterator : arrayToBeSortedBubble){System.out.print(iterator+ " ") ; }
        System.out.println() ;
        System.out.println("The runtime of BubbleSort with" + numberOfElements +" elements is "+ runTimeBubbleSort+" nanoseconds") ;



        /*


        // calling MergeSort
        System.out.println("Merge Sort") ;
        System.out.println("Array to be sorted: ") ;
        int [] arrayToBeSortedMerge = TestClass.randomArray(upperBound, numberOfElements);
        long startTimeMergeSort = System.nanoTime() ;
        SortingAlgorithms.mergeSort(arrayToBeSortedMerge,0,arrayToBeSortedMerge.length-1);

        long endTimeMergeSort = System.nanoTime() ;
        long runTimeMergeSort = (endTimeMergeSort - startTimeMergeSort) ;
        for(int iterator : arrayToBeSortedMerge){ System.out.print(iterator+ " " ); } // print the elements after sorting
        System.out.println() ;
        System.out.println("The runtime of MergeSort with "+numberOfElements +" elements is "+runTimeMergeSort+" seconds") ;

        */




    }
}
