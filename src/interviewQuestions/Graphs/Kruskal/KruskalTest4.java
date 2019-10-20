package interviewQuestions.Graphs.Kruskal;

import java.util.Arrays;
import java.util.Iterator;

public class KruskalTest4 {
    public class Edge implements Comparable<Edge>{
        int src , dest , weight ;
        public int compareTo(Edge e){
            return this.weight  - e.weight ;
        }
    }
    public class Subset{
        int rank , parent;
    }

    int V ,  E;
    Edge[] edges ;
    public KruskalTest4(int v, int e){
        this.V = v; this.E = e ;
        this.edges = new Edge[E] ;
        for(int counter = 0 ; counter< E; counter++){
            edges[counter] = new Edge() ;
        }
    }

    public int find(Subset[] subsets , int x){
        if(subsets[x].parent != x){
            subsets[x].parent = find(subsets , subsets[x].parent) ;
        }
        return subsets[x].parent ;
    }

    public void Union(Subset[] subsets , int x , int y){
        int xRoot = find(subsets, x) ;
        int yRoot = find(subsets, y) ;
        if(subsets[xRoot].rank< subsets[yRoot].rank){
            subsets[xRoot].parent = yRoot ;
        }
        else if( subsets[xRoot].rank > subsets[yRoot].rank){
            subsets[yRoot].parent = xRoot ;
        }
        else{
            subsets[yRoot].parent = xRoot ;
            subsets[xRoot].rank +=1 ;
        }
    }

    public void KruskalMST(){
        Edge[] result =  new Edge[V];
        for(int counter = 0 ; counter< result.length ; counter++){ result[counter] = new Edge() ; }
        Subset[] subsets = new Subset[V] ;
        Arrays.sort(edges);
        for(int counter =0 ; counter< V; counter++){
            subsets[counter] = new Subset() ;
            subsets[counter].rank = 0 ;
            subsets[counter].parent = counter ;
        }
        int i  = 0 , e = 0 ;

        while(e< V-1){
            Edge newEdge ;
            newEdge = edges[i++] ;
            int x = find(subsets, newEdge.src) ;
            int y = find(subsets, newEdge.dest) ;
            if(x!= y){
                result[e++] = newEdge ;
                Union(subsets, x , y);

            }
        }

        System.out.println("Printing the edges of the PRIM MST");
        for(int counter = 0 ; counter< result.length ; counter++){
            System.out.println("------ SOURCE -----------"+
                    result[counter].src + " -----DESTINATION-----"+ result[counter].dest+ " ----------- Weight -------" +
                    " "+result[counter].weight);
        }

    }



    public static void main (String[] args)
    {

        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        KruskalTest4 graph = new KruskalTest4(V, E);

        // add edge 0-1
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 10;

        // add edge 0-2
        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 6;

        // add edge 0-3
        graph.edges[2].src = 0;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 5;

        // add edge 1-3
        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 15;

        // add edge 2-3
        graph.edges[4].src = 2;
        graph.edges[4].dest = 3;
        graph.edges[4].weight = 4;

        graph.KruskalMST();
    }

}
