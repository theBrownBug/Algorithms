package interviewQuestions.BST;

import java.util.LinkedList;
import java.util.Queue;

public class BSTtest3 {
    public Node root ;
    public BSTtest3(){ this.root = null ; }
    public BSTtest3(int data){ this.root = new Node(data); }

    // === TRAVERSALS -======================================================================

    // depth first traversals
    void inOrderTraversal(Node root){
        if(root == null){ return  ; }
        inOrderTraversal(root.getLeft()) ;
        System.out.println("KEY = " + root.getData());
        inOrderTraversal(root.getRight()) ;
    }

    void preOrderTraversal(Node node){
        if(node == null){return; }
        System.out.println("key = " + node.getData() );
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }
     void postOrderTraversal(Node node){
        if(node == null){return;}
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.println("Key = "+ node.getData());
    }

    // breadth first traversal
    void levelTraversal(){
        Queue<Node> queue = new LinkedList<>() ;
        queue.add(this.root) ;
        while(!queue.isEmpty()){
            Node node = queue.poll() ;
            System.out.println("Data = " + node.getData());
            if(node.getLeft()!=null){ queue.add(node.getLeft()) ; }
            if(node.getRight()!=null){ queue.add(node.getRight()) ; }
        }
    }

    //=================================================================================================================

    // misc

    // min value in the tree
    public int getMin(){
        Node temp = root ;
        if(root != null) {
            while (temp.getLeft() != null) {
                temp = temp.getLeft();
            }
            return temp.getData() ;
        }
        return Integer.MIN_VALUE ;
    }

    // max value
    public int getMax(){
        Node temp = root;
        if(root!=null){
            while(temp.getRight()!=null){
                temp = temp.getRight() ;
            }
            return temp.getData() ;
        }
        return Integer.MAX_VALUE ;
    }


    // search for an element
    Node search(Node root , int data){
        if(root== null || root.getData() == data){return  root ; }
        else if(data< root.getData()){ return search(root.getLeft() , data) ; }
        else{ return search(root.getRight() , data ) ; }
    }


    // insertion
    void insert(int key){
        root =  insertRec(root , key) ;
    }

    Node insertRec(Node node , int key){

        if (node==null){ node = new Node(key) ; }
        else if(node.getData()> key){ node.left = insertRec(node.getLeft() , key ) ; }
        else{ node.right= insertRec(node.getRight() , key ) ; }
        return node ;
    }


    // deletion

    int minValue(Node root){
        int minV = root.getData() ;
        while(root.getLeft() != null){
            minV = root.getLeft().getData() ;
            root = root.getLeft() ;
        }
        return minV ;
    }

    void delete(int key){
        root = deleteRec(root, key);
    }
    Node deleteRec(Node node ,int key){
        //base if the node is null
        if(node == null){ return  node ; }
        else if(key< node.getData()){ return deleteRec(node.getLeft() , key) ; }
        else if(key> node.getData()){ return  deleteRec(node.getRight() , key) ; }
        else{

            // if neither or one child is present
            if(node.getLeft() == null){
                return node.getRight() ;
            }
            else if(node.getRight() == null){
                return node.getLeft() ;
            }

            // find succesor and assign its key to the node
            node.data = minValue(node.getRight()) ;

            deleteRec(node.getRight() , node.data) ;
        }
        return node ;
    }


    // ================================ SUCCESSORS AND PREDECESSORS ====================================================

    Node getMinimum(Node node){
        Node current = node;
        while(current.getLeft() != null){
            current = current.getLeft() ;
        }
        return current;
    }



}
