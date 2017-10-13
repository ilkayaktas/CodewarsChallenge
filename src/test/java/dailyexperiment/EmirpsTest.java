package dailyexperiment;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * Created by iaktas on 19.09.2017 at 15:25.
 */
class EmirpsTest {
    @Test
    void findEmirp() {
        long[] emiprs = Emirps.findEmirp(10);
        Assert.assertArrayEquals(new long[]{0,0,0}, emiprs);

        emiprs = Emirps.findEmirp(50);
        Assert.assertArrayEquals(new long[]{4, 37, 98}, emiprs);

        emiprs = Emirps.findEmirp(14958);
        Assert.assertArrayEquals(new long[]{446, 14957, 3661772}, emiprs);

    }

}