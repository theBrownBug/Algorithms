package interviewQuestions.Graphs;

import java.util.Arrays;

public class Graph4 {

    class Edge implements Comparable<Edge>{
        int src , dest , weight ;
        public int compareTo(Edge compareEdge){
            return this.weight - compareEdge.weight ;
        }
    }

    class Subset{
        int parent , rank ;
    }

    int  V , E ;
    Edge edge[] ;

    Graph4(int v ,int e){
        this.V = v ; this.E = e ;
        edge = new Edge[E] ;
        for(int i = 0 ; i < E ; i++){
            edge[i] = new Edge() ;
        }
    }

    // a function to find the set of element i
    int find(Subset subsets[] , int i ){
        if(subsets[i].parent != i ){
            subsets[i].parent = find(subsets , subsets[i].parent) ;
        }
        return subsets[i].parent ;
    }

    // a function that does union of two sets
    void union(Subset subsets[] , int x ,int y ){
        int xRoot = find(subsets , x ) ; // find the root element of the set containing x
        int yRoot = find(subsets , y ) ;
        if(subsets[xRoot].rank < subsets[yRoot].rank){
            subsets[xRoot].parent = yRoot ;
        }
        else if(subsets[xRoot].rank > subsets[yRoot].rank){
            subsets[yRoot].parent = xRoot ;
         }
        else{
            subsets[yRoot].parent = xRoot ;
            subsets[xRoot].rank +=1 ;
        }
    }


    void KruskalMST(){
        Edge[] result = new Edge[V] ;
        int e = 0 ; // index variable used for edges
        int v = 0 ; // index variable used for sorted edges
        for(int i = 0 ; i < V ; i++){ result[i] = new Edge() ; }

        // sort the edges in the graph
        Arrays.sort(edge) ;

        // allocate memory for creating subsets
        Subset[] subsets = new Subset[V] ;
        for(int counter = 0 ; counter< V ; counter++){
            subsets[counter] = new Subset() ;
        }

        // initially every index is its own parent
        for(int i = 0 ; i < V ; i++){
            subsets[i].parent = i ;
            subsets[i].rank = 0 ;
        }
        int i = 0 ; // index used to pick the next edge
        while(e < V-1){

            Edge nextEdge = new Edge() ;
            nextEdge = edge[i++] ;
            int x = find(subsets , nextEdge.src) ;
            int y = find(subsets , nextEdge.dest) ;

            // if x == y , then a  cycle is being formed , discard that particular edge
            if(x!=y){
                result[e++] = nextEdge ;
                union(subsets , x , y );
            }
        }


        // print the contents of result[] to display
        // the built MST
        System.out.println("Following are the edges in " +
                "the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src+" -- " +
                    result[i].dest+" == " + result[i].weight);
    }







}
