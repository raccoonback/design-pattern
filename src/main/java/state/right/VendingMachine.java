package state.right;

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
        state = new NoCoinState();
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
        state.increaseCoin(coin, this);     // 상태 객체에 위임

    }

    public String select(int id) {
        return state.select(id, this);     // 상태 객체에 위임

    }

    void increaseCoin(int coin) {
        this.balance += coin;

    }

    void decreaseCoin(int id) {
        this.balance -= products.get(id).price;

    }

    boolean hasNoCoin() {
        return balance <= 0;

    }

    String provideProduct(int id) {
        return products.get(id).dispense();

    }

    void changeState(State newState) {
        this.state = newState;

    }

    public boolean isNoCoinState() {
        return state instanceof NoCoinState;

    }

    public boolean isSelectableState() {
        return state instanceof SelectableState;

    }

    public int getBalance() {
        return balance;

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

}