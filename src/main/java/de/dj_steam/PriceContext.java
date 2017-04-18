package de.dj_steam;

import de.dj_steam.strategy.PriceCalculator;

/**
 * Created by steam on 24.02.15.
 */
class PriceContext {
    private PriceCalculator strategy = null;
    private String bucket = "";

    void setStrategy(final PriceCalculator strategy, final String bucket){
        this.strategy = strategy;
        this.bucket = bucket;
    }

    int calculatePriceForProduct() {
        if (strategy != null){
            return strategy.calculatePrice(bucket);
        }
        return 0;
    }
}
