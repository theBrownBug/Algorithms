package interviewQuestions.Graphs;

public class PrimTest2 {
    public int V;
    public int minKey(int[] key , Boolean[] mstSet ){
        int min = Integer.MAX_VALUE ;
        int minIndex =  0  ;
        for(int counter = 0 ; counter< V ; counter++){
            if (!mstSet[counter] && key[counter]< min){
                min = key[counter] ;
                minIndex = counter ;
            }
        }
        return minIndex ;
    }


    public void  Prim(int[][] array){
        int [] parent = new int[V] ;
        Boolean[] mstSet = new Boolean[V] ;
        int[] key = new int[V] ;

        for(int counter = 0 ; counter< V; counter++){
            mstSet[counter]= false ;
            key[counter] = Integer.MAX_VALUE ;
        }

        // set the values for the base value
        key[0] = 0 ;
        parent[0] = -1 ;

        for(int counter = 0 ; counter< V -1 ; counter++){
            int u = minKey(key, mstSet) ;
            mstSet[u] = true ;
            for(int counter2 = 0 ; counter2 < V  ; counter2++){
                if( array[u][counter] != 0 && !mstSet[counter2] &&
                    array[u][counter2]< key[counter2]
                ){
                    parent[counter2] = u ;
                    key[counter2] = array[u][counter2] ;
                }

            }

        }

    }

}


