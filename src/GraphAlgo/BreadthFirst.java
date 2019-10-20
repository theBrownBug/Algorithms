import java.io.* ; 
import java.util.* ; 

class BreadthFirst{

        private int vertices  ; // number Of vertices 
        private int LinkedList <Integer> adj[]; // adjencency list 
        
        // constructor for the BreadthFirst algorithm 
        BreadthFirst(int vertices){
        
                this.vertices = vertices ;
                adj = new LinkedList[vertices] ; 

                // A graph is a linked List of Linked Lists 
                for(int i = 0 ; i< vertices ; i++){
                        adj[v] = new LinkedList() ; 
                }
        }
        
        /**
         *adds a particular edge to a particular existing edge in the graph 
         * */
        public void addEdge(int v , int w){
                adj[v].add(w) ; 
        }
        
        // prints BFS traversal from a given source 
        public void BFS(int source){
                // by default,  set all the vertices as unvisited 
                boolean[] visited  = new boolean[vertices] ; 
                
                LinkedList<Integer> queue = new LinkedList<Integer>() ; 
                // mark the current node as visited and enque it
                queue.add(source);
                visited[source] = true; 

                while(queue.size()!=0){
                
                        // dequeue a vertex and print it 
                        s = queue.poll() ; 
                        System.out.println(s+" ") ;

                        // get all the vertices of the dequeued vertex and find all the nodes conneted to it that are unvisited 
                        Iterator<Integer> i = adj[s].listIterator() ; 
                        while(i.hasNext()){
                        
                                int n = i.next() ; 
                                if(!visited[n]){
                                        visited[n] = true ; 
                                        queue.add(n) ; 
                                }
                        }
                }

        }
        
        /// test harness 
        public static void main(String args[]){
                
                BreadthFirst graph = new BreadthFirst(4) ; // a graph with 4 vertices  

                graph.addEdge(0,1) ; // add edge 1 to edge 0 ; 
                graph.addEdge(0,2) ; 
                graph.addEdge(1,2) ; 
                graph.addEdge(2,0) ;
                graph.addEdge(2,3) ; 
                graph.addEdge(3,3) ; 
                
                graph.BFS(2)  ; 
        }

}
