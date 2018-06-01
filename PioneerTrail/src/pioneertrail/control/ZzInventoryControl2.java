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
public class ZzInventoryControl2 {
    
    public static double calcNewWeight(double itemWeight, int itemCount, double wagonWeight, double wagonMaxWeight) {
        
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



        if (itemWeight < 1) {
            return -1;
        }
        
        if (itemCount < 1) {
            return -2;
        }
        
        if (wagonWeight + (itemWeight * itemCount) > wagonMaxWeight) {
            return -3;
        }
        
        return wagonWeight + (itemWeight * itemCount);
    }
}
