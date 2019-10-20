package interviewQuestions.SortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

class Test4 {

    public static int binarySearch(int[] array , int left , int right , int toFind){
        if(right>=1){
            int middle = (left + (right -1 ))/2 ;
            if(array[middle]== toFind){
                return middle ;
            }
            else if(array[middle]> toFind){
               return   binarySearch(array , left , middle - 1 , toFind) ;
            }
              return binarySearch(array , middle + 1 , right , toFind) ;
        }
        return  -1 ;
    }


    // heap sort

    void maxHeapify(int[] array , int heapSize , int root) {
        int maxElement = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        if (leftChild < heapSize && array[leftChild] > array[maxElement]) {
            maxElement = leftChild;
        }
        if (rightChild < heapSize && array[rightChild] > array[maxElement]) {
            maxElement = rightChild;
        }

        if (root != maxElement) {
            int swap = array[maxElement];
            array[maxElement] = array[root];
            array[root] = swap;
            maxHeapify(array, heapSize, maxElement);
        }
    }

    void heapSort(int[] array){
            int length =  array.length ;
            for(int counter = (length/2) -1  ; counter>=0 ; counter--){
                maxHeapify(array , length , counter);
            }
            for (int counter = length -1 ; counter>= 0 ; counter--){
                int swap = array[0] ;
                array[0] = array[counter] ;
                array[counter] = swap ;
                maxHeapify(array , counter , 0);
            }
        }


        // insertion sort

        public static  void insertionSort(int[] array){
            for(int next = 1 ; next< array.length ; next++){
                int key = array[next] ;
                int j = next -1 ;
                while(j>= 0 && array[j]> key){
                    array[j+1] = array[j] ;
                    j-- ;
                }
                array[j+1] = key ;
            }
        }


        // bubble sort

        public static  void bubbleSort(int[] array){
            for(int counter = 0 ; counter < array.length -1 ; counter++){
                for(int counter2 = 0 ; counter2< array.length - counter - 1 ; counter2++){
                    if(array[counter2]> array[counter2+1]){
                        int swap = array[counter2] ;
                        array[counter2] = array[counter2+1] ;
                        array[counter2+1] = swap ;
                    }
                }
            }
        }

        // selection sort

        public static void selectionSort(int[] array){
           int min = 0 ;
           int minIndex = 0 ;

            for(int counter = 0 ; counter< array.length-1 ; counter++){
                minIndex = counter ;
                for(int counter2 = counter+1 ; counter2< array.length ; counter2++){
                    if(array[counter2]< array[minIndex]){
                        minIndex = counter2 ;
                    }
                }

                min = array[counter] ;
                array[counter] = array[minIndex] ;
                array[minIndex] = min ;
            }
    }



    // merge sort helper
    public  void merge(int[] array , int left , int middle , int right){
        int leftArraySize = middle - left +1 ;
        int rightArraySize = right - middle ;
        int[] leftArray = new int[leftArraySize] ;
        int[] rightArray = new int[rightArraySize];

        //copy elements
        for(int counter = 0; counter< leftArraySize ; counter++){
            leftArray[counter] = array[counter+ left] ;
        }

        for(int counter = 0 ; counter< rightArraySize ; counter++){
            rightArray[counter] = array[counter+ middle + 1] ;
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

        // copy the rest of the elements
        while(i< leftArraySize){
            array[k] = leftArray[i] ;
            k++ ; i++ ;
        }
        while(j< rightArraySize){
            array[k] = rightArray[j] ;
            k++ ; j++ ;
        }

    }
    // merge sort
    void  mergeSort(int[] array , int left ,int right){
            if(left< right){
                int middle = (right + left) /2  ;
                mergeSort(array , left , middle) ;
                mergeSort(array , middle+1 , right) ;
                merge(array , left , middle , right) ;
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



    public static int duplicateCharacters(String input) {
        // Your code goes here
        char[] inputChars = input.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : inputChars) {
            if (map.containsKey(c)) {
                int value = map.get(c);
                value += 1;
                map.put(c, value);
            } else {
                map.put(c, 1);
            }
        }
        int duplicates = 0;
        for (Integer value : map.values()) {
            if (value > 1) {
                duplicates += 1;
            }
        }

        return duplicates;
    }



    public static boolean isNumber(String data){
        try{
            int number = Integer.parseInt(data) ;
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    public static int secondHighestDigit(String input) {
        ArrayList<Integer> list = new ArrayList<>();
        // Your code goes here
        String[] inputStr = input.trim().split("") ;
        for(String s: inputStr){
            if(isNumber(s)){
                list.add(Integer.parseInt(s)) ;
            }
        }
        if(list.size() <=1){
            return -1 ;
        }
        Collections.sort(list) ;
        return list.get(list.size() -2) ;
    }

        public static void main(String args[]){
        /*
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


        String sample = ("Aasdefsgh!!!") ;
        System.out.println(duplicateCharacters(sample));
        */
        System.out.println(secondHighestDigit("abc:1231234"));
    }



}
