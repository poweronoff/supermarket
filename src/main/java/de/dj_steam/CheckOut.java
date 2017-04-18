package de.dj_steam;

import de.dj_steam.strategy.AStrategy;
import de.dj_steam.strategy.BStrategy;
import de.dj_steam.strategy.CStrategy;
import de.dj_steam.strategy.DStrategy;
import de.dj_steam.strategy.PriceCalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steam on 24.02.15.
 */
class CheckOut {

    private String bucket = "";
    private List<PriceCalculator> strategies;

    CheckOut() {
        initPriceStrategies();
    }

    /**
     * use this method for extend pricing strategy rules
     */
    private void initPriceStrategies() {
        strategies = new ArrayList<>();
        strategies.add(new AStrategy());
        strategies.add(new BStrategy());
        strategies.add(new CStrategy());
        strategies.add(new DStrategy());
    }

    int scan(char product) {
        putIntoBucket(product);
        return updateTotalPrice();
    }

    int calculatePriceForBucket(String products) {
        int total = 0;
        this.bucket = products;
        PriceContext context = new PriceContext();

        for (PriceCalculator strategy : strategies) {
            context.setStrategy(strategy, bucket);
            total += context.calculatePriceForProduct();
        }
        return total;
    }

    private void putIntoBucket(char product) {
        bucket += product;
    }

    private int updateTotalPrice() {
        return calculatePriceForBucket(bucket);
    }
}
