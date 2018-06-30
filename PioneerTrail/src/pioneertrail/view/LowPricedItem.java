/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import static java.util.Collections.list;
import java.util.Scanner;
import pioneertrail.control.ActorControl;
import pioneertrail.control.InventoryControl;

/**
 *
 * @author Danica
 */
class LowPricedItem extends View {

    public LowPricedItem() {
        displayMessage = buildMenu();
    }

    private String buildMenu() {

        String input = "\n**********"
                + "\nLow price"
                + "\n**********"
                + "\nI am a low priced item stub"
                + "\nPress Q to return to previous menu.";

        return input;
        
        
    }
    
//    public static int getMinValue(int[] numbers){
//  int minValue = numbers[0];
//  for(int i=1;i<numbers.length;i++){
//    if(numbers[i] < minValue){
//	  minValue = numbers[i];
//	}
//  }
//  return minValue;
//}

    @Override
    public boolean doAction(String inputs) {

//      Pseudocode:finding the smallest value
//        min(list): number 
//            BEGIN minValue = list[0] 
//                FOR index = 1 TO list.length -1      
//                IF ( list[index] < minValue)      
//                THEN           
//                    minValue = list[index]      
//                ENDIF 
//            ENDFOR 
//            RETURN minValue 
//        END

//        double minValue = 0;
//
//        minValue = list[0];
//        for (index = 1 : list.length -1) {
//        if (list[index] < minValue) {
//            minValue = list[index];
//        }
//    }
//        return minValue;

        return false;
    }
}

//        for (index = 0 list.length - 1) {
//                if ( list[index] == value);
//        return = index;
//    }
//        return -1;
//        maxValue = list[0];
//        for (index = 1 : list.length -1) {
//        if (list[index] > maxValue);
//    }
//        return maxValue;
//    

