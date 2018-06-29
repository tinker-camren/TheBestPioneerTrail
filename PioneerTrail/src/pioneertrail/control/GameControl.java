/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.control;

import java.util.ArrayList;
import pioneertrail.PioneerTrail;
import pioneertrail.model.ActorEnum;
import pioneertrail.model.ActorObject;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.InventoryItemEnum;
import pioneertrail.model.Location;
import pioneertrail.model.Map;
import pioneertrail.model.Player;
import pioneertrail.model.Purchase;
import pioneertrail.model.RegularScene;
import pioneertrail.model.ResourceScene;
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

    public static int createNewGame(Player player) {
        if (player == null) {
            return -1;
        }
        Game game = new Game();
        game.setPlayer(player);

        //Create wagon model layer object and save the data to the game
        Wagon wagon = createWagon();
        game.setWagon(wagon);

        Purchase purchase = new Purchase();
        purchase.setMoney(100);

        game.setPurchase(purchase);

        //Create Actor array and save the data to the game
        ActorObject[] actors = createActors();
        game.setActors(actors);

        //Create Array List of Inventory Items and save the data to the wagon object
        ArrayList<InventoryItem> items = createItems();
        wagon.setItems(items);

        //Saving array
        purchase.setItems(items);

        //Create Array List of Tools and save the data to the wagon object
        ArrayList<Tool> tools = createTools();
        wagon.setTools(tools);

        Map map = createMap(5, 5, items);
        game.setMap(map);

        PioneerTrail.setCurrentGame(game);
        return 1;
    }

    public static void saveGame() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("save game not implemented yet");
    }

    public static ActorObject[] createActors() {

        ActorObject[] actors = new ActorObject[5];

        ActorObject Father = new ActorObject();
        Father.setName("Kevin");
        Father.setGender("M");
        Father.setType("Adult");
        Father.setHealth(50);
        Father.setSickness("Broken Bone");
        actors[ActorEnum.Father.ordinal()] = Father;

        ActorObject Mother = new ActorObject();
        Mother.setName("Kannette");
        Mother.setGender("F");
        Mother.setType("Adult");
        Mother.setHealth(75);
        Mother.setSickness("Fatigue");
        actors[ActorEnum.Mother.ordinal()] = Mother;

        ActorObject Child1 = new ActorObject();
        Child1.setName("Chris");
        Child1.setGender("M");
        Child1.setType("Child");
        Child1.setHealth(100);
        Child1.setSickness("Healthy");
        actors[ActorEnum.Child1.ordinal()] = Child1;

        ActorObject Child2 = new ActorObject();
        Child2.setName("Thomas");
        Child2.setGender("M");
        Child2.setType("Child");
        Child2.setHealth(100);
        Child2.setSickness("Healthy");
        actors[ActorEnum.Child2.ordinal()] = Child2;

        ActorObject Child3 = new ActorObject();
        Child3.setName("Lili");
        Child3.setGender("F");
        Child3.setType("Child");
        Child3.setHealth(100);
        Child3.setSickness("Healthy");
        actors[ActorEnum.Child3.ordinal()] = Child3;

        return actors;
    }

    public static ArrayList<InventoryItem> createItems() {

        ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
        InventoryItem item = new InventoryItem();

        InventoryItem wood = new InventoryItem();
        wood.setPrice(5);
        wood.setDescription("Used to repair wagons");
        wood.setCount(10);
        item.setWeight(10);
        wood.setItemType("Wood");
        items.add(InventoryItemEnum.Wood.ordinal(), wood);

        item = new InventoryItem();
        item.setPrice(5);
        item.setDescription("food");
        item.setCount(10);
        item.setWeight(5);
        item.setItemType("potatoes");
        items.add(InventoryItemEnum.Potatoes.ordinal(), item);

        item = new InventoryItem();
        item.setPrice(2);
        item.setDescription("drink");
        item.setCount(10);
        item.setWeight(4);
        item.setItemType("water");
        items.add(InventoryItemEnum.Water.ordinal(), item);

        item = new InventoryItem();
        item.setPrice(8);
        item.setDescription("food");
        item.setCount(10);
        item.setWeight(6);
        item.setItemType("Meat");
        items.add(InventoryItemEnum.Meat.ordinal(), item);
//        wagon.setItems(items);

        return items;
    }

    public static ArrayList<Tool> createTools() {

        ArrayList<Tool> tools = new ArrayList<Tool>();
//        Game game = PioneerTrail.getCurrentGame();

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
//        wagon.setTools(tools);

        return tools;
    }

    public static Wagon createWagon() {

//        Game game = PioneerTrail.getCurrentGame();
        Wagon wagon = new Wagon();
        wagon.setHealth(80);
        wagon.setMaxHealth(100);
        wagon.setWeight(250);
//        game.setWagon(wagon);

        return wagon;
    }

    //purchase array
