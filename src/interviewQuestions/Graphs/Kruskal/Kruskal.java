package interviewQuestions.Graphs.Kruskal;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {

    class Edge implements Comparable<Edge>{
        int src , dest , weight ;
        public int compareTo(Edge compareEdge) {
            return this.weight  - compareEdge.weight ;
        }
    }

    public class Subset{
        public int rank , parent ;
    }

    int V , E;
    Edge[] edges ;
    public Kruskal(int v , int e){
        this.V= v ;
        this.E = e ;
        this.edges = new Edge[e] ;
        for(int counter= 0 ; counter< this.edges.length ; counter++){
            this.edges[counter] = new Edge() ;
        }
    }

    public int find(Subset[] subsets , int i){
        if(subsets[i].parent != i){
            subsets[i].parent = find(subsets , subsets[i].parent) ;
        }
        return subsets[i].parent ;
    }

    void Union(Subset[] subsets , int x ,int y){
        int xRoot = find(subsets, x) ;
        int yRoot = find(subsets , y) ;

        if(subsets[xRoot].rank < subsets[yRoot].rank){
            subsets[xRoot].parent = yRoot  ;
        }
        else if(subsets[xRoot].rank > subsets[yRoot].rank){
            subsets[yRoot].parent= xRoot;
        }
        else{
            subsets[yRoot].parent = xRoot ;
            subsets[xRoot].rank += 1;
        }
    }

    void KruskalMst(){
        Edge[] result = new Edge[V] ;
        int i = 0 , e = 0 ;
        for(i = 0 ; i< V ; i++){ result[i] = new Edge() ; }
        Arrays.sort(edges);

        Subset[] subsets = new Subset[V] ;
        for(i = 0; i< V ; i++){ subsets[i] = new Subset() ; }
        for(int counter = 0 ; counter< V ; counter++){
            subsets[counter].parent = counter ;
            subsets[counter].rank =  0 ;
        }

        i = 0 ;
        while(e< V - 1){
            Edge nextEdge = new Edge() ;
            nextEdge = edges[i++];
            int x = find(subsets, nextEdge.src );
            int y = find(subsets ,nextEdge.dest) ;

            if(x!=y){
                result[e++] = nextEdge ;
                Union(subsets, x , y );
            }
        }
    }



}
