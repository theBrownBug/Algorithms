package interviewQuestions.LinkedList;

// delete a middle element from a linked list
public class LinkedList12 {
    Node head;
    public class Node{
        Node next ; int data ;
        public Node(int data){ this.data = data ; this.next = null; }
    }
    public void deleteMiddleElement(){
        Node slowNode = this.head ;
        Node fastNode = this.head ;
        int count = 0 ;
        while(fastNode!=null && fastNode.next !=null) {
            fastNode = fastNode.next.next ;
            slowNode = slowNode.next ;
            count++ ;
        }
        Node tempNode = head;
        for(int counter = 0 ; counter < count-1 ; counter++){
            tempNode = tempNode.next ;
        }
        tempNode.next = slowNode.next ;
    }

    public static void main(String args[]){

    }

}
