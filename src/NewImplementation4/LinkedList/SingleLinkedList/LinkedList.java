package NewImplementation4.LinkedList.SingleLinkedList;

public class LinkedList <E>{
    public Node head;
    int size = 0 ;
    public static class Node<E>{
        E data ;
        Node next ;
        public Node(E data){
            this.data = data ;
            this.next = null ;
        }
    }

    // insert at the head of the linked list
    public void push(E data){
        Node newNode = new Node(data) ;
        if(this.head ==null){
            this.head = newNode ;
            this.size+=1 ;
            return;
        }

        newNode.next = this.head;
        this.head = newNode ;
        this.size += 1 ;
    }

    // insert at a particular index of the linked list
    public void insert(Node previous , E data) throws Exception{
        Node newNode = new Node(data) ;
        if(previous == null){
            throw new Exception("The previous node cannot be null") ;
        }
        newNode.next = previous.next ;
        previous.next = newNode ;
        this.size+=1 ;
    }

    // insert at the end of the linked list
    public void append(E data){
        Node newNode = new Node (data) ;
        // if the head of the linked list is empty, insert the node
        if(this.head ==  null){
            this.head= newNode ;
            this.size +=1 ;
            return;
        }
        Node temp = this.head ;
        while(temp.next != null){
            temp = temp.next ;
        }
        temp.next = newNode ;
        this.size+=1 ;
    }

    public boolean delete(E key) throws Exception{
        if(this.head == null){
            throw new Exception("The linked list is empty") ;
        }

        // if the node to be deleted is at the head  ;
        if(this.head.data.equals(key)){
            Node nextNode= this.head.next ;
            this.head.next = null ; // unlink the head to be deleted, it will be garbage collected after the sequence
            this.head = nextNode ;
            size-=1 ;
            return true ;
        }

        // start from the next node of head to avoid null pointer exception at line 82
        Node temp = this.head.next , previous = this.head ;
        while(temp!= null && !temp.data.equals(key) ){
            previous = temp ;
            temp = temp.next ;
        }
        // if the node to be deleted is not present in the linked list
        if(temp == null){
            System.out.println("The node is not present in the linked list");
            return false;
        }
        previous.next = temp.next ;
        temp.next = null ;
        size-=1 ;
        return true ;
    }


}
