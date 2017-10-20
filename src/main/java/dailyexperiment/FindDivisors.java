package dailyexperiment;

/**
 * Created by iaktas on 19.10.2017 at 16:38.
 */

public class FindDivisors {
    public long numberOfDivisors(int n) {
        long l = 0;
        for (int i = n; i >0 ; i--) {
            if(n%i==0)l++;
        }
        return l;
    }
}
