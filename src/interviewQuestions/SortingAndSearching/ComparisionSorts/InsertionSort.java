package interviewQuestions.SortingAndSearching.ComparisionSorts;

public class InsertionSort {

    void sort(int[] array){
        int arrayLength = array.length ;
        for(int i = 1 ; i <arrayLength ; i++){
            int key  = array[i] ;
            int j = i - 1;
            while(j>=0 && array[j]>key){
                array[j+1] = array[j] ;
                j-=1 ;
            }
            array[j+1] = key ;
        }
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }


    // Driver method
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6 };

        InsertionSort ob = new InsertionSort();
        ob.sort(arr);

        printArray(arr);
    }
}
