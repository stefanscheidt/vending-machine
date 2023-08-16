# Vending Machine - Vendomagic Control Interfaces


## Description

This project provides the interfaces to control an imaginare vending machine "Vendomagic Model 9302GX".
This machine offers a display, a coin acceptor, a coin box with three payout tubes for three different types of coins,
buttons to select one out of 72 products, and a product dispenser.
Coins ejected from the payout tubes will be placed in a coin return.

For the coin box, the display and the product dispenser, a control unit will get access to implementations of these
interfaces to be able to control the machine.

The interfaces for the coin acceptor and the product selector must be implemented by the control unit.
The control unit will be called by the vending machine hardware via these interfaces.

For details see the Javadoc of the interfaces:

| Feature          | Interface                                                                | Type             |
|------------------|--------------------------------------------------------------------------|------------------|
| accept coins     | [CoinAcceptor](src/main/java/vendomagic/ports/CoinAcceptor.java)         | must be provided |
| eject coins      | [CoinBox](src/main/java/vendomagic/ports/CoinBox.java)                   | must be used     |
| select product   | [ProductSelector](src/main/java/vendomagic/ports/ProductSelector.java)   | must be provided |
| dispense product | [ProductDispenser](src/main/java/vendomagic/ports/ProductDispenser.java) | must be used     |
| display text     | [Display](src/main/java/vendomagic/ports/Display.java)                   | must be used     |


## Reference

See [How Does Coin Vending Machine Mechanism Work](https://vendingmachineinsider.com/coin-vending-machine-mechanism/)
