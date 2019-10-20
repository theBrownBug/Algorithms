package NewImplementation4.HashMap;

public class HashMap<K , V>{
    public Entry<K, V>[] buckets ;
    private final int DEFAULT_SIZE = 16;
    public int size = 0 ;
    public HashMap(){
        this.buckets = new Entry[DEFAULT_SIZE] ;
    }
    public HashMap(int size) throws Exception{
        try {
            if (size > 0) { this.buckets = new Entry[size]; }
            else{ throw new Exception(" The size of the hashmap has to be greater than 0") ; }
        }catch (NumberFormatException e){
            System.out.println(e + "The size of the hashmap should be a number");
        }
    }
    public void put(K key , V value){
        int bucketNumber = key.hashCode() % this.buckets.length ;
        Entry<K , V> existing = this.buckets[bucketNumber] ;

        //if the head of the linked list at index= bucketNumber is empty, initialise the head
        if(existing == null){
            this.buckets[bucketNumber] = new Entry<>(key, value , null) ;
            this.size +=1 ;
        }
        else{
            /*
            * if the head of the bucketNumber is not null,
            * then keep iterating over the linked list until one of the 2 things happen:
            * 1. if you find an entry with a matching key, then change the value and return
            * 2. else create a new entry at the end of the linked list
            *
            * */
            while(existing.next!= null){
                if(existing.key.equals(key)){
                    existing.value = value ;
                    return;
                }
                existing = existing.next ;
            }


            if(existing.key.equals(key)){
                existing.value = value ;
                return;
            }
            existing.next = new Entry<>(key , value , null ) ;
            size+=1 ;
        }
    }

    public V get(K key){
        Entry<K , V > existing = this.buckets[key.hashCode() % this.buckets.length] ;
        while(existing!= null){
                if(existing.key.equals(key)){
                    return existing.value ;
                }
                existing = existing.next ;
        }
        return null ;
    }



}
