package DS;

import java.io.InputStreamReader;

class Queue{

    private int size;
    private int front , rear , capacity ;
    private double[] array ;

    public Queue(int capacity){
        this.capacity = capacity ;
        this.size = front = 0 ;
        this.rear = capacity - 1 ;
        this.array = new double[capacity] ;
    }

    public boolean isFull(Queue queue){
        return queue.size == queue.capacity ;
    }

    public boolean isEmpty(Queue queue){
        return queue.size == 0 ;
    }

    public void enqueue(double data){
        if(isFull(this)){
            System.out.println(" The queue is full , overflow ..") ;
            return  ;
        }
        else{
            this.rear  = (this.rear + 1 )% this.capacity  ;
            this.array[this.rear] = data  ;
            this.size += 1 ;
            System.out.println(data + "is enqueud to the queue") ;
        }
    }

    public double dequeue(){
        if(isEmpty(this)){
            System.out.println("queue underflow") ;
            return Double.MIN_VALUE ;
        }
        else{
            double item = this.array[this.front] ;
            this.front = (this.front+1)%this.capacity ;
            this.size -- ;
            return item ;
        }
        return Double.MIN_VALUE  ;
    }

    public int getRear(){
        if(isEmpty(this)){
            return Integer.MIN_VALUE ;
        }
        else{return this.rear ; }
    }

    public int getFront() {
        if(isEmpty(this)){
            return Integer.MIN_VALUE  ;
        }
        else{return this.front;}
    }


}