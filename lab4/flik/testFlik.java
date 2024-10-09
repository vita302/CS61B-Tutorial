package flik;
import org.junit.Test;

import static org.junit.Assert.*;

public class testFlik {
    @Test
    public void sequencyTest() {
        int j = 0;
        for (int i = 0 ; i < 128 ; ++i , ++j) {
            System.out.print(i);
            System.out.println(j);
            assertTrue(Flik.isSameNumber(i , j));
        }
        System.out.println(Flik.isSameNumber(128 , 128));
    }
}
