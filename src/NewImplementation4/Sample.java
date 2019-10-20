package NewImplementation4;

import java.util.HashMap;
import java.util.LinkedList;

public class Sample {

    public static char maximumOccurringCharacter(String text) {
        // Write your code here
        char[] charArray= text.toCharArray() ;
        HashMap<Character, Integer> map= new HashMap<>() ;
        for(Character c : charArray){
            if(map.containsKey(c)){
                int value = map.get(c) ;
                map.put(c , value + 1) ;
            }
            else{
                map.put(c , 1) ;
            }
        }

        char maxKey ; int maxValue = Integer.MIN_VALUE  ;
        LinkedList<Character> maxList = new LinkedList<>()  ;
        for(char key: map.keySet()){
            if(map.get(key)>maxValue){
                maxValue = map.get(key) ;
            }
        }

        for(char key: map.keySet()){
            if(map.get(key)== maxValue){
                maxList.add(key) ;
            }
        }

        char earlier = Character.MAX_VALUE ;
        for(int counter = 0 ; counter< maxList.size() ; counter++){
            if( maxList.get(counter)< earlier){
                earlier = maxList.get(counter) ;
            }
        }
        return earlier ;
    }

    public static void main(String args[]){
        System.out.println(maximumOccurringCharacter("abbbaacc"));
    }
}
