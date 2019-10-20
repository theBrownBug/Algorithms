package interviewQuestions.LinkedList;

/*
* Remove all the duplicates from an unsorted linked list
* implement a hash set and unlink any elements that are duplicates
* */

import java.util.HashSet;

public class LinkedList13 {
    public class Node{
        int data ; Node next ;
        Node(int data){ this.data = data ; }
    }

    public static void removeDuplicates(Node head){
        HashSet<Integer> set = new HashSet<>()  ;
        Node current = head ;
        Node previous = null ;
        while(current!=null){
            int currentVal = current.data ;
            // if the set already contains the data , then unlink the element
            if(set.contains(currentVal)){
                previous.next = current.next ;
            }
            else{
                set.add(currentVal) ;
                previous = current ;
            }
            current = current.next ;
        }

    }
}
