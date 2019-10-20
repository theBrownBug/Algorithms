package interviewQuestions.HashMap;

import java.util.Map;

public class HashMap <K , V> {
    private Entry<K,V>[] buckets ;
    private static final int INITIAL_CAPACITY = 16 ;

    private int size = 0 ;

    public HashMap(){ this.buckets = new Entry[INITIAL_CAPACITY] ; }

    public HashMap(int capacity) { this.buckets = new Entry[capacity]; }



    public void put(K key , V value){
        Entry<K, V> entry = new Entry(key , value , null) ;
        int bucketNumber = key.hashCode() % buckets.length ;
        Entry<K, V> existing = buckets[bucketNumber] ;
        if(existing ==null){
            existing = entry ;
            size++ ;
        }
        else{
            while(existing.next != null){
                if(existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next ;
            }
            if(existing.key.equals(key)){
                existing.value = value ;
            }
            else{
                existing.next = entry ;
                size++ ;
            }
        }
    }


    public V get(K key){
        Entry<K,V> bucket = buckets[key.hashCode() % buckets.length ] ;
        while(bucket!=null){
            if(bucket.key.equals(key)){
                return bucket.value ;
            }
            bucket = bucket.next ;
        }
        return null ;
    }

}
