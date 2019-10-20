package interviewQuestions.BST;

public class BSTtest5 {
    Node root ;
    public BSTtest5(){ this.root = null ; }
    public BSTtest5(int data ){ this.root = new Node(data) ; }
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }

    public Node search(int data , Node root){
        if(root == null || root.getData()== data){
            return root;
        }
        else if(root.getData()> data){
            return search(data, root.getLeft()) ;
        }
        else{
            return search(data , root.getRight()) ;
        }
    }


    // Node max and min
    public Node getMax(){
        Node temp = this.root ;
        if(temp== null){
            return null ;
        }
        else{
            while(temp.getRight() != null){
                temp = temp.getRight() ;
            }
            return temp ;
        }
    }

    // Node get min
    public Node getMin(){
        Node temp = this.root ;
        if(temp == null){
            return  null;
        }
        else{
            while(temp.getLeft() != null ){
                temp = temp.getLeft() ;
            }
            return temp ;
        }
    }

    // insert operations


}
