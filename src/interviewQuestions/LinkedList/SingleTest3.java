package interviewQuestions.LinkedList;

public class SingleTest3 {
    public Node head ;
    public static class Node{
        int data;
        Node next ;
        public Node(int data){
            this.data = data ;
            this.next = null ;
        }
    }

    // add the node at the beginning of the linked list
    public void push(int data){
        Node tempNode = new Node(data) ;
        if(this.head == null){
            this.head = tempNode ;
            return;
        }
        tempNode.next = this.head ;
        this.head = tempNode ;
    }


    // add the node at the a certain point
    public void insert(Node previousNode , int data){
        Node temp = new Node(data) ;

        if(previousNode == null){
            System.out.println("Previous node cannot be null ");
            return;
        }

        temp.next = previousNode.next ;
        previousNode.next = temp ;
        return;
    }

    public void append(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.push(data);
        }
        Node temp  = this.head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode ;
    }


    public void delete(int key ){
        if(this.head.data == key){
           this.head =  this.head.next  ;
           return;
        }

        Node temp = this.head , previous = null ;
        while(temp != null && temp.data != key){
            previous = temp ;
            temp = temp.next ;
        }

        if(temp == null){
            System.out.println("The key is not present in the linked list ");
            return;
        }
        previous.next = temp.next ;

    }



}
