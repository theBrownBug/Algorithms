package interviewQuestions.LinkedList;

public class LinkedList {
    Node head ;
    public static class Node{
        Node next ;
        int data ;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    // push the the node to the front of the linked list
    public void push(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.head = newNode ;
        }
        else{
            newNode.next = head ;
            this.head = newNode;
        }
    }

    // insert a node a specific location
    public void insert(Node previous , int data){
        Node newNode = new Node(data);
        if(previous ==null){
            System.out.println("Previous cannot be null");
            return;
        }
        newNode.next = previous.next ;
        previous.next = newNode ;
    }

    // insert the node at the end of the linked list
    public void append(int data){
        Node newNode = new Node(data) ;
        if(head ==null){ this.head = newNode ; }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next ;
        }
        temp.next = newNode ;
    }

    // delete a node from a list
    public void deleteNode(int key){
        // if the data is in the head of the node
        Node temp = head , previous = null ;

        if(temp.data == key){
            this.head = temp.next ; // unlink the head
        }
        while(temp.data != key && temp != null){
            previous = temp ;
            temp = temp.next ;
        }
        // check if the key is not present in the linkedlist
        if(temp==null){
            System.out.println(" The key is not present in the linked list");
            return;
        }
        previous.next = temp.next ;

    }
}
