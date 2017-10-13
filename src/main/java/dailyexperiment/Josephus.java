package dailyexperiment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by iaktas on 19.09.2017 at 13:34.
 */

public class Josephus {
    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> newList = new ArrayList<>();
        Queue<T> queue = new LinkedList<>(items);

        while (true) {
            for (int i = 1; i < k; i++) {
                T element = queue.poll(); // get head from queue
                if (element == null) break;
                queue.add(element); // put back queue
            }
            T element = queue.poll();
            if (element == null) break;
            newList.add(element);
        }

        return newList;
    }
}
