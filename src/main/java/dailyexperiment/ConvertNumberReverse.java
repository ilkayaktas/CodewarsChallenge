package dailyexperiment;

/**
 * Created by iaktas on 19.10.2017 at 16:13.
 */

class ConvertNumberReverse {
    public static int[] digitize(long n) {
        return new StringBuilder().append(n).reverse().toString().chars().map(operand -> operand-48).toArray();
    }
}
