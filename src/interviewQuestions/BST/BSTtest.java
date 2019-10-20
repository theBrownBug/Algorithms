package interviewQuestions.BST;

import java.util.LinkedList;
import java.util.Queue;

public class BSTtest {
    Node root ;
    public BSTtest(int data){
        this.root = new Node(data) ;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    //======================= traversals = =======


    // depth first ;
    public void inorderTraversal(Node root){
        if(root== null){return;}
        inorderTraversal(root.getLeft());
        System.out.println("Key = "+ root.getData());
        inorderTraversal(root.getRight());
    }

    public void preOrderTraversal(Node root){
        if(root== null){ return; }
        System.out.println("Key ="+ root.getData());
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }
    public void postOrderTraversal(Node root){
        if(root==null){return; }
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.println("KEY = "+root.getData());
    }


    // breadth First (LEVEL ORDER TRAVERSAL)

    void printLevelOrder(){
        Queue<Node> queue = new LinkedList<Node>() ;
        queue.add(root) ;
        while(!queue.isEmpty()){
            Node tempNode = queue.poll() ;
            System.out.print(tempNode.data + " ");
            if(tempNode.getLeft()!=null){
                queue.add(tempNode.getLeft()) ;
            }
            if(tempNode.getRight() != null){
                queue.add(tempNode.getRight()) ;
            }
        }

    }
    //==================================================================================================================

    // get maximum and minimum values
    public int getMin(){
        Node temp = getRoot() ;
        while(temp.getLeft()!= null){
            temp = temp.getLeft() ;
        }
        return temp.getData() ;
    }

    public int getMax(){
        Node temp = getRoot() ;
        while(temp.getRight()!= null){
            temp= temp.getRight() ;
        }
        return temp.getData() ;
    }

    // SEARCH
    public Node search(Node root , int key){
        // base case
        if(root== null || root.getData()==key){ return root ; }
        else if(key< root.getData()){
            return search(root.getLeft() , key) ;
        }
        return search(root.getRight() , key) ;
    }

    //==================================================================================================================

    // insert

    public void insert(int data){
        this.root = insertRec(root , data) ;
    }

    public Node insertRec(Node root , int data){
        // base case
        if(root==null){
            root = new Node(data) ;
            return root ;
        }
        else if(root.getData()>data){
           root.left = insertRec(root.getLeft() , data) ;
        }

        root.right = insertRec(root.getRight() , data) ;

        return  root ;
    }


    // -----------------------------------------------------------------------------------------------------------------
    // successors and predecessors

    Node findMaxElement(Node root){
        Node current = root ;
        while(current.getRight() != null){
            current = current.getRight() ;
        }
        return current ;
    }

    Node findMinElement(Node root){
        Node current = root ;
        while(current.getLeft()!= null){
            current = current.getLeft() ;
        }
        return  current ;
    }

    Node successor(Node root , Node n){

        // base case  when the right subtree is not empty
        if(root.getRight()!=null){
            return findMinElement(root) ;
        }
        Node parent = n.parent ;
        while(parent!=null && n == parent.getRight()){
            n = parent ;
            parent = parent.parent ;
        }
        return parent ;
    }

    Node predecessor(Node root , Node n){
        //base case
        if(root.getLeft()!=null){
            return findMaxElement(root) ;
        }

        Node parent = n.getParent() ;
        while(parent!=null && n == parent.getLeft()){
            n = parent ;
            parent = parent.getParent() ;
        }
        return parent ;
    }

    //==================================================================================================================
    // delete a  node




}
