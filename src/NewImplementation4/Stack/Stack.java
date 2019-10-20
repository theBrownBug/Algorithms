package NewImplementation4.Stack;

public class Stack<E>{
    final int DEFAULT_SIZE = 1000 ;
    public Object[] array ;
    private int top;
    public Stack(){
        this.top = -1 ;
        this.array = new Object[DEFAULT_SIZE] ;
    }
    public Stack(int size) throws Exception{
        try {
            if(size>0){ this.array = new Object[size] ; }
            else { throw new Exception("The size of the stack has to be greater than 0"); }
        }catch (NumberFormatException e){
            System.out.println("The size should be an integer value");
        }
    }

    public void push(E data)throws StackOverflowError{
        if(this.top>=this.array.length){
            throw new StackOverflowError("The stack is full") ;
        }
        this.array[top++] = data ;
    }
    public E pop() throws Exception{
        if(top <0){
            throw new Exception("Stack underflow error") ;
        }
        return (E)this.array[top--] ;
    }

    public E peek() throws Exception{
        if(top < 0 ){ throw new Exception("Stack underflow error") ; }
        return (E) this.array[top] ;
    }

}
