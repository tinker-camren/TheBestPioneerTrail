/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail;

import pioneertrail.model.Actor;
import pioneertrail.model.Answer;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Player;
import pioneertrail.model.Tool;
import pioneertrail.model.Wagon;
import pioneertrail.model.Question;
import pioneertrail.model.QuestionScene;
import pioneertrail.model.RegularScene;
import pioneertrail.model.ResourceScene;
import pioneertrail.model.SicknessScene;

/**
 *
 * @author CTinker
 */
public class PioneerTrail {

    /**
     * @param args the command line arguments
     */
    
    static void CamrenTest() {

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
        SicknessScene brokenBoneSicknessScene = new SicknessScene();

        brokenBoneSicknessScene.setDescription("One of your family members has broken a bone on some rocky terrain. You must now choose to leave the broken bone"
                + " and let it heal naturally, which increases the chance of infection and death, or you can choose to rest and let it heal, which improves your chances of surviving");
        brokenBoneSicknessScene.setSicknessType(rockyRidgeRegularScene.getSicknessType());
        brokenBoneSicknessScene.setMortalityRate(.50);
        brokenBoneSicknessScene.setSceneInfo(rockyRidgeRegularScene);

        System.out.println(brokenBoneSicknessScene.toString());

        // test ResourceScene
        ResourceScene rockyRidgeResourceScene = new ResourceScene();

        rockyRidgeResourceScene.setAmount(5);
        rockyRidgeResourceScene.setSceneItemType("Water");

        System.out.println(rockyRidgeResourceScene.toString());

        // test Answer
        Answer brokenBoneAnswer1 = new Answer();

        brokenBoneAnswer1.setAnswer(false);

        System.out.println(brokenBoneAnswer1.toString());

        // test Question
        Question brokenBoneQuestion1 = new Question();
        
        brokenBoneQuestion1.setQuestionText("Do you want to use items to decrease the mortality rate?");
       brokenBoneQuestion1.setAnswer(brokenBoneAnswer1);
       
       System.out.println(brokenBoneQuestion1.toString());
       
       // test QuestionScene
       QuestionScene brokenBoneQuestionScene = new QuestionScene();
       
       brokenBoneQuestionScene.setQuestion(brokenBoneQuestion1);
       brokenBoneQuestionScene.setEffect("Decreases mortality rate by 5% per item");
       brokenBoneQuestionScene.setCorrectAnswer(true);
       
       System.out.println(brokenBoneQuestionScene.toString());

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
        CamrenTest();

    }

}
