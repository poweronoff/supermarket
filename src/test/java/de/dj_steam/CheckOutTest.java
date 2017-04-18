package de.dj_steam;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CheckOutTest {

    @Test
    public void testScan() throws Exception {
        CheckOut testPrice = new CheckOut();
        assertEquals(50, testPrice.scan('A'));
        assertEquals(80, testPrice.scan('B'));
        assertEquals(130, testPrice.scan('A'));
        assertEquals(160, testPrice.scan('A'));
        assertEquals(175, testPrice.scan('B'));
    }

    @Test
    public void testTotals() {
        CheckOut testPrice = new CheckOut();
        assertEquals(0, testPrice.calculatePriceForBucket("") );
        assertEquals(50, testPrice.calculatePriceForBucket("A"));
        assertEquals(80, testPrice.calculatePriceForBucket("AB"));
        assertEquals(115, testPrice.calculatePriceForBucket("CDBA"));

        assertEquals(100, testPrice.calculatePriceForBucket("AA"));
        assertEquals(130, testPrice.calculatePriceForBucket("AAA"));
        assertEquals(180, testPrice.calculatePriceForBucket("AAAA"));
        assertEquals(230, testPrice.calculatePriceForBucket("AAAAA"));
        assertEquals(260, testPrice.calculatePriceForBucket("AAAAAA"));

        assertEquals(160, testPrice.calculatePriceForBucket("AAAB"));
        assertEquals(175, testPrice.calculatePriceForBucket("AAABB"));
        assertEquals(190, testPrice.calculatePriceForBucket("AAABBD"));
        assertEquals(190, testPrice.calculatePriceForBucket("DABABA"));
    }
}