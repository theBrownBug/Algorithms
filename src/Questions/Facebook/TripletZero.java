package Questions.Facebook;

import java.util.ArrayList;
import java.util.Arrays;

public class TripletZero {

    /*
    * O(n^3) method
    *
    * */
    public static ArrayList<ArrayList<Integer>> simpleMethod(int[] array){

        ArrayList<ArrayList<Integer>> nestedlist = new ArrayList<ArrayList<Integer>>() ;
        boolean found = false ;
        for(int i = 0 ; i < array.length - 2 ; i++){
            for(int j = i+1 ; j < array.length - 1 ; j++){
                for(int k = j+1 ; k< array.length ; k++){
                    if(i!= j && j!= k && i != k){
                        if(array[i] + array[j] + array[k] == 0){
                            found = true ;
                            ArrayList<Integer> newList= new ArrayList<>() ;

                            newList.add(array[i]) ;
                            newList.add(array[j]) ;
                            newList.add(array[k]) ;
                            nestedlist.add(newList) ;
                        }
                    }
                }
            }
        }

        if(!found){return null ; }

        return nestedlist ;
    }


    /**
     *
     * O(n^2) complexity
     *
     * */
    public static ArrayList<ArrayList<Integer>> advancedMethod(int[] array ,int length){
        ArrayList<ArrayList<Integer>> allTriplets = new ArrayList<>() ;
        int[] sortedArray = Arrays.copyOf(array , length);
        mergeSort(sortedArray , 0 , length - 1) ;
        //Arrays.sort(sortedArray);
        boolean found = false ;

        for(int counter = 0 ; counter < length - 1; counter++){
            int left = counter + 1;
            int right = length - 1 ;
            int x = sortedArray[counter];

            while(left < right){
                if((x + sortedArray[left] +sortedArray[right]) == 0){
                    ArrayList<Integer> newList= new ArrayList<>() ;
                    newList.add(x) ;
                    newList.add(sortedArray[left]) ;
                    newList.add(sortedArray[right]) ;
                    allTriplets.add(newList) ;

                    left++ ;
                    right-- ;
                    found = true ;
                }
                else if((sortedArray[left] + sortedArray[right] + x) < 0){
                    left++ ;
                }
                else{
                    right-- ;
                }

            }
        }

        if(!found){return null ; }
        return allTriplets ;
    }

    public static void merge(int[] array , int left, int middle , int right){
        int leftSize = middle - left +1 ;
        int rightSize = right - middle ;
        int[] leftArray = new int[leftSize] ;
        int[] rightArray = new int[rightSize] ;
        for(int counter = 0 ; counter< leftSize ; counter++){
            leftArray[counter] = array[left +counter] ;
        }
        for(int counter = 0 ; counter< rightSize ; counter++){
            rightArray[counter] = array[middle + 1 + counter] ;
        }

        // merge
        int i = 0 , j = 0 , k = left ;
        while(i< leftSize && j< rightSize){
            if(leftArray[i]<= rightArray[j]){
                array[k]= leftArray[i] ;
                i++ ;
            }
            else{
                array[k] = rightArray[j] ;
                j++ ;
            }
            k++ ;
        }

        // copy the rest of the elements
        while(i< leftSize){
            array[k] = leftArray[i] ;
            i++ ; k++ ;
        }

        while(j < rightSize){
            array[k] = rightArray[j] ;
            j++ ; k++ ;
        }



    }
    public static void mergeSort(int[] array , int left , int right){
        if(left< right){
            int middle = (left + right) / 2;
            mergeSort(array , left , middle);
            mergeSort(array, middle + 1, right);
            merge(array , left , middle , right);
        }
    }






    public static void main(String args[]){

        int[] array = {0 , -1 , 2 , -3 , 1} ;
        ArrayList<ArrayList<Integer>> out = TripletZero.simpleMethod(array) ;
        if(out== null){
            System.out.println("No triplets found");
        }
        else {
            for (int counter = 0; counter < out.size(); counter++) {
                for (int c = 0; c < out.get(counter).size(); c++) {
                    System.out.print(out.get(counter).get(c) + " ");
                }
                System.out.println();
            }
        }

        System.out.println() ;
        System.out.println("O(n^2 method .. includes sorting)") ;
        ArrayList<ArrayList<Integer>> triplets = TripletZero.advancedMethod(array , array.length) ;
        if(triplets == null){
            System.out.println("No triplets found");
        }
        else{

            for(int counter = 0 ; counter< triplets.size() ; counter++){
                for(int c = 0 ; c< triplets.get(counter).size() ; c++){
                    System.out.print( triplets.get(counter).get(c) + " ");
                }
                System.out.println();
            }
        }





    }


}
