package Questions;
/**
 * Count BST nodes that lie in a given range
 *
 * Given a Binary Search Tree (BST) and a range, count number of nodes that lie in the given range.
 * */
public class BST {

    public static class Node{
        int data ;
        Node left , right ;
        Node(int x ){
            this.data = x ;
            this.left = this.right = null ;
        }
    }

    Node root ;
    int getCount(Node node , int low, int high){
        if(node == null){return 0 ; }

        // If current node is in range, then
        // include it in count and recur for
        // left and right children of it
        if(node.data>= low && node.data<= high)
            return 1+ getCount(node.left , low , high) + getCount(node.right , low , high) ;

            // If current node is smaller than low,
            // then recur for right child
        else if(node.data<low)
            return getCount(node.right , low , high);

            // Else recur for left child
        else
            return getCount(node.left , low , high) ;
    }

    public static void main(String args[]){
        BST tree = new BST();

        tree.root = new Node(10);
        tree.root.left     = new Node(5);
        tree.root.right     = new Node(50);
        tree.root.left.left = new Node(1);
        tree.root.right.left = new Node(40);
        tree.root.right.right = new Node(100);

        int l=5;
        int h=45;
        System.out.println("Count of nodes between [" + l + ", "
                + h+ "] is " + tree.getCount(tree.root,
                l, h));

        char character = 'a' ;
        String s = String.valueOf(character+1) ;
    }

    /*
    * Time complexity of the above program is O(h + k) where h is height of BST and k is number of
    * of nodes
    * */
}
