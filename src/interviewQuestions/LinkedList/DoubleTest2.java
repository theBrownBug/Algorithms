package interviewQuestions.LinkedList;

public class DoubleTest2 {
    Node head ;
    public static class Node{
        int data;
        Node next , previous ;
        Node(int data){
            this.data = data ;
            this.next = this.previous = null ;
        }
    }

    public void push(int data){
        Node temp = new Node(data) ;
        if(this.head == null ){
            this.head = temp;
            return;
        }
        else{
            temp.next = this.head ;
            this.head.previous = temp ;
            this.head = temp ;
        }
    }

    public void insert(Node previous , int data){
        if(previous == null){
            System.out.println("Previous node should be not null. ");
            return;
        }
        else{
            Node temp = new Node(data) ;
            temp.next = previous.next ;
            previous.next.previous = temp ;
            temp.previous = previous;
        }
    }

    public void append(int data){
        if(this.head == null){
            push(data);
            return;
        }
        Node temp = this.head  , previous = null ;
        while(temp.next != null){
            previous = temp ;
            temp = temp.next ;
        }

        Node newNode = new Node(data) ;
        temp.next = newNode ;
        newNode.previous = temp ;

    }

    public void delete(int key){
        if(this.head.data==key){
            this.head = this.head.next ;
            this.head.previous = null ;
            return;
        }

        Node prev = null , temp = this.head ;
        while(temp.next != null && temp.data != key){
            prev = temp ;
            temp = temp.next ;
        }

        if(temp == null){
            return;
        }
        prev.next = temp.next ;
        temp.next.previous = prev ;

    }

}
