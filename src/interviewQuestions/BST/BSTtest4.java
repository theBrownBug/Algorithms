package interviewQuestions.BST;

import java.util.LinkedList;
import java.util.Queue;

public class BSTtest4 {

    public Node root ;
    public BSTtest4(){ this.root = null ; }
    public BSTtest4(int data){ this.root = new Node(data); }


    public Node search(Node root , int data){
        if(root == null || root.getData() == data){
            return root ;
        }
        else if(root.getData()> data){
            return search(root.getLeft() , data) ;
        }
        return search(root.getRight() , data ) ;
    }


    // insertions

    public void insert(int data){
        root = inserRec(root , data) ;
    }

    public Node inserRec(Node root , int data){
        if(root == null){return  new Node(data) ; }
        else if( data< root.getData()){
            root.left = inserRec(root.getLeft() , data) ;
        }
        else{
            root.right = inserRec(root.getRight() , data );
        }
        return  root ;
    }



    /// deletion

    int minKey(Node root){
        int minV = root.getData() ;
        while(root.getLeft() != null){
            minV = root.getLeft().getData() ;
            root = root.getLeft() ;
        }
        return minV ;
    }


    public void delete(int data){
        root = deleteRec(root , data) ;
    }

    public Node deleteRec(Node root , int data){
        if(root == null || root.getData() == data){
            return root ;
        }
        else if( data< root.getData()){
            root.left = deleteRec(root , data) ;
        }
        else if(data> root.getData()){
            root.right = deleteRec(root.getRight() , data) ;
        }
        else{

            if(root.right== null){
                return root.getLeft() ;
            }
            if(root.getLeft()== null){
                return root.getRight() ;
            }

            int minV= minKey(root.getRight()) ;
            deleteRec(root.getRight() , root.getData()) ;

        }

        return root ;
    }



    public void BFS(){
        Queue<Node> queue = new LinkedList<>() ;
        queue.add(this.root);
        while(!queue.isEmpty()){
            Node n = queue.poll() ;
            System.out.println(n.data);
            if(n.getLeft()!=null){
                queue.add(n.getLeft()) ;
            }
            else{
                queue.add(n.getRight()) ;
            }
        }

    }



}
