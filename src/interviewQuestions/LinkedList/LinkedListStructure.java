package interviewQuestions.LinkedList;

public class LinkedListStructure {
    Node head;
    public static class Node{
        int data; Node next ;
        public Node(int data){
            this.data = data; this.next = null ;
        }
    }

    // push at the head of the list
    public void push(int data){
        Node newNode = new Node(data) ;
        newNode.next = head;
        head = newNode ;
    }

    // push a node in between
    public void insert(Node previous , int data){
        if(previous== null){
            System.out.println("The previous node cannot be null . ");
            return ;
        }
        Node newNode = new Node(data) ;
        newNode.next = previous.next ;
        previous.next = newNode ;
    }

    // add a node at the end of the linked List

    public void append(int data){
        Node newNode = new Node(data) ;
        if(head==null){
            this.head  = newNode ;

        }
        else {
            Node last = head ;
            while(last.next!=null){
                last= last.next ;
            }
            last.next = newNode ;
        }
    }


    // delete node from a linked list
    public void deleteNode(int key){
        if(this.head == null){
            System.out.println("The head is null");
            return;
        }
        Node   temp = head, previous = null ;

        // if the node to be removed is at the head
        if(temp!=null && temp.data == key){
            // unlink the head ;
            head  = temp.next ;
            return;
        }

        // search for the key
        while(temp.data != key && temp != null){
            previous = temp ;
            temp = temp.next ;
        }
        if(temp == null){
            System.out.println("The key is not present in the linked list ");
            return;
        }
        previous.next = temp.next ; // unlink the node from the list

    }

    public static void main(String args[]){

    }
}
