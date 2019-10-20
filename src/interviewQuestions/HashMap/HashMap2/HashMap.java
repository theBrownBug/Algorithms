package interviewQuestions.HashMap.HashMap2;

public class HashMap<K , V>{
    private Entry<K , V> [] buckets ;
    private static int INITIAL_CAPACITY = 16 ;
    private int size = 0 ;

    public HashMap(){
        this.buckets = new Entry[INITIAL_CAPACITY] ;
    }
    public HashMap(int capacity){
        this.buckets = new Entry[capacity] ;
    }
    public void put(K key , V value){
        Entry<K, V> entry= new Entry<>(key , value , null) ;
        int bucket = key.hashCode() % buckets.length ;
        Entry<K , V> existing = buckets[bucket] ;
        if(existing==null){
            buckets[bucket] = entry ;
            size++;
        }
        else{
            while(existing.next != null){
                if(existing.key.equals(key)){
                    existing.value= value ;
                    return;
                }
                existing = existing.next ;
            }

            // why this if statement??
            if(existing.key.equals(key)){
                existing.value = value ;
            }


            else{
                existing.next = entry ;
                size++ ;
            }

        }

    }
}
