package interviewQuestions.LinkedList;

public class DoubleLinkedList {
    Node head ;
    static class Node{
        Node next , previous ;
        int data ;
        Node(int data){
            this.data = data;
            this.next = this.previous = null ;
        }
    }

    //  push the data in front of the linked list
    public void push(int data){
        Node newNode = new Node(data) ;
        if(this.head == null){
            this.head = newNode ;
            return;
        }
        newNode.next = head ;
        head.previous = newNode ;
        head = newNode ;
    }


    // insert a node after a  particular node
    public void insert(Node previousNode , int data){
        if(previousNode==null){
            System.out.println("The previous node cannot be null .");
            return;
        }
        Node newNode = new Node(data) ;
        newNode.previous = previousNode ;
        newNode.next = previousNode.next ;
        previousNode.next = newNode ;
        if(newNode.next != null) {
            newNode.next.previous = newNode;
        }
    }

    // insert a node at the end of the linked list
    public void append(int data){
        Node newNode = new Node(data) ;
        Node temp= this.head ;
        if(temp == null){
            this.head = newNode ;
            return;
        }
        while(temp.next != null){
            temp= temp.next ;
        }
        temp.next = newNode ;
        newNode.previous = temp ;
    }

    // This function prints contents of linked list starting from the given node
    public void printlist(Node node)
    {
        Node last = null;
        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.previous;
        }
    }

}
