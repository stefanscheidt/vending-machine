package vendomagic.ports;

/**
 * This interface must be provided to accept or reject inserted coins.
 */
public interface CoinAcceptor {

    int INVALID_INSERT = -1;

    /**
     * Accept or reject an inserted coin.
     * All passed in measured values have absolute precision.
     * Return the ID of the payout tube the inserted coin should be put in.
     * For a model 9302GX, valid tube IDs are 0, 1, 2 for the three payout tubes.
     * Return -1 if the inserted coin should be rejected.
     *
     * @param weight the weight of the inserted coin in milligrams, with absolute precision
     * @param diameter the diameter of the inserted coin in micrometers, with absolute precision
     * @param thickness the thickness of the inserted coin in micrometers, with absolute precision
     *
     * @return the ID of the payout tube the inserted coin should be put in, or -1 if the coin should be rejected
     */
    int accept(int weight, int diameter, int thickness);

}
