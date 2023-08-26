package venma;

import vendomagic.ports.ProductDispenser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestProductDispenser implements ProductDispenser {

    private final List<Integer> dispensedProductSlots = new ArrayList<>();

    @Override
    public void dispense(int slot) {
        this.dispensedProductSlots.add(slot);
    }

    public List<Integer> dispensedProductSlots() {
        return Collections.unmodifiableList(dispensedProductSlots);
    }

}
