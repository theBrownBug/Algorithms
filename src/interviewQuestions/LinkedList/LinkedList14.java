package interviewQuestions.LinkedList;

/*
*  REVERSE A LINKED LIST
* */

public class LinkedList14 {
    static Node head ;
    public static class Node{
        int data  ;
        Node next ;
        Node(int data){
            this.data = data;
            next = null ;
        }
    }

    /*
    *  DOUBT
    * */
    Node reverse(Node node){
        Node previous = null ;
        Node current = head ;
        Node next = null ;
        while(current != null){
            next = current.next ;
            current.next = previous ;
            previous = current ;
            current = next ;
        }
        node = previous ;
        return  node ;
    }

}
