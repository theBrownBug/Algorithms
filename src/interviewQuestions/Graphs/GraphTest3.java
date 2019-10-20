package interviewQuestions.Graphs;


import interviewQuestions.BST.BinaryTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTest3 {

    public int V ;
    LinkedList<Integer> adjList [] ;
    public GraphTest3(int v){
        this.V = v ;
        this.adjList =  new LinkedList[V] ;
        for(LinkedList<Integer> l : adjList){
            l = new LinkedList<>() ;
        }
    }

    public void BFS(int source){
        boolean[] visited = new boolean[V] ;
        Queue<Integer> queue = new LinkedList<>() ;
        queue.add(source) ;
        visited[source] = true;
        while(queue.size()!=0){
            int i = queue.poll() ;
            Iterator<Integer> iterator = adjList[i].listIterator() ;
            while(iterator.hasNext()){
                int j= iterator.next() ;
                if(!visited[j]){
                    visited[j] = true ;
                    queue.add(j) ;
                }
            }
        }

    }

    public void DFS(int source){
        Boolean[] visited = new Boolean[V];
        DFSUtil(source , visited);
    }

    void DFSUtil(int source , Boolean[] visited){
        visited[source] = true;
        System.out.println(source + " ");
        Iterator<Integer> iterator = adjList[source].listIterator() ;
        while(iterator.hasNext()){
            int i= iterator.next() ;
            if(!visited[i]){
                DFSUtil(i , visited);
            }
        }

    }


    public int minKey(int[] key , Boolean[] mstSet){
        int min = Integer.MAX_VALUE ; int minIndex = -1 ;
        for(int counter = 0 ; counter< V ; counter++){
            if(!mstSet[counter] && key[counter]< min){
                min = key[counter] ;
                minIndex = counter;
            }
        }
        return  minIndex ;
    }

    public void primMST(int[][] graph){
        int[] parent = new int[V] ;
        int[] key = new int[V]  ;
        Boolean[] mstSet = new Boolean[V] ;
        for(int counter = 0; counter< V ; counter++){
            mstSet[counter] = false; key[counter] = Integer.MAX_VALUE ;
        }
        key[0] = 0 ;
        parent[0] = -1 ;

        for(int counter = 0 ; counter< V - 1 ; counter++){
            int u = minKey(key , mstSet) ;
            mstSet[u] = true ;
            for(int counter2 = 0 ; counter2< V ; counter2++){
                if(!mstSet[counter2] && graph[u][counter2]!=0 && graph[u][counter2] <key[counter2]){
                    parent[counter2] = u ;
                    key[counter2]= graph[u][counter2] ;
                }
            }
        }
    }


    public int minDistance( int[] distance , Boolean[] sptSet){
        int min = Integer.MAX_VALUE   , minIndex = - 1;
        for(int counter = 0; counter< V ; counter++){
            if(!sptSet[counter] && distance[counter]<= min){
                min = distance[counter] ;
                minIndex = counter ;
            }
        }
        return minIndex ;
    }


    public void Djikstra(int[][] graph , int source){
        int[] distance = new int[V] ;
        Boolean[] sptSet = new Boolean[V] ;
        for(int counter = 0 ;counter< V; counter++){
            sptSet[counter] = false ;
            distance[counter] = Integer.MAX_VALUE ;
        }
        distance[source] = 0 ;
        for(int counter = 0 ; counter< V - 1 ; counter++){

            int u =  minDistance(distance , sptSet) ;
            sptSet[u] = true ;
            for(int counter2 = 0 ; counter2< V ; counter2++){
                if(!sptSet[counter2]
                        && graph[u][counter2] != 0
                        && distance[u] != Integer.MAX_VALUE
                        && distance[u] + graph[u][counter2]< distance[counter2]
                ){
                    distance[counter2] = distance[u]  + graph[u][counter2] ;
                }
            }
        }


    }




}
