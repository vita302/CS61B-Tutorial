package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{

    Comparator<T> cmp;
    ArrayDeque<T> arr;

    public MaxArrayDeque(Comparator<T> c) {
        arr = new ArrayDeque<T>();
        cmp = c;
    }


    public T max(Comparator<T> c) {
        if (arr.isEmpty()) {
            return null;
        }
        int target = arr.head;
        T tmpmax = arr.get(target);
        for (int i = 1 ; i < list_size ; i ++) {
            int res = c.compare(arr.get(target) , tmpmax);
            if (res > 0) {
                tmpmax = arr.get(target);
            }
            target = (target + 1) % arr.arr_size;
        }

        return tmpmax;
    }

    public T max() {
        return max(cmp);
    }
}
