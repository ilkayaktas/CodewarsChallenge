package dailyexperiment;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.junit.Assert.assertEquals;

/**
 * Created by iaktas on 10/18/17 at 9:58 AM.
 */
public class PickPeaksTest {
    private static String[] msg = {"should support finding peaks",
            "should support finding peaks, but should ignore peaks on the edge of the array",
            "should support finding peaks; if the peak is a plateau, it should only return the position of the first element of the plateau",
            "should support finding peaks; if the peak is a plateau, it should only return the position of the first element of the plateau",
            "should support finding peaks, but should ignore peaks on the edge of the array",
            ""};

    private static int[][] array = {{1,2,3,6,4,1,2,3,2,1},
            {3,2,3,6,4,1,2,3,2,1,2,3},
            {3,2,3,6,4,1,2,3,2,1,2,2,2,1},
            {2,1,3,1,2,2,2,2,1},
            {2,1,3,1,2,2,2,2},
            {1,16,-4,5,-4}};

    private static int[][] posS  = {{3,7},
            {3,7},
            {3,7,10},
            {2,4},
            {2},
            {1,3}};

    private static int[][] peaksS = {{6,3},
            {6,3},
            {6,3,2},
            {3,2},
            {3},
            {16,5}};

    @Test
    public void sampleTests() {
        for (int n = 0 ; n < msg.length ; n++) {
            final int[] p1 = posS[n], p2 = peaksS[n];
            Map<String,List<Integer>> expected = new HashMap<String,List<Integer>>() {{
                put("pos",   Arrays.stream(p1).boxed().collect(Collectors.toList()));
                put("peaks", Arrays.stream(p2).boxed().collect(Collectors.toList()));
            }},
                    actual = PickPeaks.getPeaks(array[n]);
            assertEquals(msg[n], expected, actual);
        }
    }

    @Test
    public void moreTest(){
        final int[] p1 = posS[5], p2 = peaksS[5];
        Map<String,List<Integer>> expected = new HashMap<String,List<Integer>>() {{
            put("pos",   Arrays.stream(p1).boxed().collect(Collectors.toList()));
            put("peaks", Arrays.stream(p2).boxed().collect(Collectors.toList()));
        }},
                actual = PickPeaks.getPeaks(array[5]);
        assertEquals(msg[5], expected, actual);
    }
}