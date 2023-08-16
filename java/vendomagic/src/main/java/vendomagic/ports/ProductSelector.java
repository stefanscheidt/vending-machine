package vendomagic.ports;

/**
 * This interface must be provided to receive a product selection.
 */
public interface ProductSelector {

    /**
     * This method is called when the vending machine user selects a product.
     * For a model 9302GX, valid product slots are 0 to 71.
     *
     * @param slot the slot of the product the user selected
     */
    void select(int slot);

}
