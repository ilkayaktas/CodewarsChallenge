package dailyexperiment;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by iaktas on 18.09.2017 at 13:39.
 */
public class OrderWeightTest {
    OrderWeight orderWeight = new OrderWeight();

    @Test
    public void orderWeight2() {
        System.out.println("****** Basic Tests ******");
        assertEquals("2000 103 123 4444 99", orderWeight.orderWeight2("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", orderWeight.orderWeight2("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }

    @Test
    public void orderWeight1() {
        System.out.println("****** Basic Tests ******");
        assertEquals("2000 103 123 4444 99", orderWeight.orderWeight1("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", orderWeight.orderWeight1("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }

    @Test
    public void orderWeight() {
        System.out.println("****** Basic Tests ******");
        assertEquals("2000 103 123 4444 99", orderWeight.orderWeight("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", orderWeight.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));

    }

}