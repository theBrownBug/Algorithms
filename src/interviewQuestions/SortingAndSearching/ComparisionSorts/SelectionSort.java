package interviewQuestions.SortingAndSearching.ComparisionSorts;

public class SelectionSort {
    public void selectionSort(int[] array){
        int length = array.length ;
        // initializing smallest
        int smallest = 0 ;
        int exchangeVar = 0 ;
        for(int counter = 0 ; counter< array.length -1 ; counter++){
            smallest = counter ;
            for(int counter2 = counter+1 ; counter2< array.length ; counter2 ++){
                if(array[counter2]< array[smallest]){
                    smallest = counter2 ;
                }
            }
            exchangeVar= array[counter] ;
            array[counter]= array[smallest] ;
            array[smallest] = exchangeVar ;
        }
    }
}
