///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pioneertrail.view;
//
//import java.util.ArrayList;
//import pioneertrail.PioneerTrail;
//import pioneertrail.control.ToolControl;
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
//        Tool tool = wagon.getTools().get(0);
//
//        String input = "\n**********"
//                + "\nSickness Menu"
//                + "\n**********";
//        input += ("\n\nWagon Health: " + wagon.getHealth());
//
//        if (tool.getToolType().equalsIgnoreCase("Hammer")) {
//            if (tool.getDurability() > 0) {
//                input += ("\nHammer Durability: " + tool.getDurability());
//            } else {
//                input += ("\nHammer broken or non-existent");
//            }
//        } else {
//            input += ("\nHammer broken or non-existent");
//        }
//        if (item.getItemType().equalsIgnoreCase("Wood")) {
//            if (item.getCount() > 0) {
//                input += ("\nWood Amount: " + item.getCount());
//            } else {
//                input += ("\nNo wood. You must gather wood before repairing"
//                        + " your wagon");
//            }
//        } else {
//            input += ("\nNo wood. You must gather wood before repairing"
//                    + " your wagon");
//        }
//        input += ("\n\nR - Repair Wagon "
//                + "\nQ - Quit ");
//        input += ("\nEnter your selection:");
//        //input = input;
//
//        return input;    
//    }
//    
////    @Override
////    public String[] getInputs() {
////        String[] inputs = new String[1];
////
////        System.out.println("**********"
////                + "\nSickness Menu"
////                + "\n**********");
////        System.out.println(
////                "F - View Family Members"
////                + "\nI - View inventory items"
////                + "\nT - View Tool List"
////                + "\nP - Purchase supplies"
////                + "\nM - Move to new location"
////                + "\nF - View Family Members"
////                + "\nG - Gather resources"
////                + "\nR - Repair wagon"
////                + "\nD - Deal with sickness"
////                + "\nH - Help"
////                + "\nS - Save game"
////                + "\nQ - Quit");
////        String input = this.getInput("\nEnter the amount of wood you would like "
////                + "to use, or enter any character to quit: ");
////        inputs[0] = input;
////
////        if (inputs[0].equalsIgnoreCase("Q")) {
////            return inputs;
////        }
////
////        try {
////            int menuItem = 0;
////            menuItem = Integer.parseInt(inputs[0]);
////        } catch (Exception ex) {
////            System.out.println("\nReturning to previous menu");
////            inputs[0] = "Q"; //Forces menu to quit if anything except an int is entered
////        }
////        return inputs;
////    }
//
//    @Override
//    public boolean doAction(String inputs) {
//
//        String menuItem = inputs.toUpperCase();
//
//        switch (menuItem) {
//            case "N":
//                startNewGame();
//                break;
//            case "R":
//                restartGame();
//                break;
//            case "H":
//                getHelp();
//                break;
//            case "E":
//                return true;
//
//            default:
//                System.out.println("Invalid menu item");
//
//        }
//
//        return false;
//    }
//
//    private void ActorSicknessMenu() {
//        ActorSicknessMenu actorSicknessMenu = new ActorSicknessMenu();
//        actorSicknessMenu.displayActorSicknessMenu();
//    }
//
//}
