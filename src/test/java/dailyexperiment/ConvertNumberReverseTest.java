package dailyexperiment;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by iaktas on 19.10.2017 at 16:20.
 */
public class ConvertNumberReverseTest {
    @Test
    public void testNumber(){
        assertArrayEquals(new int[] {1, 3, 2, 5, 3}, ConvertNumberReverse.digitize(35231));
    }

}