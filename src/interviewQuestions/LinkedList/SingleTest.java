package interviewQuestions.LinkedList;

public class SingleTest {
    public Node head ;
    public static class Node{
        Node next ;int data ;
        public Node(int data){
            this.next = null ; this.data = data ;
        }
    }

    // insertions

    // at the head;

    public void push(int data){
        Node newNode = new Node(data) ;
        if(this.head== null){
            this.head = newNode ;
            return;
        }
        newNode.next = head;
        this.head = newNode;
    }


    // in between

    public void insert(Node previous , int data){
        Node newNode = new Node(data) ;
        if(previous == null){
            System.out.println("Previous cannot be null ");
            return;
        }
        newNode.next = previous.next ;
        previous.next = newNode ;
    }

    // at the end
    public void append(int data){
        Node newNode =  new Node(data) ;
        if(this.head == null){
            this.head = newNode ;
            return;
        }
        Node temp = head;
        while(temp.next != null ){
            temp  = temp.next ;
        }
        temp.next = newNode ;
    }

    // deletions

    public void delete(int key) {

        // if the head has to be removed;

        if (head != null) {
            if (this.head.data == key) {
                this.head = this.head.next ;
                return;
            }
            Node previous = null , temp = head;
            while(temp!=null && temp.data != key ){
                previous = temp ;
                temp = temp.next ;
            }

            // if the key is not present
            if(temp == null){
                return;
            }

            // else unlink
            previous.next = temp.next ;

        }
    }




}
