package interviewQuestions.Graphs.Kruskal;

import java.util.Arrays;
import java.util.LinkedList;

public class KruskalTest2 {
    public class Edge implements Comparable<Edge>{
        int src ,dest , weight ;
        public int compareTo(Edge c){
            return this.weight - c.weight ;
        }
    }

    public class Subset{
        int rank , parent ;
    }

    int V , E ;
    Edge[] edges ;
    public KruskalTest2(int v ,int  e ){
        this.E = e ; this.V = v ;
        this.edges = new Edge[E] ;
        for(int counter = 0; counter< E ; counter++){
            edges[counter] = new Edge() ;
        }
    }


    public int find(Subset[] subsets , int i){
        if(subsets[i].parent != i){
            subsets[i].parent = find(subsets, subsets[i].parent) ;
        }
        return subsets[i].parent ;
    }


    public void Union(Subset[] subsets , int x , int y){
        int xRoot = find(subsets, x) ;
        int yRoot = find(subsets , y);
        if(subsets[xRoot].rank < subsets[yRoot].rank){
            subsets[xRoot].parent = yRoot ;
        }
        else if(subsets[xRoot].rank > subsets[yRoot].rank){
            subsets[yRoot].parent = xRoot ;
        }
        else{
            subsets[yRoot].parent = xRoot ;
            subsets[xRoot].rank += 1 ;
        }
    }


    public void KruskalMST(){
        Edge[] result = new Edge[V];
        int e  = 0, i = 0 ;
        for(int counter = 0 ; counter< V ; counter++){
            edges[i] = new Edge() ;
        }
        Arrays.sort(edges);
        Subset[] subsets = new Subset[V] ;
        for(int counter = 0  ; counter< V ; counter++){
            subsets[counter] = new Subset() ;
            subsets[counter].rank = 0 ;
            subsets[counter].parent = counter ;
        }
        i = 0 ;
        while(e< V - 1){
            Edge nextEdge ;
            nextEdge = edges[i++] ;
            int x = find(subsets , nextEdge.src) ;
            int y = find(subsets, nextEdge.dest);
            if(x!= y){
                result[e++] = nextEdge ;
                Union(subsets, x , y );
            }
        }

    }

}
