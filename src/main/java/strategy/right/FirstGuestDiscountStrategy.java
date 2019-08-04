package strategy.right;

/**
 * Created by koseungbin on 2019-08-03
 */

public class FirstGuestDiscountStrategy implements DiscountStrategy {
    @Override
    public int getDiscountPrice(Item item) {
        return (int)(item.getPrice() * 0.9);

    }

}
