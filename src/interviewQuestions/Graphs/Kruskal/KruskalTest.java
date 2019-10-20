package interviewQuestions.Graphs.Kruskal;

import java.util.Arrays;

public class KruskalTest {
    public class Edge implements Comparable<Edge>{
        int src , dest , weight ;
        public int compareTo(Edge compareEdge){
            return this.weight - compareEdge.weight ;
        }
    }

    public class Subset{
        int rank , parent ;
    }
    public int V, E ;
    public Edge[] edges ;

    KruskalTest(int V , int E ){
        this.V = V ;
        this.E = E ;
        edges = new Edge[E] ;
        for(int counter = 0 ; counter< E ;counter++){
            edges[counter] = new Edge() ;
        }
    }

    int find(Subset subsets[] , int i){
        if(subsets[i].parent != i){
            subsets[i].parent = find(subsets , subsets[i].parent) ;
        }
        return subsets[i].parent ;
    }

    public void Union(Subset[] subsets , int x , int y){
        int xRoot= find(subsets , x) ;
        int yRoot = find(subsets, y) ;
        if(subsets[xRoot].rank< subsets[yRoot].rank){
            subsets[xRoot].parent = yRoot ;
        }
        else if(subsets[xRoot].rank > subsets[yRoot].rank){
            subsets[yRoot].parent = xRoot ;
        }
        else{
            subsets[yRoot].parent = xRoot ;
            subsets[xRoot].rank+=1 ;
        }
    }

    public void KruskalMST(){
        Edge[] result = new Edge[V] ;
        int e = 0 , i = 0 ;
        for(i = 0 ; i< V ;i++){
            result[i] = new Edge() ;
        }
        Arrays.sort(edges);

        Subset[] subsets = new Subset[V] ;
        for(i = 0; i< V ; i++){
            subsets[i]= new Subset() ;
        }
        for(i = 0 ; i< V ; i++){
            subsets[i].rank = 0;
            subsets[i].parent = i ;
        }
        i = 0 ;
        while(e< V-1){
            Edge nextEdge ;
            nextEdge = edges[i++] ;
            int x = find(subsets , nextEdge.src) ;
            int y = find(subsets ,nextEdge.dest) ;
            if(x!=y){
                result[e++] = nextEdge ;
                Union(subsets,  x , y);
            }
        }

    }

}
