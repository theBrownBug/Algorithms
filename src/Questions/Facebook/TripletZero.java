package Questions.Facebook;

import java.util.ArrayList;

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
        System.out.println() ;

    }


}
