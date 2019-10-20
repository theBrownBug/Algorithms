package Questions;
import java.util.* ;

public class DecimalToRoman{

    public static String toRoman(int number){

        HashMap<String , Integer> numberMap = new HashMap<>() ;
        numberMap.put("I" , 1) ;
        numberMap.put("V" , 5) ;
        numberMap.put("X" , 10) ;
        numberMap.put("L" , 50) ;
        numberMap.put("C" , 100) ;
        numberMap.put("D" , 500) ;
        numberMap.put("M" , 1000) ;
        numberMap.put("IV", 4 ) ;
        numberMap.put("IX" ,9) ;
        numberMap.put("XL" , 40) ;
        numberMap.put("XC" , 90) ;
        numberMap.put("CD" , 400) ;
        numberMap.put("CM" , 900) ;
        LinkedHashMap<String , Integer> newMap = DecimalToRoman.sortMap(numberMap) ;

        if(number<1 || number>3999){
            return null ;
        }
        StringBuilder builder = new StringBuilder() ;
        for(Map.Entry<String , Integer> entry : newMap.entrySet()){
            if(number<entry.getValue()){continue;}
            else{
                int counter = -1 ;
                int sum = 0;
                while(number>= sum){
                    sum+= entry.getValue() ;
                    counter+=1 ;

                }
                number %=entry.getValue() ;

                for(int c = 0 ; c<counter ; c++) {
                    builder.append(entry.getKey());
                }
            }
        }
        return builder.toString() ;

    }

    public static LinkedHashMap<String, Integer> sortMap(HashMap<String, Integer> hashMap){
        ArrayList<String> mapKeys = new ArrayList<>(hashMap.keySet()) ;
        ArrayList<Integer> mapValues = new ArrayList<>(hashMap.values()) ;
        mapValues.sort(Collections.reverseOrder());
        LinkedHashMap<String, Integer> newMap = new LinkedHashMap<>() ;

        Iterator<Integer> valueIterator = mapValues.iterator() ;
        while(valueIterator.hasNext()){
            int value = valueIterator.next() ;
            for(String str: hashMap.keySet()){
                if(hashMap.get(str)== value){
                    newMap.put(str , value) ;
                }
            }
        }
        return newMap;

    }

    public static void main(String args[]){
        int[] numbers = {3549 , 10 , 80, 1904} ;
        for(int number: numbers){
            System.out.println(DecimalToRoman.toRoman(number));
        }
    }

}
