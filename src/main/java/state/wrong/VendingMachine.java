package state.wrong;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by koseungbin on 2019-08-04
 */

public class VendingMachine {
    private Integer balance;
    private Map<Integer, Product> products;
    private State state;

    public VendingMachine() {
        balance = 0;
        state = State.NOCOIN;
        initProducts();

    }

    private void initProducts() {
        products = new HashMap<>();
        products.put(1, new Product("오이", 500));
        products.put(2, new Product("참외", 1000));
        products.put(3, new Product("감자", 800));
        products.put(4, new Product("버섯", 200));
        products.put(5, new Product("사과", 100));

    }

    public void insertCoin(int coin) {
        switch (state) {
            case NOCOIN:
                increaseCoin(coin);
                state = State.SELECTABLE;
                break;

            case SELECTABLE:
                increaseCoin(coin);
                break;
            case SOLDOUT:
                returnCoin();

        }

    }

    public void select(int id) {
        switch (state) {
            case NOCOIN:
                // Nothing
                break;

            case SELECTABLE:
                provideProduct(id);
                decreaseCoin(id);
                if (hasNoCoin()) {
                    state = State.NOCOIN;

                }

                break;
            case SOLDOUT:
                // Nothing

        }

    }

    private void increaseCoin(int coin) {
        this.balance += coin;

    }

    private void decreaseCoin(int id) {
        this.balance -= products.get(id).price;

    }

    private boolean hasNoCoin() {
        return balance <= 0;

    }

    private String provideProduct(int id) {
        return products.get(id).dispense();

    }

    private void returnCoin() {
    }

    private class Product {
        private String name;
        private int price;

        private Product(String name, int price) {
            this.name = name;
            this.price = price;

        }

        String dispense() {
            return name;

        }

    }

    private enum State {
        NOCOIN, SELECTABLE, SOLDOUT;

    }

}