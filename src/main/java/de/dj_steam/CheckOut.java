package de.dj_steam;

import de.dj_steam.strategy.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steam on 24.02.15.
 */
public class CheckOut {

    private String bucket = "";
    private List<PricingStrategy> strategies;

    public CheckOut(){
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

    public int scan(char product){
        putIntoBucket(product);
        return updateTotalPrice();
    }

    public int calculatePriceForBucket(String products){
        int total = 0;
        this.bucket = products;
        PriceContext context = new PriceContext();

        for(PricingStrategy strategy : strategies){
            context.setStrategy(strategy, bucket);
            total += context.calculatePriceForProduct();
        }
        return total;
    }

    private void putIntoBucket(char product){
        bucket += product;
    }

    private int updateTotalPrice(){
      return calculatePriceForBucket(bucket);
    }
}
