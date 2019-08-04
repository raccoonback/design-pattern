package strategy;

import java.util.List;

/**
 * Created by koseungbin on 2019-08-03
 */

public class Calculator {
    private DiscountStrategy discountStrategy;

    public Calculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;

    }

    public int calculate(List<Item> items) {
        int sum = 0;
        for(Item item : items) {
            sum += discountStrategy.getDiscountPrice(item);

        }

        return sum;

    }

}
