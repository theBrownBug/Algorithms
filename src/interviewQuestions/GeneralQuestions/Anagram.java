package interviewQuestions.GeneralQuestions;
import java.util.Arrays;
import java.util.Scanner;

/*
* Anagram check whether 2 strings are permutations of each other
*
* */
public class Anagram {

    public boolean isAnagram(char[] firstArray , char[] secondArray){
        if(firstArray.length != secondArray.length){return  false ; }
        else{
            Arrays.sort(firstArray);
            Arrays.sort(secondArray);
            for(int counter = 0 ; counter < firstArray.length ;counter++){
                if(firstArray[counter]!= secondArray[counter]){
                    return  false ;
                }
            }

        }
        return true;
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in) ;
        String first  =  input.nextLine().toLowerCase().trim() ;
        String second = input.nextLine().toLowerCase().trim() ;
        char[] firstCharArray  = first.toCharArray() ;
        char[] secondCharArray = second.toCharArray() ;

    }
}
