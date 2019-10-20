package interviewQuestions.Graphs;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTest {
    public int V ;
    LinkedList<Integer> adjList [] ;
    int[][] matrix ;
    public GraphTest(int V){
        this.V = V ;
        this.matrix = new int[V][V] ;
        adjList = new LinkedList[V] ;
        for(int counter = 0 ; counter< adjList.length ; counter++){
            adjList[counter] = new LinkedList<>() ;
        }
    }
    //========================== adjlist to matrix  and vice versa ================================================================================

    public LinkedList[] toAdjList(int[][] array){
        LinkedList<Integer> [] list = new LinkedList[array.length] ;
        for(LinkedList l : list){ l = new LinkedList() ; }
        for(int counter =  0 ; counter< array.length ; counter++){
            for(int counter2 = 0 ; counter2< array[counter].length ; counter2++){
                list[counter].add(array[counter][counter2]) ;
            }
        }
        return list ;
    }

    public int[][] toMatrix(LinkedList[] adjList){
        int V = adjList.length ;
        int[][] array = new int[V][V] ;
        for(int counter = 0 ; counter< adjList.length ; counter++){
            for(int counter2 = 0 ; counter2< V ; counter2++){
                if(adjList[counter].contains((Integer)counter2)){
                    array[counter][counter2] = (Integer) adjList[counter].get(counter2);
                }
                else {
                    array[counter][counter2] = 0 ;
                }

            }
        }
        return array ;
    }

    //============================ BREADTH FIRST SEARCH ===============================================================//

    public void breadthFirstTraversal(int s ){
        boolean[] visited = new boolean[V] ;
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true ;
        queue.add(s) ;
        while(!queue.isEmpty()){
            int i = queue.poll() ;
            System.out.println("Data = "+ i);
            Iterator<Integer> iterator = adjList[i].listIterator() ;
            while(iterator.hasNext()){
                int next = iterator.next() ;
                if(!visited[next]){
                    queue.add(next) ;
                    visited[next] = true ;
                }
            }

        }
    }



    // ============= DEPTH FIRST SEARCH ============================================================///

    public void DFS(int v){
        boolean[] visited = new boolean[V] ;
        DFSUtil(v ,visited) ;
    }

    public void DFSUtil(int v, boolean[] visited){
        visited[v] = true ;
        System.out.print(v+" ");

        Iterator<Integer> iterator=  adjList[v].listIterator() ;
        while(iterator.hasNext()){
            int next = iterator.next() ;
            if(!visited[next]){
                DFSUtil(next , visited);
            }
        }
    }

    public static void main(String args[]){
        LinkedList<Integer> list = new LinkedList<>() ;
        Boolean[] test= new Boolean[2] ;
        Boolean[] copy= Arrays.copyOf(test , test.length) ;
    }

}
