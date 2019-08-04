package state.right;

/**
 * Created by koseungbin on 2019-08-04
 */

public class SelectableState implements State {
    @Override
    public void increaseCoin(int coin, VendingMachine vendingMachine) {
        vendingMachine.increaseCoin(coin);

    }

    @Override
    public String select(int productId, VendingMachine vendingMachine) {
        String product = vendingMachine.provideProduct(productId);
        vendingMachine.decreaseCoin(productId);
        if (vendingMachine.hasNoCoin()) {
            vendingMachine.changeState(new NoCoinState());

        }

        return product;

    }

}
