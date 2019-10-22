package Questions.Facebook;

import java.util.ArrayList;
import java.util.Collections;

public class ReArrangeString {


    public static String reArrange(String s){
        if(s == null ||s.equals("")  ){
            return null ;
        }
        int sum= 0 ;
        String[] stringArray = s.split("") ;
        ArrayList<String> stringList = new ArrayList<>() ;
        for(int counter = 0 ; counter< stringArray.length ; counter++){
            try{
                int n = Integer.parseInt(stringArray[counter]) ;
                sum+= n ;
                continue;
            }
            catch (Exception e){
                stringList.add(stringArray[counter]) ;
            }
        }

        Collections.sort(stringList);
        StringBuilder builder = new StringBuilder() ;
        for(String str: stringList){
            builder.append(str) ;
        }
        builder.append(String.valueOf(sum)) ;
        return builder.toString() ;
    }


    public static void main(String args[]){
        String array = "ACCBA10D2EW30" ;
        System.out.println(reArrange(array));
    }
}
