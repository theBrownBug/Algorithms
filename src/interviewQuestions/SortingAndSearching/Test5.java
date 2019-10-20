package interviewQuestions.SortingAndSearching;

public class Test5 {

    // iterative algos
    void insertionSort(int[] array){

        for(int nextElement = 1 ; nextElement< array.length ; nextElement ++){
            int key = array[nextElement] ;
            int j = nextElement - 1;
            while(j>=0 && array[j]>key){
                array[j+1] = array[j] ;
                j-- ;
            }
            array[j+1] = key ;
        }
    }

    void bubbleSort(int[] array){
        for(int i = 0 ; i < array.length -1 ; i++){
            for(int counter = 0 ; counter< array.length - i - 1 ;counter++){
                if(array[counter]> array[counter+1]){
                    int swap = array[counter] ;
                    array[counter] = array[counter+1] ;
                    array[counter+1] = swap ;
                }
            }
        }
    }

    void selectionSort(int[] array){
        int exchangeVar = 0 ;
        int index = 0 ;
        for(int counter = 0 ; counter< array.length -1 ; counter++){
            index = counter ;
            for(int counter2 = counter+1 ; counter2< array.length ; counter2++){
                if(array[counter2]< array[index]){
                    index = counter2 ;
                }
            }
            exchangeVar = array[index] ;
            array[index] =array[counter] ;
            array[counter] = exchangeVar ;

        }
    }




    // divide and conquer algos

    int binarySearch(int[]array , int left , int right , int element){
        if(right>=1){
            int middle = left + (right - 1) / 2 ;
            if(array[middle] == element){
                return  middle ;
            }
            else if(element< array[middle]){
                binarySearch(array , left , middle - 1 , element ) ;
            }
            else{
                binarySearch(array , middle + 1 , right , element ) ;
            }
        }
        return  -1 ;
    }


    public void merge(int[] array ,int left , int middle , int right){
        int leftArraySize = middle - left + 1;
        int rightArraySize= right - middle;
        int[] leftArray = new int[leftArraySize] ;
        int[] rightArray = new int[rightArraySize] ;

        // copy the elements
        for(int counter = 0 ; counter < leftArraySize ; counter++){
            leftArray[counter] = array[left + counter] ;
        }
        for(int counter = 0 ; counter< rightArraySize ; counter++){
            rightArray[counter] = array[middle + 1 + counter] ;
        }

        int i = 0 , j = 0 , k = left ;
        while(i < leftArraySize && j < rightArraySize){

            if(leftArray[i]<= rightArray[j]){
                array[k] = leftArray[i] ;
                i++ ;
            }
            else{
                array[k] = rightArray[j] ;
                j++ ;
            }
            k++ ;
        }

        // copy the rest of the elements
        while(i < leftArraySize){
            array[k] = leftArray[i] ;
            i++ ; k++ ;
        }
        while(j < rightArraySize){
            array[k] = rightArray[j] ;
            j++ ; k++ ;
        }

    }


     void mergeSort(int[] array , int left, int right){
        if(left< right){
            int middle = (left + right)/2 ;
            mergeSort(array , left , middle);
            mergeSort(array , middle + 1 , right );
            merge(array , left , middle , right );
        }
    }


    void maxHeapify(int[] array , int heapSize , int root){
        int largest = root ;
        int leftChild = 2 * root +1 ;
        int rightChild = 2* root + 2 ;
        if(leftChild< heapSize && array[largest]< array[leftChild]){
            largest = leftChild ;
        }
        if(rightChild< heapSize && array[largest] < array[rightChild]){
            largest = rightChild;
        }
        if(root != largest){
            int swap = array[largest] ;
            array[largest] = array[root] ;
            array[root] = swap ;
            maxHeapify(array , heapSize , largest);
        }
    }

    void heapSort(int[] array){
        int length = array.length ;
        for(int counter = (length/2) - 1 ; counter>= 0 ; counter--){
            maxHeapify(array , length , counter);
        }
        for(int counter = length - 1 ; counter>= 0 ; counter--){
            int swap = array[0] ;
            array[0] = array[counter];
            array[counter] = swap ;
            maxHeapify(array , counter , 0 );
        }
    }


    static  int[] randomArrayGenerator(){
        int size = (int) Math.abs(Math.random() *100) ;
        int[] array = new int[size] ;
        for(int counter = 0  ; counter< array.length ; counter++){
            array[counter] = (int) Math.abs(Math.random()*1000) ;
        }

        return array ;
    }

    public static  void print(int[]array){
        for(int counter = 0 ; counter<array.length ; counter++){
            System.out.print(array[counter] +" , ");
        }
        System.out.println();
    }

    public static void main(String args[]){

        Test5 ob = new Test5() ;

        System.out.println("MERGE SORT ");
        int[] array3 = randomArrayGenerator() ;
        print(array3);
        ob.mergeSort(array3 , 0 , array3.length-1);
        print(array3);
        System.out.println();


        System.out.println("HEAP SORT ");
        int[] array5 = randomArrayGenerator() ;
        print(array5);
        ob.heapSort(array5);
        print(array5);
        System.out.println();

    }


}
