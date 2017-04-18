package de.dj_steam.strategy;

/**
 * Created by steam on 24.02.15.
 */
public class AbstractPricingStrategy {

    protected int calculateNumberOfProductsForType(String products, char product) {
        int numberOfProducts = 0;
        for (int i = 0; i < products.length(); i++) {
            if (products.charAt(i) == product) {
                numberOfProducts++;
            }
        }
        return numberOfProducts;
    }

    protected int calculatePriceForAllProducts(int numberOfProducts, int price, int priceThreshold, int discount) {
        if (priceThreshold > 0) {
            int remainder = numberOfProducts % priceThreshold;
            int triples = numberOfProducts / priceThreshold;
            return (triples * discount) + (remainder * price);
        } else {
            return numberOfProducts * price;
        }
    }
}
