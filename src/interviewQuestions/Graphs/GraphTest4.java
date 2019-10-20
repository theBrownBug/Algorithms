package interviewQuestions.Graphs;


import javax.swing.text.StyledEditorKit;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTest4 {
    public int V ;
    LinkedList<Integer> adjList [] ;

    public GraphTest4(int V){
        this.V = V ;
        this.adjList = new LinkedList[V] ;
        for(int counter = 0 ; counter< adjList.length ; counter++){
            adjList[counter] = new LinkedList<>() ;
        }
    }

    public void BreadthFirstSearch(int source){
        Boolean[] visited = new Boolean[V] ;
        Queue<Integer> queue = new LinkedList<>() ;
        queue.add(source) ;
        visited[source ] = true ;
        while(!queue.isEmpty()){
            int i = queue.poll() ;
            Iterator<Integer> iterator = adjList[i].listIterator() ;
            while(iterator.hasNext()){
                int j = iterator.next() ;
                if(!visited[j]){
                    queue.add(j) ;
                    visited[j] = true ;
                }
            }
        }
    }


    public void DFS(int src){
        Boolean[] visited = new Boolean[V] ;
        DFSUtil(visited , src);
    }

    public void DFSUtil(Boolean[] visited , int src){
        visited[src] = true ;
        System.out.println(src + " ");
       Iterator<Integer> iterator = adjList[src].listIterator() ;
       while(iterator.hasNext()){
           int i = iterator.next() ;
           if(!visited[i]){
               DFSUtil(visited ,  i );
           }
       }

    }



}
