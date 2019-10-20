package interviewQuestions.BST;

public class Node {
    Node left ,right , parent ;
    int data ;
    Node(int data){
        this.data = data ;
        left = right = parent = null ;
    }
    public Node getLeft() { return left; }
    public void setLeft(Node left) { this.left = left; }
    public Node getRight() { return right; }
    public void setRight(Node right) { this.right = right; }
    public Node getParent() { return parent; }
    public void setParent(Node parent) { this.parent = parent; }
    public int getData() { return data; }
    public void setData(int data) { this.data = data; }
}

