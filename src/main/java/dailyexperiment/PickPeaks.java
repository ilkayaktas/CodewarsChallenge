package dailyexperiment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by iaktas on 17.10.2017 at 14:25.
 */

public class PickPeaks {
    public static Map<String,List<Integer>> getPeaks(int[] arr) {
        Map<String,List<Integer>> expected = new HashMap<>();
        expected.put("pos",  new ArrayList<>());
        expected.put("peaks", new ArrayList<>());

        int currentState = Integer.compare(arr[1], arr[0]), previousState, pos=-1, peak=-1;

        for (int i = 1; i < arr.length; i++) {
            previousState = currentState;

            currentState = Integer.compare(arr[i], arr[i-1]);
            if(currentState>0){
                pos = i;
                peak = arr[i];
            }

            if(previousState >= 0 && currentState < 0){
                expected.get("pos").add(pos);
                expected.get("peaks").add(peak);
            }
        }
        return expected;
    }

}
