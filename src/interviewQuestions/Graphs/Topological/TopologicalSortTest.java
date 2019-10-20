package interviewQuestions.Graphs.Topological;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSortTest {
    int V ;
    LinkedList<Integer> adjList[] ;
    public TopologicalSortTest(int i){
        this.V = i ;
        this.adjList = new LinkedList[V] ;
        for(int counter = 0; counter< V; counter++){
            adjList[counter] = new LinkedList<>() ;
        }
    }

    public void topologicalSortUtil(int v , Boolean [] visited , Stack stack){
        visited[v] = true ;
        Integer i ;
        Iterator<Integer> iterator = adjList[v].listIterator() ;
        while(iterator.hasNext()){
            i = iterator.next() ;
            if(!visited[i]){
                topologicalSortUtil(i , visited , stack);
            }
        }
        stack.push(v) ;
    }

    void topologicalSort(){
        Stack stack= new Stack() ;
        Boolean[] visited = new Boolean[V] ;
        for(int i = 0 ; i< V;  i++){
            visited[i] = false ;
        }
        for(int counter = 0 ; counter< V; counter++) {
            if (!visited[counter]) {
                topologicalSortUtil(counter, visited, stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop() + " ");
        }

    }
}
