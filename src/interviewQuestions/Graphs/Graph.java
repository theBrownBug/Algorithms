package interviewQuestions.Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V ;
    private LinkedList<Integer> adjList[] ;
    Graph(int v){
        this.V = v ;
        this.adjList = new LinkedList[v] ;
        for(LinkedList l:adjList ){
            l = new LinkedList();
        }
    }

    void addEdge(int vertex , int weight){
        adjList[vertex].add(weight) ;
    }

    public int getV(){return this.V ;}

    void BFS(int s){
        boolean[] visited = new boolean[V] ;
        LinkedList<Integer> queue= new LinkedList<>() ;
        visited[s]= true ;
        while(queue.size()!=0){
            // Dequeue a vertex from queue and print it
            s = queue.poll() ;
            System.out.print(s+" ");
            Iterator<Integer> iterator = adjList[s].listIterator() ;
            while(iterator.hasNext()){
                int i = iterator.next() ;
                if(! visited[i]){
                    visited[i] = true ;
                    queue.add(i) ;
                }
            }
        }
    }

    /*=============+++++++++++++++++++++DFS +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/


    /*
    * DFS utility Function
    * */
    void DFSUtil(int v , boolean visited[]){
        visited[v] = true ;
        System.out.print(v+" ");
        Iterator<Integer> iterator = adjList[v].listIterator() ;
        while(iterator.hasNext()){
            int next = iterator.next() ;
            if(!visited[next]){
                DFSUtil(next, visited);
            }
        }
    }

    // v is the source at which DFS starts
    void DFS(int v){
        boolean[] visited = new boolean[V] ;
        DFSUtil(v, visited);
    }

}
