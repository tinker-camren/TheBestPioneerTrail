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

    public static void createNewGame(Player player) {
        System.out.println("Test create new game");
        Game game = new Game();
        PioneerTrail.setCurrentGame(game);
        
        ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
        InventoryItem item = new InventoryItem();
        item.setDescription("potatoes");
        item.setCount(20);
        item.setItemType("food");
        item.setWeight(1);
        items.add(item);
        
        item = new InventoryItem();
        item.setDescription("water");
        item.setCount(5);
        item.setItemType("drink");
        item.setWeight(3);
        items.add(item);
        game.setItems(items);
        
        item = new InventoryItem();
        item.setDescription("Meat");
        item.setCount(8);
        item.setItemType("food");
        item.setWeight(10);
        items.add(item);
        game.setItems(items);
    }

    public static void saveGame() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("save game not implemented yet");
    }

}
