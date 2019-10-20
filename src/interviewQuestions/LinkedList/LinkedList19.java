package interviewQuestions.LinkedList;

// Circular Linked List Traversal

// inserting a new node at the begining of a circular linked list

public class LinkedList19 {
    Node head ;
    public static class Node{
        int data ; Node next ;
        Node(int data){
            this.data = data ;
            this.next = null  ;
        }
    }

    public Node push(Node head , int data){
        Node newNode = new Node(data) ;
        Node temp = this.head ;
        newNode.next = head ;
        if(head != null){
            while(temp.next!= head){
                temp = temp.next  ;
                temp.next = newNode ;
            }
        }
        else{
            newNode.next = newNode ;
            head = newNode ;
        }

        return  head;
    }

    /* Function to print nodes in a
given Circular linked list */
    static void printList(Node head)
    {
        Node temp = head;
        if (head != null)
        {
            do
            { System.out.print(temp.data + " ");
                temp = temp.next;
            }
            while (temp != head);
        }
    }
}
