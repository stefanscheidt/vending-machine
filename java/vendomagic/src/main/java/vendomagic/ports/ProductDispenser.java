package vendomagic.ports;

/**
 * This interface must be used to control the vending machine product dispenser.
 */
public interface ProductDispenser {

    /**
     * Dispense a product.
     * For a model 9302GX, valid product slots are 0 to 71.
     *
     * @param slot the slot of the product to dispense
     */
    void dispense(int slot);

}
