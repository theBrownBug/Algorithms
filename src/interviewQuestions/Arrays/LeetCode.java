package interviewQuestions.Arrays;

import java.util.Scanner;

public class LeetCode {

    public static String defangIPaddr(String address) {
        String newDel = "[.]" ;
        String[] processed = address.split("\\.");
        String out = "" ;
        for(int counter = 0 ; counter < processed.length -1 ; counter++){
            out += (processed[counter] + (newDel));
        }
        out += (processed[processed.length-1])  ;
        return out ;
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in) ;
        String add = input.nextLine().trim() ;
        String out = LeetCode.defangIPaddr(add) ;
        System.out.println(out) ;
    }
}
