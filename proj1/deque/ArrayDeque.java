package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>{
    T[] arr;
    int head = 0;
    int tail = 0;
    int list_size , arr_size;

    public ArrayDeque() {
        arr = (T[]) new Object[8];
        head = 0;
        tail = 0;
        list_size = 0;
        arr_size = 8;
    }

    @Override
    public int size() {
        return list_size;
    }

    @Override
    public void addFirst(T x) {
        if (list_size == arr_size - 1) {
            resize(arr_size * 2);
        }
        int target;
        if (isEmpty())  {
            target = head;
            tail = (head + 1) % arr_size;
        } else {
            target = (head - 1 + arr_size) % arr_size;
        }
        arr[target] = x;
        head = target;
        list_size += 1;
    }

    @Override
    public void addLast(T x) {
        if (list_size == arr_size - 1) {
            resize(arr_size * 2);
        }
        arr[tail] = x;
        list_size += 1;
        tail = (tail + 1) % arr_size;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i > list_size) {
            return null;
        }
        //int target = (i  + head) % arr_size;

        int target = head;
        for (int j = 0 ; j < i ; j ++)
        {
            target = (target + 1) % arr_size;
        }
        return arr[target];
    }

    /*
    public boolean isEmpty() {
        return list_size == 0;
    }

     */


    @Override
    public T removeLast() {
        if (isEmpty()) {
            return  null;
        }
        int target = (tail - 1 + arr_size) % arr_size;
        T last = arr[target];
        tail = target;
        list_size -= 1;
        if (list_size * 4 < arr_size) {
            resize(arr_size / 2);
        }
        return last;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T first = arr[head];
        list_size -= 1;
        head = (head + 1 + arr_size) % arr_size;
        if (list_size * 4 < arr_size) {
            resize(arr_size / 2);
        }
        return first;
    }


    public void resize(int cap) {
        T[] narr = (T[]) new Object[cap];
        int hh = head;
        int j = 0;

        while (j < list_size) {
            narr[j] = arr[hh];
            j ++;
            hh = (hh + 1) % arr_size;
        }

        arr_size = cap;
        head = 0;
        if (isEmpty()) {
            tail = 0;
        } else {
            tail = j;
        }
        arr = narr;
    }

    @Override
    public void printDeque() {
        if (isEmpty()) {
            System.out.println();
        }
        int hh = head;
        int j = 0;
        while (j < list_size) {
            System.out.print(arr[hh]);
            System.out.print(' ');
            hh = (hh + 1) % arr_size;
            j ++;
        }

        System.out.println();
    }

    private class ADIterator implements Iterator<T>{
        private int wizPos;
        public ADIterator() {
            wizPos = (head) % arr_size;
        }
        public boolean hasNext() {
            return wizPos < list_size;
        }
        public T next() {
            T retItem = arr[wizPos];
            wizPos = (wizPos + 1) % arr_size;
            return retItem;
        }
    }

    public Iterator<T> iterator() {
        return new ADIterator();
    }

    public boolean equals(Object o) {
        if (o instanceof ArrayDeque<?> cmp) {
            if (cmp.size() != list_size) {
                return false;
            }

            for (int i = 0 ; i < list_size ; i += 1) {
                if (cmp.get(i) != this.get(i)) {
                    return false;
                }
            }

            return true;
        }

        return false;

    }
}