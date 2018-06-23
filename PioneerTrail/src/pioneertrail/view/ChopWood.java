/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

//import java.util.Scanner;
//import pioneertrail.PioneerTrail;
//import pioneertrail.control.ToolControl;
//import pioneertrail.model.Game;
//import pioneertrail.model.InventoryItem;
//import pioneertrail.model.Tool;
//import pioneertrail.model.Wagon;
//import pioneertrail.control.ToolControl;
/**
 *
 * @author Danica
 */
class ChopWood extends View {

    public ChopWood() {
        super("*********************"
                + "\nChop Wood MENU"
                + "\n*********************"
                + "\nThere are trees near the trail. "
                + "You decide to investigate."
                + "\nChop the trees with your axe?"
                + "\nY - Yes"
                + "\nN - No"
                + "\nQ - Quit");
    }

    @Override
    public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();

        if (menuItem.compareToIgnoreCase("Y") == 0) {
            System.out.println("You chopped some wood!");
            return false;
        } else if (menuItem.compareToIgnoreCase("N") == 0) {
            System.out.println("You decided not to chop wood.");
            return false;
        } else {
            System.out.println("Invalid menu item");
        }
        return false;
    }
}

//    public ChopWood() {
//        super("**********"
//                + "\nChop Wood"
//                + "\n**********"
//                + "Enter the amount of wood you would like to chop. "
//                + "Enter the weight of wood you would like to chop. "); //would one of these be in a different view?
//    }
//    @Override
//    public String[] getInputs() {
//        String[] inputs = new String[1];
//
///////////////////////
//        System.out.println("Input 1.");
//        double InventoryItem.getCount = scanner.nextInt();
//        System.out.println("Input 2.");
//        double inventoryItem.getWeight = scanner.nextInt();
////////////////////////
//        Scanner sc = new Scanner(System.in);
//        String input1 = sc.nextLine();
//        System.out.println(input1);
//
//        int inputA1 = sc.nextInt();
//        int inputA2 = sc.nextInt();
//        int inputA3 = sc.nextInt();
//        System.out.println("--------");
//        System.out.println(inputA1);
//        System.out.println(inputA2);
//        System.out.println(inputA3);
///////////////////////
//        System.out.println("**********"
//                + "\nChop Wood"
//                + "\n**********");
//
//        String input = this.getInput("\nEnter the amount of wood you would like to chop. "
//                // + "\nEnter the weight of wood. "
//                + "\nEnter Q to quit: ");
//        inputs[0] = input;
//
//        input = this.getInput("\nEnter the weight of wood you would like to chop. "
//                + "\nEnter Q to quit: ");
//        inputs[0] = input;
//
//        if (inputs[0].equalsIgnoreCase("Q")) {
//            return inputs;
//        }
//        try {
//            int menuItem = 0;
//            menuItem = Integer.parseInt(inputs[0]);
//        } catch (Exception ex) {
//            System.out.println("\nReturning to previous menu");
//            inputs[0] = "Q"; //Forces menu to quit if anything except an int is entered
////        }
//        return inputs;
//    }
//    @Override
//    public boolean doAction(String inputs) {
//        Game game = PioneerTrail.getCurrentGame();
//        Wagon wagon = game.getWagon();
//        InventoryItem item = wagon.getItems().get(0);
//        int menuItem = Integer.parseInt(inputs);
////        if (wagon.getMaxWeight() < item.getCount()) {
////            System.out.println("Your wagon cannot carry more wood.");
////            return false;
////        }
//        if (item.getItemType().equalsIgnoreCase("Wood")) {
//            int woodAmount = (item.getCount());
//            item.setCount(menuItem);
//            double scrap = .5;
//            double result = ToolControl.chopWood(item, scrap);
//            if (result == -1) {
//                System.out.println("Wood amount cannot be negative");
//                item.setCount(woodAmount);
//            } else if (result == -2) {
//                System.out.println("Wood weight cannot be negative.");
//                item.setWeight(woodAmount);
//            } else if (result == -3) {
//                System.out.println("Wood amount cannot be more than 15.");
//                item.setCount(woodAmount);
//            } else if (result == -4) {
//                System.out.println("Wood weight cannot be more than 12.");
//                item.setWeight(woodAmount);
//            } else {
//                System.out.println("Wood amount is: " + result);
//                item.setCount(woodAmount);
//                System.out.println("You now have " + item.getCount() + " wood.");
//            }
//        }
//        return false;
//    }
//}
//////IF ELSE MENU
//    @Override
//    public String[] getInputs() {
//        String[] inputs = new String[1];
//
//        System.out.println("*********************"
//                + "\nChop Wood MENU"
//                + "\n*********************");
//        System.out.println("There are trees near the trail. "
//                + "You decide to investigate.");
//        System.out.println(
//                "\nChop the trees with your axe?"
//                + "\nY - Yes"
//                + "\nN - No"
//                + "\nQ - Quit");
//        String input = this.getInput("Enter your selection: ");
//        inputs[0] = input;
//
//        return inputs;
//    }

//@Override
//    public boolean doAction(String[] inputs) {
//
//        String menuItem = inputs[0].toUpperCase();
//
//        if (menuItem.compareToIgnoreCase("Y") == 0) {
//            System.out.println("You chopped some wood!");
//            return false;
//        } else if (menuItem.compareToIgnoreCase("N") == 0) {
//            System.out.println("You decided not to chop wood.");
//            return false;
//        } else {
//            System.out.println("Invalid menu item");
//        }
//        return false;
//    }
//}
//
