package strategy;

/**
 * Created by koseungbin on 2019-08-03
 */

public class GeneralDiscountStrategy implements DiscountStrategy {
    @Override
    public int getDiscountPrice(Item item) {
        return item.getPrice();

    }

}
