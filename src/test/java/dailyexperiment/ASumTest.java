package dailyexperiment;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by iaktas on 19.09.2017 at 11:35.
 */
class ASumTest {
    @Test
    public void test1() {
        assertEquals(2022, ASum.findNb(4183059834009L));
    }
    @Test
    public void test2() {
        assertEquals(-1, ASum.findNb(24723578342962L));
    }
    @Test
    public void test3() {
        assertEquals(4824, ASum.findNb(135440716410000L));
    }
    @Test
    public void test4() {
        assertEquals(3568, ASum.findNb(40539911473216L));
        assertEquals(51467, ASum.findNb(1754172512247361284L));
    }
}