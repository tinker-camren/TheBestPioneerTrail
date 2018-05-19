/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail;

import pioneertrail.model.Actor;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Player;
import pioneertrail.model.Tool;
import pioneertrail.model.Wagon;

/**
 *
 * @author CTinker
 */
public class PioneerTrail {

    /**
     * @param args the command line arguments
     */
    static void CamrenTest() {

    }

    static void KathyTest() {

    }

    static void DanicaTest() {
        //InventoryItem test
        InventoryItem itemOne = new InventoryItem();

        itemOne.setDescription("Fresh drinking water is rejuvenating");
        itemOne.setWeight(1.5);
        itemOne.setItemType("Water");

        System.out.println(itemOne.toString());

        //Tool test
        Tool toolOne = new Tool();
        
        toolOne.setAction('H');
        toolOne.setDurability(50);
        toolOne.setToolType("Hammer");
        
        System.out.println(toolOne.toString());

        //Wagon Test
        Wagon wagonOne = new Wagon();
        
        wagonOne.setHealth(200);
        wagonOne.setInventoryWeight(75.5);
    }

    static void TeamTest() {
        //Player Test
        Player playerOne = new Player();

        playerOne.setName("Camren");
        playerOne.setScore(1500);

        System.out.println(playerOne.toString());

        //Actor Test
        Actor.Father.getName();
        Actor.Child2.getHealth();
        Actor.Child3.getType();
        Actor.Mother.getGender();
        Actor.Child1.getCoordinates();

        System.out.println(Actor.Child1.toString());

        //Game Test
        Game gameOne = new Game();

        gameOne.setPlayer(playerOne);
        gameOne.setMilesTraveled(100);
        gameOne.setNumPeople(4);

        System.out.println(gameOne.toString());
    }

    public static void main(String[] args) {
        TeamTest();
        DanicaTest();

    }

}
