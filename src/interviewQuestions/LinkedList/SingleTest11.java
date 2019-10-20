package interviewQuestions.LinkedList;

import java.awt.desktop.SystemSleepEvent;

public class SingleTest11 {
    Node head ;
    public static class Node{
        int data ;
        Node next ;
        public Node(int data){
            this.data = data ;
        }
    }
    /*
    * inserts data into the head of the new Node
    * */

    public void push(int data){
        if(this.head==null){
            this.head = new Node(data) ;
        }
        else{
            Node newNode = new Node(data) ;
            newNode.next = this.head ;
            this.head = newNode ;
        }
    }

    public void insert(Node previous , int data){
        if(previous == null){
            System.out.println("Previous cannot be null ");
            return ;
        }
        Node newNode = new Node(data) ;
        newNode.next= previous.next ;
        previous.next = newNode ;
    }

    public void add(int data){
        Node newNode = new Node(data) ;
        if(this.head == null){ this.head = newNode  ;  return; }
        Node temp= this.head;
        while(temp.next != null){
            temp= temp.next ;
        }
        temp.next = newNode ;

    }

    // delete a node

    // check the implementation....
    public void delete(int key){
        if(this.head!=null) {
            if (key == this.head.data) {
                this.head = this.head.next ;
                return;
            }
            else{
                Node temp = this.head , previous = null ;
                while(temp!= null && temp.data != key ){
                    previous = temp;
                    temp = temp.next ;
                }
                if(temp==null){
                    System.out.println("The key is not present in the linked list");
                    return;
                }
                previous.next = temp.next ;
            }
        }
    }



}
