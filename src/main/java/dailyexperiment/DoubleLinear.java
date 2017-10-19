package dailyexperiment;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by iaktas on 19.10.2017 at 13:46.
 */

class DoubleLinear {
    static int last;

    public static int dblLinear(int n) {
        TreeSet<Integer> t = new TreeSet(Arrays.asList(1));

        int calculatedElement = t.last();
        while (isContinue(t, n, calculatedElement)) {
            t.addAll(Arrays.asList(2 * calculatedElement + 1, 3 * calculatedElement + 1));
            calculatedElement = t.higher(calculatedElement);
        }
        return t.parallelStream().collect(Collectors.toList()).get(n);
    }

    private static boolean isContinue(TreeSet<Integer> t, int n, int calc) {
        if (t.size() <= n) {
            last = t.last();
            return true;
        }else if (t.size() > n && last > 2 * calc + 1){
            return true;
        }else{
            return false;
        }
    }
}
