package DynamicProgramming;
import java.util.HashMap ;

public class Fibonacci {

    public int fibonacciNormal(int number){
        if(number<=2){
            return 1 ;
        }
        return fibonacciNormal(number  -1)+ fibonacciNormal(number -2);
    }


    public int fibonacciDP(int number){
        HashMap<Integer, Integer> map = new HashMap<>() ;
        return fibonacciDPSubRoutine(number , map);
    }

    public int fibonacciDPSubRoutine(int number, HashMap<Integer , Integer> map){
        if(map.containsKey(number)){ return map.get(number); }
        if(number<=2){return 1 ; }

        return fibonacciDPSubRoutine(number -1 , map ) + fibonacciDPSubRoutine(number -2 , map);

    }

}
