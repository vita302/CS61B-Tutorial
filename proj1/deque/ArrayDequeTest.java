package deque;

import static org.junit.Assert.*;

import org.junit.Test;
/*
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

    public static void main(String[] args) {
        testgrowshrink();
    }


}

*/

public class ArrayDequeTest {
    @Test

    public void testRandom() {
        deque.ArrayDeque<Integer> student = new deque.ArrayDeque<>();
        ArrayDeque<Integer> solution = new ArrayDeque<>();
        String msg = "";
        for (int i = 0; i < 54569; i++) {
            double choice = 0.76;
            Integer randVal = 55;
            if (choice < 0.33) {
                student.addLast(randVal);
                solution.addLast(randVal);
                msg += "addLast(" + randVal + ")\n";
            } else if (choice < 0.67) {
                student.addFirst(randVal);
                solution.addFirst(randVal);
                msg += "addFirst(" + randVal + ")\n";
            } else {
                int size = student.size();
                msg += "size()\n";
                if (size > 0) {
                    if (randVal < 50) {
                        msg += "removeFirst()\n";
                        assertEquals(msg, solution.removeFirst(), student.removeFirst());
                    } else {
                        msg += "removeLast()\n";
                        assertEquals(msg, solution.removeLast(), student.removeLast());
                    }
                }
            }
        }
    }

    @Test
    public void testReSize() {
        deque.ArrayDeque<Integer> student = new deque.ArrayDeque<>();
        ArrayDeque<Integer> solution = new ArrayDeque<>();
        student.addFirst(1);
        solution.addFirst(1);
        student.addFirst(2);
        solution.addFirst(2);
        assertEquals(solution.removeFirst(), student.removeFirst());
        assertEquals(solution.removeFirst(), student.removeFirst());
    }

    @Test
    public void testReSize2() {
        deque.ArrayDeque<Integer> student = new deque.ArrayDeque<>();
        ArrayDeque<Integer> solution = new ArrayDeque<>();
        student.addLast(0);
        student.addLast(1);
        solution.addLast(0);
        solution.addLast(1);
        assertEquals(solution.removeFirst(), student.removeFirst());
        solution.addLast(3);
        solution.addLast(4);
        solution.addLast(5);
        solution.addLast(6);
        solution.addLast(7);
        solution.addLast(8);
        student.addLast(3);
        student.addLast(4);
        student.addLast(5);
        student.addLast(6);
        student.addLast(7);
        student.addLast(8);
        assertEquals(solution.removeFirst(), student.removeFirst());
    }
}