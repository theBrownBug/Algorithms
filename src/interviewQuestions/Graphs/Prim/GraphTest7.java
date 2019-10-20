package interviewQuestions.Graphs.Prim;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTest7 {
    public int V ;
    LinkedList<Integer> adjList[]  ;
    GraphTest7(int i){
        this.V=  i ;
        this.adjList = new LinkedList[V] ;
        for(LinkedList l: adjList){ l= new LinkedList() ; }
    }

    public void addEdge(int v , int e){
        this.adjList[v].add(e);
    }


    public void BFS(int source){
        Boolean[] visited =  new Boolean[V] ;
        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true ;
        queue.add(source);
        while(!queue.isEmpty()){
            int u = queue.poll() ;
            System.out.println(u +  " ");
            Iterator<Integer> iterator =  this.adjList[u].listIterator() ;
            while(iterator.hasNext()){
                int i = iterator.next() ;
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public void DFS(int source){
        Boolean[] visited = new Boolean[V] ;
        DFSUtil(source , visited) ;
    }

    public void DFSUtil(int source , Boolean[] visited){
        visited[source] = true ;
        System.out.println(source +" ");
        Iterator<Integer> iterator = adjList[source].listIterator() ;
        while(iterator.hasNext()){
            int i = iterator.next() ;
            if(!visited[i]){
                DFSUtil(i, visited);
            }
        }
    }

    /// ------------------------------------------ PRIMS ALGO ==========================================================

    public int minKey(int[] key , Boolean[]mstSet){
        int min = Integer.MAX_VALUE , minIndex = -1 ;
        for(int counter = 0  ; counter< V ; counter++){
            if(key[counter]< min){
                min = key[counter] ;
                minIndex = counter ;
            }
        }
        return  minIndex ;
    }

    public void PrimsAlgo(int[][] graph){
        int[] parent = new int[V] ;
        Boolean[] mstSet = new Boolean[V] ;
        int[] key = new int[V] ;
        for(int counter =  0; counter< V; counter++){
            mstSet[counter] = false ;
            key[counter] = Integer.MAX_VALUE ;
        }
        key[0] = 0 ;
        parent[0] = - 1;

        for(int i = 0 ; i< V -1 ; i++){
            int u = minKey(key , mstSet) ;
            mstSet[u] = true ;
            for(int counter = 0 ; counter< V ; counter++){
                if(!mstSet[counter]
                        && graph[u][counter]!= 0
                        && key[counter] > graph[u][counter]){
                    key[counter] = graph[u][counter] ;
                    parent[counter] = u ;
                }
            }
        }
    }
    //==============================================DIJKSTRA'S ADJ MATRIX ====================================================

    int minDistance(int[] distance , Boolean[] sptSet){
        int min = Integer.MAX_VALUE , minIndex = -1 ;
        for(int counter = 0 ; counter< V ; counter++){
            if(distance[counter]< min){
                min = distance[counter] ;
                minIndex = counter ;
            }
        }

        return minIndex ;
    }

    public void Dijkstra(int[][] graph , int source){
        int[] distance = new int[V] ;
        Boolean[] sptSet = new Boolean[V] ;
        for(int counter = 0 ; counter< V ; counter++){
            sptSet[counter] = false;
            distance[counter] = Integer.MAX_VALUE ;
        }
        distance[source] = 0 ;

        for(int i = 0 ; i < V - 1 ; i++){
            int u = minDistance(distance , sptSet) ;
            sptSet[u] = true ;
            for(int counter = 0; counter< V ; counter++){

                if(!sptSet[counter]
                        && graph[u][counter] != 0
                        && distance[u] != Integer.MAX_VALUE
                        && graph[u][counter] + distance[u]  < distance[counter]){

                    distance[counter] = graph[u][counter]  + distance[u]  ;
                }

            }
        }

    }





}
