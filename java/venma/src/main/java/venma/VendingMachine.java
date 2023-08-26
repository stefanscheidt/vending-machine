package venma;

import vendomagic.ports.CoinAcceptor;
import vendomagic.ports.Display;
import vendomagic.ports.ProductDispenser;
import vendomagic.ports.ProductSelector;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;

public class VendingMachine implements CoinAcceptor, ProductSelector {

    private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);
    private static final String TEXT_INSERT_COIN = "INSERT COIN";
    private static final String TEXT_THANK_YOU = "THANK YOU";
    private static final String TEXT_PRICE = "PRICE";

    private final Display display;
    private final ProductDispenser productDispenser;

    private int totalAmount = 0;

    public VendingMachine(Display display, ProductDispenser productDispenser) {
        this.display = display;
        this.productDispenser = productDispenser;

        this.display.show(TEXT_INSERT_COIN);
    }

    @Override
    public int accept(int weight, int diameter, int thickness) {
        var coin = Coin.validate(new Insert(weight, diameter, thickness));

        if (coin.isEmpty()) {
            return INVALID_INSERT;
        }

        totalAmount += coin.get().value();
        display.show(formatAmount(totalAmount));
        return coin.get().payoutTube();
    }

    @Override
    public void select(int slot) {
        Optional<Integer> productPrice = Product.forSlot(slot).map(Product::price);

        if (productPrice.isEmpty()) {
            return;
        }

        if (productPrice.get() > totalAmount) {
            display.show("%s %s".formatted(TEXT_PRICE, formatAmount(productPrice.get())));
            display.show(totalAmount > 0 ? formatAmount(totalAmount) : TEXT_INSERT_COIN);
            return;
        }

        productDispenser.dispense(slot);
        display.show(TEXT_THANK_YOU);
        display.show(TEXT_INSERT_COIN);
    }

    private static String formatAmount(int amount) {
        return CURRENCY_FORMAT.format(amount / 100.0);
    }
}
