package dailyexperiment;

import java.util.Arrays;

/**
 * Created by iaktas on 19.09.2017 at 10:50.
 */

public class CountOfPositives {
    public static int[] countPositivesSumNegatives(int[] input)
    {

        int[] num;
        if(input == null || input.length == 0){
            num = new int[0];
        } else{
            num = new int[2];
            num[0] = (int) Arrays.stream(input).filter(i -> i > 0).count();
            num[1] = Arrays.stream(input).filter(i-> i < 0).sum();
        }
        return num;
    }
}
