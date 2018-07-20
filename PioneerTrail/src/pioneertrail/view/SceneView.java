/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import pioneertrail.PioneerTrail;
import pioneertrail.control.ActorControl;
import pioneertrail.model.ActorObject;
import pioneertrail.model.Game;
import pioneertrail.model.ResourceScene;
import pioneertrail.model.Scene;
import pioneertrail.model.SicknessScene;

/**
 *
 * @author tinkerc
 */
public class SceneView extends View {

    public SceneView() {
        displayMessage = buildMenu();
    }
    
    private String buildMenu() {
        
        Game game = PioneerTrail.getCurrentGame();
        Scene scene = game.getMap().getCurrentLocation().getScene();
//        ResourceScene rScene = (ResourceScene) scene;
//        SicknessScene sScene = (SicknessScene) scene;
//        if (!rScene.getInventoryItems().isEmpty())
//            scene.setSceneType("Resource Scene");
//        if (!sScene.getSicknessType().isEmpty())
//            scene.setSceneType("Sickness Scene");
//        if (scene.getSceneType().isEmpty())
//            scene.setSceneType("Regular Scene");
        if (scene.getClass().getName().equalsIgnoreCase("pioneertrail.model.SicknessScene"))
            scene.setSceneType("Sickness Scene");
        if (scene.getClass().getName().equalsIgnoreCase("pioneertrail.model.ResourceScene"))
            scene.setSceneType("Resource Scene");
        if (scene.getClass().getName().equalsIgnoreCase("pioneertrail.model.RegularScene"))
            scene.setSceneType("Regular Scene");
        this.console.println(scene.getClass().getName());
        
        String input = "********************\n"
                + scene.getSceneName() + " Scene"
                + "\n********************";
        
        input += "\n\nDescription: " + "\n" + scene.getDescription();
        input += "\n\nScene Type: " + scene.getSceneType();
        
        if (scene.getSceneType().equalsIgnoreCase("Sickness Scene")) {
            ActorObject actor = ActorControl.catchSickness(scene);
            input += "\n" + actor.getName() + " Has caught " 
                     + actor.getSickness() + "!";
        }
        
        
        input += "\n\nG - Gather Resources (Only works if it's a resource scene)";
        input += "\nM - Go to the Game Menu";
        
        return input; 
    }
    
    @Override
    public boolean doAction(String inputs) {
        
        Game game = PioneerTrail.getCurrentGame();
        String menuItem = inputs.toUpperCase();

        switch (menuItem) {
            case "G":
                gatherResources();
                break;           
            case "E":
                //mainMenuView();
                return true;

            default:
                ErrorView.display(this.getClass().getName(), "Invalid menu item");
        }
        return true;
    }

    private void gatherResources() {
        GatherResources gatherResources = new GatherResources();
        gatherResources.display();
    }
        
}
