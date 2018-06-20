/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.control;

import java.util.ArrayList;
import pioneertrail.PioneerTrail;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Player;
import pioneertrail.model.Tool;
import pioneertrail.model.Wagon;

/**
 *
 * @author tinkerc
 */
public class GameControl {

    public static Player savePlayer(String playersName) {
        if (playersName.length() < 1) {

            return null;
        }
        Player player = new Player();
        player.setName(playersName);
        PioneerTrail.setPlayer(player);
        return new Player();
    }

    public static Game createNewGame(Player player) {
        System.out.println("Test create new game");
        Game game = new Game();
        game.setPlayer(player);
             
        //For Camren's Wagon holding items
        ArrayList<Tool> tools = new ArrayList<Tool>();
        ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
        InventoryItem item = new InventoryItem();
        
        //Create instances for testing
        Wagon wagon = new Wagon(); 
            wagon.setHealth(80);
            wagon.setMaxHealth(100);
            wagon.setWeight(250);
        game.setWagon(wagon);
        
        //Commented out because testing failed. Will use in the future
//        Tool tool = new Tool();
//            tool.setDurability(85);
//            tool.setMultiplier(2);
//            tool.setToolType("Hammer");
//            tools.add(tool);
//            
//        tool = new Tool();
//            tool.setDurability(60);
//            tool.setMultiplier(2);
//            tool.setToolType("Gun");
//            tools.add(tool);
//            wagon.setTools(tools);
//            
//        tool = new Tool();
//            tool.setDurability(70);
//            tool.setMultiplier(2);
//            tool.setToolType("Axe");
//            tools.add(tool);
//            wagon.setTools(tools);
//
//        item = new InventoryItem();
//            item.setCount(25);
//            item.setDescription("Used to repair wagons");
//            item.setItemType("Wood");
//            inventoryItems.add(item);
//            items.add(item);
//            wagon.setItems(items);
            
        Tool tool = new Tool();
            tool.setDurability(85);
            tool.setMultiplier(2);
            tool.setToolType("Hammer");
            tools.add(0, tool);
            
        tool = new Tool();
            tool.setDurability(60);
            tool.setMultiplier(2);
            tool.setToolType("Gun");
            tools.add(1, tool);
            
        tool = new Tool();
            tool.setDurability(70);
            tool.setMultiplier(2);
            tool.setToolType("Axe");
            tools.add(2, tool);
            wagon.setTools(tools);

        InventoryItem wood = new InventoryItem();
            wood.setCount(25);
            wood.setDescription("Used to repair wagons");
            wood.setItemType("Wood");
            items.add(0, wood);
            
//        InventoryItem water = new InventoryItem();
//            water.setCount(10);
//            water.setDescription("Powerhouse of life");
//            water.setItemType("Water");
//            water.setWeight(water.getCount() * 5);
//            items.add(1, water);
            
//        //add to InventoryItems arraylist in the wagon class
//        wagon.getItems().add(0, wood);
//        wagon.getItems().add(1, water);
//        
//        //add tools to arraylist in the wagon class
//        wagon.getTools().add(0, hammer);
//        wagon.getTools().add(1, gun);
//        wagon.getTools().add(2, axe);
        //End create instances
        
        //For Kathy's view
        item = new InventoryItem();
        item.setDescription("food");
        item.setCount(20);
        item.setItemType("potatoes");
        items.add(1, item);
        
        item = new InventoryItem();
        item.setDescription("drink");
        item.setCount(5);
        item.setItemType("water");
        item.setWeight(3);
        items.add(2, item);
        
        item = new InventoryItem();
        item.setDescription("food");
        item.setCount(8);
        item.setItemType("Meat");
        item.setWeight(10);
        items.add(3, item);
        wagon.setItems(items);
        //End for Kathy's view
        
        return game;
    }

    public static void saveGame() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("save game not implemented yet");
    }

}
