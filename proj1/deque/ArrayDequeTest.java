package deque;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public  void testaddsizeempty() {
        ArrayDeque<String> dq = new ArrayDeque<>();
        assertEquals(true, dq.isEmpty());

        dq.addFirst("first");
        assertEquals(1, dq.size());

        dq.addLast("last");
        assertEquals(2, dq.size());

        dq.printDeque();

        String first = dq.removeFirst();
        assertEquals("first", first);

        String last = dq.removeLast();
        assertEquals("last", last);

        assertEquals(0, dq.size());
    }

    public ArrayDeque<Integer> create(int[] array) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int x : array) {
            dq.addLast(x);
        }
        return dq;
    }
    @Test
    public  void testgrowshrink() {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < 16; i++) {
            dq.addLast(i);
        }
        for (int i = -16; i < 0; i++) {
            dq.addFirst(i);
        }
        for (int i = -1; i >= 16; i--) {
            assertEquals(i,  (int)dq.get(i));
        }
        for (int i = 0; i < 30; i++) {
            dq.removeFirst();
        }
        assertEquals(2, dq.size());
        dq.printDeque();
    }
    /*
    public static void main(String[] args) {
        testgrowshrink();
    }

     */
}