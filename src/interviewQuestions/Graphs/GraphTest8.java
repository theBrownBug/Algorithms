package interviewQuestions.Graphs;

import javax.swing.text.StyledEditorKit;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTest8 {
    public int V ;
    public LinkedList<Integer> adjList[] ;
    public GraphTest8(int v){
        this.V= v ;
        this.adjList = new LinkedList[V] ;
        for(int counter = 0 ; counter< V ; counter++){
            adjList[counter] = new LinkedList<>() ;
        }
    }

    public void BFS(int source){
        Boolean[] visited = new Boolean[V] ;
        for(int counter= 0; counter< V ; counter++){
            visited[counter] = false ;
        }
        visited[source]= true ;
        Queue<Integer> queue = new LinkedList<>() ;
        queue.add(source) ;
        while(!queue.isEmpty()){
            Integer i = queue.poll() ;
            System.out.println(i+" ");
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


    public void DFS(int source){
        Boolean[] visited= new Boolean[V] ;
        for(int counter = 0; counter< V ;counter++){
            visited[counter] = false ;
        }
        DFSUtil(source , visited) ;
    }

    public void DFSUtil(int source , Boolean[] visited){
        visited[source] = true ;
        System.out.println(source + " ");
        Iterator<Integer> iterator = adjList[source].listIterator() ;
        while(iterator.hasNext()){
            int j = iterator.next() ;
            if(!visited[j]){
                DFSUtil(j , visited);
            }
        }
    }


    //]=================================================================================================================

    public int minDistance(int[] distance , Boolean[] sptSet){
        int min = Integer.MAX_VALUE , minIndex = -1 ;
        for(int counter = 0 ; counter< V ;counter++){
            if(!sptSet[counter] && min>=distance[counter]){
                minIndex = counter ;
                min = distance[counter] ;
            }
        }
        return minIndex ;
    }

    public void Dijkstra(int[][] graph , int source){
        Boolean[] sptSet = new Boolean[V] ;
        int[] distance = new int[V] ;
        for(int counter = 0 ; counter< V  ; counter++){
            sptSet[counter] = false  ;
            distance[counter] = Integer.MAX_VALUE ;
        }
        distance[source] = 0 ;
        for(int counter = 0; counter< V-1 ; counter++){
            int u = minDistance(distance , sptSet) ;
            sptSet[u] = true;
            for(int i = 0 ;  i < V ; i++){
                if(!sptSet[i]
                        && graph[u][i] != 0
                        && distance[u] != Integer.MAX_VALUE
                        && distance[u] + graph[u][i]< distance[i]){
                        distance[i] = graph[u][i] + distance[u] ;
                }
            }
        }
    }

    //============================= PRIM's ALGO ========================================================================

    int minKey(int[] key , Boolean[] mstSet){
        int min = Integer.MAX_VALUE , minIndex = -1 ;
        for(int counter= 0 ; counter< V  ; counter++){
            if(!mstSet[counter] && key[counter]< min){
                min = key[counter] ;
                minIndex = counter ;
            }
        }
        return minIndex ;
    }

    public void Prim(int[][] graph){
        int[] key= new int[V] ;
        Boolean[] mstSet = new Boolean[V] ;
        int[] parent = new int[V] ;
        for(int counter = 0 ; counter< V; counter++){
            key[counter] = Integer.MAX_VALUE ;
            mstSet[counter] = false ;
        }
        parent[0] = -1 ;
        key[0] = 0;
        for(int i = 0 ; i< V ; i++){
            int u = minKey(key, mstSet) ;
            mstSet[u] = true ;
            for(int counter = 0; counter< V ; counter++){
                if(!mstSet[counter] && graph[u][counter] != 0
                        && graph[u][counter]< key[counter]){
                        parent[counter] = u ;
                        key[counter] = graph[u][counter] ;
                }
            }
        }
    }
}
