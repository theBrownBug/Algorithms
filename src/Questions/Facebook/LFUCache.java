package Questions.Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LFUCache {
    class Node{
        int key , value, count ;
        Node next , previous ;
        public Node(int key , int value , int count){
            this.key = key ;
            this.value = value ;
            this.count = count ;
        }

    }

    int minFreq , capacity ;
    Map<Integer , Node> map ;
    Map<Integer , List<Node>> freqMap ;
    Map<Integer, Integer> freqPosMap ;

    public LFUCache(int capacity){
        this.capacity = capacity ;
        this.minFreq = 0 ;
        this.map = new HashMap<>() ;
        this.freqMap = new HashMap<>() ;
        this.freqPosMap = new HashMap<>() ;

    }

    public int get(int key){
        System.out.println("start get key" + key);
        if(!map.containsKey(key)){
            return -1 ;
        }

        Node node = map.get(key) ;
        freqMap.get(node.count).remove((int)(freqPosMap.get(key))) ;
        node.count +=1 ;
        if(!freqMap.containsKey(node.count)){
            freqMap.put(node.count , new ArrayList<>()) ;
        }

        freqMap.get(node.count).add(node) ;


        // update freqPostmap
        freqPosMap.put(key , freqMap.get(node.count).size() - 1) ;
        if(freqMap.get(minFreq).size()== 0 ){
            minFreq+=1 ;
        }
        System.out.println("After get key: "+key);
        printMap() ;
        return node.value ;

    }


    public void put(int key , int value){
        System.out.println("start put key:" + key + " value:" + value);
        if(capacity<=0){
            return;
        }

        if(map.containsKey(key)){
            map.get(key).value = value ;
            return;
        }

        // clean up queue
        if(map.size()>= capacity){
            Node node = freqMap.get(minFreq).get(0) ;
            map.remove(node.key) ;
            freqMap.get(minFreq).remove(0) ;
            freqPosMap.remove(node.key) ;
        }

        Node newNode = new Node(key , value , 1) ;
        map.put(key , newNode) ;
        if(!freqMap.containsKey(newNode.count)){
            freqMap.put(newNode.count , new ArrayList<>()) ;

        }

        freqMap.get(newNode.count).add(newNode) ;
        freqPosMap.put(key , freqMap.get(newNode.count).size() - 1) ;
        minFreq = 1 ;
        System.out.println("after put key:" + key + " value:" + value);
        printMap();

    }

    private void printMap(){

        System.out.println("map");
        for (Node node : map.values()) {
            System.out.println("key: " + node.key + " value:" + node.value);
        }
        System.out.println("freqMap");
        for (Map.Entry<Integer, List<Node>> entry: freqMap.entrySet()) {
            System.out.println(entry.getKey() + " list size:" + entry.getValue().size());
        }
        System.out.println("freqPosmap");
        for (Map.Entry<Integer, Integer> entry: freqPosMap.entrySet()) {
            System.out.println("key:" + entry.getKey() + " pos: " + entry.getValue());
        }
        System.out.println("min freq list");
        for (Node node : freqMap.get(minFreq)){
            System.out.print(node.key + "->");
        }
        System.out.println();
        System.out.println();
    }


}




