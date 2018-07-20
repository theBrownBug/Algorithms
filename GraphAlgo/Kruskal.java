package GraphAlgo;
import java.util.* ;
import java.lang.*  ;
import java.lang.* ;


public class Kruskal {


    class Edge implements Comparable<Edge>{
        int src , dest , weight ;
        // comparator function used for sorting edges based on their weight

        public int compareTo(Edge compareEdge){
            return this.weight - compareEdge.weight ;
        }


    } ;

    // a class to represent the union find
    class subSet{int parent ; int rank ; } ;
    int V , E ; // number of edges and number of vertices
    Edge[] edge ; // collection of all edges

    Kruskal(int vertex , int edge){
        V = vertex  ; E = edge ;
        edge = new Edge[E] ;
        for(int i = 0 ; i < edge ; ++i){
            edge[i] = new Edge()  ;
        }
    }
    // a utility function to find the set of an element i



    public static void main(String args[]){


    }
}
