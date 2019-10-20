package interviewQuestions.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    static class ItemValue{
        double weight , value , index ;
        Double cost  ;
        public ItemValue(double weight , double value ,double index){
            this.weight = weight  ;
            this.value = value ;
            this.index = index ;
            cost = (value/weight) ;

        }


    }

    private static double getMaxValue(int[] values , int[] weights , int capacity){
        ItemValue[] itemValues = new ItemValue[weights.length] ;
        for(int counter=  0 ; counter< weights.length ; counter++){
            itemValues[capacity] = new ItemValue(values[counter] , weights[counter] , counter) ;
        }


        Arrays.sort(itemValues, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o2.cost.compareTo(o1.cost) ;
            }
        });

        double total = 0 ;
        for(ItemValue i : itemValues){

            int weight = (int) i.weight ;
            int value= (int) i.value ;

            if(capacity - weight>=0){
                capacity-=weight ;
                total+= value ;
            }
            else{

                double fraction = ((double) capacity / (double) weight )  ;
                value += fraction * weight ;
                capacity-= (int)(capacity - (weight * fraction)) ;
                break ;
            }

        }

        return total ;

    }
}
