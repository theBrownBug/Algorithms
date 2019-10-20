package interviewQuestions.Graphs.Djikstra;

public class Djikstra {

    static final int V = 9 ;
    int minDistance(int[] dist  , Boolean sptSet[]){
        // Initialize min value
        int min = Integer.MAX_VALUE, minIndex=-1;
        for(int counter = 0 ; counter< V ; counter++){
            if(!sptSet[counter] && dist[counter]<=min){
                min= dist[counter] ;
                minIndex = counter ;
            }
        }
        return minIndex ;
    }

    // A utility function to print the constructed distance array
    void printSolution(int dist[], int n) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" tt "+dist[i]);
    }

    void Djikstra(int[][] graph , int source){
        int[] distance = new int[V] ;
        Boolean[] sptSet = new Boolean[V] ;
        for(int i = 0 ; i < V  ; i++){
            distance[i] = Integer.MAX_VALUE ;
            sptSet[i] = false ;
        }
        distance[source] = 0 ;

        for(int i = 0 ; i< V-1 ; i++){
            int u = minDistance(distance , sptSet) ;
            sptSet[u] = true ;
            for(int counter = 0 ; counter < V ; counter++){
                if(!sptSet[i] && graph[u][counter] != 0 && distance[u]!= Integer.MAX_VALUE &&
                distance[u] + graph[u][counter]< distance[counter]){
                    distance[counter] = distance[u] + graph[u][counter] ;
                }
            }
        }
        // print the constructed distance array
        printSolution(distance, V);
    }

    public static void main(String args[]){
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        Djikstra t = new Djikstra();
        t.Djikstra(graph, 0);
    }

}
