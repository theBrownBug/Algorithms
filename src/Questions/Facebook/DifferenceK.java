package Questions.Facebook;
/*
*
* Count all distinct pairs with difference equal to k
* */
public class DifferenceK {

    /*
    * O(n^2)
    *
    * */
    public static int differenceK(int[] array, int  k ){
        int pairs = 0 ;
        for(int counter= 0 ; counter< array.length -1 ; counter++){
            for(int counter2 = counter +1 ; counter2<array.length ;counter2++){
                if(Math.abs(array[counter] - array[counter2]) == k){
                    pairs+=1 ;
                }
            }
        }
        return pairs ;
    }



    /*
     * O(n log n )
     *
     * */

    public static int differenceKFaster(int[] array , int k ){
        mergeSort(array , 0 , array.length - 1);
        int count = 0 ;
        int left = 0 ;
        int right = 0 ;
        while(right< array.length){
            if(array[right] - array[left] == k){count+= 1 ; right++ ; left++ ; }
            else if(array[right] - array[left]> k ){
                left ++ ;
            }
            else{right ++ ; }
        }
        return count;
    }


    public static void merge(int[] array , int left , int middle , int right){
        int leftSize = middle - left + 1 ;
        int rightSize = right - middle ;
        int[] leftArray = new int[leftSize] ;
        int[] rightArray = new int[rightSize] ;
        for(int counter =   0 ; counter< leftArray.length ; counter++){
            leftArray[counter] = array[left + counter] ;
        }
        for(int counter = 0 ;counter< rightArray.length ; counter++){
            rightArray[counter] = array[middle + 1 + counter] ;
        }

        int i = 0 , j =  0 , k = left ;

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

        while(i<leftSize){
            array[k] = leftArray[i] ;
            i++ ; k++ ;
        }
        while(j< rightSize){
            array[k] = rightArray[j] ;
            j++ ; k++ ;
        }
    }

    public static void mergeSort(int[] array , int left , int right){
        if(left<right){
            int middle = (left + right) / 2;
            mergeSort(array, left , middle);
            mergeSort(array , middle + 1 , right);
            merge(array , left , middle , right);
        }
    }


    public static void main(String args[]){

    }
}
