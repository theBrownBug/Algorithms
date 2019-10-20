package interviewQuestions.Graphs.Topological;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
/**
 *
 * The above algorithm is simply DFS with an extra stack.
 * So time complexity is the same as DFS which is O(V+E).
 * */
public class TopologicalSort {
    public int V ;
    LinkedList<Integer> adjList [] ;

    public TopologicalSort(int i){
        this.V = i ;
        this.adjList = new LinkedList[V] ;
        for(LinkedList l : adjList){ l = new LinkedList() ; }
    }


    void topologicalSortUtil(int v , Boolean[] visited  , Stack stack){
        visited[v] = true ;
        Integer i ;
        Iterator<Integer> it = adjList[v].listIterator();
        while(it.hasNext()){
            i = it.next() ;
            if(!visited[i]){
                topologicalSortUtil(i , visited , stack);
            }
        }

        stack.push(v) ;


    }

    public void topologicalSort(){
        Stack stack = new Stack() ;
        Boolean[] visited = new Boolean[V] ;
        for(int i = 0 ; i< V ; i++){
            visited[i] = false ;
        }

        for(int i = 0 ; i < V ; i++){
            if(!visited[i]){
                topologicalSortUtil(i , visited , stack);
            }
        }

        while(!stack.empty()){
            System.out.println(stack.pop() + " ");
        }
     }

}
