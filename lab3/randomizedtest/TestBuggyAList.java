package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */

public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        BuggyAList<Integer> bg = new BuggyAList<>();
        AListNoResizing<Integer> nb = new AListNoResizing<>();

        for (int i = 4 ; i <= 6 ; i ++)
        {
            bg.addLast(i);
            nb.addLast(i);
        }

        assertEquals(bg.size() , nb.size());

        assertEquals(bg.removeLast() , nb.removeLast());
        assertEquals(bg.removeLast() , nb.removeLast());
        assertEquals(bg.removeLast() , nb.removeLast());
    }

    @Test
    public  void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");

            } else if (operationNumber == 1) {
                // size
                int sizel = L.size();
                int sizeb = B.size();
                //System.out.println("size: " + sizel + sizeb);
                assertEquals(sizel , sizeb);
            }
            else if (operationNumber == 2 && L.size() > 0 && B.size() > 0) {
                int lastl = L.getLast();
                int lastb = B.getLast();
                //System.out.println("last: " + lastl + lastb);
                assertEquals(lastl , lastb);
            }
            else {
                if (L.size() > 0 && B.size() > 0) {
                    L.removeLast();
                    B.removeLast();
                    //System.out.println("Last element removed.");
                }
            }
        }
    }

}
