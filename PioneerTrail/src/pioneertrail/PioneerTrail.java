/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail;

import pioneertrail.model.Actor;
import pioneertrail.model.Game;
import pioneertrail.model.Player;

/**
 *
 * @author CTinker
 */
public class PioneerTrail {

    /**
     * @param args the command line arguments
     */
    
    void CamrenTest(){
        
    }
    
    void KathyTest() {
        
    }
    
    void DanicaTest() {
        
    }

    void TeamTest() {
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
        
    }
    
}
