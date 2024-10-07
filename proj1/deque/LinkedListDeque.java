package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> , Iterable<T>{
    private class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;
    }

    private int size;
    private Node<T> sentinal;

    public LinkedListDeque() {
        sentinal = new Node<T>();
        sentinal.next = sentinal;
        sentinal.prev = sentinal;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node<T> nw = new Node<>();
        nw.value = item;
        nw.next = sentinal.next;
        nw.prev = sentinal;
        sentinal.next = nw;
        nw.next.prev = nw;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        Node<T> nw = new Node<>();
        nw.value = item;
        nw.prev = sentinal.prev;
        nw.next = sentinal;
        sentinal.prev = nw;
        nw.prev.next  = nw;
        size += 1;
    }

    @Override
    public T removeFirst() {
        if (size == 0) { return null; }
        Node<T> target = sentinal.next;
        sentinal.next = target.next;
        size -= 1;
        if (size == 0) {
            sentinal.prev = sentinal;
        }
        return target.value;
    }

    //重写prev，next 上一节点的修改
    //equals与compator
    @Override
    public T removeLast() {
        if (size == 0) { return null; }
        Node<T> target = sentinal.prev;
        sentinal.prev = target.prev;
        target.prev.next = sentinal;
        size -= 1;
        if (size == 0) { sentinal.next = sentinal; }
        return target.value;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0 || size == 0) { return null; }
        Node<T> target = sentinal;
        for (int i = 0 ; i <= index ; i += 1) {
            target = target.next;
        }
        return target.value;
    }

    @Override
    public int size() { return size; }

    @Override
    public void printDeque() {
        int wizPos = 0;
        Node<T> target = sentinal.next;
        while (wizPos <= size) {
            System.out.print(target.value);
            System.out.print(' ');
            target = target.next;
            wizPos += 1;
        }
    }

    public T getRecursive(int index) {
        Node<T> curr = sentinal.next;
        if (curr.next == sentinal) {
            return null;
        }
        return getByR(curr , index);
    }

    public T getByR(Node<T> pre , int index) {
        if (pre == sentinal) { return null; }
        if (index == 0) { return pre.value; }
        else { return getByR(pre.next , index - 1); }
    }

/*
    public interface Iterable<T> {
        Iterator<T> iterator();

    }
    */

    private class ITLinked<T> implements Iterator<T> {
        private int wizPos;
        public ITLinked() {
            wizPos = 0;
        }

        public boolean hasNext() { return wizPos < size; }

        public T next() {
            T retItem = (T) get(wizPos);
            wizPos += 1;
            return retItem;
        }

    }

    public Iterator<T> iterator() {
        return new ITLinked<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o == this) { return true; }
        //if (this.getClass() != o.getClass()) {return false; }
        Deque<T> cmp = (Deque<T>) o;
        if (cmp.size() != size()) { return false; }

        for (int i = 0 ; i < size ; i ++) {
            if (cmp.get(i) != get(i)) {
                return false;
            }
        }

        return true;
    }

}