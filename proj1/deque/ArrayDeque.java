package deque;

public class ArrayDeque<T> {
    T[] arr;
    int head = 0;
    int tail = 0;
    int length , arr_size;

    public ArrayDeque() {
        arr = (T[]) new Object[8];
        head = 0;
        tail = 0;
        length = 0;
        arr_size = 8;
    }

    public int size() {
        return length;
    }

    public void addFirst(T x) {
        if (head == (tail - 1 + arr_size) % arr_size) resize(arr_size * 2);
        int target = (head + 1) % arr_size;
        arr[target] = x;
        head = target;
        length += 1;
    }

    public void addLast(T x) {
        if ((tail - 1 + arr_size) % arr_size == head) resize(arr_size * 2);
        arr[tail] = x;
        length += 1;
        tail = (tail + 1) % length;
    }

    public T get(int i) {
        if (i < 0 || i > length) return null;
        int target = (i + head) % length;
        return arr[target];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public T removeLast() {
        if (isEmpty()) return  null;
        int target = (tail - 1 + arr_size) % arr_size;
        T last = arr[target];
        tail = target;
        length -= 1;
        if (length * 4 < arr_size) resize(arr_size / 2);
        return last;
    }

    public T removeFirst() {
        if (isEmpty()) return null;
        T first = arr[head];
        length -= 1;
        head = (head - 1 + arr_size) % arr_size;
        if (length * 4 < arr_size) resize(arr_size / 2);
        return first;
    }

    public void resize(int cap) {
        T[] narr = (T[]) new Object[cap];
        int hh = head , tt = tail;
        int j = 0;

        while (hh < tt) {
            narr[j] = arr[hh];
            j ++;
            hh = (hh + 1) % arr_size;
        }

        arr_size = cap;
        head = 0;
        if (isEmpty()) tail = 0;
        else tail = j;
        arr = narr;
    }

    public void printDeque() {
        if (isEmpty()) System.out.println();
        int hh = head , tt = tail;
        while (hh < tt) {
            System.out.print(arr[hh]);
            System.out.print(' ');
            hh = (hh + 1) % arr_size;
        }

        System.out.println();
    }
}