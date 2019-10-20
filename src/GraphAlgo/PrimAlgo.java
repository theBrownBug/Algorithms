package GraphAlgo;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.* ;
import java.io.* ;
import java.lang.* ;

public class PrimAlgo {

    // NUmber of vertices on a graph = 5 , in this instance
    private static final int V = 5;

    protected int minKey(int[] key , Boolean[] mstSet){

        // initialise the minimum value
        int min = Integer.MAX_VALUE , minIndex = -1;

        for(int vertex = 0 ; vertex< V ;vertex++){
            if(mstSet[vertex]==false && key[vertex]< min){

                min = key[vertex];
                minIndex = vertex ;
            }

        }
        return  minIndex  ;

    }

    // a utility function to print the Constructed MST stored in the parent

    protected void printMST(int[] parent , int n , int[][] graph){

            System.out.println("EDGE WEIGHT");
            for(int i = 1 ; i < V ; i++){

                System.out.println(parent[i]+" - "+i+" "+graph[i][parent[i]]) ;
            }

    }

    // function to print the MST FOR A GRAPH REPRESENTED USING ADJENCY MATRIX representation
    public void primMST(int[][] graph){

        int[] parent = new int[V] ; // array to store the constructed MST
        int[]  key = new int[V] ;   // key values to pick minimum weight in cut
        Boolean[] mstSet = new Boolean[V] ;

        // initialise all the keys as infinite

        for(int i = 1; i< V ; i++){
            key[i] = Integer.MAX_VALUE ;
            mstSet[i] = false;
        }

        key[0] = 0 ;
        parent[0] = -1 ;

        for(int count = 0 ; count<V-1 ; count++){
            // pick the minimum key vertex from the set of vertices not included in the MST
            int u = minKey(key , mstSet) ;
            // add the picked vertex to the MST SET
            mstSet[u] = true ;

            for(int v = 0 ; v < V ; v++){

                if(graph[u][v]!= 0 && mstSet[v] == false && graph[u][v] < key[v]){
                    parent[v] = u ;
                    key[v] = graph[u][v] ;

                }
            }
        }
        printMST(parent,V, graph);
    }

    public static void main(String args[]){

        PrimAlgo test = new PrimAlgo() ;
        int[][] graph = new int[][]{{0,2,0,6,0} , {2,0,3,8,5} ,{ 0,3,0,0,7} , { 6,8,0,0,9} ,{0,5,7,9,0} } ;
        test.primMST(graph);

    }

}
