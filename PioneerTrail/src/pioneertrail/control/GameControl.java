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
import pioneertrail.model.SceneType;
import pioneertrail.model.SicknessScene;
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
        
        item = new InventoryItem();
        item.setPrice(15);
        item.setDescription("Medical Supplies");
        item.setCount(10);
        item.setWeight(6);
        item.setItemType("Medical Supplies");
        items.add(InventoryItemEnum.MedicalSupplies.ordinal(), item);
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

        if (noOfRows < 0 || noOfColumns < 0) {
            return null;
        }
        if (items == null || items.size() < 1) {
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

    private static Location[][] createLocations(int noOfRows, int noOfColumns) {
        System.out.println("Create Locations");

        Location[][] locations = new Location[noOfRows][noOfColumns];
        for (int i = 0; i < (locations.length); i++) {
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

    private static RegularScene[] createScenes() {
        System.out.println("Create Regular Scene");

        RegularScene[] scenes = new RegularScene[25];
        RegularScene scene1 = new RegularScene();
        scene1.setSceneName("Nauvoo");
        scene1.setDescription("As the Latter-day Saints fled Missouri during the winter of 1838–39, "
                + "having been threatened with extermination by the governor of the state, "
                + "they crossed into Illinois and settled in a swampy area along the Mississippi River."
                + " They named the city Nauvoo.");
        scene1.setTerrainType("Swamp");
        scenes[SceneType.scene1.ordinal()] = scene1;

        //ResourceScene[] scenes = new ResourceScene[25]; --Sickness Scene
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
        scenes[SceneType.scene2.ordinal()] = scene2;
        
        //Sickness
        RegularScene scene3 = new RegularScene();
        scene3.setSceneName("Richardsons Point");
        scene3.setDescription("Suffering through 10 days of downpour, "
                + "the Camp of Israel stalled here while awaiting improved weather. "
                + "Some of the first deaths on the trail occurred here. "
                + "The effect of the rain on immediate travel led to the decision "
                + "to cache some artillery ordnance and also allowed many who wished "
                + "to return to Nauvoo for family members to do so. At least 30 men took "
                + "advantage of the opportunity");
        scene3.setTerrainType("Rainy, Swampy");
        scenes[SceneType.scene3.ordinal()] = scene3;
        
        //Sickness
        RegularScene scene4 = new RegularScene();
        scene4.setSceneName("Chariton River Crossing");
        scene4.setDescription("The main body of the pioneers chose to remain at Chariton "
                + "to wait out some of the worst weather of the Iowa crossing. "
                + "The pause allowed Saints scattered along the length of the trail to catch up, "
                + "completing the organization of the initial pioneer company. ");
        scene4.setTerrainType("Rainy, Swampy");
        scenes[SceneType.scene4.ordinal()] = scene4;
        
        //Resource
        RegularScene scene5 = new RegularScene();
        scene5.setSceneName("Locust Creek");
        scene5.setDescription("Also at Locust Creek, Brigham Young redirected the Camp of Israel"
                + " to a northwest heading in order to leave behind the trail-wise and unscrupulous "
                + "traders he felt were taking advantage of the company.");
        scene5.setTerrainType("Creek");
        scenes[SceneType.scene5.ordinal()] = scene5;
        
        //Resource, crops
        RegularScene scene6 = new RegularScene();
        scene6.setSceneName("Garden Grove");
        scene6.setDescription("Church leaders decided to create a substantial camp at this site, "
                + "a sort of temporary settlement to serve the thousands of weary and destitute "
                + "pioneers who would yet come this way. Cabins were erected, grounds were fenced and plowed, "
                + "crops were planted, and individuals were chosen to remain and oversee the camp. "
                + "The bodies of several Saints were laid to final rest in a windswept lot known as the “cow yard.” "
                + "The settlement was vacated in the spring of 1848.");
        scene6.setTerrainType("Resting area");
        scenes[SceneType.scene6.ordinal()] = scene6;
        
        //Regular
        RegularScene scene7 = new RegularScene();
        scene7.setSceneName("Mount Pisgah");
        scene7.setDescription("The resources at Garden Grove proved insufficient for meeting all the "
                + "needs of the Saints still crossing Iowa. A second, more expansive and permanent settlement"
                + " was established at Mount Pisgah, named in honor of the biblical mount from which Moses was "
                + "permitted to see the promised land. It was here that the U.S. Army first called on the Saints"
                + " to furnish volunteers for the Mormon Battalion.");
        scene7.setTerrainType("Creek");
        scenes[SceneType.scene7.ordinal()] = scene7;
        
        //Regular
        RegularScene scene8 = new RegularScene();
        scene8.setSceneName("Nishnabotna River Crossing");
        scene8.setDescription("The crossing of the Nishnabotna marks the meeting of two refugee peoples,"
                + " the Latter-day Saints and the Potawatomi Indians. The Potawatomi remained in the area "
                + "only during 1846, while Latter-day Saints on their way to Council Bluffs or points farther"
                + " west would continue to travel across the area for some time.");
        scene8.setTerrainType("River");
        scenes[SceneType.scene8.ordinal()] = scene8;
        
        //Regular
        RegularScene scene9 = new RegularScene();
        scene9.setSceneName("Grand Encampment");
        scene9.setDescription("This broad, open area became the stopping place for pioneer companies as they"
                + " approached the Missouri River. At this site, the current location of the Iowa School for "
                + "the Deaf, more than 500 volunteers of the Mormon Battalion officially mustered into the U.S."
                + " Army for service in the war with Mexico.");
        scene9.setTerrainType("Resting Area");
        scenes[SceneType.scene9.ordinal()] = scene9;
        
        //Regular
        RegularScene scene10 = new RegularScene();
        scene10.setSceneName("Council Bluffs");
        scene10.setDescription("Council Bluffs was a major outfitting point for Latter-day Saints and countless"
                + " others heading west during most of the overland emigration period. Located across the Missouri River"
                + " from Winter Quarters, Council Bluffs was one of the most significant Latter-day Saint settlements during"
                + " the late 1840s and early 1850s.");
        scene10.setTerrainType("Plain");
        scenes[SceneType.scene10.ordinal()] = scene10;
        
        //Sickness
        RegularScene scene11 = new RegularScene();
        scene11.setSceneName("Winter Quarters");
        scene11.setDescription("An instant city on the plains, Winter Quarters served as Church headquarters for less than a year,"
                + " until the leadership moved west in 1847. By Christmas 1846, Church members had built a large stockade and about"
                + " 700 homes ranging from solid, two-story structures to simple dugouts in the bluffs. For many, however, the rigors"
                + " of the Iowa crossing, exposure, and poor nutrition and sanitation proved too much, and several hundred Saints died"
                + " during the winter of 1846–47. ");
        scene11.setTerrainType("Plain");
        scenes[SceneType.scene11.ordinal()] = scene11;
        
        //Regular
        RegularScene scene12 = new RegularScene();
        scene12.setSceneName("Elkhorn River Crossing");
        scene12.setDescription("“Pursued our journey about 18 miles. Arrived at the Elkhorn River, where we found Capt. Dan Jones"
                + " encamped with the Welsh company of Saints, and Capt. Silas Richards with his company of fifty, encamped about"
                + " three miles west of the Elkhorn, awaiting our arrival.” ");
        scene12.setTerrainType("River");
        scenes[SceneType.scene12.ordinal()] = scene12;
        

        RegularScene scene13 = new RegularScene();
        scene13.setSceneName("Fort Kearny");
        scene13.setDescription("469 miles from Nauvoo."
                + "\nEstablished in June 1848 near Grand Island, Fort Kearny was the second fort named "
                + "\nafter Stephen Watts Kearny, the U.S. general of Mexican War fame. The first Fort Kearny, "
                + "\nestablished in May 1846, was located on the Missouri River, some 50 miles south of Council "
                + "\nBluffs. It was abandoned in May 1848.");
        scene13.setTerrainType("Valley");
        scenes[SceneType.scene13.ordinal()] = scene13;

        //Possible ResourceScene
        RegularScene scene14 = new RegularScene();
        scene14.setSceneName("Confluence Point");
        scene14.setDescription("563 miles from Nauvoo."
                + "\nOn May 11, 1847, at a location three-fourths of a mile north of the confluence of the "
                + "\nNorth and South Platte Rivers, members of Brigham Young’s vanguard company attached an "
                + "\nodometer (or roadometer) to the wheel of a wagon owned by Heber C. Kimball and driven "
                + "\nby Philo Johnson. The company first used the instrument on the morning of May 12, 1847, "
                + "\nand they used it for the rest of their journey to the Salt Lake Valley. The 1847 pioneers "
                + "\ndid not invent the roadometer, but the version they created was accurate enough for William"
                + "\nClayton to later use the recorded mileage in his famous The Latter-day Saints’ Emigrants’ "
                + "\nGuide.");
        scene14.setTerrainType("Valley");
        scenes[SceneType.scene14.ordinal()] = scene14;

        //Possible SicknessScene
        RegularScene scene15 = new RegularScene();
        scene15.setSceneName("Ash Hollow");
        scene15.setDescription("646 miles from Nauvoo."
                + "\nAsh Hollow, its original beauty ruined by thousands of passing emigrants, was noted "
                + "\nby countless diarists. Many commented that Sioux Indians were often at the site, and "
                + "\nin September 1855, General William S. Harney and a command of 600 soldiers attacked "
                + "\nan encampment of approximately 250 Sioux. Harney’s soldiers killed 86 men, women, and "
                + "\nchildren; took 70 captives; and looted and burned the encampment’s tepees. Ash Hollow "
                + "\nwas also a significant cholera graveyard during the gold rush years.");
        scene15.setTerrainType("Valley");
        scenes[SceneType.scene15.ordinal()] = scene15;

        RegularScene scene16 = new RegularScene();
        scene16.setSceneName("Chimney Rock");
        scene16.setDescription("718 miles from Nauvoo."
                + "\nThe Latter-day Saints, like hundreds of thousands of other Americans and emigrants "
                + "\nin the mid- to late 1800s, crossed the Great American Plains and the Rocky Mountains "
                + "\nin their quest for a better life in the West. But surely this was the most unusual "
                + "\ngroup to make the journey. Organized in companies—with captains, committees, and "
                + "\nchoirs—they sang, danced, and worshiped their way across half a continent, building "
                + "\nbridges, planting crops, and erecting shelters in an orchestrated effort to ensure a "
                + "\nbetter passage for those who would inevitably follow.");
        scene16.setTerrainType("Mountain");
        scenes[SceneType.scene16.ordinal()] = scene16;

        //Possible SicknessScene
        RegularScene scene17 = new RegularScene();
        scene17.setSceneName("Scotts Bluff");
        scene17.setDescription("738 miles from Nauvoo."
                + "\nScotts Bluff is named for Hiram Scott, a Rocky Mountain Fur Company trapper abandoned "
                + "\nhere by his companions when he became ill. Numerous accounts of his tragic death were "
                + "\nnoted by early travelers along the Platte River. As with many other landmarks along the "
                + "\nPlatte, virtually all those who kept journals mentioned it, including Latter-day Saints, "
                + "\nmost of whom were traveling on the north side of the river. Also located near the site "
                + "\nis the grave of Rebecca Winters, a Latter-day Saint mother who fell victim to cholera in "
                + "\n1852.");
        scene17.setTerrainType("Mountain");
        scenes[SceneType.scene17.ordinal()] = scene17;

        //Possible ResourceScene
        RegularScene scene18 = new RegularScene();
        scene18.setSceneName("Fort Laramie");
        scene18.setDescription("788 miles from Nauvoo."
                + "\nThe site was originally known as Fort William, then Fort John. The original site was "
                + "\nabandoned and Fort Laramie constructed nearby, taking its name from a French trapper, "
                + "\nJacques LaRamie. It always served as a trading post, even after it became a legitimate "
                + "\nU.S. military outpost in 1849. As a major resting and reprovisioning point for almost "
                + "\nall emigrants on the trek west, it was a welcome sight.");
        scene18.setTerrainType("Fort");
        scenes[SceneType.scene18.ordinal()] = scene18;

        RegularScene scene19 = new RegularScene();
        scene19.setSceneName("Sweetwater River");
        scene19.setDescription("It was a high, dry, and difficult 50-mile overland journey from the North Platte to the"
                + "\nSweetwater. Emigrants traveling to Salt Lake followed the Sweetwater for some distance "
                + "\ntowards South Pass.");
        scene19.setTerrainType("River");
        scenes[SceneType.scene19.ordinal()] = scene19;

        RegularScene scene20 = new RegularScene();
        scene20.setSceneName("Independence Rock");
        scene20.setDescription("965 miles from Nauvoo."
                + "\nThis site also is noted by most overland journalists due to the countless names carved "
                + "\non it. Its use as a name registry was already well established by the time Brigham Young "
                + "\nand the vanguard company passed it in June 1847.");
        scene20.setTerrainType("Mountain");
        scenes[SceneType.scene20.ordinal()] = scene20;

        //Possible ResourceScene
        RegularScene scene21 = new RegularScene();
        scene21.setSceneName("Fort Bridger");
        scene21.setDescription("1183 miles from Nauvoo."
                + "\nAt this famous fort, the Oregon Trail swung north from Fort Bridger while the Mormon "
                + "\nTrail continued on another 100 miles west to the Salt Lake Valley. In 1855, the Church "
                + "\npurchased the fort from Jim Bridger and his partner, Louis Vazquez, for $18,000. In "
                + "\nSeptember of 1857 it was burned to the ground to keep it from falling into the hands "
                + "\nof Albert Sidney Johnston's advancing federal army during the so-called \"Utah War.");
        scene21.setTerrainType("Fort");
        scenes[SceneType.scene21.ordinal()] = scene21;

        RegularScene scene22 = new RegularScene();
        scene22.setSceneName("Echo Canyon");
        scene22.setDescription("1246 miles from Nauvoo."
                + "\nThis was one of the last canyons the emigrants descended through before entering "
                + "\nthe Salt Lake Valley. Its high rock walls and narrow profile made it a veritable, "
                + "\nand frequently noted, echo chamber.");
        scene22.setTerrainType("Canyon");
        scenes[SceneType.scene22.ordinal()] = scene22;

        RegularScene scene23 = new RegularScene();
        scene23.setSceneName("Golden Pass Road");
        scene23.setDescription("1,281 miles from Nauvoo."
                + "\nIn 1848 Parley P. Pratt unsuccessfully petitioned Salt Lake City for $800 to construct "
                + "\na road through Big Canyon Creek in the Wasatch Mountains, just south of Emigration Canyon. "
                + "\nPratt thought Emigration Canyon was much too difficult and that the city needed another "
                + "\nentrance into the valley. The city refused his request for money, but he obtained the "
                + "\ndeed to the canyon and late in July 1849 began road construction in earnest.");
        scene23.setTerrainType("Canyon");
        scenes[SceneType.scene23.ordinal()] = scene23;

        RegularScene scene24 = new RegularScene();
        scene24.setSceneName("Emigration Canyon: Donner Hill");
        scene24.setDescription("1283 miles from Nauvoo."
                + "\nNearly one year to the day before the Latter-day Saints entered this canyon, the "
                + "\nfinal geographic obstacle between Big Mountain and the Salt Lake Valley, members "
                + "\nof the Reed-Donner wagon train heading to California blazed its length and carved "
                + "\nits first rough road.");
        scene24.setTerrainType("Canyon");
        scenes[SceneType.scene24.ordinal()] = scene24;

        RegularScene scene25 = new RegularScene();
        scene25.setSceneName("Zion");
        scene25.setDescription("1297 miles from Nauvoo."
                + "\nArrival in the Salt Lake Valley had a special meaning to each emigrant. For many "
                + "\nit signified the end of their arduous journey. They had endured to the end of the "
                + "\nMormon Trail, and their participation in that memorable trek gave metaphor and "
                + "\nmeaning to life itself. Even for those who were not Latter-day Saints, the first "
                + "\nglimpse of this broad, open valley after such hardship provided a deeply emotional "
                + "\nmoment.");
        scene25.setTerrainType("Valley");
        scenes[SceneType.scene25.ordinal()] = scene25;

//Assign values to each attribute in the Scene object
//Assign scene1 to its position in the scenes array
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

    private static void assignItemsToScenes(ArrayList<InventoryItem> items, RegularScene[] scenes) {
        System.out.println("Create Items to Scene");

    }

    private static void assignScenesToLocations(RegularScene[] scenes, Location[][] locations) {
        System.out.println("Create Scenes to Locations");

    }
}
