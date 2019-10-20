package interviewQuestions.Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTest2 {
    int V ;
    LinkedList<Integer> adjList [] ;
    public GraphTest2(int n){
        this.V = n ;
        this.adjList = new LinkedList[V] ;
        for(LinkedList l : adjList){
            l= new LinkedList() ;
        }
    }

    public void breadthFirst(int s){
        boolean[] visited = new boolean[V] ;
        Queue<Integer> queue = new LinkedList<>() ;
        queue.add(s) ;
        visited[s] = true ;
        while(!queue.isEmpty()){
            int i = queue.poll();
            System.out.println("i = "+i);
            Iterator<Integer> iterator = adjList[i].listIterator() ;
            while(iterator.hasNext()){
                int temp = iterator.next() ;
                if(!visited[temp]){
                    visited[temp]  = true ;
                    queue.add(temp) ;
                }
            }
        }
    }

    //===================================+++++ DFS =====================================================================

    public void DFS(int s){
        boolean[] visited = new boolean[V] ;
        DFSUtil(s , visited) ;
    }

    public void DFSUtil(int source, boolean[] visited){
        visited[source] = true ;
        System.out.println(source + " ");
        Iterator<Integer> iterator = adjList[source].iterator() ;
        while (iterator.hasNext()){
            int i = iterator.next() ;
            if(!visited[i]){
                DFSUtil(i ,visited);
            }
        }
    }


    //======================================+ PRIM +===============================================


    // MINIMUM SPANNING TREES

    int minKey(int[] key, Boolean[] mstSet){
        int min = Integer.MAX_VALUE , minIndex = -1 ;
        for(int counter = 0 ; counter< this.V ; counter++){
            if(!mstSet[counter] && key[counter] < min){
                min = key[counter] ;
                minIndex = counter ;
            }
        }
        return minIndex ;
    }


    // A utility function to print the constructed MST stored in
    // parent[]
    void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }


    void primMST(int[][] graph){
        int[] parent = new int[V] ;
        int[] key = new int[V] ;
        Boolean[] mstSet = new Boolean[V] ;
        // initialize
        for(int counter = 0 ; counter< V ; counter++){
            key[counter] = Integer.MAX_VALUE ;
            mstSet[counter]= false  ;
        }

        key[0] = 0 ; parent[0] = -1;

        for(int counter = 0 ; counter< V  ; counter++){
            // get the index with the smallest key value to include in the mst Set
            int u = minKey(key , mstSet) ;
            // include that index in the mst Set
            mstSet[u] = true ;

            for(int counter2 = 0  ;counter2 < V ; counter2++){

                if(graph[u][counter2]!=0 && mstSet[counter2]==false && graph[u][counter2]< key[counter2]){
                    parent[counter2] = u ;
                    key[counter2] = graph[u][counter2] ;
                }
            }
            printMST(parent , graph);
        }
    }


    //==================================================================================================================



}
