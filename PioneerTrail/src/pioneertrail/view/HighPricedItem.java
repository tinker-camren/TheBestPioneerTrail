/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.Scanner;
import pioneertrail.control.InventoryControl;
import pioneertrail.model.Purchase;

/**
 *
 * @author Danica
 */
class HighPricedItem extends View {

    public HighPricedItem() {
        displayMessage = buildMenu();
    }

    private String buildMenu() {

//        ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
//        Game game = PioneerTrail.getCurrentGame();
//        Wagon wagon = game.getWagon();
//        items = wagon.getItems();
//        InventoryItem item = items.get(0);
//        Tool tool = wagon.getTools().get(0);
        Purchase purchase = new Purchase();

        String input = "\n**********"
                + "\nHigh price"
                + "\n**********" 
                + "\nI am a high priced item stub."
                + "\nPress Q to return to previous menu.";

//      //Pseudocode: finding the largest value
//            max(list): number
//            BEGIN 
//                maxValue = list[0] 
//                FOR index = 1 TO list.length -1     
//                    IF ( list[index] > maxValue)     
//                    THEN           
//                        maxValue = list[index]      
//                    ENDIF 
//                ENDFOR 
//                RETURN maxValue 
//            END

            
        return input;
    }

    @Override
    public boolean doAction(String inputs) {

//        String menuItem = inputs.toUpperCase();
//
//        if ("R".equals(menuItem)) {
//            repairWagonMenu();
//        } else if ("Q".equals(menuItem)) {
//            return true;
//        } else {
//            System.out.println("Invalid menu item");
//        }
//
        return false;
    }
}

//        -----------
//        -----------
//        //InventoryControl.getPriceItems();
//        
//        //Scanner purchase = new Scanner(System.in);
//        
//        
////        -----
//                Test (can delete)
//        Scanner purchase = new Scanner(System.in);
//        
//        String first, second, answer;
//        System.out.println("Enter first name: ");
//        first = purchase.nextLine();
//        System.out.println("Enter last name: ");
//        second = purchase.nextLine();
//        answer = first + " " + second;
//        System.out.println(answer);
//        ----
//System.out.println(purchase.nextLine());

