package interviewQuestions.Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTest5 {

    public int V ;
    public LinkedList<Integer> adjList[] ;

    // declare the
    public GraphTest5(int i){
        this.V = i ;
        this.adjList = new LinkedList[i] ;
        for(int counter =0 ; counter< V; counter++){
            this.adjList[counter] = new LinkedList<>() ;
        }
    }

    public void BreadthFirstSearch(int src) {
        Boolean[] visited = new Boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src) ;
        while(!queue.isEmpty()){
            int i = queue.poll() ;
            System.out.println(i+ " ");
            Iterator<Integer> iterator = adjList[i].listIterator() ;
            while(iterator.hasNext()){
                int j = iterator.next() ;
                if(!visited[j]){
                    visited[j] = true ;
                    queue.add(j) ;
                }
            }
        }
    }

    public void DFS(int src){
        Boolean[] visited = new Boolean[V] ;
        DFSUtil(src , visited) ;
    }

    public void DFSUtil(int src, Boolean[] visited){
        visited[src] = true ;
        System.out.println(src + " ");
        Iterator<Integer> iterator = adjList[src].listIterator() ;
        while(iterator.hasNext()){
            int i=  iterator.next() ;
            if(!visited[i]){
                DFSUtil(i , visited);
            }
        }
    }

    //=========================== DJIKSTRA =========================

    public int minDistance(int[] distance , Boolean[] sptSet){
        int min = Integer.MAX_VALUE ;
        int minIndex  = -1 ;
        for(int counter = 0 ; counter < V ;counter++){
            if(!sptSet[counter] && distance[counter]< min){
                min = distance[counter] ;
                minIndex = counter ;
            }
        }
        return minIndex ;
    }

    public void Djikstra(int[][] graph , int src) {
        int[] distance = new int[V];
        Boolean[] sptSet = new Boolean[V];
        for (int counter = 0; counter < V; counter++) {
            sptSet[counter] = true;
            distance[counter] = Integer.MAX_VALUE;
        }
        distance[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            int u = minDistance(distance, sptSet);
            sptSet[u] = true;
            for (int counter = 0; counter < V; counter++) {
                if (!sptSet[counter]
                        && graph[u][counter] != 0
                        && distance[u] != Integer.MAX_VALUE
                        && distance[u] + graph[u][counter] < distance[counter]) {
                    distance[counter] = distance[u] + graph[u][counter];
                }
            }
        }

    }
        // ============================== PRIM's ALGORITHM ============================================================

        int minKey(int[] key , Boolean[] mstSet){

            int min = Integer.MAX_VALUE ;
            int minIndex = -1 ;
            for(int counter = 0 ; counter< V; counter++){
                if(!mstSet[counter] && key[counter]< min){
                    min = key[counter] ;
                    minIndex = counter ;
                }
            }
            return  minIndex ;
        }

        public void Prim(int[][] graph){
            int[] key = new int[V] ;
            Boolean[] mstSet = new Boolean[V] ;
            int[] parent = new int[V] ;
            for(int counter = 0 ; counter< V; counter++){
                mstSet[counter] = false ;
                key[counter] = Integer.MAX_VALUE ;
            }
            parent[0] = -1 ;
            key[0]= 0 ;
            for(int i = 0 ; i< V - 1 ; i++){
                int u = minKey(key , mstSet) ;
                mstSet[u] = true ;
                for(int counter = 0 ; counter< V ; counter++){
                    if(!mstSet[counter] && graph[u][counter] != 0 && graph[u][counter]< key[counter]){
                        key[counter] = graph[u][counter] ;
                        parent[counter] = u ;
                    }
                }
            }

        }


}
