package venma;

import java.util.Arrays;
import java.util.Optional;

public enum Coin {
    NICKEL(5, 5000, 21210, 1950, 0),
    DIME(10, 2268, 17910, 1350, 1),
    QUARTER(25, 5670, 24257, 1956, 2);

    public static Optional<Coin> validate(Insert insert) {
        return Arrays.stream(values())
                .filter(coin -> coin.matches(insert))
                .findFirst();
    }

    private final int value;
    private final int weight;
    private final int diameter;
    private final int thickness;
    private final int payoutTube;

    Coin(int value, int weight, int diameter, int thickness, int payoutTube) {
        this.value = value;
        this.weight = weight;
        this.diameter = diameter;
        this.thickness = thickness;
        this.payoutTube = payoutTube;
    }

    public int value() {
        return value;
    }

    public int payoutTube() {
        return payoutTube;
    }

    private boolean matches(Insert insert) {
        return new Insert(weight, diameter, thickness).equals(insert);
    }
}
