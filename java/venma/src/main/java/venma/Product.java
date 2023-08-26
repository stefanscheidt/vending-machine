package venma;

import java.util.Arrays;
import java.util.Optional;

public enum Product {
    COLA(100, 0), CHIPS(50, 1), CANDY(65, 2);

    private final int price;
    private final int slot;

    Product(int price, int slot) {
        this.price = price;
        this.slot = slot;
    }

    public int price() {
        return price;
    }

    public int slot() {
        return slot;
    }

    static Optional<Product> forSlot(int slot) {
        return Arrays.stream(values())
                .filter(product -> product.slot == slot)
                .findFirst();
    }
}
