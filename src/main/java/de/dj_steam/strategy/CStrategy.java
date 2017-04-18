package de.dj_steam.strategy;

/**
 * Created by steam on 24.02.15.
 */
public class CStrategy extends AbstractPricingStrategy implements PricingStrategy {

    private static final char PRODUCT_ID = 'C';
    private static final int PRICE = 20;
    private static final int PRICE_THRESHOLD = 0;
    private static final int DISCOUNT = 0;


    @Override
    public int calculatePrice(String products) {
        int productsNumber = calculateNumberOfProductsForType(products, PRODUCT_ID);
        return calculatePriceForAllProducts(productsNumber, PRICE, PRICE_THRESHOLD, DISCOUNT);
    }
}
