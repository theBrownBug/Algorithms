package DS;
import java.util.* ;
public class Stack{

    private int top ;
    private int size ;
    private double[] array ;

    public Stack(int size){
        try {
            this.size = size;
            this.top = -1;
            this.array = new double[size];
        }catch(NumberFormatException e){

            System.out.println("Enter the correct size of the stack ");
        }
    }

    public boolean isEmpty(){
        return this.top <0 ;

    }

    public boolean push(double data){
        if(top >=(this.size -1 )){

            System.out.println("There is a stack overflow ") ;
            return false;
        }
        else{
            this.array[top+1] = data ;
            top++ ;
        }
    }

    public double pop(){
        if(top<0) {
            System.out.println("Stack underflow");
            return Double.POSITIVE_INFINITY ;
        }
        else{
            return array[top];
            top-- ;
        }

    }

    public boolean stack_empty(){
        return top<0  ;

    }

    public boolean stack_full(){
        return top== size-1 ;
    }


    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}