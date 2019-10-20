package NewImplementation4.Queue;

public class Queue<E>{
    Object[] array ;
    int front , rear , size ;
    int DEFAULT_CAPACITY = 1000 ;
    int capacity = 0 ;
    public Queue(){
        this.array = new Object[DEFAULT_CAPACITY] ;
        this.front = this.size = 0 ;
        rear = DEFAULT_CAPACITY - 1;
        this.capacity = DEFAULT_CAPACITY ;
    }
    public Queue(int size) throws Exception{
        try{
            if(size>0){
                this.array = new Object[size] ;
                this.capacity = size ;
                this.front = this.size =  0 ;
                this.rear = this.capacity - 1;
            }
            else{throw new Exception("the size should be greater than 0") ; }
        }catch (NumberFormatException e){
            System.out.println("The size of the queue should be a number");
        }
    }

    public boolean isFull(){ return this.size>=this.capacity ; }
    public boolean isEmpty(){ return this.size== 0 ; }
    public void enqueue(E data){
        if(isFull()){ return; }
        this.rear = (this.rear+1) % this.capacity ;
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
        this.size-=1 ;
        System.out.println("Item dequeued");
        return dataToReturn ;
    }



}
