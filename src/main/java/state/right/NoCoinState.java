package state.right;

/**
 * Created by koseungbin on 2019-08-04
 */

public class NoCoinState implements State {
    @Override
    public void increaseCoin(int coin, VendingMachine vendingMachine) {
        vendingMachine.increaseCoin(coin);
        vendingMachine.changeState(new SelectableState());

    }

    @Override
    public String select(int productId, VendingMachine vendingMachine) {
        return "코인이 존재하지 않습니다.";

    }

}
