package interviewQuestions.LinkedList;

// flatten a linked list
public class LinkedLIst11 {
    Node head ;
    public static class Node{
        int data ;
        Node next , down ;
        public Node(int data){
            this.data = data ;
            this.next = this.down = null ;
        }
    }


    Node merge(Node a  , Node b ){

        // if the first linked list is empty the second is the answer
        if(a==null){ return b ; }

        if(b == null ){return  a ; }

        Node result ;
        if(a.data< b.data){
            result = a;
            result.down = merge(a.down , b) ;
        }
        else{
            result = b ;
            result.down = merge(a , b.down);
        }
        return result ;
    }

    Node flatten(Node root){
        // base case
        if(root==null || root.next==null){
            return  root ;
        }
        root.next = flatten(root.next) ;
        root = merge(root , root.next) ;

        return  root ;
    }


}
