
/*
class Node{
    private int key ;
    Node leftNode , rightNode , parent ;


    public Node(int key){
        this.key = key ;
        leftNode = rightNode = null ;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getParent(){
        return this.parent ;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public void setParentNode(Node parent){
        this.parent = parent ;
    }
}

*/
package DS;

class Node {

    int key ;
    Node left , right , parent ;

    Node(int key){
        this.key = key ;
        left = right = parent = null ;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}