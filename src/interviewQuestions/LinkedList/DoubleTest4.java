package interviewQuestions.LinkedList;

public class DoubleTest4 {
    public Node head ;
    public static class Node{
        Node next , previous ;
        int data ;
        public Node(int data){
            this.data = data ;
            this.next = this.previous = null ;
        }
    }

    public void push(int data){
        Node newNode = new Node(data) ;
        if(this.head== null){ this.head  = newNode ; return; }
        newNode.next = this.head ;
        this.head.previous = newNode ;
        this.head = newNode ;
    }

    public void insert(Node previous, int data){
        if(previous ==null){
            System.out.println("Previous cannot be null");
            return;
        }
        Node newNode = new Node(data) ;
        newNode.next = previous.next ;
        previous.next.previous = newNode ;
        previous.next = newNode ;
        newNode.previous = previous ;
    }

    public void append(int data){
        Node newNode = new Node(data) ;
        if(this.head == null){
            this.head = newNode ;
            return;
        }
        Node temp = this.head ;
        while(temp.next != null){
            temp = temp.next ;
        }
        temp.next = newNode ;
        newNode.previous = temp ;
    }

    public void delete(int key){
        // if the key is at the head
        if(this.head.data ==key){
            this.head = this.head.next ; // make the next node as the head
            this.head.previous.next = null ; // make the original head's next pointer to be null
            this.head.previous = null ; // make the new head's previous to be null
        }

        Node temp = this.head , previous = null ;
        while(temp!= null && temp.data != key){
            previous = temp ;
            temp = temp.next ;
        }
        if(temp==null){
            System.out.println(" The key is not present in the linked list");
            return;
        }
        previous.next = temp.next ;
        temp.next.previous = previous ;
        temp.next = null;
        temp.previous = null ;
    }
}