//    public static Purchase[] createPurchase() {
//
//        Purchase[] purchase = new Purchase[5];
//
//        Purchase Food = new Purchase();
//        Food.setPrice(.5);
//        Food.setType("food");
//        Food.setWeight(5);
//        Food.setCount(100);
//        Food.setDescription("Food for eating");
//        purchase[0] = Food;
//
//        Purchase Water = new Purchase();
//        Water.setPrice(.2);
//        Water.setType("water");
//        Water.setWeight(10);
//        Water.setCount(100);
//        Water.setDescription("Water for drinking");
//        purchase[1] = Water;
//
//        Purchase Wood = new Purchase();
//        Wood.setPrice(.5);
//        Wood.setType("wood");
//        Wood.setWeight(10);
//        Wood.setCount(100);
//        Wood.setDescription("Wood to repair the wagon and start fires");
//        purchase[2] = Wood;
//
//        Purchase Hammer = new Purchase();
//        Hammer.setPrice(1);
//        Hammer.setType("tool");
//        Hammer.setWeight(5);
//        Hammer.setCount(2);
//        Hammer.setDescription("Hammers are used to repair the wagon");
//        purchase[3] = Hammer;
//
//        Purchase Axe = new Purchase();
//        Axe.setPrice(1);
//        Axe.setType("tool");
//        Axe.setWeight(5);
//        Axe.setCount(2);
//        Axe.setDescription("Axes are used to chop and gather wood along the way");
//        purchase[4] = Axe;
//
//        return purchase;
//    }
    public static Map createMap(int noOfRows, int noOfColumns, ArrayList<InventoryItem> items) {
       
        if (noOfRows < 0 || noOfColumns < 0){
        return null;
    }
        if (items == null || items.size()< 1){
        return null;
    }
        Map map = new Map();
        map.setRowCount(noOfRows);
        map.setColumnCount(noOfColumns);
          
        
       Location[][] locations = createLocations(noOfRows, noOfColumns);
       map.setLocations(locations);
       System.out.println(map.getLocations());
       
       RegularScene[] scenes = createScenes();
       
       assignItemsToScenes(items, scenes);
       assignScenesToLocations(scenes, locations);
       
       System.out.println("CreateMap Method Called");
    return map;
           
       
    }
    private static Location[][] createLocations(int noOfRows, int noOfColumns){
    System.out.println("Create Locations");
    
    Location[][] locations = new Location[noOfRows][noOfColumns];
      for (int i = 0; i < (locations.length); i++ ) {
      for (int z = 0; z < (locations[i].length); z++) {
       Location location = new Location();
       location.setColumn(z);
       location.setRow(i);
       location.setVisited(false);
       locations[i][z] = location;
   }

    return locations;
}
    
    return null;
    }
    private static RegularScene[] createScenes(){
    System.out.println("Create Regular Scene");   
    
    RegularScene[] scenes = new RegularScene[25];
    RegularScene scene1 = new RegularScene();
    scene1.setSceneName("Nauvoo");
    scene1.setDescription("As the Latter-day Saints fled Missouri during the winter of 1838–39, "
            + "having been threatened with extermination by the governor of the state, "
            + "they crossed into Illinois and settled in a swampy area along the Mississippi River."
            + " They named the city Nauvoo.");
    scene1.setTerrainType("Swamp");
    scenes[0] = scene1;
    
    //ResourceScene[] scenes = new ResourceScene[25];
    RegularScene scene2 = new RegularScene();
    scene2.setSceneName("Sugar Creek");
    scene2.setDescription("This first major campsite in Iowa, about seven miles inland from the Mississippi River, "
            + "served an estimated 2,000 people in February 1846, including most of the Church leadership. "
            + "This first company of pioneers was known as the Camp of Israel. "
            + "The Sugar Creek camp also served as a portent of things to come. "
            + "Bone-chilling cold, wind, snow, and ice plagued the refugees with sickness and death. "
            + "Uncertainty about routes and destinations to the West, in addition to mounting problems with supplies and equipment, "
            + "kept the advance party from departing Sugar Creek for nearly a month.");
    scene2.setTerrainType("River");
    scenes[0] = scene2;
    
    
    
    
Assign values to each attribute in the Scene object
Assign scene1 to its position in the scenes array
//scene2 = Create a new ConstructionScene object
//Assign values to each attribute in the Scene object
//Assign scene2 to its position in the scenes array
//scene2 = Create a new ResourceScene object
//Assign values to each attribute in the Scene object
//Assign scene2 to its position in the scenes array
//…
//…
//…
//RETURN scenes 
    
    
    return null;
    }
    
    private static void assignItemsToScenes(ArrayList<InventoryItem> items,RegularScene[] scenes){
    System.out.println("Create Items to Scene");   
    
   
    }
    private static void assignScenesToLocations(RegularScene[] scenes,Location[][] locations){
    System.out.println("Create Scenes to Locations");   
    
        
    }
}
