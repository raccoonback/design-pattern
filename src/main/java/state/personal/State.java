package state.personal;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * Created by koseungbin on 2019-08-04
 */

public enum State {
    NOCOIN((coin, vm) -> vm.increaseCoin(coin), (id, vm) -> "코인이 존재하지 않습니다."),
    SELECTABLE((coin, vm) -> vm.increaseCoin(coin), (id, vm) -> {
        String product = vm.provideProduct(id);
        vm.decreaseCoin(id);
        return product;

    });

    private BiConsumer<Integer, VendingMachine> increaseFunc;
    private BiFunction<Integer, VendingMachine, String> selectFunc;

    State(BiConsumer<Integer, VendingMachine> increaseFunc, BiFunction<Integer, VendingMachine, String> selectFunc) {
        this.increaseFunc = increaseFunc;
        this.selectFunc = selectFunc;

    }

    public void increaseCoin(int coin, VendingMachine vm) {
        increaseFunc.accept(coin, vm);

    }

    public String select(int id, VendingMachine vm) {
        return selectFunc.apply(id, vm);

    }

}