/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.control;

import java.util.ArrayList;
import pioneertrail.PioneerTrail;
import pioneertrail.model.ActorObject;
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
        ArrayList<ActorObject> actors = new ArrayList<ActorObject>();
                
        //Create instances for testing
        
        //Create Wagon
        Wagon wagon = new Wagon(); 
            wagon.setHealth(80);
            wagon.setMaxHealth(100);
            wagon.setWeight(250);
        game.setWagon(wagon);
        
        //Create Tools
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

        //Create Inventory Items
        InventoryItem wood = new InventoryItem();
            wood.setCount(25);
            wood.setDescription("Used to repair wagons");
            wood.setItemType("Wood");
            items.add(0, wood);
            
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
        
        //Create Actors
        ActorObject Father = new ActorObject();
            Father.setName("Kevin");
            Father.setGender("M");
            Father.setType("Adult");
            Father.setHealth(50);
            Father.setSickness("Broken Bone");
        
        ActorObject Mother = new ActorObject();
            Mother.setName("Kannette");
            Mother.setGender("F");
            Mother.setType("Adult");
            Mother.setHealth(75);
            Mother.setSickness("Fatigue");
            
        ActorObject Child1 = new ActorObject();
            Child1.setName("Chris");
            Child1.setGender("M");
            Child1.setType("Child");
            Child1.setHealth(100);
            Child1.setSickness("Healthy");
            
        ActorObject Child2 = new ActorObject();
            Child2.setName("Thomas");
            Child2.setGender("M");
            Child2.setType("Child");
            Child2.setHealth(100);
            Child2.setSickness("Healthy");
            
        ActorObject Child3 = new ActorObject();
            Child3.setName("Lili");
            Child3.setGender("F");
            Child3.setType("Child");
            Child3.setHealth(100);
            Child3.setSickness("Healthy");
        
        return game;
    }

    public static void saveGame() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("save game not implemented yet");
    }

}
