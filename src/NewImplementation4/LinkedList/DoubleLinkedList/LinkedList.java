package NewImplementation4.LinkedList.DoubleLinkedList;

import java.util.concurrent.ExecutionException;

public class LinkedList<E> {
    public int size = 0 ;
    private Node head  ;
    public static class Node<E>{
        E data ;
        Node next , previous ;
        public Node(E data){
            try {
                this.data = data;
                this.next = this.previous = null;
            }catch (Exception e){
                System.out.println("The type of data is invalid");
            }
        }
    }

    public LinkedList(){ this.head= null ; }
    public LinkedList(E data){
        this.head = new Node(data) ;
        this.size+= 1 ;
    }

    // at the head of the linked list
    public void push(E data){
        // if the head is empty
        if(this.head== null){
            this.head = new Node(data) ;
            this.size+=1 ;
            return;
        }
        Node newNode = new Node(data) ;
        newNode.next = this.head;
        this.head.previous = newNode ;
        this.head = newNode ;
        size +=1 ;
    }

    // insert at a particular position
    public void insert(Node previous , E data)throws Exception{
        if(previous == null){
            throw new Exception("The previous node cannot be null") ;
        }
        Node newNode = new Node(data) ;
        previous.next = newNode.next ; // the next node previous node is the next node of newNode
        previous.next.previous = newNode ; // the previous node of next node is the newNode
        previous.next = newNode ; // previous node's next node is newNode
        newNode.previous = previous ;
        size+=1 ;

    }

    // insert at the end of the linked list
    public void append(E data){
        if(this.head == null){
            this.head = new Node(data) ;
            this.size +=1 ;
            return;
        }
        Node temp = this.head ;
        while(temp.next!= null){
            temp = temp.next ;
        }
        Node newNode = new Node(data) ;
        temp.next= newNode ;
        newNode.previous = temp ;
        this.size+=1 ;
    }

    public boolean delete(E key){
        // if the head is null return false(the linked list is empty)
        if(this.head == null){
            System.out.println("The linked list is empty");
            return false ;
        }
        // if the node to be deleted is the head
        if(this.head.data.equals(key)){
            Node nextNode = this.head.next ;
            this.head.next = null ; // remove the forward link from the head to be deleted
            nextNode.previous = null ; // remove the back link from the next node
            this.head = nextNode ; // assign the nextNode as the head
            this.size-=1 ;
            return true ;
        }
        Node temp = this.head.next , previous= this.head ;
        while(temp!= null && !temp.data.equals(key)){
            previous = temp ;
            temp = temp.next ;
        }

        if(temp == null){
            System.out.println("the key is not present in the linked list");
            return false ;
        }

        // make the next of previous as temp's next node
        previous.next = temp.next ;
        // make the next node's previous as the previous node
        temp.next.previous = previous ;
        // unlink the node to be deleted completely
        temp.next= temp.previous = null ;
        this.size-=1 ;
        return true ;
    }

}
