package interviewQuestions.BST;

public class BSTStructure {
    public Node root;
    public BSTStructure(){
        this.root = null ;
    }
    public BSTStructure(int data){
        this.root = new Node(data) ;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //============================================ Max AND MIN +========================================================
    public int getMin(){
        Node temp = getRoot() ;
        while(temp.getLeft()!=null){
            temp = temp.getLeft() ;
        }
        return  temp.getData() ;
    }
    public int getMax(){
        Node temp = getRoot() ;
        while(temp.getRight() != null){
            temp = temp.getRight() ;
        }
        return temp.getData() ;
    }
    // = ================================= TRAVERSALS +=================================================================

    // pre order traversal
    public void preOrderTraversal(Node node){
        if(node ==null){
            return;
        }
        System.out.println("Key = "+ node.getData()) ;
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }
    public void inorderTraversal(Node node){
        if(node== null){return ; }
        inorderTraversal(node.getLeft());
        System.out.println("Key = " + node.getData());
        inorderTraversal(node.getRight());
    }
    public void postOrderTraversal(Node node){
        if(node == null){ return; }
        System.out.println("Key  = "+node.getData());
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
    }

    // ========================================= SEARCH ==============================================//
    public Node search(Node root , int key){
        // base case
        if(root == null || root.getData() == key){return  root ; }
        else if(key< root.getData()){
            return search(root.getLeft() , key) ;
        }
        return  search(root.getRight() , key) ;
    }
    //====================== INsertion =====================================================================

    public void insert(int data){
        this.root = insertRec(root , data) ;
    }

    public Node insertRec(Node root , int data){
        if(root == null){
            root = new Node(data) ;
            return  root ;
        }
        else if(root.getData()> data){
            root.left = insertRec(root.left , data) ;
        }
        else{
            root.right = insertRec(root.right ,data ) ;
        }
        return  root ;
    }

    //----------------------------------_ DELETE KEY ==================================================================

    int minValue(Node node){
        int minVal = node.getData() ;
        while(node.getLeft()!=null){
            minVal = node.getLeft().getData() ;
            node = node.getLeft() ;
        }
        return minVal ;
    }


    public void delete(int key){
        root = deleteRec(root ,  key) ;
    }

    public Node deleteRec(Node root , int key){

        // if the tree is empty
        if(root ==null){return  root ; }
        if(key< root.getData()){
            root.left = deleteRec(root.left , key) ;
        }
        else if(key> root.getData()){
            root.right = deleteRec(root.right , key) ;
        }
        else{
            // if only child or no child is present
            if(root.left==null){ return root.right ; }
            else if(root.right== null){ return root.left ; }


            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root ;
    }


    //======================================== SUCCESSOR  AND PREDECESSOR ========================================================================

    public Node findMinNode(Node node){
        Node current = node ;
        while(current.getLeft()!=null){
            current = current.getLeft() ;
        }
        return current ;
    }

    public Node findMaxNode(Node node){
        Node current = node ;
        while(current.getRight()!=null){
            current = current.getRight() ;
        }
        return current ;
    }

    public Node successor(Node root , Node n ){
        // if the right subtree exists
        if(n.getRight()!=null){
            return findMinNode(n.getRight()) ;
        }

        // else
        Node p = n.parent ;
        while(p!=null && n == p.getRight()){
            n = p ;
            p = p.parent ;
        }
        return p;
    }


    public Node predecessor(Node root, Node n){
        // base case
        if(n.getLeft()!=null){
            return findMaxNode(n.getLeft()) ;
        }

        // else
        Node p = n.parent ;
        while(p!= null && n == p.getLeft()){
            n = p ;
            p = p.parent ;
        }
        return p ;
    }





}
