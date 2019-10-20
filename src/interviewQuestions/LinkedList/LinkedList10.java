package interviewQuestions.LinkedList;

//  Question - find the middle of the linkedlist
public class LinkedList10 {
    Node head ;
    public static class Node{
        int data ;
        Node next ;
        public Node(int data){
            this.data = data;
            this.next = null ;
        }
    }

    // make 2 pointers
    // slow pointer
    // fast pointer
    public void middleElement(){
        Node slowPointer = this.head ;
        Node fastPointer = this.head ;
        if (this.head !=null) {
            while (fastPointer != null && fastPointer.next != null) {
                fastPointer = fastPointer.next.next;
                slowPointer = slowPointer.next;
            }
        }
        System.out.println(" The middle element is " + slowPointer.data);
    }

    // count the elements in the 1st go
    // then iterate till count/2 on the second go
    public void findMiddleElement2(){
        int counter = 0 ;
        Node temp = this.head ;
        if(temp !=  null){
            temp = temp.next ;
            counter++ ;
        }
        Node temp2 = head ;
        for(int i = 0 ; i < counter/2 ; i++){
            temp2 = temp2.next ;
        }
        System.out.println(temp2.data);
    }

}
