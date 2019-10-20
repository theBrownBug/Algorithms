package Questions.Facebook;

import java.util.HashMap;

public class RomanToInt {

    public static int romanToInt(String s) {
        HashMap<String , Integer> map = new HashMap<>();
        map.put("I" , 1) ;
        map.put("V" , 5) ;
        map.put("X" , 10) ;
        map.put("L" , 50) ;
        map.put("C" , 100) ;
        map.put("D" , 500) ;
        map.put("M" , 1000) ;
        String[] numbers = s.split("") ;
        int number = 0 ;
        for(int counter = 0 ; counter< numbers.length  ; counter++){
            if(counter != 0) {
                if (map.get(numbers[counter]) > map.get(numbers[counter - 1])) {
                    number-= map.get(numbers[counter -1 ] ) ;
                    number += map.get(numbers[counter]) - map.get(numbers[counter - 1]);


                }
                else{
                    number+= map.get(numbers[counter]) ;
                }
            }
            else{
                if (map.get(numbers[counter+1]) > map.get(numbers[counter])) {
                    number += map.get(numbers[counter+1]) - map.get(numbers[counter]);
                    counter+=1 ;

                }
                else{
                    number+= map.get(numbers[counter]) ;
                }
            }

        }

        return number ;
    }

    public static void main(String args[]){
        System.out.println(RomanToInt.romanToInt("III"));
        System.out.println(RomanToInt.romanToInt("IV"));
        System.out.println(RomanToInt.romanToInt("LVIII"));
        System.out.println(RomanToInt.romanToInt("MCMXCIV"));
    }
}
