package de.dj_steam.strategy;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by steam on 24.02.15.
 */
class PricingStrategy {

    int calculatePriceForGivenProduct( final String bucket, final char productId, final int productPrice, final int priceThreshold, final int discount){
        int productsNumber = calculateNumberOfProductsForType(bucket, productId);
        return calculatePriceForAllProducts(productsNumber, productPrice, priceThreshold, discount);
    }

   private int calculateNumberOfProductsForType(final String products, final char product) {
        return StringUtils.countMatches(products, product);
    }

    private int calculatePriceForAllProducts(final int numberOfProducts, final int price, final int priceThreshold, final int discount) {
        if (priceThreshold > 0) {
            int remainder = numberOfProducts % priceThreshold;
            int triples = numberOfProducts / priceThreshold;
            return (triples * discount) + (remainder * price);
        } else {
            return numberOfProducts * price;
        }
    }
}
