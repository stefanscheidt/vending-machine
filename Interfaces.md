# Vendomagic Control Interfaces

## Description

This project provides fictitious interfaces to control an fictitious vending machine "Vendomagic Model 9302GX".
This machine offers a display, a coin acceptor, a coin box with three payout tubes for three different types of coins, buttons to select one out of 72 products, and a product dispenser.
Coins ejected from the payout tubes will be placed in a coin return.

For the _coin box_, the _display_ and the _product dispenser_, the code you write will get access to implementations of these interfaces to be able to control the machine.

The interfaces for the _coin acceptor_ and the _product selector_ must be implemented by the code you write.
The code you write will be called by the vending machine hardware via these interfaces.

For details see the Javadoc of the Java version of the interfaces:

| Feature          | Interface          | Type             |
|------------------|--------------------|------------------|
| accept coins     | [CoinAcceptor]     | must be provided |
| eject coins      | [CoinBox]          | must be used     |
| select product   | [ProductSelector]  | must be provided |
| dispense product | [ProductDispenser] | must be used     |
| display text     | [Display]          | must be used     |


## Reference

See [How Does Coin Vending Machine Mechanism Work](https://vendingmachineinsider.com/coin-vending-machine-mechanism/)


[CoinAcceptor]: ./java/vendomagic/src/main/java/vendomagic/ports/CoinAcceptor.java     
[CoinBox]: ./java/vendomagic/src/main/java/vendomagic/ports/CoinBox.java         
[ProductSelector]: ./java/vendomagic/src/main/java/vendomagic/ports/ProductSelector.java
[ProductDispenser]: ./java/vendomagic/src/main/java/vendomagic/ports/ProductDispenser.java
[Display]: ./java/vendomagic/src/main/java/vendomagic/ports/Display.java
