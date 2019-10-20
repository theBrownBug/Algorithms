package interviewQuestions.Graphs.Topological;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalTest3 {

    public int V ;
    public LinkedList<Integer> adjList [] ;
    public TopologicalTest3(int v){
        this.V = v;
        this.adjList = new LinkedList[V] ;
        for(int counter = 0 ; counter< V ; counter++){
            this.adjList[counter] =new LinkedList<>() ;
        }
    }


    public void TopologicalSortUtil(int i , Boolean[] visited , Stack stack){
        visited[i] = true ;
        Integer x;
        Iterator<Integer> iterator = adjList[i].listIterator() ;
        while(iterator.hasNext()){
            x = iterator.next();
            if(!visited[x]){
                TopologicalSortUtil(x , visited, stack);
            }
        }
        stack.push(new Integer(i)) ;
    }


    public void TopologicalSort(){
        Stack stack = new Stack() ;
        Boolean[] visited = new Boolean[V];
        for(int counter= 0 ; counter< V ; counter++){
            visited[counter] = false ;
        }
        for(int counter= 0 ; counter< V ; counter++){
            if(!visited[counter]){
                TopologicalSortUtil(counter , visited, stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop() + " ");
        }
    }
}
