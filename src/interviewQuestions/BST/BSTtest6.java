package interviewQuestions.BST;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BSTtest6 {
    public Node root ;

    // constructors
    public BSTtest6(){
        this.root = null ;
    }
    public BSTtest6(int data){
        this.root =new Node(data) ;
    }


    // traversals
    public void inOrderTraversal(Node root){
        if(root == null){ return  ; }
        inOrderTraversal(root.getLeft()) ;
        System.out.println(root.data + " ");
        inOrderTraversal(root.getRight()) ;
    }

    public void preOrderTraversal(Node root){
        if(root == null){return; }
        System.out.println(root.data + " ");
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    public void postOrderTraversal(Node root){
        if(root == null){ return; }
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.println(root.data + " ");
    }

   public void inPlaceTraversal(){
        Queue<Node> queue = new LinkedList<>() ;
        queue.add(this.root );
        while(!queue.isEmpty()){
            Node n = queue.poll() ;
            System.out.println(n.data +  " ");
            if(n.getLeft() != null){ queue.add(n.getLeft()) ; }
            if(n.getRight() != null){ queue.add(n.getRight()) ; }
        }
    }

    // ========================= MAX AND MIN OF A TREE =================================================================

    Node minNode(){
        Node temp = this.root ;
       if(temp == null){ return null; }
       while(temp.getLeft()!= null){
            temp = temp.getLeft() ;
        }
        return temp;
    }

    Node maxNode(){
        Node temp = this.root ;
        if(temp == null){ return  null ; }
        while(temp.getRight() != null){
            temp = temp.getRight() ;
        }
        return  temp  ;
    }

    //=================================================================================================================


    // to check whether a binary search tree is a BST or not

    static boolean isBST(Node root , Node left , Node right){
        // base condition
        if(root== null){
            return true ;
        }

        if(left != null && left.getData() >= root.getData()){
            return false ;
        }

        if(right!= null && right.getData() <= root.getData()){
            return false ;
        }
        return isBST(root.getLeft() , left , root) && isBST(root.getRight()  , root , right) ;
    }



}




