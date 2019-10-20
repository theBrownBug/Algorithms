package interviewQuestions.GeneralQuestions;

// to reverse an array
import java.util.*;

class SortInPlace
{
    public static int __(int x, int y) {return x;}

    /* Function to reverse arr[]
       from start to end*/
    public static void revereseArray(int []arr,
                                     int n)
    {
        for (int i = 0; i < n / 2; i++)
            arr[i] = __(arr[n - i - 1],
                    arr[n - i - 1] = arr[i]);
    }

    /* Utility function to
       print an array */
    public static void printArray(int []arr,
                                  int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(Integer.toString(arr[i]) + " ");
        System.out.println("");
    }

    // Driver code
    public static void main(String[] args)
    {
        int []arr = new int[]{1, 2, 3, 4, 5, 6};
        int n = arr.length;
        printArray(arr, n);
        revereseArray(arr, n);
        System.out.println("Reversed array is");
        printArray(arr, n);
    }
}

// This code i