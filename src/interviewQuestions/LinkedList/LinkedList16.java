package interviewQuestions.LinkedList;

/**
 *  Detect a loop in a linked list
 *
 *  Floyd's Cycle Detection
 *
 *  Solution = use the multiple pointers like the slow pointer and the fast pointer
 *
 *  Time Complexity: O(n)
 *  Auxiliary Space: O(1)
 *
 * */
public class LinkedList16 {
    Node head;
    public static class Node{
        int data ;
        Node next ;
        public Node(int data){
            this.data = data ; this.next = null ;
        }
    }

    public void push(int data){
        Node toPush = new Node(data) ;
        if(head==null){
            this.head = toPush ;
        }
        toPush.next = head ;
        this.head = toPush ;
    }

    int detectLoop(){
        Node slowPointer = head , fastPointer = head ;
        while (slowPointer!=null && fastPointer!=null && fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next ;
            if(slowPointer == fastPointer){
                return 1 ;
            }
        }
        return  0 ;
    }



}
