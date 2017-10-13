package dailyexperiment;

/**
 * Created by iaktas on 19.09.2017 at 11:33.
 */

public class ASum {
    public static long findNb(long m) {
        long n = 0;
        long total=0;

        while (true){
            if(total==m){
                return n;
            } else if(total>m){
                return -1;
            } else{
                n++;
                total += (long)Math.pow(n, 3);
            }
        }
    }
}
