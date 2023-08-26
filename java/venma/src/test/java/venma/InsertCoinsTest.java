package venma;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static vendomagic.ports.CoinAcceptor.INVALID_INSERT;
import static venma.ValidInserts.*;

public class InsertCoinsTest {

    private static final int NICKEL_PAYOUT_TUBE = 0;
    private static final int DIME_PAYOUT_TUBE = 1;
    private static final int QUARTER_PAYOUT_TUBE = 2;

    private TestDisplay display;
    private VendingMachine machine;

    @BeforeEach
    void setUp() {
        display = new TestDisplay();
        machine = new VendingMachine(display, new TestProductDispenser());
    }

    @Test
    void accept_nickel() {
        assertThat(accept(NICKEL_INSERT)).isEqualTo(NICKEL_PAYOUT_TUBE);
    }

    @Test
    void accept_dime() {
        assertThat(accept(DIME_INSERT)).isEqualTo(DIME_PAYOUT_TUBE);
    }

    @Test
    void accept_quarter() {
        assertThat(accept(QUARTER_INSERT)).isEqualTo(QUARTER_PAYOUT_TUBE);
    }

    @Test
    void dont_accept_invalid_insert() {
        assertThat(machine.accept(1000, 1000, 1000)).isEqualTo(INVALID_INSERT);
    }

    @Test
    void show_total_amount_when_accepting_coins() {
        accept(NICKEL_INSERT);
        accept(QUARTER_INSERT);
        accept(DIME_INSERT);
        accept(DIME_INSERT);
        assertThat(display.displayedText()).containsExactly(
                "INSERT COIN",
                "$0.05",
                "$0.30",
                "$0.40",
                "$0.50"
        );
    }

    private int accept(Insert insert) {
        return machine.accept(insert.weight(), insert.diameter(), insert.thickness());
    }

}
