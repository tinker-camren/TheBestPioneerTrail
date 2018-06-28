///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pioneertrail.view;
//
//import java.util.ArrayList;
//import pioneertrail.PioneerTrail;
//import pioneertrail.control.ActorControl;
//import pioneertrail.control.InventoryControl;
//import pioneertrail.control.ToolControl;
//import pioneertrail.model.ActorEnum;
//import pioneertrail.model.ActorObject;
//import pioneertrail.model.Game;
//import pioneertrail.model.InventoryItem;
//import pioneertrail.model.Tool;
//import pioneertrail.model.Wagon;
//
///**
// *
// * @author Danica
// */
//class SicknessMenu extends View {
//    // This class is still under construction for Camren's incividual assignment
//    
//    public SicknessMenu() {
//        displayMessage = buildMenu();
//}
//    private String buildMenu() {
//
//        ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
//        Game game = PioneerTrail.getCurrentGame();
//        Wagon wagon = game.getWagon();
//        items = wagon.getItems();
//        InventoryItem item = items.get(0);
//
//        String input = "\n**********"
//                + "\nSickness Menu"
//                + "\n**********";
//        
//        ActorControl.listActorSickness();
//        
//        input += ("\n\n1 - Father"
//                + "\n2 - Mother"
//                + "\n3 - Child1"
//                + "\n4 - Child2"
//                + "\n5 - Child3");
//        input += ("\nEnter your selection or enter Q to quit:");
//
//        return input;    
//    }
//
//    @Override
//    public boolean doAction(String inputs) {
//        
//        try {
//            int menuItem = Integer.parseInt(inputs);
//        } catch(Exception ex) {
//            System.out.println("\nInvalid input, please enter a number");
//            return false;
//        }
//        
//        int menuItem = Integer.parseInt(inputs);
//        ActorObject actor = new ActorObject();
//        ActorObject[] actors = pioneertrail.PioneerTrail.getCurrentGame().getActors();
//        
//        switch (menuItem) {
//            case 1:
//                actor = actors[ActorEnum.Father.ordinal()];
//                actorSicknessMenu(actor);
//                break;
//            case 2:
//                actor = actors[ActorEnum.Mother.ordinal()];
//                actorSicknessMenu(actor);
//                break;
//            case 3:
//                actor = actors[ActorEnum.Child1.ordinal()];
//                actorSicknessMenu(actor);
//                break;
//            case 4:
//                actor = actors[ActorEnum.Child2.ordinal()];
//                actorSicknessMenu(actor);
//                break;
//            case 5:
//                actor = actors[ActorEnum.Child3.ordinal()];
//                actorSicknessMenu(actor);
//                break;
//
//            default:
//                System.out.println("Invalid menu item");
//
//        }
//
//        return false;
//    }
//
//    private void actorSicknessMenu(ActorObject actor) {
//        ActorSicknessMenu actorSicknessMenu = new ActorSicknessMenu();
//        actorSicknessMenu.displayActorSicknessMenu(actor);
//    }
//
//
//
//}
