package interviewQuestions.LinkedList;

public class LinkedListTest {
    Node head;
    public static class Node{
        int data;
        Node next ;
        Node(int data){this.data = data; this.next = null; }
    }

    // push a node at the head of the list
    public void push(int data){
        Node newNode = new Node(data) ;
        if(this.head==null){
            this.head = newNode ;
        }
        else{
            newNode.next = head ;
            this.head = newNode ;
        }
    }

    // push a node in between
    public void insert(Node previous , int data){
        Node newNode = new Node(data) ;
        if(previous == null){
            System.out.println("Previous cannot be null");
            return;
        }
        else{
            newNode.next = previous.next ;
            previous.next = newNode ;
        }
    }

    // push a node at the end of the linked list
    public void append(int data){
        Node newNode = new Node(data) ;
        //if the head is empty
        if(this.head == null){
            this.head = newNode ;
            return;
        }
        Node temp = this.head ;
        while(temp.next != null){
            temp = temp.next ;
        }
        temp.next = newNode ;
    }


    public void delete(int key){
        // if the key is stored at the head
        Node temp = this.head ;
        if(temp.data  == key){
            this.head = temp.next ;
        }
        Node previous = null ;
        while(temp != null && temp.data!=key ){
            previous = temp ;
            temp = temp.next ;
        }

        if(temp == null){
            System.out.println("The key does not exist");
            return;
        }
        previous.next = temp.next ;

    }



}
