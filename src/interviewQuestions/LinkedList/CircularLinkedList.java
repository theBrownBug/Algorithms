package interviewQuestions.LinkedList;

public class CircularLinkedList {
    Node head ;
    static class Node{
        int data ; Node next ;
        public Node(int data){
            this.data = data ; this.next = null ;
        }
    }

    Node addToEmpty(int data){
        if(this.head!=null){
            System.out.println("The head is not empty");
            return null ;
        }
        Node node = new Node(data) ;
        this.head = node ;
        this.head.next = node ;

        return head;
    }


}
