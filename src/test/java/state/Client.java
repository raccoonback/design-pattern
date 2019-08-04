package state;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import state.right.VendingMachine;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by koseungbin on 2019-08-04
 */

@DisplayName("State Patten Test")
class Client {
    @Test
    void should_no_coin_state_when_initialized() {
        // given
        VendingMachine vendingMachine = new VendingMachine();

        // when then
        assertTrue(vendingMachine.isNoCoinState(), "초기 생성시 No Coin 상태이어야 한다.");
        assertFalse(vendingMachine.isSelectableState(), "초기 생성시 Selectable 상태가 아니다.");

    }

    @Test
    void should_not_select_when_state_is_no_coin() {
        // given
        VendingMachine vendingMachine = new VendingMachine();

        // when then
        assertEquals("코인이 존재하지 않습니다.", vendingMachine.select(1));
        assertEquals("코인이 존재하지 않습니다.", vendingMachine.select(2));
        assertEquals("코인이 존재하지 않습니다.", vendingMachine.select(3));

    }

    @Test
    void should_change_to_selectable_state() {
        // given
        VendingMachine vendingMachine = new VendingMachine();

        // when
        vendingMachine.insertCoin(10);

        // then
        assertTrue(vendingMachine.isSelectableState(), "Coin 삽입할 경우, Selectable 상태로 변경된다.");
        assertFalse(vendingMachine.isNoCoinState(), "Coin 삽입할 경우, No Coin 상태가 아니다.");

    }

    @Test
    void should_take_item_when_insert_coin() {
        // given
        VendingMachine vendingMachine = new VendingMachine();

        // when
        vendingMachine.insertCoin(800);
        String product = vendingMachine.select(1);

        // then
        assertEquals("오이", product, "id = 1 인 상품을 반환한다.");

    }

    @Test
    void expect_remain_balance_when_select_item() {
        // given
        VendingMachine vendingMachine = new VendingMachine();

        // when
        vendingMachine.insertCoin(800);
        vendingMachine.select(1);
        int balance = vendingMachine.getBalance();

        // then
        assertEquals(300, balance, "VendingMachine 현재 잔금은 300(800 - 500)이다.");

    }

    @Test
    void expect_not_remain_balance_when_over_balance() {
        // given
        VendingMachine vendingMachine = new VendingMachine();

        // when
        vendingMachine.insertCoin(800);
        vendingMachine.select(3);
        int balance = vendingMachine.getBalance();

        // then
        assertEquals(0, balance, "VendingMachine 현재 잔금은 300(800 - 800)이다.");

    }

    @Test
    void should_change_no_coin_state_when_over_balance() {
        // given
        VendingMachine vendingMachine = new VendingMachine();

        // when
        vendingMachine.insertCoin(800);
        vendingMachine.select(3);

        // then
        assertTrue(vendingMachine.isNoCoinState(), "VendingMachine balance 모두 사용할 경우, No Coin 상태로 변경된다.");
        assertFalse(vendingMachine.isSelectableState(), "VendingMachine balance 모두 사용할 경우, Selectable 상태가 아니다.");

    }

}
