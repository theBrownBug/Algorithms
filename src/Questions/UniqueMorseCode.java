package Questions;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueMorseCode {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] symbols = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."} ;
        HashMap<String , String> map = new HashMap<>() ;
        char character = 'a' ;
        for(String str: symbols){
            String s = String.valueOf(character);
            map.put(s , str) ;
            character+=1 ;
        }
        HashMap<String , String> wordMap = new HashMap<>() ;
        for(String word: words){
            wordMap.put(word , "") ;
        }

        // finds the mas
        for(String word: words){
            String[] wArray = word.split("") ;
            StringBuilder builder = new StringBuilder() ;
            for(String w: wArray){
                builder.append(map.get(w)) ;
            }
            wordMap.put(word,  builder.toString()) ;
        }

        HashSet<String> hashSet = new HashSet<String>();
        for(String word: words){
            hashSet.add(wordMap.get(word)) ;
        }

        return hashSet.size() ;


    }

    public static void main(String args[]){
        String[] words = {"gin" , "zen" , "gig" , "msg"};
        System.out.println(UniqueMorseCode.uniqueMorseRepresentations(words));
    }
}
