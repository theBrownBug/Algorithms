package interviewQuestions.BST;

public class BinaryTree {
    Node root ;

    public BinaryTree(){this.root = null ;}
    public BinaryTree(int data){ this.root = new Node(data) ; }

    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }


    public Node search(Node root , int key){

        // base case
        if(this.root == null || root.getData()== key){ return  root ; }
        else if(root.getData()>key){ return search(root.getLeft() , key) ; }
        else{ return search(root.getRight() , key) ; }
    }

    public int minValue(){
        Node temp = this.getRoot() ;
        while(temp.getLeft()!= null){
            temp = temp.getLeft() ;
        }
        return temp.getData() ;
    }

    public int maxValue(){
        Node temp = this.getRoot() ;
        while(temp.getRight()!=null){
           temp = temp.getRight() ;
        }
        return temp.getData() ;
    }

    //======================================= Traversals =======================================================//

    public void preOrderTraversal(Node node){
        if(node==null){ return; }
        System.out.println("Key = "+ node.getData()) ;
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

    public void inOrderTraversal(Node node){
        if(node == null){return; }
        inOrderTraversal(node.getLeft());
        System.out.println("Key = "+ node.getData()) ;
        inOrderTraversal(node.getRight());
    }

    public void postOrderTraversal(Node node){
        if(node==null){return; }
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.println("Key = "+ node.getData()) ;
    }

    //==================================================================================================================

    public void insert(int key){
        root = insertRec(root , key );
    }
    public Node insertRec(Node root, int key){
        if(this.root == null){
            this.root = new Node(key) ;
            return  root ;
        }
        else if(this.root.getData()> key){
            root.left = insertRec(this.root.getLeft() , key ) ;
        }
        else{
            root.right = insertRec(this.root.getRight() , key) ;
        }
        return root ;
    }

    //==========================++++++==++++++++++++DELETE ======================================================++++++=



}
