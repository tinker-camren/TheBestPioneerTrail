/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.Scanner;
import pioneertrail.model.Actor;

/**
 *
 * @author Kathy
 */
////////////6-23-18 changes
class FamilyMembers extends View {

    public FamilyMembers() {
        displayMessage = buildMenu();
    }

    private String buildMenu() {
        String input = "**********"
                + "\nFamily Members List"
                + "\nFind more about details of each actor"
                + "\n**********";

        int count = 0;
        for (Actor actor : Actor.values()) {
            count++;
            input += ("\n\t" + count + " - " + actor.getName());
        }
        input += ("\nEnter your selection(Press Q to quit): ");

            return input;
        }
////////////////6-23-18 changes end
        
//    @Override
//    public String[] getInputs() {
//        String[] inputs = new String[1];
//        boolean valid = false;
//
//        //Create test instances
////        Actor father;
////        father = new Actor();
////            father.setName("Richie");
////            father.setHealth(80);
////        Actor mother = new Actor();
////            mother.setName("Kathy");
////            mother.setHealth(70);
////        Actor child1 = new Actor();
////            child1.setName("Chris");
////            child1.setHealth(30);
//        //End test instances
//        while (valid == false) {
//        System.out.println("**********"
//                + "\nFamily Members List"
//                + "\nFind more about details of each actor"
//                + "\n**********");
//        int count = 0;
//        for (Actor actor : Actor.values()) {
//            count++;
//            System.out.println("\t" + count + " - " + actor.getName());
//        }
//        System.out.println("Enter your selection(Press Q to quit): ");
//        Scanner scanner = new Scanner(System.in);
//        inputs[0] = scanner.nextLine();
//        inputs[0] = inputs[0].trim();
//
//        if (inputs[0].length() < 1) {
//            System.out.println("You must enter a non-blank value");
//            continue; //Move to the top of the loop and repeat
//        }
//        valid = true;
//        return inputs;
//    }
//
//    return inputs ;
//}
//////////////6-23-18 some changes made
        @Override
        public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();

            int value = Integer.parseInt(menuItem);
            if ((value < 1) || (value > Actor.values().length)) {
                System.out.println("Invalid menu item");

                return false;
            }
//        this.name = name;
//        this.gender = gender;
//        this.type = type;
//        this.health = health;
//        this.coordinates = coordinates;
            value--;
            System.out.println("Name: " + Actor.values()[value].getName());
            System.out.println("Gender: " + Actor.values()[value].getGender());
            System.out.println("Type: " + Actor.values()[value].getType());
            System.out.println("Health: " + Actor.values()[value].getHealth());

            return false;
        }

    }
