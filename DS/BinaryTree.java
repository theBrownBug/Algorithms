package DS;
/**
 *
 * this binary tree assumes that no two keys have the same value
 * */
public class BinaryTree {

    public class Node {

        public Node right , left, parent ;
        public int key ;

        public Node(int key){
            this.key  = key ;
            this.left = this.right = this.parent  = null ;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }
    }

    public Node root ;
    public BinaryTree(int key){ this.root = new Node(key) ;}
    public BinaryTree(){ setRoot(null); }


    public void insert(BinaryTree tree, Node node){
        Node trailingPointer = null ;
        Node root = tree.getRoot() ;
        while(root!=null){
            trailingPointer = root ;
            if(root.getKey()> node.getKey()){ root = root.getLeft() ; }
            else{ root = root.getRight() ; }
        }
        node.setParent(trailingPointer);
        if(trailingPointer==null){ tree.setRoot(node); }
        if(node.getKey()>trailingPointer.getKey()){trailingPointer.setLeft(node);}
        else{trailingPointer.setRight(node) ; }
    }
    // O(h)
    public Node search(Node root ,int key){
        if(root.getKey()==key || root==null){return root ; }
        if(root.getKey()> key){ search(root.getLeft() , key) ; }
        else if(root.getKey()< key){ search(root.getRight() ,key) ;  }
        return root ;
    }

    public Node getSuccessor(Node node){
        Node parent = null ;
        if(node.getRight()!=null){ getMinimum(node.getRight()) ; }
        else{
             Node current = node;
             parent = node.getParent() ;
             while(parent!=null && current== parent.getRight()){
                 current= parent ;
                 parent = parent.getParent() ;
             }
            // if the parent is null and there are no right children // it is a left skewed tree , then just
            // return the parent of the current node
            return parent ;
            }
            return parent ;
    }

    public Node getPredecessor(Node node){
        Node parent = null ;
        if(node.getLeft()!=null){return getMaximum(node.getLeft()) ; }
        else{
            parent = node.getParent() ;
            Node current = node ;
            while(parent!=null && current==parent.getLeft()){
                current = parent ;
                parent = parent.getParent() ;
            }
        }
        return parent ;

    }

    public void transplant(BinaryTree tree , Node toBeReplaced , Node replacementNode){
        if(toBeReplaced.getParent()==null){ tree.setRoot(replacementNode); }
        else if(toBeReplaced==toBeReplaced.getParent().getLeft()){ toBeReplaced.getParent().setLeft(replacementNode); }
        else{ toBeReplaced.getParent().setRight(replacementNode);}

        if(replacementNode!=null){ replacementNode.setParent(toBeReplaced.getParent()); }
    }

    public void deleteNode(BinaryTree tree , Node toBeDeleted){
        if(toBeDeleted.getLeft()== null){ transplant(tree , toBeDeleted , toBeDeleted.getRight());}
        else if(toBeDeleted.getRight()==null){ transplant(tree , toBeDeleted , toBeDeleted.getLeft());}
        else{
            Node successor = getSuccessor(toBeDeleted) ;
            if(successor.getParent()!= toBeDeleted){
                transplant(tree , successor , successor.getRight());
                successor.setRight(toBeDeleted.getRight()) ;
                successor.getRight().setParent(successor);
            }
            transplant(tree , toBeDeleted, successor);
            successor.setParent(toBeDeleted.getLeft());
            successor.getLeft().setParent(successor);
        }

    }

    public Node getMinimum(Node node){
        Node mini = node ;
        while(mini.getLeft()!= null){ mini = mini.getLeft() ; }
        return mini;
    }
    public Node getMaximum(Node node){
        Node max = node ;
        while(node.getRight()!= null){ max = max.getRight() ; }
        return  max;
    }
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        Node r = new Node(root.getKey()) ;
        this.root = r;
    }
}
