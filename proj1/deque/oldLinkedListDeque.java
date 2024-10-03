

package deque;

//import java.awt.event.TEvent;

import java.util.Iterator;

public class oldLinkedListDeque<T>{
    public class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

    }

    public Node<T> sentinal , endSentinal;
    public int list_size = 0;

    public oldLinkedListDeque() {
        sentinal = new Node<>();
        endSentinal = new Node<>();
        sentinal.next = endSentinal;
        endSentinal.prev = sentinal;
        sentinal.value = endSentinal.value = null;
    }

    public T getRecursive(int index) {
        Node<T> curr = sentinal.next;
        if (curr == endSentinal) {
            return null;
        }
        return getByR(curr , index);
    }

    private T getByR(Node<T> curr , int index)
    {
        if (index == 0) {
            return curr.value;
        } else {
            curr = curr.next;
            if (curr == endSentinal) return null;
            return getByR(curr , index - 1);
        }
    }



    
    public void addFirst(T x) {
        Node<T> fr = new Node<>();
        fr.value = x;
        fr.next = sentinal.next;
        sentinal.next = fr;
        fr.prev = sentinal;
        list_size += 1;
        if (endSentinal.prev == sentinal) {
            endSentinal.prev = fr;
        }
    }

    
    public void addLast(T x) {

        Node<T> curr = endSentinal.prev;
        Node<T> fr = new Node<>();
        fr.value = x;
        fr.next = endSentinal;
        curr.next = fr;
        fr.prev = curr;
        endSentinal.prev = fr;
        if (sentinal.next == endSentinal) {
            sentinal.next = fr;
        }
        list_size += 1;
    }

    /*
    
    public boolean isEmpty() {
        if (list_size != 0) return false;
        return true;
    }

     */

    
    public int size() {
        return list_size;
    }

    
    public void printDeque() {
        Node<T> pointer;
        pointer = sentinal.next;
        while (pointer != endSentinal) {
            System.out.print(pointer.value);
            System.out.print(' ');
            pointer = pointer.next;
        }

        System.out.println();
    }

    
    public T removeFirst() {
        Node<T> curr = sentinal.next;
        if (curr == endSentinal) {
            return null;
        }
        T x = sentinal.next.value;
        curr.prev = sentinal;
        sentinal.next = curr.next;
        list_size -= 1;
        return x;
    }

    
    public T removeLast() {
        Node<T> curr = endSentinal.prev;
        if (curr == sentinal) {
            return null;
        }
        T x = curr.value;
        curr.prev.next = endSentinal;
        endSentinal.prev = curr.prev;
        list_size -= 1;
        return x;
    }

    
    public T get(int index) {
        int count = 0;
        Node<T> curr = sentinal.next;

        while (count != index) {
            curr = curr.next;
            count += 1;
            if (curr == endSentinal) {
                return null;
            }
        }

        return curr.value;
    }

    private class LDiterable implements Iterator<T> {
        private int wizPos;
        public LDiterable() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < list_size;
        }

        public T next() {
            T retItem = get(wizPos);
            wizPos += 1;
            return retItem;
        }

    }

    public Iterator<T> iterator() {
        return new LDiterable();
    }

    /*
    public boolean equals(Object o) {
        if (o instanceof LinkedListDeque<?> cmp) {
            if (cmp.size() != size()) { return false; }

            for (int i = 0 ; i < list_size ; i ++) {
                if (cmp.get(i) != get(i)) {
                    return false;
                }
            }

            return true;
        }
        return false;
    }
    */
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (this == o) {return true; }
        if (this.getClass() != o.getClass()) {return false; }
        LinkedListDeque<T> cmp = (LinkedListDeque<T>) o;
        if (cmp.size() != size()) { return false; }

        for (int i = 0 ; i < list_size ; i ++) {
            if (cmp.get(i) != get(i)) {
                return false;
            }
        }

        return true;
    }
}