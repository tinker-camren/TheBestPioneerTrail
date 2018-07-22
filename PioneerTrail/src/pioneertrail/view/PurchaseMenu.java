/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.ArrayList;
import pioneertrail.PioneerTrail;
import pioneertrail.control.GameControl;
import pioneertrail.control.InventoryControl;
import static pioneertrail.control.InventoryControl.purchase;
import pioneertrail.exceptions.GameControlException;
import pioneertrail.exceptions.InventoryControlException;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
//import pioneertrail.model.InventoryItemEnum;
import pioneertrail.model.Purchase;
import pioneertrail.model.Wagon;

/**
 *
 * @author Danica
 */
class PurchaseMenu extends View {

    public PurchaseMenu(InventoryItem item) {
        displayMessage = buildMenu(item);
    }

    private String buildMenu(InventoryItem item) {
        String input = "**************************\n"
                + item.getItemType() + " purchase menu"
                + "\n**************************\n\n"
                + "Would you like to buy " + item.getItemType() + "?"
                + "\n\nEnter the amount of items you would like to purchase, "
                + "\nor press Q to return to the previous MENU";

        //InventoryControl.listPriceSort();
        Purchase purchase = PioneerTrail.getCurrentGame().getPurchase();
        purchase.setCurrentItem(item);

        return input;
    }

    @Override
    public boolean doAction(String inputs) {

        int amount;

        try {
            amount = Integer.parseInt(inputs);
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), "\nInvalid input, please enter a number.");
            return false;
        }

        Game game = PioneerTrail.getCurrentGame();
        Wagon wagon = game.getWagon();
        Purchase purchase = game.getPurchase();
        InventoryItem item = purchase.getCurrentItem();
        item.setCount(amount);
        //purchase.setCount(amount);
        double result;

        try {
            result = InventoryControl.purchase(item, wagon, purchase);
        } catch (InventoryControlException ice1) {
            ErrorView.display(this.getClass().getName(), ice1.getMessage());
            return false;
        }

        this.console.println("\nYou bought " + result + " " + item.getItemType());

//        if (purchase.getMoney() - item.getPrice() * item.getCount() > 0) {
//            this.console.println("\nYou bought " + result + " " + item.getItemType());
//        } else {
//            this.console.println("\nYou cannot afford " + result + " " + item.getItemType());
//        }
        try {
            result = InventoryControl.money(item, purchase, wagon);
        } catch (InventoryControlException ice2) {
            ErrorView.display(this.getClass().getName(), ice2.getMessage());
            return false;
        }

//        this.console.println("\nWeight is " + item.getWeight());
        if (purchase.getMoney() > 0) {
            this.console.println("\nMoney is now $" + purchase.getMoney());
        } else {
            this.console.println("\nYou are out of money");
        }

        this.console.println("\nprice of " + item.getItemType() + ": " + "$" + item.getPrice());
        return false;
    }
}
