package de.dj_steam.strategy;

/**
 * Created by steam on 24.02.15.
 */
public class DStrategy extends PricingStrategy implements PriceCalculator {

    private static final char PRODUCT_ID = 'D';
    private static final int PRICE = 15;
    private static final int PRICE_THRESHOLD = 0;
    private static final int DISCOUNT = 0;

    @Override
    public int calculatePrice(final String bucket) {
        return calculatePriceForGivenProduct(bucket, PRODUCT_ID, PRICE, PRICE_THRESHOLD, DISCOUNT);
    }
}
