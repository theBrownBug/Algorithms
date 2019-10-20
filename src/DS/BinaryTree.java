package DS;


class BinaryTree{

    Node root ;

    public BinaryTree(){
        this.root = null ;
    }
    public BinaryTree(int key ){
        this.root = new Node(key) ;

    }
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }

    public printPreOrder(Node node){
        if(node = null){
            return ;
        }
        System.out.println("Key  = " + node.getKey()) ;
        printPreOrder(node.leftNode) ;
        prinrPreOrder(node.rightNode) ;
    }

    public printPostOrder(Node node){
        if(node==null){
            return ;
        }
        printPostOrder(node.leftNode) ;
        printPostOrder(node.rightNode) ;

        System.out.println("Key = "+ node.getKey()) ;
    }

    public printInOrder(Node node){

        if(node==null){
            return ;
        }
        printInOrder(node.leftNode) ;
        System.out.println("Key = "+ node.getKey()) ;
        printInOrder(node.rightNode) ;
    }






    public void insertNode(){}


    /**
     * @param   Node  The root node of the Binary Search Tree
     * @param   Key   The key to be searched
     *
     * returns The Node having the key ;
     * Time complexity = O(h)
     *
     * Recursive Tree Search
     * */

    public Node search(Node root , int key){
        // base Case
        if(root==null || root.getKey()==key){
            return root ;
        }
        // if the Node's key is smaller than that of root's key
        else if(root.getKey() > key){
            return search(root.leftNode , key) ;
        }

        // if the
        else if(root.getKey()< key){
            return search(root.rightNode , key) ;
        }

    }


    /**
     *@param
     *Iterative Tree Search
     *
     */

    public Node iterativeSearch(BinaryTree tree , int key){

        Node root  = tree.getRoot() ;

        while (root != null|| root.getKey() != key){

            if(root.getKey()> key){
                root = root.leftNode ;
            }
            else if (root.getKey()<key){
                root = root.rightNode ;
            }
        }
        return root ;
    }

    /**
     * @param   Node
     * successor is the minimum element in the right subtree of the node
     * */

    public Node successor(Node node){
        Node y ;
        if(node.rightNode != null) {
           y =  minValue(node.rightNode) ;
        }
        return y ;
    }

    /**
     *
     *This just returns the element that is the predeccessor and doesnt set anything
     * predecessor is the maximum element in the left subtree
     * */

    public Node predeccesor(Node node){
       Node y ;
        if(node.leftNode != null){
           y =  maxValue(node.leftNode) ;
        }
        return  y  ;
    }




    public Node minValue(Node node){
        Node current = node ;
        while(current.leftNode !=null){
            current = current.leftNode ;
        }
        return current.getKey() ;
    }

    public Node maxValue(Node node){
        Node current = node ;
        while(current.rightNode != null){
            current = current.rightNode ;
        }
        return current.getKey() ;
    }






    void printPostOrder(){
        printPostOrder(getRoot());
    }
    void printPreOrder(){
        printPreOrder(getRoot());
    }

    void printInOrder(){
        printInOrder(getRoot());
    }






    /*
    * Driver Code
    * */

    public static void main(String args[]){

        BinaryTree tree = new BinaryTree(100) ;
        tree.root.leftNode = new Node(99) ;
        tree.root.rightNode  = new Node(101) ;

        tree.root.leftNode.leftNode = new Node(98) ;
        tree.root.leftNode.rightNode = new Node(102) ;

        tree.root.rightNode.leftNode = new Node(90) ;
        tree.root.rightNode.rightNode = new Node(104) ;

    }



}