package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{

    Comparator<T> cmp;


    public MaxArrayDeque(Comparator<T> c) {
        cmp = c;
    }


    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        int target = 0;
        T tmpmax = get(target);
        for (int i = 1 ; i < size() ; i ++) {
            int res = c.compare(get(target) , tmpmax);
            if (res > 0) {
                tmpmax = get(target);
            }
            target = (target + 1) % getArr_size();
        }

        return tmpmax;
    }

    public T max() {
        return max(cmp);
    }
}
