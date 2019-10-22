package Questions.Facebook;

public class MinDepthBST {

    public Node root ;
    public static class Node{
        int data ;
        Node left , right , parent ;
        public Node(int data){
            this.data = data ;
            this.parent = this.left = this.right = null ;
        }
    }



    public int findDepth(Node root){
        if(root == null){
            return 0 ;
        }
        if(root.left != null && root.right != null){
            return 1+  Math.min(findDepth(root.left) , findDepth(root.right) );
        }
        else if(root.left == null){
            return 1 + findDepth(root.right) ;
        }
        else{
            return 1 + findDepth(root.left) ;
        }

    }

    public static void main(String args[]){
        MinDepthBST tree = new MinDepthBST() ;
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(tree.findDepth(tree.root));
    }


}
