package de.dj_steam;

import de.dj_steam.strategy.PricingStrategy;

/**
 * Created by steam on 24.02.15.
 */
public class PriceContext {
    private PricingStrategy strategy = null;
    private String bucket = "";

    public void setStrategy(final PricingStrategy strategy, String bucket){
        this.strategy = strategy;
        this.bucket = bucket;
    }

    public int calculatePriceForProduct() {
        if (strategy != null){
            return strategy.calculatePrice(bucket);
        }
        return 0;
    }
}
