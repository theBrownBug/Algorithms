
package DS;
class Traversal{


    public static void inOrderTraversal(Node root){

        if(root ==null){return ;}
        inOrderTraversal(root.getLeft()) ;
        System.out.println("The key of the node is " + root.getKey()) ;
        inOrderTraversal(root.getRight()) ;

    }


    public static void postOrderTraversal(Node root){
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.println("The key of the node is " + root.getKey()) ;

    }

    public static void preOrderTraversal(Node root){
        System.out.println("The key of the node is " + root.getKey()) ;
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }
}