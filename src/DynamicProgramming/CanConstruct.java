package DynamicProgramming;
import java.util.* ;

public class CanConstruct {



    public static boolean canConstructNormal(String target , ArrayList<String> substrings){
        if (target.equals("")){return true ; }

        for (String word : substrings){
            if(target.startsWith(word)){
                String replaced  = target.replace(word , "")  ;
                if(canConstructNormal(replaced , substrings)){return true ; }
            }
        }

        return false ;
    }


    public static boolean canConstructDP(String target , ArrayList<String> subStrings){
        HashMap<String , Boolean> map = new HashMap<>();
        return canConstructDPSubRoutine(target , subStrings , map);
    }

    public static boolean canConstructDPSubRoutine(String target , ArrayList<String> subStrings, HashMap<String , Boolean> map){
        if(map.containsKey(target)){return map.get(target) ; }
        if(target.equals("")){return true ; }
        for(String word : subStrings){
            if(target.startsWith(word)){
                String replaced  = target.replace(word , "")  ;
                if(canConstructDPSubRoutine(replaced , subStrings , map)){return true ; }
                map.put(replaced, true);
            }
        }
        map.put(target , false);
        return false ;
    }


    public static void main(String args[]){

        ArrayList<String> wordBank1 = new ArrayList<>(Arrays.asList("ab", "abc", "cd", "def" , "abcd")) ;
        System.out.println(canConstructNormal("abcdef", wordBank1));
    }
}
