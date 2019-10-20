package DS;
class LinkedList{
        
        static Node head ; // head of the node
        

        /*
         *DOubt ??
         *The inner class is made static so that Main() can access it ...???
         *
         * */

        static class Node{
        
                int data; 
                Node next ; 
                // constructor ; 
                Node(int d){
                
                        data = d ; 
                        next = null ; }

                public void printNode(){
                        System.out.print(data+" ") ; 
                }
        }
        

        /**
         *
         *inserting an element in the linked List at the head 
         * */
        public void push(int data){
                
                Node newNode = new Node(data) ; 
                newNode.next = head ;
                head  = newNode; 

        }

        /**
         *
         *inserting a node in btw 
         */

        public void insert(Node previous, int data){
                if(previous ==null){
                        System.out.println("New node cannot be null") ; 

                }
                Node newNode = new Node(data) ; 

                newNode.next = previous.next ; 
                previous.next = newNode ; 
        
        }


        // adding a node at the end of the linked List 
        public void append(int data){
        
                Node newNode = new Node(data) ; 

                if(head ==null){
                        head = new Node(data) ; 
                        return ; 
                }
                newNode.next = null  ;
                Node last = head ;
                while(last.next!=null){
                        last = last.next ; 
                }

                last.next = newNode ; 
        }

        
        public void deleteNode(int key){
        
                Node temp = head , previous = null ; 

                // if the head contains the key to be deleted, then just 
                if(temp!= null && temp.data == key){
                        // unlink the head  ; 
                        
                       head = temp.next ; 
                       return ;}

                // search for the key 
                while(temp!=null && temp.data!= key){
                        previous = temp  ; 
                        temp = temp.next ; 
                         
                }
                // if the key is not present in the linked List 
                if(temp==null){
                       return ;  
                }

                // unlink the node ; 
                previous.next = temp.next ; 

        
        }

        /**
         *prints all the nodes of the LinkedList 
         * */
        public void printList(LinkedList l){
                        
                Node n = head ; 
                while(n!= null){
                System.out.print(n.data+" ") ; 
                n = n.next ; 
                }
        }

        public static void main(String args[]){
        
                LinkedList ll = new LinkedList() ; 
                // creating 3 new nodes ; 
                
                Node head = new Node(1) ; 
                Node secondNode= new Node(2) ; 
                Node thirdNode = new Node(3) ; 
        
                // connecting all the 3 nodes ; 

                head.next = secondNode  ;
                secondNode.next  = thirdNode ;

        }

}
