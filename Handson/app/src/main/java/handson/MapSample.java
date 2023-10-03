package handson;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class MapSample {
    public static void main(String[] args) {
        //InitialCapacity = 16 - Buckets - Each bucket has a linked list. where key, keyhash, value, ref to the next node is stored. 
        //To identify the bucket => hashfunction(key) * (capacity - 1)
        //LoadFactor = 0.7f
        //Threshold = InitialCapacity * LoadFactor = 16 * 0.7 = 12
        //Rehashing - Resize and Rehash when the threshold is reached. 
        //Resized in 2 factor. 16,32, 64 ...
        
        Map<String, Integer> hashmap = new HashMap<>(); //Doesn't maintain insertion order. Not Sorted. Not ThreadSafe.
        IntStream.rangeClosed(1, 100).forEach(e -> hashmap.put(""+e, e));
        System.out.println(hashmap.values());

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();// maintain insertion order. Not Sorted. Not ThreadSafe.
        IntStream.rangeClosed(1, 100).forEach(e -> linkedHashMap.put(""+e, e));
        System.out.println(linkedHashMap.values());
        //Inside its using structure like doubly linked list. 
        //linked list having addtional two nodes previous and next to maintain insertion oder. 

        Map<Integer, Integer> treeMap = new TreeMap<>();// maintain insertion order. Sorted Keys by Natural Order. Not ThreadSafe.
        IntStream.rangeClosed(1, 100).forEach(e -> treeMap.put(e, e));
        System.out.println("TreeMap: "+ treeMap.keySet()+",\n"+ treeMap.values());
        /// Its implemented using RedBlack Tree. Its a self balancing BST. 
        // Self Balancing is nothing but whenever any actions happens, tree will be restructred based on the updated values again. 

        Map<String, Integer> concMap = new ConcurrentHashMap<>(); //Doesn't maintain insertion order. Not Sorted. ThreadSafe.
        IntStream.rangeClosed(1, 100).forEach(e -> concMap.put(""+e, e));
        System.out.println("Concurrent HashMap: "+concMap.values());

        // SynchronizedHashmap - Where the whole hashmap is locked in multithread environment.
        // whereas in ConcurrentHashMap, locking is block level. only the particular block will be locked.
        // so other threads can access other blocks of hashmap. 
    
    }

}
