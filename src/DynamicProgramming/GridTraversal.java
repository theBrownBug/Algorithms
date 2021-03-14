package DynamicProgramming;
import java.util.* ;

public class GridTraversal{

    /*
    * Given a 2D grid and provided you can 'down' and 'right',
    * how many ways can you traverse from top left to bottom right ?
    *
    * */
    public int gridTraversalNormal(int row , int column){
        if(row==0 || column == 0){ return  0 ; }
        if(row == 1 && column==1){return 1; }
        return gridTraversalNormal(row -1  , column) + gridTraversalNormal(row , column - 1) ;
    }



    public int gridTraversalDP(int row , int column){
        HashMap<String , Integer> map = new HashMap<>() ;
        return gridTraversalDPSubRoutine(row , column , map) ;
    }

    public int gridTraversalDPSubRoutine(int row , int column , HashMap<String , Integer> map){
        String key = String.valueOf(row) + "," + String.valueOf(column);
        if(map.containsKey(key)){return map.get(key); }
        if(row ==0 || column ==0){ return 0; }
        if(row == 1 && column == 1){return 1 ; }
        int result = gridTraversalDPSubRoutine(row - 1, column , map) + gridTraversalDPSubRoutine(row , column - 1 , map);
        map.put(key , result) ;
        return result ;
    }



}
