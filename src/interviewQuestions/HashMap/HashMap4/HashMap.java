package interviewQuestions.HashMap.HashMap4;

public class HashMap<K , V> {
    public Entry<K ,V> buckets[] ;
    private static int DEFAULT_SIZE= 16 ;
    int size = 0 ;
    public HashMap(){
        this.buckets = new Entry[DEFAULT_SIZE] ;
    }
    public HashMap(int size){
        if(size>0) {
            this.buckets = new Entry[size];
        }
    }

    public void put(K key , V value){
        Entry newEntry = new Entry<>(key ,value , null) ;
        int bucketNumber = key.hashCode() % buckets.length ;
        Entry<K , V> existing = buckets[bucketNumber] ;
        if(existing == null){
            buckets[bucketNumber] = newEntry ;
            size++ ;
        }
        else{
            while(existing.next !=null){
                if(existing.key.equals(key)){
                    existing.value = value ;
                    return;
                }
                existing = existing.next ;
            }
            if(existing.key.equals(key)){
                existing.value= value ;
            }
            else{
                existing.next = newEntry ;
            }
        }
    }


    public V get(K key){
        Entry<K , V> bucket = buckets[key.hashCode() % buckets.length] ;
        while(bucket != null){
            if(bucket.key.equals(key)){
                return bucket.value ;
            }
            bucket = bucket.next ;
        }
        return null ;
    }


}
