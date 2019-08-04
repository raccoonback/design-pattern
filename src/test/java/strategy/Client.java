package strategy;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by koseungbin on 2019-08-03
 */

@DisplayName("Strategy Patten Test")
class Client {
    @Test
    void should_apply_general_strategy() {
        // given
        DiscountStrategy discountStrategy = new GeneralDiscountStrategy();
        Calculator calculator = new Calculator(discountStrategy);
        List<Item> items = Arrays.asList(new Item("사과", 1000, LocalDateTime.now()));

        // when
        int sum = calculator.calculate(items);

        // then
        assertEquals(1000, sum, "should not apply discounts");

    }

    @Test
    void should_apply_firstGuest_strategy() {
        // given
        DiscountStrategy discountStrategy = new FirstGuestDiscountStrategy();
        Calculator calculator = new Calculator(discountStrategy);
        List<Item> items = Arrays.asList(new Item("사과", 1000, LocalDateTime.now()));

        // when
        int sum = calculator.calculate(items);

        // then
        assertEquals(900, sum, "should apply 10% discounts");

    }

    @Test
    void should_apply_fresh_strategy() {
        // given
        DiscountStrategy discountStrategy = new FreshDiscountStrategy();
        Calculator calculator = new Calculator(discountStrategy);
        List<Item> items = Arrays.asList(new Item("사과", 1000, LocalDateTime.now()));

        // when
        int sum = calculator.calculate(items);

        // then
        assertEquals(800, sum, "should apply 20% discounts");

    }

}
