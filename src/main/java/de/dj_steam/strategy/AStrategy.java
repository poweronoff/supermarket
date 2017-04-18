package de.dj_steam.strategy;

/**
 * Created by steam on 24.02.15.
 */
public class AStrategy extends AbstractPricingStrategy implements PricingStrategy {

    private static final char PRODUCT_ID = 'A';
    private static final int PRICE = 50;
    private static final int PRICE_THRESHOLD = 3;
    private static final int DISCOUNT = 130;


    @Override
    public int calculatePrice(String products) {
        int productsNumber = calculateNumberOfProductsForType(products, PRODUCT_ID);
        return calculatePriceForAllProducts(productsNumber, PRICE, PRICE_THRESHOLD, DISCOUNT);
    }
}


