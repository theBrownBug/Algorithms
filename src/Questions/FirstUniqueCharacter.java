package Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FirstUniqueCharacter {

    public static int firstUniqChar(String s) {
        HashMap<String , ArrayList<Integer>> map = new HashMap<>() ;
        String[] array = s.split("") ;
        if(array.length ==1 && array[0].equals("")){ return  -1 ; }
        for(int counter = 0 ; counter < array.length; counter++){
            if(map.containsKey(array[counter])){
                ArrayList<Integer> list = map.get(array[counter]) ;
                list.add(counter) ;
                map.put(array[counter], list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>() ;
                list.add(counter) ;
                map.put(array[counter] , list) ;
            }
        }
        int firstElementIndex = Integer.MAX_VALUE ;
        for(String key : map.keySet()){
            // if the size of the array list is greater than 1, its a duplicate element
            // if the size of the arraylist is 1, get the least index
            if(map.get(key).size() ==1){
                ArrayList<Integer> list = map.get(key) ;
                if(list.get(0)< firstElementIndex){
                    firstElementIndex = list.get(0);
                }
            }
        }


        return firstElementIndex ;
    }
    public static void main(String args[]){
        System.out.println(FirstUniqueCharacter.firstUniqChar("leetcode"));
        System.out.println(FirstUniqueCharacter.firstUniqChar("loveleetcode"));
        System.out.println(FirstUniqueCharacter.firstUniqChar(""));
    }
}
