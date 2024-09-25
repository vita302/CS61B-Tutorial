package deque;
import org.junit.Test;
import static org.junit.Assert.*;


public class ArrayDequeTest {
    /*
    @Test
    public void RandomTest() {
        ArrayDeque<Integer> tt1 = new ArrayDeque<>();
        tt1.addFirst(10);
        tt1.addLast(11);
        int I = tt1.removeFirst();
        int II = tt1.removeLast();
        System.out.print(I + II);
    }

     */


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
}
