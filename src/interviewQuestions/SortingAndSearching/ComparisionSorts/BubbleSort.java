package interviewQuestions.SortingAndSearching.ComparisionSorts;

public class BubbleSort {

    void bubbleSort(int[] array){
        for(int counter = 0 ; counter< array.length - 1 ; counter++){
            for(int counter2 =  0 ; counter2< array.length - counter - 1 ; counter2++){
                if(array[counter2]> array[counter2+1]){
                    int temp = array[counter2] ;
                    array[counter2] = array[counter2+1] ;
                    array[counter2] = temp ;
                }
            }
        }
    }


    /* Prints the array */
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]){
        BubbleSort ob = new BubbleSort();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
