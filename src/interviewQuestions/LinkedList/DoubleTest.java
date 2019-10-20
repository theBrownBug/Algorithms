package interviewQuestions.LinkedList;

public class DoubleTest {
    public Node head ;

    public static class Node{
        int data ;
        Node next , previous;
        public Node(int data ){
            this.data = data ;
            this.next = this.previous = null ;
        }
    }

    public void push(int data){
        Node newNode = new Node(data) ;
        // if the list is empty
        if(this.head == null){
            this.head = newNode ;
            return;
        }
        newNode.next = head;
        newNode.previous = null ;
        this.head.previous = newNode ;
        this.head = newNode ;
    }

    // insert a node in between after a node
    public void insert(Node previous, int data){
        Node newNode = new Node(data) ;
        if(previous==null){
            System.out.println("Previous cannot be null");
            return;
        }
        newNode.next = previous.next ;
        newNode.previous = previous ;
        previous.next.previous = newNode ;
        previous.next = newNode ;
    }

    public void append(int data){
        Node newNode= new Node(data) ;
        if(this.head == null){
            push(data);
            return;
        }
        Node temp = head ;
        while(temp.next!=null){
            temp = temp.next ;
        }
        temp.next = newNode ;
        newNode.next = null ;
        newNode.previous = temp ;
    }

    public void delete(int key){
        // if the head contains the key
        if(this.head.data == key){
            this.head = this.head.next;
            this.head.previous = null ;
            return;
        }
        Node prev = null , temp = this.head;
        while(temp!= null &&  temp.data != key){
            prev = temp ;
            temp = temp.next ;
        }
        if(temp == null){
            System.out.println("Key is not present in the linked list");
            return;
        }
        prev.next = temp.next ;
        temp.next.previous = prev;
        return;
        // check everything

    }

}
