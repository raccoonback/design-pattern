package state.right;

/**
 * Created by koseungbin on 2019-08-04
 */

public interface State {
    void increaseCoin(int coin, VendingMachine vendingMachine);

    String select(int productId, VendingMachine vendingMachine);

}
