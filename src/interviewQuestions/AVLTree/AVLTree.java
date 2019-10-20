package interviewQuestions.AVLTree;

import java.util.NoSuchElementException;

public class AVLTree<Key extends Comparable<Key>, Value>{
    private Node root ;
    private class Node{
        private final Key key ;
        private Value value ;
        private int height ;
        private int size ;
        private Node left ;
        private Node right ;
        public Node(Key key , Value value , int height , int size){
            this.key = key ;
            this.value = value ;
            this.height = height ;
            this.size = size ;
        }
    }

    public AVLTree(){}
    public boolean isEmpty(){
        return root == null ;
    }


    public int size(){ return root.size ; }
    public int size(Node x){
        if(x== null){return  0 ; }
        else{return x.size ; }
    }
    public int height(){ return root.height ; }
    public int height(Node x){
        if(x== null){return 0 ; }
        else{return x.height ; }
    }


    //==================================================================================================================

    public Value get(Key key){
        if(key== null){throw  new IllegalArgumentException() ; }
        Node x = get(root , key) ;
        if(x== null){return  null ; }
        return x.value ;
    }

    private Node get(Node node , Key key){
        if(node==null){return null ; }
        int compare = key.compareTo(node.key) ;
        if(compare<0){return get(node.left , key) ; }
        else if(compare>0){return get(node.right , key) ; }
        else return node ;
    }


    //==================================================================================================================



    public boolean contains(Key key){
        return get(key) != null ;
    }



    public void put(Key key , Value value){
        if(key== null){
            throw  new IllegalArgumentException() ;
        }
        if(value == null){delete(key) ; }
        root = put(root , key , value) ;
    }

    private Node put(Node x, Key key , Value value){
        if(x== null){
            return new Node(key , value , 0 , 1 ) ;
        }
        int compare = key.compareTo(x.key) ;
        if(compare<0){
            x.left = put(x.left , key, value) ;
        }
        else if(compare>0){
            x.right = put(x.right , key , value) ;
        }
        else{
            x.value = value ;
            return x ;
        }
        x.size = 1+ size(x.left) + size(x.right)  ;
        x.height = 1 + Math.max(height(x.right) , height(x.left)) ;
        return balance(x) ;
    }

    /**
     * Restores the balance of the AVL subtree
     * */

    private Node balance(Node x){
        if(balanceFactor(x)<-1){
            if(balanceFactor(x.right)> 0){
                x.right = rotateRight(x.right) ;
            }
            x = rotateLeft(x) ;
        }
        else if(balanceFactor(x)>1){
            if(balanceFactor(x.left)>1){
                x.left= rotateLeft(x.left) ;
            }
            x = rotateRight(x) ;
        }
        return x ;
    }

    private int balanceFactor(Node x){ return height(x.left) - height(x.right) ; }

    private Node rotateRight(Node x){
        Node y = x.left ;
        x.left = y.right ;
        y.right = x ;
        y.size = x.size ;
        x.size= 1 + size(x.left) + size(x.right) ;
        x.height = 1 + Math.max(height(x.left) , height(x.left)) ;
        y.height = 1 + Math.max(height(y.left) , height(y.right)) ;
        return y ;
    }

    private Node rotateLeft(Node x){
        Node y = x.right ;
        x.right = y.left ;
        y.left = x;
        y.size = x.size ;
        x.size = 1+ size(x.right) + size(x.left) ;
        x.height = 1 + Math.max(height(x.left) , height(x.right)) ;
        x.height = 1 + Math.max(height(y.left) , height(y.right)) ;
        return y ;
    }

    public void delete(Key key) throws IllegalArgumentException{
        if(key == null){throw  new IllegalArgumentException()  ; }
        if(!contains(key)){return;}
        root = delete(root , key) ;
        //assert check() ;
    }

    private Node delete(Node node , Key key){
        int compare = key.compareTo(node.key) ;
        if(compare<0){
            node.left = delete(node.left , key) ;
        }
        else if(compare>0){
            node.right = delete(node.right , key) ;
        }
        else{
            if(node.left == null){
                return node.right ;
            }
            else if(node.right == null){
                return node.left ;
            }
            else{
                Node y = node ;
                node = min(y.right) ;
                node.right = deleteMin(y.right) ;
                node.left = y.right ;
            }
        }
        node.size = 1 + size(node.left) + size(node.right) ;
        node.height = 1 + Math.max(height(node.left) , height(node.right)) ;
        return balance(node) ;
    }


    public void deleteMin(){
        if(isEmpty()){throw new NoSuchElementException() ; }
        root = deleteMin(root) ;
      //  assert check() ;
    }

    private Node deleteMin(Node node){
        if(node.left == null){return node.right ; }
        node.left = deleteMin(node.left) ;
        node.size = 1 + size(node.left) + size(node.right) ;
        node.height = 1 + Math.max(height(node.right) , height(node.left)) ;
        return balance(node) ;
    }

    public void deleteMax(){
        if(isEmpty()){throw new NoSuchElementException() ; }
        root = deleteMax(root);
       // assert check() ;
    }

    private Node deleteMax(Node node){
        if(node.right == null){
            return node.left ;
        }
        node.right = deleteMax(node.right);
        node.size = 1 + size(node.left) + size(node.right) ;
        node.height = 1 + Math.max(height(node.right) , height(node.left)) ;
        return balance(node) ;
    }

    public Key min(){
        if(isEmpty()){throw  new NoSuchElementException() ;}
        return min(root).key ;
    }

    private Node min(Node node){
        if(node.left == null){
            return node ;
        }
        return min(node.left);
    }

    public Key max(){
        if(isEmpty()){throw  new NoSuchElementException() ;}
        return max(root).key ;
    }

    private Node max(Node node){
        if(node.right == null){
            return node ;
        }
        return max(node.right) ;
    }


    public Key floor(Key key){
        if(key == null){throw new IllegalArgumentException() ; }
        if(isEmpty()){throw  new NoSuchElementException() ; }
        Node x = floor(root , key) ;
        if(x== null){return null ;}
        else{
            return x.key ;
        }
    }


    private Node floor(Node node , Key key){
        if(node == null){
            return null ;
        }
        return null ;
    }

}
