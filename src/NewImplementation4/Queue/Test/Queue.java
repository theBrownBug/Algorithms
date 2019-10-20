package NewImplementation4.Queue.Test;

public class Queue <E>{
    public Object[] array ;
    public int DEFAULT_CAPACITY = 1000 ;
    int front , rear, size ;
    int capacity  ;
    public Queue(){
        this.array = new Object[DEFAULT_CAPACITY] ;
        this.front = this.size = 0 ;
        this.rear = DEFAULT_CAPACITY - 1;
        this.capacity = DEFAULT_CAPACITY ;
    }
    public Queue(int capacity) throws Exception{
        try {
            if(capacity<0){ throw new Exception("The capacity cannot be less than 0") ; }
            else{
                this.array = new Object[capacity] ;
                this.front = this.size = 0 ;
                this.rear = capacity - 1;
                this.capacity = capacity ;
            }
        }
        catch (NumberFormatException e){
            System.out.println("The capacity of the queue should be a number");
        }
    }

    public boolean isFull(){ return this.size == this.capacity ; }
    public boolean isEmpty(){ return this.size == 0 ; }

    public void enqueue(E data){
        if(isFull()){
            System.out.println("The queue is full");
        }
        this.rear = (this.rear + 1) % this.capacity ;
        this.array[this.rear] = data ;
        this.size+=1 ;
        System.out.println("Data enqueued");
    }
    public E dequeue(){
        if(isEmpty()){
            System.out.println("The queue is empty");
            return null ;
        }
        E dataToReturn = (E)this.array[this.front] ;
        this.front = (this.front + 1) % this.capacity ;
        this.size-= 1 ;
        System.out.println("Item dequeued");
        return dataToReturn ;
    }

}
