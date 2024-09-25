package deque;

import java.util.ArrayList;

public class ArrayDeque<Item> {

    public Item[] arr;
    public int arr_size;
    public int first;
    public int last;
    public int length;

    public ArrayDeque() {
        arr = (Item[]) new Object[8];
        arr_size = 0;
        length = 8;
        first = 0;
        last = 0;
    }

    public void resize(int cap) {
        Item[] narr = (Item[]) new Object[cap];
        int i = first;
        int j = 0;
        while (j < arr_size) {
            narr[j] = arr[i];
            i = (i + 1) % length;
            j ++;
        }
        first = 0;
        if (isEmpty()) last = 0;
        else last = j - 1;
        arr = narr;
        length = cap;
    }

    public Item removeLast() {
        if (isEmpty()) return null;
        int t = (last - 1) & (length - 1);

        Item x = arr[t];
        //arr[t] = null;
        last = t;
        arr_size -= 1;
        if (arr_size * 4 < length) resize(length / 2);
        return x;
    }

    public void addLast(Item x) {
        arr[last] = x;
        arr_size += 1;
        if ((last = (last + 1) & (length - 1)) == first) resize(length * 2);
    }

    public int size() {
        return arr_size;
    }

    public boolean isEmpty() {
        return arr_size == 0;
    }
    public void addFirst(Item x) {
        arr[first = (first - 1) & (length - 1)] = x;
        if (first == last - 1) resize(length * 2);
        arr_size += 1;
    }

    public Item removeFirst() {
        if (isEmpty()) return null;
        int h = first;
        Item x = (Item) arr[h];
        if (x == null) return null;

        arr[h] = null;
        first = (first + 1) & (length - 1);
        arr_size -= 1;
        if (arr_size * 4 < length) resize(length / 2);
        return x;
    }

    public Item get(int i) {
        if (i < 0 || i >= arr_size) return null;
        int pos = (i + first) % length;
        return arr[pos];
    }

    public void printDeque() {
        int hh = first , tt = last;

        while (hh < tt) {
            Item t = arr[hh];
            System.out.print(t);
            System.out.print(' ');
            hh = (hh + 1) % length;
        }
        System.out.println();
    }
}