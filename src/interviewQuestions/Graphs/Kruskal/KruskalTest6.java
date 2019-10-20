package interviewQuestions.Graphs.Kruskal;

import java.util.Arrays;

public class KruskalTest6 {
    public class Edge implements Comparable<Edge>{
        int src , dest , weight ;
        public int compareTo(Edge e ){
            return this.weight - e.weight  ;
        }
    }

    public class Subset{ int rank , parent ; }
    int E , V ;
    Edge[] edges ;
    public KruskalTest6(int v , int e){
        this.V= v ; this.E= e ;
        this.edges = new Edge[E] ;
        for(int counter = 0; counter< edges.length ; counter++){
            edges[counter] = new Edge() ;
        }
    }

    public int find(Subset[] subsets , int x){
        if(subsets[x].parent != x){
            subsets[x].parent = find(subsets , subsets[x].parent);
        }
        return subsets[x].parent ;
    }

    public void union(Subset[] subsets , int x , int y){
        int xRoot = find(subsets, x) ;
        int yRoot = find(subsets, y)  ;
        if(subsets[xRoot].rank< subsets[yRoot].rank){
            subsets[xRoot].parent = yRoot ;
        }
        else if(subsets[xRoot].rank> subsets[yRoot].rank){
            subsets[yRoot].parent = xRoot ;
        }
        else{
            subsets[yRoot].parent = xRoot ;
            subsets[xRoot].rank +=1 ;
        }
    }


    public void KruskalMST(){
        Edge[] result = new Edge[V] ;
        Subset[] subsets = new Subset[V] ;
        for(int counter = 0; counter< result.length ; counter++){
            result[counter] = new Edge() ;
        }
        for(int counter = 0 ;counter< subsets.length ; counter++){
            subsets[counter] = new Subset() ;
            subsets[counter].rank  = 0 ;
            subsets[counter].parent= counter ;
        }
        Arrays.sort(edges);

        int i = 0 , e = 0 ;

        while(e<V-1){
            Edge nextEdge;
            nextEdge= edges[i++];
            int x = find(subsets, nextEdge.src) ;
            int y= find(subsets, nextEdge.dest) ;
            if(x!=y){
                result[e++] = nextEdge ;
                union(subsets, x , y);
            }
        }

        for(int counter =0 ;counter<result.length ; counter++){
            System.out.println(result[counter].src +  " "+ result[counter].dest + " " + result[counter].weight);
        }
    }





}
