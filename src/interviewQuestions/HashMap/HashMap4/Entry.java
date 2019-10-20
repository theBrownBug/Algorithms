package interviewQuestions.HashMap.HashMap4;

public class Entry<K , V> {
    final K key  ;
    V value ;
    public Entry<K,V> next ;
    public Entry(K key , V value , Entry next){
        this.key = key ;
        this.value = value ;
        this.next = next ;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
    public void setValue(V value) { this.value = value; }
    public Entry<K, V> getNext() { return next; }
    public void setNext(Entry<K, V> next) { this.next = next; }


}
