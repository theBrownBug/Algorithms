package interviewQuestions.BST;

import java.util.LinkedList;
import java.util.Queue;

public class BSTtest8 {
    Node root ;
    public BSTtest8(){this.root = null ; }
    public BSTtest8(int i){this.root = new Node(i) ; }

    // ==================== Traversals ============================
    public void inOrderTraversal(Node root){
        if(root ==null){ return ; }
        inOrderTraversal(root.getLeft()) ;
        System.out.println(root.data + " ");
        inOrderTraversal(root.getRight()) ;
    }

    public void preOrderTraversal(Node root){
        if(root==null){return;}
        System.out.println(root.data);
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    public void postOrderTraversal(Node root){
        if(root == null){return;}
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.println(root.data);
    }

    public void BFS(Node root){

        Queue<Node> queue = new LinkedList<>() ;
        queue.add(root) ;
        while(!queue.isEmpty()){
            Node n = queue.poll() ;
            System.out.println(n.data + " ");
            if(n.getLeft()!=null){
                queue.add(n.getLeft()) ;
            }
            if(n.getRight()!=null){
                queue.add(n.getRight()) ;
            }
        }
    }


    //===================== search=============

    public Node search(Node root, int key){
        if(root == null || root.getData() ==key){
            return root ;
        }
        else if(root.getData() > key){
            return search(root.getLeft() , key) ;
        }
        return search(root.getRight() , key) ;
    }


    public Node getMin(){
        if(root==null){return null;}
        Node temp = root ;
        while(temp.getLeft() != null){
            temp = temp.getLeft() ;
        }
        return temp ;
    }

    public Node getMax(){
        if(root== null){return  null ; }
        Node temp = root ;
        while(temp.getRight()!=null){
            temp = temp.getRight() ;
        }
        return  temp ;
    }

    public void insert(int key){
        this.root = insertRec(root, key);
    }
    public Node insertRec(Node node , int key){
        if(node==null){return new Node(key) ; }
        else if(node.getData()>key){
            node.left= insertRec(node.getLeft() , key) ;
        }
        else{
            node.right = insertRec(node.getRight() , key) ;
        }
        return node ;
    }
}
