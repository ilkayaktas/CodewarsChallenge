package dailyexperiment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aselsan on 17.11.2017 at 11:25.
 */
public class MiddlePermutationTest {
    @Test
    public void basicTests() {
        assertEquals("bdca", MiddlePermutation.findMidPerm("abcd"));
        assertEquals("bac", MiddlePermutation.findMidPerm("abc"));
        assertEquals("cbxda", MiddlePermutation.findMidPerm("abcdx"));
        assertEquals("cxgdba", MiddlePermutation.findMidPerm("abcdxg"));
        assertEquals("dczxgba", MiddlePermutation.findMidPerm("abcdxgz"));
    }
}