/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import pioneertrail.control.InventoryControl;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Purchase;

/**
 *
 * @author Danica
 */
class SupplyPurchase {

    void displaySupplyPurchase() {
        
        InventoryItem item = new InventoryItem();
        
        //System.out.println(item);

       InventoryControl.listItems();

    }
}
