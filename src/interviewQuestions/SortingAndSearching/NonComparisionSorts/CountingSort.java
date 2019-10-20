package interviewQuestions.SortingAndSearching.NonComparisionSorts;

import java.util.Arrays;

public class CountingSort {

    public void sort(int[] array){

        int max  = Arrays.stream(array).max().getAsInt() ;
        int min  = Arrays.stream(array).min().getAsInt() ;
        int range = max - min + 1;
        int[] count = new int[range] ;
        int[] output = new int[array.length] ;

        for(int i = 0 ; i < array.length ; i++){
            count[array[i] - min]++ ;
        }

        for(int i = 1 ; i < count.length ; i++){
            output[count[i] - min  - 1] = array[i] ;
            count[array[i] - min ]-- ;
        }

        for(int i = 0 ; i< array.length ; i++){
            array[i] = output[i];
        }
    }
}
