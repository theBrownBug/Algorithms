package interviewQuestions.LinkedList;
/**
 *  Question= Given a linked list , reverse the list k nodes at a time
 * */
public class LinkedList15 {
    Node head ;
    public static class Node{
        int data ;
        Node next;
        Node(int data){
            this.data = data ;
            next = null ;
        }
    }




    Node reverse(Node head , int k ){
        Node current = head ;
        Node previous = null ;
        Node next = null ;
        int count = 0 ;
        while(current!= null && count< k ){
            next = current.next ;
            current.next = previous ;
            previous = current ;
            current = next ;
            count ++ ;
        }

        /*
        next is now a pointer to (k+1)th node
        Recursively call for the list starting from current.
        And make rest of the list as next of first node
       */

        if(next != null){
            head.next = reverse(next , k ) ;
        }
        return previous ;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }


}
