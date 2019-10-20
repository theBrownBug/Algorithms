package interviewQuestions.LinkedList;

public class SingleTest2 {
    Node head;
    public static class Node{
        int data ;
        Node next ;
        public Node(int data){
            this.data = data;
            this.next = null ;
        }
    }


    // add a node at the head of the linked list
    public void push(int data){
        Node temp = new Node(data) ;
        if(this.head == null){
            this.head= temp ;
            return;
        }
        temp.next = head ;
        this.head = temp ;
    }


    // add the node in between of 2 nodes
    public void insert(Node previous , int data){
        Node temp = new Node(data) ;
        if(previous == null){
            System.out.println(" The previous node cannot be null ");
            return;
        }
        temp.next = previous.next ;
        previous.next = temp  ;
        return;
    }

    public void append(int data){
        if(this.head == null){
            this.head = new Node(data) ;
            return;
        }
        Node newNode = null  , temp = this.head ;
        while(temp.next != null ){
            temp = temp.next ;
        }
        newNode = new Node(data) ;
        temp.next = newNode ;
    }


    // delete a key from a linked list
    public void deleteNode(int key){
        if(this.head.data == key){
            this.head  = this.head.next ;
            return ;
        }
        else{

            Node previous = null , temp = this.head ;
            while(temp != null  && temp.data != key){
                previous = temp ;
                temp = temp.next ;
            }
            if(temp == null){
                return;
            }
            previous.next = temp.next ;
        }

    }

}
