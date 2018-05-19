/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail;

import pioneertrail.model.Actor;
import pioneertrail.model.Game;
import pioneertrail.model.Player;
import pioneertrail.model.RegularScene;

/**
 *
 * @author CTinker
 */
public class PioneerTrail {

    /**
     * @param args the command line arguments
     */
    
    static void CamrenTest(){
        
        // test RegularScene
        RegularScene rockyRidgeRegularScene = new RegularScene();
        
        //rockyRidgeRegularScene.setLocation(rockyRidge);
        rockyRidgeRegularScene.setDescription("You have just arrived at Rocky Ridge. This ridge has claimed the lives of many pioneers because of its steep and rugged terrain."
                + "It's hard on handcarts so you will need some spare wheels if you don't want an increased risk of damaging your wagon. There is also an increased chance of breaking bones in this terrain");
        rockyRidgeRegularScene.setSicknessType("Broken Bone");
        rockyRidgeRegularScene.setSicknessChance(.30);
        rockyRidgeRegularScene.setSceneName("Rocky Ridge");
        rockyRidgeRegularScene.setTerrainType("Rocky");
        rockyRidgeRegularScene.setTerrainEffect("Increased chance of broken bones and your wagon will be damaged if you don't have spare wheels");
        
        System.out.println(rockyRidgeRegularScene.toString());
                
        // test SicknessScene
        
        
        // test ResourceScene
        
        
        // test QuestionScene
        
        
        // test Question
        
        
        // test Answer
        
        
    }
    
    static void KathyTest() {
        
    }
    
    static void DanicaTest() {
        //InventoryItem test
        
        
        //Tool test
        
        
        //Wagon Test
        
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
        
        CamrenTest();
        
    }
    
}
