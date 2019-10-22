package Questions.Facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class RomanToDecimal {

    public static int valueOf(char i){
        if(i=='I'){ return 1 ; }
        else if(i=='V'){return 5 ; }
        else if(i=='X'){return 10 ; }
        else if(i=='L'){return 50 ; }
        else if(i=='C'){return 100 ; }
        else if(i=='D'){return 500 ; }
        else if(i=='M'){return 1000 ; }
       return -1 ;
    }

    /*
    *
    * */
    public static int toDecimal(String s){
        int sum = 0 ;
        for(int counter = 0 ; counter< s.length() ; counter++){
            int value1 = valueOf(s.charAt(counter)) ;
            if(counter+1< s.length()){
                int value2 = valueOf(s.charAt(counter + 1)) ;
                if(value1>=value2){
                    sum+= value1 ;
                }
                else{
                    sum = sum+ value2 - value1 ;
                    counter+=1 ;
                }
            }
            else{
                sum+= value1 ;
                //counter++ ;
            }
        }
        return sum ;
    }


    public static void main(String args[]){
        String[] strings = {"XXX" , "XLII" , "CMXX"} ;
        for(String s : strings){
            System.out.println(toDecimal(s));
        }

    }
}
