package interviewQuestions.Graphs.Kruskal;

import java.util.Arrays;

public class KruskalTest3 {
    public class Edge implements Comparable<Edge>{
        int src , dest , weight ;
        public int compareTo(Edge c){
            return this.weight - c.weight ;
        }
    }

    class Subset{
        int rank , parent ;
    }

    int V , E ;
    Edge[] edges;
    public KruskalTest3(int v , int e){
        this.V  = v  ; this.E = e ;
        edges = new Edge[E] ;
        for(int counter = 0 ; counter<E ; counter++){
            this.edges[counter] = new Edge() ;
        }
    }

    public int find(Subset[] subsets , int x){
        if(subsets[x].parent != x){
            subsets[x].parent = find(subsets, subsets[x].parent) ;
        }
        return subsets[x].parent;
    }

    public void Union(Subset[] subsets, int x  , int y ){
        int xRoot = find(subsets, x) ;
        int yRoot = find(subsets, y) ;
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
        Edge[] result = new Edge[V] ;
        int i = 0 , e = 0 ;
        for(int counter= 0 ; counter< V ;counter++){
            result[counter] = new Edge() ;
        }
        Arrays.sort(edges);

        Subset[] subsets = new Subset[V];
        for(int counter = 0 ; counter< subsets.length ;counter++){
            subsets[counter] = new Subset() ;
            subsets[counter].rank = 0 ;
            subsets[counter].parent = counter ;
        }

        i = 0 ;
        while(e< V - 1){
            Edge nextEdge ;
            nextEdge = edges[i++] ;
            int x = find(subsets , nextEdge.src);
            int y = find(subsets , nextEdge.dest) ;
            if(x!= y){
                result[e++] = nextEdge ;
                Union(subsets, x, y);
            }
        }

    }

}
