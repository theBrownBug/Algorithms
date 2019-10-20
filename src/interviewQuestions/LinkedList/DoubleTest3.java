package interviewQuestions.LinkedList;
public class DoubleTest3 {
    public Node head ;
    public static class Node{
        int data;
        Node next , previous ;
        public Node(int data){
            this.data = data ;
            this.next= this.previous = null ;
        }
    }

    public void push(int data){
        Node newNode = new Node(data) ;
        if(this.head== null){
            this.head = newNode ;
            return;
        }
        newNode.next = this.head ;
        this.head.previous = newNode ;
        this.head = newNode ;
    }

    public void insert(Node previous , int data){
        Node newNode = new Node(data) ;
        if(previous == null){
            System.out.println("The previous node cannot be null");
            return;
        }

        newNode.next = previous.next ;
        previous.next = newNode ;
        newNode.previous = previous ;
        newNode.next.previous = newNode ;
    }


    public void append(int data){
        Node newNode = new Node(data) ;
        if(this.head== null){
            this.push(data);
            return;
        }
        Node temp = this.head;
        while(temp.next != null){
            temp = temp.next ;
        }
        temp.next = newNode ;
        newNode.previous = temp ;
    }


    // check delete

    public void delete(int key){

        if(this.head.data == key){
            Node temp = this.head ;
            temp.next.previous= null ;
            this.head = temp.next ;
            temp.next = null ;
            return;
        }

        // else
        Node previous = null , temp = this.head;
        while(temp!=null && temp.data != key){
            previous = temp ;
            temp = temp.next ;
        }
        previous.next = null ;

        previous.next = temp.next ;
        temp.next.previous = previous ;



    }

}
