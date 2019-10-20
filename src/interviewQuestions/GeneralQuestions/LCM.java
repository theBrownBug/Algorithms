package interviewQuestions.GeneralQuestions;

public class LCM {


    public int LCM(int a , int b){
        int larger = Math.max(a , b) ;
        int smaller = Math.min(a , b);
        for(int i = larger ;; i+= larger  ){
            if( (i% smaller) == 0 ){
                return  i ;
            }
        }
    }



}
