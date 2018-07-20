/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.ArrayList;
import pioneertrail.PioneerTrail;
import pioneertrail.control.InventoryControl;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.InventoryItemEnum;
import pioneertrail.model.Purchase;

/**
 *
 * @author Danica
 */
class SupplyPurchase extends View {

    public SupplyPurchase() {
        displayMessage = buildMenu();
    }

    private String buildMenu() {

        Game game = PioneerTrail.getCurrentGame();
        Purchase purchase = game.getPurchase();
        InventoryItem item = new InventoryItem();
        //InventoryControl.listItems();

        String input = "\n************"
                + "\nStore Items"
                + "\n************"
                + InventoryControl.listItems();

        input += "\n\n***********************"
                + "\nPurchase Supplies Menu"
                + "\n***********************";

        input += ("\nMoney $"
                + purchase.getMoney());

        ArrayList<InventoryItem> items = game.getWagon().getItems();
        int count = 0;
        for (InventoryItem currentItem : items) {
            input += "\n" + count + " - $" + currentItem.getPrice() + ": " + currentItem.getItemType();
            count++;
        }

        input += "\nQ - Return to previous MENU";
        if (purchase.getMoney() > 0) {
            input += ("\n\nMoney: $" + purchase.getMoney());
        } else {
            input += ("\nYou are out of money");
        }

        input += ("\n\nEnter a number 0-4 or Q to quit.");

        return input;
    }

    @Override
    public boolean doAction(String inputs) {

        try {
            int menuItem = Integer.parseInt(inputs);
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), "\nInvalid input, please enter a number or Q.");
            return false;
        }

        int menuItem = Integer.parseInt(inputs);
        InventoryItem item;
        ArrayList<InventoryItem> items = PioneerTrail.getCurrentGame().getPurchase().getItems();

        switch (menuItem) {
            case 0:
                item = items.get(InventoryItemEnum.Wood.ordinal());
                purchaseMenu(item);
                break;
            case 1:
                item = items.get(InventoryItemEnum.Potatoes.ordinal());
                purchaseMenu(item);
                break;
            case 2:
                item = items.get(InventoryItemEnum.Water.ordinal());
                purchaseMenu(item);
                break;
            case 3:
                item = items.get(InventoryItemEnum.Meat.ordinal());
                purchaseMenu(item);
                break;
            case 4:
                item = items.get(InventoryItemEnum.MedicalSupplies.ordinal());
                purchaseMenu(item);
                break;

            default:
                ErrorView.display(this.getClass().getName(), "Invalid menu item");
        }
        return false;
    }

    private void purchaseMenu(InventoryItem item) {
        PurchaseMenu purchaseMenu = new PurchaseMenu(item);
        purchaseMenu.display();
        displayMessage = buildMenu();
    }
}
