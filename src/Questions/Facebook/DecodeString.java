package Questions.Facebook;

import java.util.Stack;

public class DecodeString {

    public static boolean isNumber(String s){
        try {
            int n = Integer.parseInt(s) ;
            return true ;
        }
        catch (Exception e){
            return false ;
        }
    }
    public static boolean isClosedPara(String s){
        return s.charAt(0)==']' ;
    }
    public static String decodeString(String string){
        Stack<Integer> integerStack = new Stack<>() ;
        Stack<Character> characterStack  = new Stack<>() ;

        String[] array = string.split("") ;
        int counter = 0 ;
        for(int c = 0 ; c< array.length ; c++){
            if(!isClosedPara(array[c])) {
                if (isNumber(array[c])) {
                    integerStack.push(Integer.parseInt(array[c]));
                }
                else{
                    characterStack.push(array[c].charAt(0)) ;
                }
            }
        }

        StringBuilder out = new StringBuilder() ;

        while(!characterStack.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            Character c = 'A' ;
            while (c != '[') {
                c = characterStack.pop();
                if (c != '[') {
                    builder.append(c);
                }
                else {
                    int n = integerStack.pop();
                    // after each iteration
                    String toAppend = builder.append(out.toString()).toString();
                    for (int counter2 = 0; counter2 < n - 1; counter2++) {
                        builder.append(toAppend);
                    }
                    out.setLength(0);
                }

            }
            // assign a random character to c
            out.append(builder.toString()) ;
            builder.setLength(0);



        }
        return out.toString() ;
    }

    public static void main(String args[]){
        System.out.println(decodeString("2[ab]"));
    }
}

