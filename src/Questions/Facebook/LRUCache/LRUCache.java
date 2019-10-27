//package Questions.Facebook.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static class ListNode{
        int key , value ;
        ListNode previous , next ;
        ListNode(){}

    }

    Map<Integer , ListNode> map = new HashMap<>() ;
    ListNode head , tail;
    int capacity , totalItemsInCache ;
    public LRUCache(int capacity){
        this.capacity = capacity ;
        totalItemsInCache = 0 ;

        head = new ListNode() ;
        tail = new ListNode() ;

        head.next = tail ;
        tail.previous = head ;
    }



    public int get(int key){
        ListNode node = map.get(key) ;

        if(node== null){
            return -1 ;
        }
        moveToHead(node);
        return node.value ;
    }

    public void put(int key , int value){

        ListNode node = map.get(key) ;
        if(node== null){
            ListNode newNode = new ListNode() ;
            newNode.key = key ;
            newNode.value = value ;

            map.put(newNode.key , newNode) ;
            addToFront(newNode);
            totalItemsInCache+=1 ;
            if(totalItemsInCache> capacity){
                removeLRUEntry() ;
            }

        }
        else{
            node.value = value ;
            moveToHead(node);
        }
    }


    public void removeLRUEntry(){
        ListNode tail = popTail() ;
        map.remove(tail.key);
        totalItemsInCache-=1 ;
    }

    public ListNode popTail(){
        ListNode tailItem = tail.previous ;
        removeFromList(tailItem);
        return tailItem ;
    }

    public void addToFront(ListNode node){
        node.previous = head ;
        node.next = head.next ;

        head.next.previous = node ;
        head.next = node;
    }

    public void removeFromList(ListNode node){
        ListNode savedPrev = node.previous ;
        ListNode savedNext = node.next ;
        savedPrev.next = savedNext ;
        savedNext.previous = savedPrev ;
    }

    public void moveToHead(ListNode node){
        removeFromList(node);
        addToFront(node) ;
    }



}
