package interviewQuestions.LinkedList;

/**
 *  REMOVE KTH NODE FROM THE END OF A LINKED LIST
 * */

public class LinkedList18 {
    Node head ;
    public static class Node{
        int data ;
        Node next ;
        public Node(int data){
            this.data = data ; this.next = null ;
        }
    }

    public void deleteElement(int k){
        Node current = head ;
        int counter = 0 ;
        while(current!=null){
            current = current.next ;
            counter++ ;
        }
        if(k > counter){
            System.out.println("The size of the list is smaller than k ");
            return;
        }
        int elementToDelete = counter - k  - 1;
        int counter2 = 0 ;
        Node temp = head ;
        Node previous = null ;
        while(counter2<= elementToDelete){
            previous = temp ;
            temp = temp.next;
            counter2++ ;
        }
        // unlink
        previous.next = temp.next ;
    }



}
