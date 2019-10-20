package interviewQuestions.Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTest10 {
    int V;
    LinkedList<Integer> adjList[] ;
    int[][] adjMatrix ;
    public GraphTest10(int v){
        this.V = v;
        this.adjList = new LinkedList[V] ;
        for(int counter = 0; counter< adjList.length ; counter++){
            adjList[counter] = new LinkedList<>() ;
        }
        this.adjMatrix= new int[V][V] ;
    }


    // depth first traversal =======================================================
    public void DFS(int source){
        Boolean[] visited = new Boolean[V] ;
        for(Boolean b : visited){ b = false ; }
        DFSUtil(visited , source) ;
    }

    public void DFSUtil(Boolean[] visited , int source){
        visited[source] = true ;
        System.out.println(source + " ");
        Iterator<Integer> iterator = adjList[source].listIterator() ;
        while(iterator.hasNext()){
            int i = iterator.next() ;
            if(!visited[i]){
                DFSUtil(visited , i);
            }
        }
    }
    // ==============================================================

    public void BFS(int source){
        Boolean[] visited = new Boolean[V] ;
        for(int counter = 0 ; counter< V; counter++){ visited[counter] =false ; }
        Queue<Integer> queue = new LinkedList<>()  ;
        queue.add(source) ;
        while(!queue.isEmpty()){
            int i = queue.poll() ;
            System.out.println(i+" ");
            Iterator<Integer> iterator = adjList[i].listIterator();
            while(iterator.hasNext()){
                int next = iterator.next() ;
                if(!visited[next]){
                    queue.add(next) ;
                }
            }
        }
    }

    //================================================================================



}
