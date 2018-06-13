/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.control;

import pioneertrail.model.InventoryItem;
import pioneertrail.model.Tool;
import pioneertrail.model.Wagon;

/**
 *
 * @author Tinkerc
 */
public class ToolControl {
    
    //Camren
    public static int repairWagon(InventoryItem item, Tool tool, Wagon wagon) {
     
//        pseudo code
//        BEGIN
//            IF (InventoryItem.getType != ‘Wood’ ) THEN
//              RETURN -1
//            IF (Tool.getDurability <1) THEN
//              RETURN -2
//            IF (InventoryItem.getCount < 1) THEN
//              RETURN -3
//            IF (Tool.getType != ‘Hammer’) THEN
//              RETURN -4
//            IF ((InventoryItem.getCount * Tool.getMultiplier) + Wagon.getHealth > Wagon.getMaxHealth) THEN
//              Wagon.setHealth (Wagon.getMaxHealth)
//            Tool.setDurability (Tool.getDurability – InventoryItem.getCount)
//              Return Wagon.getHealth
//            Wagon.setHealth (InventoryItem.getCount * InventoryItem.getMultiplier) + Wagon.getHealth
//              Tool.setDurability (Tool.getDurability – InventoryItem.getCount)
//          RETURN  Wagon.getHealth


        if (item.getItemType() != "Wood") {
            return -1;
        }
        
        if (tool.getDurability() < 1) {
            return -2;
        }
        
        if (item.getCount() < 1) {
            return -3;
        }
        
        if (tool.getToolType() != "Hammer") {
            return -4;
        }
        
        if ((item.getCount() * tool.getMultiplier()) + wagon.getHealth() > wagon.getMaxHealth()) {
            wagon.setHealth(wagon.getMaxHealth());
            tool.setDurability(tool.getDurability() - item.getCount());
            return wagon.getHealth();
        }
        
        wagon.setHealth((item.getCount() * tool.getMultiplier()) + wagon.getHealth());
        tool.setDurability(tool.getDurability() - item.getCount());
        return wagon.getHealth();
    }

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

    //Kathy
    public static double calcFoodHunt(InventoryItem food){
    //Pseudocode:
    //BEGIN
        //IF (InventoryItem.getType == "Food") THEN
		//RETURN -1
        //IF (InventoryItem.getCount <1) THEN
                //RETURN -2
        //IF totalInventoryItem.getWeight + (inventoryItem.getWeight *   inventoryItem.getCount) > 200 THEN
		//RETURN -3
        //RETURN totalInventoryItem.getWeight + (inventoryItem.getWeight * inventoryItem.getCount)
    //END
    if (food.getItemType() == "Not food"){
	return -1; //if the item is something else than food
    }
    
    if (food.getCount() < 1){
        return -2; // if food is less than 1
    }
    if ((food.getWeight() + (food.getWeight() * food.getCount())) > 200){
        return -3; // food more than 200lbs
    }
    return (food.getWeight() + (food.getWeight() * food.getCount()));
    }

}
