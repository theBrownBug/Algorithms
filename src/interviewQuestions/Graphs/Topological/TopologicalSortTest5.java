package interviewQuestions.Graphs.Topological;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSortTest5 {
    public int V;
    LinkedList<Integer> adjList[] ;
    public TopologicalSortTest5(int i){
        this.V = i ;
        this.adjList =  new LinkedList[i] ;
        for(int counter= 0 ; counter< V ; counter++){
            this.adjList[counter]= new LinkedList<>();
        }

    }


    public void topologicalSortUtil(int i , Boolean[] visited , Stack stack){
        visited[i]  = true ;
        Integer j ;
        Iterator<Integer> iterator = adjList[i].listIterator() ;
        while(iterator.hasNext()){
            j = iterator.next() ;
            if(!visited[j]){
                topologicalSortUtil(j , visited, stack);
            }
        }
        stack.push(i) ;
    }

    public void topologicalSort(){
        Stack stack = new Stack() ;
        Boolean[] visited = new Boolean[V];
        for(int counter = 0; counter< V ; counter++){ visited[counter] = false; }
        for(int counter= 0 ; counter< V ; counter++){
            if(!visited[counter]){
                topologicalSortUtil(counter, visited, stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop() + " ");
        }
    }

}
