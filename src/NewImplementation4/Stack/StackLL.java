package NewImplementation4.Stack;

import java.util.LinkedList;

public class StackLL<E> {
    public LinkedList<E> list ;
    public int stackSize = 1000 ;
    int size = 0 ;
    Node head ;
    public static class Node<E>{
        public E data ;
        Node next ;
        public Node(E data){
            this.data = data ;
            this.next = null ;
        }
    }

    public int getSize() { return size; }

    public void setSize(int size) { this.size = size; }


    /*
    * As the Stack follows LIFO, the implementation using a linked list
    * always insert an element at the head of the linked list
    *
    * */
    public void push(E data){
        Node newNode = new Node(data) ;
        if(this.size == stackSize){
            throw new StackOverflowError("The stack is full");
        }
        if(this.head == null){
            this.head = newNode ;
            size+=1 ;
            return;
        }
        newNode.next = this.head ;
        this.head = newNode ;
        size+=1 ;
    }

    public E pop() throws Exception{
        if(this.head == null){ throw new Exception("Stack underflow") ; }
        Node toReturn = this.head ;
        this.head = this.head.next ;
        toReturn.next =null; // the node to be deleted will be garbage collected
        return (E) toReturn.data;
    }

    public E peek() throws Exception {
        if (this.head == null) {
            throw new Exception("Stack underflow");
        }
        return (E) this.head.data ;
    }

}
