package NewImplementation4;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static boolean validCard(String cardNumber){
        String[] numbers = cardNumber.split("") ;
        int oddSum= 0 , evenSum = 0 ;
        ArrayList<Integer> evenList = new ArrayList<>() ;

        for(int counter = 0 ; counter< numbers.length ; counter++){
            // since the array is 0 indexed, odd numbers actually lie at even positions
            if(counter%2==0){
                oddSum += Integer.parseInt(numbers[counter]) ;
            }
            else{
                evenList.add(Integer.parseInt(numbers[counter].trim()) *2 ) ;
            }
        }

        for(int counter = 0 ; counter< evenList.size() ; counter++){
            if(evenList.get(counter)>9){
                String[] twoDigits = String.valueOf(evenList.get(counter)).split("") ;
                int sum = 0 ;
                for(String str: twoDigits){
                    sum+= Integer.parseInt(str) ;
                }
                evenList.set(counter , sum) ;
            }
            evenSum+= evenList.get(counter) ;
        }

        if((evenSum + oddSum)%10 == 0){
            return true ;
        }

        return false ;

    }

    public static void main(String args[]) throws Exception{

        Scanner input = new Scanner(System.in) ;
        int testCases = Integer.parseInt(input.nextLine().trim()) ;
        if(testCases<1 || testCases >100){
            throw new Exception("Unacceptable number of testcases") ;
        }
        String[] creditCardNumbersReversed = new String[testCases] ;

        // reversed numbers added to the array
        for(int counter = 0 ; counter<testCases ; counter++){
            String cardNumber = input.nextLine().trim() ;
            StringBuilder builder = new StringBuilder() ;
            builder.append(cardNumber) ;
            creditCardNumbersReversed[counter] = builder.reverse().toString() ;
        }
        String[] answers = new String[testCases] ;
        for(int counter = 0 ; counter<creditCardNumbersReversed.length ;counter++){
            if(Solution.validCard(creditCardNumbersReversed[counter])){
                answers[counter] = "Yes" ;
            }
            else{
                answers[counter] = "No" ;
            }
            System.out.println(answers[counter]) ;
        }
    }


}
