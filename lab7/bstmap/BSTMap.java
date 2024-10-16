package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K> , V> implements Map61B<K , V> {
    private class BSTNode<K , V> {
        private V value;
        private K key;
        private BSTNode<K , V> left , right;

        private BSTNode(K key , V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int mapSize;
    private BSTNode<K , V> sentinal;

    public BSTMap() {
        sentinal = null;
        mapSize = 0;
    }

    @Override
    public void clear() {
        sentinal = null;
        mapSize = 0;
    }

    @Override
    public boolean containsKey(K key) {
        if (sentinal == null || key == null) {
            return false;
        }
        return contains(sentinal , key);
    }

    private boolean contains(BSTNode<K ,V> curr , K key) {
        if (curr == null) {
            return false;
        }
        else if (key.compareTo(curr.key) == 0) {
            return true;
        }
        else if (key.compareTo(curr.key) > 0) {
            return contains(curr.right , key);
        }
        else if (key.compareTo(curr.key) < 0) {
            return contains(curr.left , key);
        }

        return false;
    }

    @Override
    public V get(K key) {
        if (sentinal == null || key == null) {
            return null;
        }
        else {
            return getR(sentinal , key);
        }
    }

    private V getR(BSTNode<K , V> curr , K key) {
        if (curr == null) {
            return null;
        }
        else if (key.compareTo(curr.key) == 0) {
            return curr.value;
        }
        else if (key.compareTo(curr.key) > 0) {
            return getR(curr.right , key);
        }
        else if (key.compareTo(curr.key) < 0) {
            return getR(curr.left , key);
        }

        return null;
    }

    @Override
    public int size() {
        return mapSize;
    }

    @Override
    public void put(K key , V value) {
        if (key == null) {
            return;
        }
        if (sentinal == null) {
            sentinal = new BSTNode<>(key , value);
        } else {
            putR(sentinal , key , value);
        }
        mapSize += 1;
    }

    private void putR(BSTNode<K , V> curr , K key , V value) {
        int result = key.compareTo(curr.key);
        if (result > 0) {
            if (curr.right == null) {
                curr.right = new BSTNode<>(key , value);
            } else {
                putR(curr.right, key, value);
            }
        }
        else {
            if (curr.left == null) {
                curr.left = new BSTNode<>(key , value);
            } else {
                putR(curr.left, key, value);
            }
        }
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /*
    private class BSTMit<K> implements Iterator<K> {
        private BSTNode<K , V> curr;

        public BSTMit() {
            curr = (BSTNode<K, V>) sentinal;
        }

        @Override
        public boolean hasNext() {
            return
        }
    }


     */

    public void printInOrder() {
        System.out.println();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    };
}
