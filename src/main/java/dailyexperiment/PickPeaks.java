package dailyexperiment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by iaktas on 10/18/17 at 9:57 AM.
 */
public class PickPeaks {
    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> expected = new HashMap<>();
        expected.put("pos", new ArrayList<>());
        expected.put("peaks", new ArrayList<>());

        int pos = -1, peak = -1;
        Direction previousDirection, direction = Direction.UNKNOWN;

        for (int i = 1; i < arr.length; i++) {
            previousDirection = direction;

            if (arr[i ] > arr[i-1]) {
                direction = Direction.UPWARD;
                pos = i;
                peak = arr[i];
            }
            if (arr[i] < arr[i-1]) {
                direction = Direction.DOWNWARD;
            }

            if (direction.equals(Direction.DOWNWARD) && previousDirection.equals(Direction.UPWARD)) {
                expected.get("pos").add(pos);
                expected.get("peaks").add(peak);
            }


        }
        return expected;
    }

    enum Direction {
        UNKNOWN,
        UPWARD,
        DOWNWARD
    }
}
