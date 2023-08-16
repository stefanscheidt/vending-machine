package vendomagic.ports;

/**
 * This interface must be used to eject coins and place them in the coin return.
 */
public interface CoinBox {

    /**
     * Eject a single coin from the given coin tube.
     * For a model 9302GX, valid tube IDs are 0, 1, 2 for the three payout tubes.
     *
     * @param tube the tube ID
     */
    void eject(int tube);

}
