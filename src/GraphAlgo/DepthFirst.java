import java.util.* ; 
import java.io.* ; 

class DepthFirst{

        private int vertices ; 
        private LinkedList<Integer>adj[] ; 

        public DepthFirst(int vertices){
                this.vertices = vertices ; // number of vertices of the graph 
                this.adj = new LinkedList[vertices] ; 

                for(int counter= 0 ; counter< vertices ; counter++){
                
                        adj[counter] = new LinkedList()
                }
        
        }

        // add edges 
        public void addEdge(int v , int w){
                adj[v].add(w) ; // add the vertex w to v's existing list 
        
        }

        public void DFSUTIL(int v, boolean[] visited){
        
                // mark the current node as visited 
                visited[v] = true; 
                System.out.println( v + " ") ; 

                 // recursively applu DFS for all the vertices following this vertex 

                Iterator <Integer> i = adj[v].listIterator() ; 
                while(i.hasNext()){
                
                        int n = i.next() ; 
                        if(!visited[n]){
                                DFSUtil(n, visited) ; 
                        }
                
                }
        }
        
        public void  DFS(int v){
                boolean[] visited = new boolean[v] ; 
                DFSUtil(v,visited) ; 
        
        }

        public static void main(String args[]){
        
                DFS sample = new DFS(4) ; 
                sample.addEdge(0,1) ; 
                sample.addEdge(0,2) ; 
                sample.addEdge(1,2) ; 
                sample.addEdge(2,0) ; 
                sample.addEdge(2,3) ;
                sample.addEdge(3,3) ; 

                g.DFS() ; 
        }

}
