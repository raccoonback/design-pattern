package strategy.wrong;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by koseungbin on 2019-08-03
 */

public class Calculator {
    public int calculate(boolean firstGuest, List<Item> items) {
        int sum = 0;
        for(Item item : items) {
            if(firstGuest) {
                sum += (item.getPrice() * 0.9);     // 첫 손님 10% 할인

            } else if(item.isFresh()) {
                sum += (item.getPrice() * 0.8);     // 덜 신선한 상품은 20% 할인

            } else {
                sum += item.getPrice();

            }

        }

        return sum;

    }

}

class Item {
    private String name;
    private int price;
    private LocalDateTime receivingTime;

    public Item(String name, int price, LocalDateTime receivingTime) {
        this.name = name;
        this.price = price;
        this.receivingTime = receivingTime;

    }

    int getPrice() {
        return price;

    }

    boolean isFresh() {
        return receivingTime.plusHours(6).isBefore(LocalDateTime.now());    // 입고 6시간 이전까지만 신선한 상품으로 간주

    }

}
