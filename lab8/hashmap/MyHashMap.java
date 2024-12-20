package hashmap;

import java.util.*;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */


    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }


    /* Instance Variables */
    private Collection<Node>[] buckets;
    // You should probably define some more!
    private double factor = 0.75;
    private int mapsize;
    private int initsize = 16;

    /** Constructors */
    public MyHashMap() {
        mapsize = 0;
        buckets = createTable(initsize);
    }

    public MyHashMap(int initialSize) {
        initsize = initialSize;
        mapsize = 0;
        buckets = createTable(initsize);
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        initsize = initialSize;
        mapsize = 0;
        factor = maxLoad;
        buckets = createTable(initsize);
    }

    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        Node nw = new Node(key , value);
        return nw;
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        return new LinkedList<>();
    }

    /**
     * Returns a table to back our hash table. As per the comment
     * above, this table can be an array of Collection objects
     *
     * BE SURE TO CALL THIS FACTORY METHOD WHEN CREATING A TABLE SO
     * THAT ALL BUCKET TYPES ARE OF JAVA.UTIL.COLLECTION
     *
     * @param tableSize the size of the table to create
     */



    private Collection<Node>[] createTable(int tableSize) {
        Collection<Node>[] table = new Collection[tableSize];

        for (int i = 0; i < tableSize; i++) {
            table[i] = createBucket();
        }

        return table;
    }

    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!

    public Iterator<K> iterator() {
        return new ItK();
    }

    /*
    private class ItK implements Iterator<K> {
        private LinkedList<K> list;
        public ItK() {
            list = addAll();
        }



        public boolean hasNext() {
            return curr != null;
        }

        public K next() {
            K ret = curr.key;
            if ()
        }

    }
     */

    private class ItK implements Iterator<K> {
        private List<Node> list;
        public ItK() {
            list = new LinkedList<>();
            for (int i = 0; i < initsize; i++) {
                list.addAll(buckets[i]);
            }
        }
        @Override
        public boolean hasNext() {
            return !list.isEmpty();
        }

        @Override
        public K next() {
            return list.remove(0).key;
        }
    }



    private void testFactor() {
        if ((double)mapsize / (double)initsize > factor) {
            resize(initsize * 2);
        }
    }

    /* Interface for test purpose
    @param A as the new size
     */

    public void testResize(int size) {
        resize(size);
    }

    private void resize(int size) {
        Collection<Node>[] oldb = buckets;
        buckets = createTable(size);
        initsize = size;
        for (Collection<Node> x : oldb) {
            for (Node y : x) {
                put(y.key , y.value);
                mapsize -= 1;
            }
        }

    }

    @Override
    public int size() {
        return mapsize;
    }

    @Override
    public void clear() {
        mapsize = 0;
        buckets = createTable(initsize);
    }



    @Override
    public V get(K key) {
        int code = Math.floorMod(key.hashCode(), initsize);
        for (Node x : buckets[code]) {
            if (x.key.equals(key)) {
                return x.value;
            }
        }

        return null;
    }

    @Override
    public boolean containsKey(K key) {
        int code = Math.floorMod(key.hashCode(), initsize);
        for (Node x : buckets[code]) {
            if (x.key.equals(key)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void put(K key , V value) {
        if (key == null) {return;}
        Node nw = createNode(key , value);
        int code = Math.floorMod(nw.key.hashCode(), initsize);
        if (containsKey(key)) {
            for (Node x : buckets[code]) {
                if (x.key.equals(key)) {
                    x.value = value;
                    return;
                }
            }
        }
        buckets[code].add(nw);
        mapsize += 1;
        testFactor();
    }

    @Override
    public Set<K> keySet() {
        Set<K> ns = new HashSet<>();
        for (Collection<Node> x : buckets) {
            for (Node y : x) {
                ns.add(y.key);
            }
        }

        return ns;
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key , V value) {
        throw new UnsupportedOperationException();
    }
}
