package interviewQuestions.Graphs.Prim;

// Incomplete
//https://www.geeksforgeeks.org/prims-mst-for-adjacency-list-representation-greedy-algo-6/

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class PrimAdj {

    // stores the destination vertex in the adjencency list
    class Node1{
        int dest ;
        int weight  ;
        Node1(int a ,int b){
            this.dest = a ;
            this.weight = b;
        }
    }

    static class Graph{
        int V ;
        LinkedList<Node1> adjList [] ;
        public Graph(int V){
            this.V = V ;
            this.adjList = new LinkedList[V] ;
            for(int i = 0 ; i< V ; i++){ adjList[i] = new LinkedList<>() ; }
        }

    }

    // represents a node in a priority Queue
    class Node{
        int key ; int vertex ;
    }

    class comparator implements Comparator<Node>{
        @Override
        public int compare(Node n1 , Node n2){
            return n1.key - n2.key ;
        }
    }

    void addEdge(Graph graph , int src , int dest , int weight){
        Node1 node0 = new Node1(dest , weight) ;
        Node1 node1 = new Node1(src , weight) ;
        graph.adjList[src].addLast(node0);
        graph.adjList[dest].addLast(node1);
    }

    void primMST(Graph graph){
        Boolean[] mstSet = new Boolean[graph.V] ;
        Node[] nodes= new Node[graph.V] ;
        int[] parent = new int[graph.V] ;
        for(int counter = 0 ; counter< graph.V ; counter++){
            nodes[counter] = new Node() ;
            mstSet[counter] = false ;
            nodes[counter].key= Integer.MAX_VALUE ;
            nodes[counter].vertex= counter ;
            parent[counter] = -1 ;
        }

        mstSet[0] = true;
        nodes[0].key = 0 ;

        TreeSet<Node> queue = new TreeSet<>(new comparator()) ;
        for(int counter = 0 ; counter< graph.V ; counter++){ queue.add(nodes[counter]) ; }

        while(!queue.isEmpty()){
            Node node0 = queue.pollFirst() ;
            mstSet[node0.vertex] = true ;

        }

    }



}
