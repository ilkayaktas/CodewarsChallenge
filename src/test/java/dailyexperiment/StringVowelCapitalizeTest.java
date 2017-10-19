package dailyexperiment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ilkay on 20/10/2017 at 00:23.
 */
public class StringVowelCapitalizeTest {
    @Test
    public void swap_1() {
        assertEquals("HEllOWOrld!",StringVowelCapitalize.swap("HelloWorld!"));
    }
}