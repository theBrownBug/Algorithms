package interviewQuestions.BST;

import java.util.LinkedList;
import java.util.Queue;

public class BSTtest2 {
    Node root ;

    public BSTtest2(){
        this.root= null ;

    }    public BSTtest2(int data) {
        this.root = new Node(data);
    }

    //================ Breadth first

    public void breadthFirst(){
        Queue<Node> queue = new LinkedList<>() ;
        queue.add(root) ;
        while(!queue.isEmpty()){
            Node node = queue.poll() ;
            System.out.println("Data = "+ node.getData());
            if(node.getLeft()!=null){ queue.add(node.getLeft()) ; }
            if(node.getRight()!=null){queue.add(node.getRight()) ; }
        }

    }

    public void inOrderTraversal(Node node){
        if(node==null){ return; }
        inOrderTraversal(node.getLeft());
        System.out.println("Key" + node.getData());
        inOrderTraversal(node.getRight());
    }

    public void preOrderTraversal(Node node){
        if(node == null){ return;}
        System.out.println("Key = "+ node.getData());
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

    public void postOrderTraversal(Node node){
        if(node== null){return;}
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.println("Key = " + node.getData());
    }

    // get mim and max elements of the bst
    public int getMin(){
        Node temp = root ;
        while(temp.getLeft()!= null){
            temp = temp.getLeft() ;
        }
        return temp.getData() ;
    }

    public int getMax(){
        Node temp = root ;
        while(temp.getRight()!=null){
            temp = temp.getRight() ;
        }
        return temp.getData() ;
    }


    //===============================================================

    // search

    Node search(Node root , int key){
        // base
        if(root==null || root.getData()== key){ return root ; }
        else if(key< root.getData()){ return search(root.getLeft() , key) ; }
        return search(root.getRight() , key) ;
    }


    public void insert(int key){
        root = insertRec(root , key) ;
    }

    // insert data
    public Node insertRec(Node root , int key){
        // base
        if(root == null){ root = new Node(key) ; }
        else if( key< root.getData()){
            root.left = insertRec(root.left , key) ;
        }
        else{
            root.right = insertRec(root.right , key) ;
        }
        return  root ;
    }

    //==================================================================================================================

    // successor / predecessor

    Node getMaximum(Node node){
        Node current = node ;
        while(current.getRight()!=null){current = current.getRight() ; }
        return current ;
    }
    Node getMinimum(Node node){
        Node current = node ;
        while(current.getLeft()!= null){current = current.getLeft() ; }
        return  current ;
    }

    public Node findSuccessor(Node node, Node n){
        // if the right subtree is not null
        if(node.getRight() != null){
            return getMinimum(node.getRight()) ;
        }

        // if the right subtree is null then
        Node parent = n.getParent() ;
        while(parent != null && n == parent.getRight()){
            n = parent ;
            parent = parent.getParent() ;
        }
        return parent ;
    }

    // node n = root node
    public Node predecessor(Node node , Node n){
        // if the left subtree is not empty
        if(node.getLeft() != null){
            return getMaximum(node.getLeft()) ;
        }

        // if the left subtree is empty
        Node parent = n.getParent() ;
        while(parent!= null && n == parent.getLeft()){
            n = parent ;
            parent = parent.getParent() ;
        }
        return  parent ;
    }

    // delete nodes





}
