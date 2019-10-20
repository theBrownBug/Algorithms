package interviewQuestions.Graphs.Kruskal;

import java.util.Arrays;

public class KruskalTest5{

    public class Edge implements Comparable<Edge>{
     int src , dest , weight;
     public int compareTo(Edge c){
         return this.weight - c.weight ;
     }
    }

    public class Subset{ int parent , rank ;}

    int E , V;
    Edge[] edges ;
    public KruskalTest5(int v , int e ){
        this.E = e ; this.V = v ;
        edges = new Edge[e] ;
        for(int counter = 0 ; counter< E ; counter++){
            edges[counter] = new Edge() ;
        }
    }



    public int find(Subset[] subsets, int x){
        if(subsets[x].parent != x){
            subsets[x].parent = find(subsets, subsets[x].parent) ;
        }
        return subsets[x].parent ;
    }

    public void union(Subset[] subsets, int x  , int y){
        int xRoot= find(subsets , x) ;
        int yRoot= find(subsets, y) ;

        if(subsets[xRoot].rank < subsets[yRoot].rank){
            subsets[xRoot].parent = yRoot ;
        }
        if(subsets[xRoot].rank > subsets[yRoot].rank){
            subsets[yRoot].parent = xRoot;
        }
        else{
            subsets[yRoot].parent = xRoot ;
            subsets[xRoot].rank += 1;
        }
    }

    public void KruskalMST(){
        Edge[] result = new Edge[this.V];
        for(int counter = 0; counter< V ; counter++){
            result[counter] = new Edge() ;
        }
        Arrays.sort(edges);

        int i = 0 , e = 0 ;
        Subset[] subsets = new Subset[V] ;
        for(int counter = 0;counter< V ;counter++){
            subsets[counter] = new Subset() ;
            subsets[counter].rank = 0 ;
            subsets[counter].parent= counter ;
        }
        i = 0 ;

        while(e< V-1){
            Edge newEdge ;
            newEdge = edges[i++] ;
            int x = find(subsets, newEdge.src) ;
            int y = find(subsets, newEdge.dest) ;
            if(x!=y){
                result[e++] = newEdge ;
                union(subsets,x , y);
            }
        }
        for(int counter = 0 ; counter< result.length ;counter++){
            System.out.println(result[counter].src + " " + result[counter].dest + " " + result[counter].weight);
        }
    }
}
