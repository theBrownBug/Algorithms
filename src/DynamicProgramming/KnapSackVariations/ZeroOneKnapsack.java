package DynamicProgramming.KnapSackVariations;
import java.util.*   ;
public class ZeroOneKnapsack {

    /*
    * Given a bag and a set of objects with given weights and values,
    * maximise the profit
    * */
    public int zeroOneKnapsackNormal(int[] weights , int[] values, int capacity , int size){
        // base case
        if(size == 0 || capacity ==0){
            return 0 ;
        }
        // make the choice diagram
        if(weights[size-1]<=capacity){
            return (int) Math.max(values[size - 1] + zeroOneKnapsackNormal(weights, values, capacity - weights[size -1], size -1 ) ,
                    zeroOneKnapsackNormal(weights , values , capacity , size  - 1)
                    );
        }
        else{
            return zeroOneKnapsackNormal(weights , values , capacity , size - 1);
        }
    }


    public int zeroOneKnapsackDP(int[] weights, int[] values , int capacity , int size){
        // the maximum value only depends upon the capacity of the bag
        // we make a map (2d array) for parameters that are variable . i.e in this case capacity and index(size)
        int[][] array   = new int[size+1][capacity+1] ;
        for(int counter = 0 ; counter< array.length ; counter++){
            for(int counter2 = 0 ; counter2<array[counter].length ; counter2++){
                array[counter][counter2] = -1 ;
            }
        }

        return zeroOneKnapsackDPSubRoutine(weights ,values , capacity , size , array);
    }

    public int zeroOneKnapsackDPSubRoutine(int[] weights, int[] values , int capacity , int size, int[][] array){
        if(capacity == 0 || size ==0){
            return 0 ;
        }
        if(array[size][capacity]!=-1){return array[size][capacity]; }

        if(weights[size-1]<= capacity){
            array[size][capacity] = (int) Math.max(values[size - 1] + zeroOneKnapsackNormal(weights, values, capacity - weights[size -1], size -1 ) ,
                    zeroOneKnapsackNormal(weights , values , capacity , size  - 1)
            );

        }
        else{
            array[size][capacity] = zeroOneKnapsackNormal(weights , values , capacity , size - 1);

        }
        return array[size][capacity];
    }
}
