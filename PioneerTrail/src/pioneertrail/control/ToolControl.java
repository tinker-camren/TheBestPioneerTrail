/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.control;

import pioneertrail.model.InventoryItem;

/**
 *
 * @author Tinkerc
 */
public class ToolControl {

    //Danica
    public static double chopWood(InventoryItem item, double scrap) {

//pseudocode:
        // BEGIN
        //   IF (item.getCount < 1) THEN
        //        RETURN -1
        //
        //   IF (item.getWeight < 1) THEN
        //	      RETURN - 2 
        //
        //   IF (item.getCount > 15) THEN
        //        RETURN -3
        //
        //   IF (item.getWeight > 12) THEN
        //        RETURN -4   	
        //
        //   RETURN item.getCount * (item.getWeight – item.getWeight * scrap)
        // END 
        
        if (item.getCount() < 1) { //is item count 0 or negative?
            return -1;
        }
        
        if (item.getWeight() < 1) { //is item weight 0 or negative?
            return -2;
        }
        
        if (item.getCount() > 15) { //is item count greater than 15?
            return -3;
        }
        
        if (item.getWeight() > 12) { //is item weight greater than 12?
            return -4;
        }
        
        return item.getCount() * (item.getWeight() - item.getWeight() * scrap);
    }

}
