package Questions.Facebook;
import java.util.* ;

class Entry{
    int value ;
    int key ;
    Entry left  , right ;
}

public class LRUCache {

    HashMap<Integer , Entry> hashMap ;
    Entry start , end ;
    int  LRU_CACHE_SIZE = 4;
    public LRUCache(){
        this.hashMap = new HashMap<Integer, Entry>() ;
    }

    public int getEntry(int key){
        if(hashMap.containsKey(key)){
            Entry entry = hashMap.get(key) ;
            removeNode(entry) ;
            addToTop(entry) ;
            return entry.value ;
        }
        return  -1 ;
    }

    public void put(int key , int value){
        if(hashMap.containsKey(key)){
            Entry entry = hashMap.get(key) ;
            entry.value = value ;
            removeNode(entry) ;
            addToTop(entry) ;
        }
        else{
            Entry entry = new Entry();
            entry.key = key ;
            entry.value= value ;
            entry.left = entry.right = null ;

            // if we have reached the maximum size of the  LRU Cache, it's time to remove an element
            if(hashMap.size()>LRU_CACHE_SIZE){
                hashMap.remove(end.key) ;
                removeNode(end) ;
                addToTop(entry) ;

            }
            else{
                addToTop(entry) ;
            }
            hashMap.put(key , entry) ;
        }
    }

    public void removeNode(Entry entry){
        if(entry.left != null){
            entry.left.right = entry.right ;
        }
        else{
            start = entry.right ;
        }

        if(entry.right != null){
            entry.right.left = entry.left ;
        }
        else{
            end = entry.left ;
        }
    }

    public void addToTop(Entry node){
        node.right = start;
        node.left = null ;
        if(start!= null){
            start.left = node ;
        }
        start = end ;
        if(end == null){
            end = start ;
        }
    }
}
