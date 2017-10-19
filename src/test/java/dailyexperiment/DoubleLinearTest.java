package dailyexperiment;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by iaktas on 19.10.2017 at 13:46.
 */
class DoubleLinearTest {
    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests dblLinear");
        testing(DoubleLinear.dblLinear(10), 22);
        testing(DoubleLinear.dblLinear(20), 57);
        testing(DoubleLinear.dblLinear(30), 91);
        testing(DoubleLinear.dblLinear(50), 175);

    }
}