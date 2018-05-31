/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.control;

import pioneertrail.model.InventoryItem;
import pioneertrail.model.Wagon;

/**
 *
 * @author tinkerc
 */
public class InventoryControl {
    
    public static double calcNewWeight(InventoryItem InventoryItem, Wagon Wagon) {
        
//        BEGIN
//            IF (inventoryItem.getWeight < 1) THEN
//                RETURN -1
// 
//            IF (inventoryItem.getCount < 1) THEN
//                RETURN -2
//
//            IF wagon.getWeight +  (inventoryItem.getWeight * inventoryItem.getCount) > maxWeight THEN
//                RETURN -3
//            RETURN wagon.getWeight + (inventoryItem.getWeight * inventoryItem.getCount)
//        END 	

        if (InventoryItem.getWeight() < 1) {
            return -1;
        }
        
        if (InventoryItem.getCount() < 1) {
            return -2;
        }
        
        if (Wagon.getWeight() + (InventoryItem.getWeight() * InventoryItem.getCount()) > Wagon.getMaxWeight()) {
            return -3;
        }
        
        return Wagon.getWeight() + (InventoryItem.getWeight() * InventoryItem.getCount());
    }
}
