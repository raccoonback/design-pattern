package strategy;

/**
 * Created by koseungbin on 2019-08-03
 */

public class FreshDiscountStrategy implements DiscountStrategy {
    @Override
    public int getDiscountPrice(Item item) {
        return (int)(item.getPrice() * 0.8);
    }
}
