package strategy;

import java.time.LocalDateTime;

/**
 * Created by koseungbin on 2019-08-03
 */

public class Item {
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
