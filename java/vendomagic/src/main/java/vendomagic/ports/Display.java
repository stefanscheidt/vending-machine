package vendomagic.ports;

/**
 * This interface must be used to control the vending machine display.
 */
public interface Display {

    /**
     * Display the specified text.
     *
     * @param text the text that should be shown
     */
    void show(String text);

}
