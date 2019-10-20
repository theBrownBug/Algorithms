package interviewQuestions.Graphs.Prim;

public class Prim {
    private static final int V = 5 ;

    int minKey(int[] key, Boolean[] mstSet){
        int min = Integer.MAX_VALUE , minIndex = -1 ;
        for(int i = 0  ; i < V ; i++){
            if(!mstSet[i] && key[i]< min){
                min = key[i] ;
                minIndex = i ;
            }
        }
        return minIndex ;
    }

    /*
    Print the minimum spanning tree
     */
    void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    /*
    *
    * */
    void primMST(int graph[][]){
        int[] parent = new int[V] ;
        int[] keys = new int[V] ;
        Boolean[] mst = new Boolean[V] ;
        for(int counter = 0  ; counter < V ; counter++){
            keys[counter] = Integer.MAX_VALUE ;
            mst[counter] = false;
        }
        keys[0]  = 0 ; // initialise the source node as 0
        parent[0] = -1 ;  // the parent of the 1st node is null

        for(int i = 0 ; i < V-1 ; i++){
            int u = minKey(keys , mst) ;
            mst[u] = true ;

            for(int counter = 0 ; counter<V ; counter++){
                if(graph[u][counter]!= 0 && mst[counter]== false && graph[u][counter]< keys[counter]){
                    parent[counter] = u ;
                    keys[counter] = graph[u][counter] ;
                }
            }
        }

    }

    public static void main(String args[]){

        Prim t = new Prim();
        int[][] graph = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        t.primMST(graph);
    }

}
