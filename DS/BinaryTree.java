package DS;

import java.util.Scanner;

/**
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
        public Node getRight() { return right; }
        public void setRight(Node right) { this.right = right; }
        public Node getLeft() { return left;}
        public void setLeft(Node left) { this.left = left; }
        public Node getParent() { return parent; }
        public void setParent(Node parent) { this.parent = parent; }
        public int getKey() { return key; }
        public void setKey(int key) { this.key = key; }
    }

    public Node root ;
    public BinaryTree(int key){ setRoot(new Node(key)) ;}
    public BinaryTree(){ this.root = null ;  }


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
        else if(node.getKey()>trailingPointer.getKey()){trailingPointer.setLeft(node);}
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
    public Node getRoot() { return root; }
    public void setRoot(Node root) {
        Node r = new Node(root.getKey()) ;
        this.root = r;
    }

    public static void randomTree(BinaryTree tree){
        int random = (int) (Math.random()*100);
        tree = new BinaryTree() ;
        for(int counter = 0 ; counter< random ; counter++){
            BinaryTree.Node node = tree.new Node((int)Math.random() *100) ;
            tree.insert(tree , node);
        }

    }
    public static void randomTree(BinaryTree tree , int nunberOfNodes){
        int numNodes = nunberOfNodes ;
        tree = new BinaryTree() ;
        for(int counter = 0 ; counter< numNodes ; counter++){
            BinaryTree.Node node = tree.new Node((int)Math.random() *100) ;
            tree.insert(tree , node);
        }
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in) ;
        BinaryTree tree = null ;
        int iterator =  0 ;
        do{
            System.out.println("Select one of the options : ") ;
            System.out.println("1.  Create a random tree  with random number of nodes");
            System.out.println("2.  Create a random tree with specified number of nodes");
            System.out.println("3.  Create an empty tree");
            System.out.println("4.  Insert Node");
            System.out.println("5.  Delete Node");
            System.out.println("6.  Find maximum");
            System.out.println("7.  Find minimum");
            System.out.println("8.  Find Successor");
            System.out.println("9.  Find Predecessor");
            System.out.println("-1. Exit the program");
            iterator = Integer.parseInt(input.nextLine().trim()) ;

            switch (iterator){
                case(1):
                    tree = new BinaryTree() ;
                    BinaryTree.randomTree(tree);
                    break ;
                case(2):
                    tree = new BinaryTree() ;
                    int numberOfNodes = Integer.parseInt(input.nextLine().trim()) ;
                    randomTree(tree, numberOfNodes);
                case(3):
                    tree = new BinaryTree() ;
                    break ;
                case(4):
                    if(tree!=null){
                        System.out.println("Enter the key of the node") ;
                        int key = Integer.parseInt(input.nextLine().trim()) ;
                        Node node = tree.new Node(key) ;
                        tree.insert(tree, node);
                    }else{System.out.println("Create a new tree first");}
                case(5):
                    if(tree!=null) {
                        System.out.println("Enter the key of the node to be deleted");
                        int key = Integer.parseInt(input.nextLine().trim()) ;
                        Node toBeDeleted = tree.search(tree.getRoot() , key) ;
                        if(toBeDeleted ==null){
                            System.out.println("There is no node with the specified key") ;
                            break ;
                        }
                        else{ tree.deleteNode(tree, toBeDeleted); break ; }
                    } else{System.out.println("Create a new tree first");}
                    break ;
                case(6):
                    if(tree!=null){
                        Node max = tree.getMaximum(tree.getRoot()) ;
                        System.out.println("The node with maximum key is "+ max.getKey()) ;
                    }else{System.out.println("Create a new tree first");}
                    break ;
                case(7):
                    if(tree!=null){
                        Node min = tree.getMinimum(tree.getRoot()) ;
                        System.out.println("The node with the minimum key is"+ min.getKey()) ;
                    } else{ System.out.println("Create a new tree first") ;}
                    break ;
                case(8):
                    if(tree!=null){
                        System.out.println("Enter the key of node to find its successor") ;
                        int key = Integer.parseInt(input.nextLine().trim()) ;
                        Node toBeFound = tree.search(tree.getRoot() , key) ;
                        if(toBeFound!=null){
                            Node successor = tree.getSuccessor(toBeFound);
                            System.out.println("The successor of the node  with the key "+toBeFound.getKey()+" is "+ successor.getKey()) ;
                        } else{ System.out.println("Node not found"); break ; }
                    }else{System.out.println("Create a new tree first");}
                    break ;
                case (9):
                    if(tree!=null){
                        System.out.println("Enter the key of node to find its predecessor") ;
                        int key = Integer.parseInt(input.nextLine().trim()) ;
                        Node toBeFound = tree.search(tree.getRoot() , key) ;
                        if(toBeFound!=null){
                            Node pred = tree.getPredecessor(toBeFound);
                            System.out.println("The Predecessor of the node  with the key "+toBeFound.getKey()+" is "+ pred.getKey()) ;
                        } else{ System.out.println("Node not found"); break ; }
                    }else{System.out.println("Create a new tree first");}
                    break ;
                case(-1):
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid option from the above");
                    break ;

            }

        }
        while(iterator!= -1) ;

    }
}

