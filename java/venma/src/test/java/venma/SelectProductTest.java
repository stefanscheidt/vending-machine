package venma;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static venma.Product.*;
import static venma.ValidInserts.QUARTER_INSERT;

class SelectProductTest {

    private static final int COLA_SLOT = 0;
    private static final int CHIPS_SLOT = 1;
    private static final int CANDY_SLOT = 2;

    private TestDisplay display;
    private TestProductDispenser dispenser;
    private VendingMachine machine;

    @BeforeEach
    void setUp() {
        display = new TestDisplay();
        dispenser = new TestProductDispenser();
        machine = new VendingMachine(display, dispenser);
    }

    @Test
    void select_cola_dispenses_cola() {
        accept(QUARTER_INSERT, QUARTER_INSERT, QUARTER_INSERT, QUARTER_INSERT);
        machine.select(COLA_SLOT);
        assertThat(dispenser.dispensedProductSlots()).containsExactly(COLA_SLOT);
    }

    @Test
    void select_cola_updates_display() {
        accept(QUARTER_INSERT, QUARTER_INSERT, QUARTER_INSERT, QUARTER_INSERT);
        display.clear();
        machine.select(COLA_SLOT);
        assertThat(display.displayedText()).containsExactly("THANK YOU", "INSERT COIN");
    }

    @Test
    void select_cola_no_coins() {
        display.clear();
        machine.select(COLA_SLOT);
        assertThat(display.displayedText()).containsExactly("PRICE $1.00", "INSERT COIN");
    }

    @Test
    void select_chips_no_coins() {
        display.clear();
        machine.select(CHIPS_SLOT);
        assertThat(display.displayedText()).containsExactly("PRICE $0.50", "INSERT COIN");
    }

    @Test
    void select_candy_no_coins() {
        display.clear();
        machine.select(CANDY_SLOT);
        assertThat(display.displayedText()).containsExactly("PRICE $0.65", "INSERT COIN");
    }

    @Test
    void select_cola_insufficient_coins() {
        accept(QUARTER_INSERT, QUARTER_INSERT, QUARTER_INSERT);
        display.clear();
        machine.select(COLA.slot());
        assertThat(display.displayedText()).containsExactly("PRICE $1.00", "$0.75");
    }

    private void accept(Insert... inserts) {
        Arrays.stream(inserts).forEach(i ->
                machine.accept(i.weight(), i.diameter(), i.thickness())
        );
    }

}
