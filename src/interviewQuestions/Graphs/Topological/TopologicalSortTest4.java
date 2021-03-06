package interviewQuestions.Graphs.Topological;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSortTest4 {
    public int V ;
    public LinkedList<Integer> adjList[] ;
    public TopologicalSortTest4(int V){
        this.V = V ;
        this.adjList= new LinkedList[V] ;
        for(int counter= 0; counter< V ; counter++){
            this.adjList[counter] = new LinkedList<>();
        }
    }

    public void TopologicalSortUtil(int v , Boolean[] visited , Stack stack){
        visited[v] = true ;
        Iterator<Integer> iterator = adjList[v].listIterator() ;
        Integer i ;
        while(iterator.hasNext()){
            i = iterator.next() ;
            if(visited[i]){
                TopologicalSortUtil(i , visited , stack);
            }
        }
        stack.push(v) ;
    }

    public void TopologicalSort(){
        Stack stack = new Stack() ;
        Boolean[] visited = new Boolean[V] ;

        for(int counter= 0 ; counter< V ; counter++){
            visited[counter] = false ;
        }

        for(int counter = 0 ; counter< V ; counter++){
            if(!visited[counter]){
                TopologicalSortUtil(counter, visited, stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop() +" ");
        }
    }
}
