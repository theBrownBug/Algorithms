package interviewQuestions.GeneralQuestions;
import java.util.Scanner;

public class FiboFact {
    static int fib(int n){
        if(n<= 1){ return n ; }
        return fib(n-1)  + fib(n-2) ;
    }
    static int factorial(int n ){
        if(n==0){ return  1 ; }
        return factorial(n) * factorial(n-1) ;
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in) ;
        input.close();
    }
}
