package Questions;

public class MoveZeros {

    public static void moveZeros(int[] array){
        int found = 0 ;
        for(int counter = 0 ; counter< array.length  - 1 ; counter++){
            if(array[counter]==0) {
                for (int counter2 = counter; counter2 < array.length - 1 - counter; counter2++) {
                    int temp = array[counter2] ;
                    array[counter2] = array[counter2 + 1] ;
                    array[counter2 + 1] = temp ;
                }
            }
        }

        for(int c = 0 ; c< array.length ; c++){
            System.out.print(array[c] + " ");
        }
    }

    public static void main(String args[]){
        int[] array = {0 , 0 , 1} ;
        MoveZeros.moveZeros(array);
    }
}
