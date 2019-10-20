package interviewQuestions.SortingAndSearching;

public class Test9 {
    public static int binarySearch(int[] array , int left , int right , int element){
        /*
        * why right>=1 ??
        * */

        if(right>=1){
            int middle = (left + (right -1 ))/2 ;
            if(array[middle]== element){
                return middle ;
            }
            else if(element> array[middle]){
                return binarySearch(array , middle+1 , right , element) ;
            }
            return binarySearch(array , left , middle - 1, element) ;
        }
        return -1 ;
    }


    public static void insertionSort(int[] array){
        for(int nextElement =1 ; nextElement< array.length ; nextElement++){
            int key = array[nextElement] ;
            int i  = nextElement - 1;
            while(i>= 0 && array[i]>key){
                array[i+1]= array[i] ;
                i--;
            }
            array[i+1] = key ;
        }
    }

    public static void selectionSort(int[] array){
        int smallest = 0 ;
        int exchangeVar = 0;
        for(int counter = 0 ; counter< array.length -1  ; counter++){
            smallest = counter ;
            for(int counter2 = counter + 1; counter2< array.length ; counter2++){
                if(array[counter2] < array[smallest]){
                    smallest = counter2 ;
                }
            }
            exchangeVar =array[counter] ;
            array[counter] = array[smallest] ;
            array[smallest] = exchangeVar ;
        }
    }


    public static void bubbleSort(int[] array){
        for(int counter = 0 ; counter< array.length -1  ; counter++){
            for(int counter2 = 0 ; counter2< array.length - counter - 1; counter2++){
                if(array[counter2]> array[counter2 + 1]){
                    int temp = array[counter2] ;
                    array[counter2]= array[counter2+1] ;
                    array[counter2+1] = temp ;
                }
            }
        }
    }

    public  void merge(int[] array , int left , int middle , int right){
        int leftArraySize = middle - left + 1;
        int rightArraySize = right - middle ;
        int[] leftArray = new int[leftArraySize] ;
        int[] rightArray = new int[rightArraySize] ;


        for(int counter = 0 ; counter< leftArraySize ; counter++){
            leftArray[counter] = array[left + counter] ;
        }

        for(int counter = 0 ; counter< rightArraySize ; counter++){
            rightArray[counter] = array[counter + middle + 1] ;
        }

        int i = 0 , j = 0 , k = left ;
        while(i< leftArraySize && j< rightArraySize){
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

        while(i<leftArraySize){
            array[k] = leftArray[i] ;
            i++ ; k++ ;
        }
        while(j<rightArraySize){
            array[k] = rightArray[j] ;
            j++ ; k++ ;
        }
    }


    public  void mergeSort(int[] array , int left , int right){
        if(left< right){
            int middle = (left + right)/2;
            mergeSort(array , left , middle);
            mergeSort(array , middle + 1 , right);
            merge(array , left , middle , right) ;
        }
    }


    public void maxHeapify(int[] array , int heapSize , int root){
        int maxElement = root ;
        int leftChild = 2 * root + 1;
        int rightChild= 2 * root + 2;
        if(leftChild< heapSize && array[maxElement]< array[leftChild]){
            maxElement = leftChild ;
        }
        if(rightChild < heapSize && array[maxElement] < array[rightChild]){
            maxElement = rightChild ;
        }

        if(root != maxElement){
            int swap = array[root] ;
            array[root] = array[maxElement] ;
            array[maxElement] = root ;
            maxHeapify(array , heapSize , maxElement);
        }
    }

    public void heapSort(int[] array){
        int length = array.length ;
        for(int counter = (length-1)/2 ; counter>=0 ; counter--){
            maxHeapify(array , length , counter);
        }

        for(int counter = length-1 ; counter>=0 ; counter--){
            int swap = array[counter] ;
            array[counter] = array[0];
            array[0] = swap ;
            maxHeapify(array, counter , 0);
        }
    }

    public static  void print(int[]array){
        for(int counter = 0 ; counter<array.length ; counter++){
            System.out.print(array[counter] +" , ");
        }
        System.out.println();
    }


    static  int[] randomArrayGenerator(){
        int size = (int) Math.abs(Math.random() *100) ;
        int[] array = new int[size] ;
        for(int counter = 0  ; counter< array.length ; counter++){
            array[counter] = (int) Math.abs(Math.random()*1000) ;
        }

        return array ;
    }

    public static void main(String args[]){
        Test4 ob = new Test4() ;
        int[] array1 = randomArrayGenerator() ;
        System.out.println("Bubble sort ");
        print(array1);
        bubbleSort(array1);
        print(array1);
        System.out.println();

        System.out.println("Insertion sort ");
        int[] array2 =  randomArrayGenerator() ;
        print(array2);
        insertionSort(array2);
        print(array2);
        System.out.println();



        System.out.println("MERGE SORT ");
        int[] array3 = randomArrayGenerator() ;
        print(array3);
        ob.mergeSort(array3 , 0 , array3.length-1);
        print(array3);
        System.out.println();


        System.out.println("SELECTION SORT");
        int[] array4 = randomArrayGenerator() ;
        print(array4);
        selectionSort(array4);
        print(array4);


        System.out.println();




        System.out.println("HEAP SORT ");
        int[] array5 = randomArrayGenerator() ;
        print(array5);
        ob.heapSort(array5);
        print(array5);
        System.out.println();


        System.out.println();
        System.out.println();
        System.out.println();
    }

}
