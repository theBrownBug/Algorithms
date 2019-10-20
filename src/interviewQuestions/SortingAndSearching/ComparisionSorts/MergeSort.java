package interviewQuestions.SortingAndSearching.ComparisionSorts;

public class MergeSort {

    public void merge(int[]array , int left , int middle , int right){
        int n1 = middle - left + 1 ;
        int n2 = right - middle ;
        int[] leftArray = new int[n1] ;
        int[] rightArray = new int[n2] ;
        for(int counter = 0 ; counter<n1 ; counter++){ leftArray[counter] = array[left+ counter] ; }
        for(int counter = 0 ; counter<n2 ; counter++){rightArray[counter] = array[middle+1+counter] ; }

        int x = 0  , y = 0  , k = left ;
        while(x< n1 && y < n2){
            if(leftArray[x]<= rightArray[y]){
                array[k] = leftArray[x] ;
                x++ ;
            }
            else{
                array[k] = rightArray[y] ;
                y++ ;
            }
            k++ ;
        }

        // copying the rest of the elements
        while(x< n1){
            array[k] = leftArray[x] ;
            x++ ;k++ ;
        }
        while(y<n2){
            array[k] = rightArray[y] ;
            y++ ; k++ ;
        }

    }




    public void mergeSort(int[]array , int left , int right){
        if(left< right){
            int middle = (left+ right)/2 ;
            mergeSort(array , left , middle);
            mergeSort(array,middle+1, right);
            merge(array ,left , middle , right)  ;
        }
    }



    /* A utility function to print array of size n*/
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }


    public static void main(String args[]){
            int arr[] = {12, 11, 13, 5, 6, 7};

            System.out.println("Given Array");
            printArray(arr);

            MergeSort ob = new MergeSort();
            ob.mergeSort(arr, 0, arr.length-1);
            System.out.println("\nSorted array");
            printArray(arr);


    }
}
