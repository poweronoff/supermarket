package de.dj_steam.strategy;

/**
 * Created by steam on 24.02.15.
 */
public class BStrategy extends PricingStrategy implements PriceCalculator{

    private static final char PRODUCT_ID = 'B';
    private static final int PRICE = 30;
    private static final int PRICE_THRESHOLD = 2;
    private static final int DISCOUNT = 45;

    @Override
    public int calculatePrice(final String bucket) {
        return calculatePriceForGivenProduct(bucket, PRODUCT_ID, PRICE, PRICE_THRESHOLD, DISCOUNT);
    }
}
