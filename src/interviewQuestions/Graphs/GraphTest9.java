package interviewQuestions.Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTest9 {
    public int V ;
    public LinkedList<Integer> adjList[] ;
    int[][] adjMatrix ;
    public GraphTest9(int v){
        if(v>0){
            this.V = v ;
            this.adjList = new LinkedList[v] ;
            for(LinkedList i: adjList){
                i = new LinkedList() ;
            }
            this.adjMatrix = new int[V][V] ;
        }
    }

    public void BreadthFirstSearch(int source){
        boolean[] visited = new boolean[V] ;
        for(int counter = 0 ; counter< visited.length ; counter++){
            visited[counter] = false ;
        }
        Queue<Integer> queue = new LinkedList<>() ;
        queue.add(source) ;
        visited[source]= true ;
        while(!queue.isEmpty()){
            int i = queue.poll() ;
            System.out.println(i+" ");
            Iterator<Integer> it = adjList[i].listIterator();
            while(it.hasNext()){
                int  j = it.next() ;
                if(!visited[j]){
                    visited[j] = true;
                    queue.add(j) ;
                }

            }
        }
    }

    public void DFS(int source){
        Boolean[] visited = new Boolean[V] ;
        for(int counter = 0 ; counter< visited.length ; counter++){
            visited[counter]= false ;
        }
        DFSUtil(source , visited) ;
    }

    public void DFSUtil(int source , Boolean[] visited){
        visited[source] = true ;
        System.out.println(source  + " ");
        Iterator<Integer> it = adjList[source].listIterator() ;
        while(it.hasNext()){
            int i = it.next() ;
            if(!visited[i]){
                DFSUtil(i , visited);
            }
        }
    }

    //==================================================================================================================

    public int minKey(int[] key , Boolean[] mstSet){
        int min = Integer.MAX_VALUE ;
        int minIndex = -1 ;
        for(int counter = 0 ; counter< V ; counter++){
            if(!mstSet[counter] && key[counter]< min){
                minIndex = counter ;
                min = key[counter] ;
            }
        }
        return minIndex ;
    }

    public void Prim(int[][] graph){
        int[] key = new int[V] ;
        Boolean[] mstSet = new Boolean[V] ;
        int[] parent = new int[V] ;
        for(int counter = 0 ; counter< V; counter++){
            mstSet[counter] = false ;
            key[counter] = Integer.MAX_VALUE ;
        }
        parent[0] = - 1;
        key[0] = 0 ;
        for(int counter = 0; counter<V ;counter++){
            int u= minKey(key , mstSet) ;
            mstSet[u] = true ;
            for(int counter2 = 0 ; counter2<V ; counter2++){
                if(!mstSet[counter2] && graph[u][counter2]!= 0 && graph[u][counter2]< key[counter2]){
                    parent[counter2] = u ;
                    key[counter2] = graph[u][counter2] ;
                }
            }

        }
    }
    //==================================================================================================================
    // djikstra

    public int minDistance(int[] distance , Boolean[] sptSet){
        int minDistance = Integer.MAX_VALUE ;
        int minIndex = -1 ;
        for(int counter= 0 ; counter<distance.length ; counter++){
            if(!sptSet[counter] && distance[counter]< minDistance ) {
                minDistance = distance[counter];
                minIndex = counter;
            }
        }
        return minIndex ;
    }

    public void Djikstra(int[][] graph , int source){

        Boolean[] sptSet  = new Boolean[V] ;
        int[] distance = new int[V] ;
        for(int counter = 0; counter< V ; counter++){
            sptSet[counter] = false ;
            distance[counter] = Integer.MAX_VALUE ;
        }
        distance[source] = 0  ;
        sptSet[source] = true;
        for(int counter = 0 ; counter< V-1 ; counter++){
            int minDistance = minDistance(distance, sptSet) ;
            sptSet[minDistance] = true ;
            for(int i = 0; i < V ; i++){
                if(!sptSet[i]
                        && graph[minDistance][i] != 0
                        && distance[minDistance] != Integer.MAX_VALUE
                        && distance[minDistance] + graph[minDistance][i] < distance[i]
                ){

                }
            }
        }

    }


}

