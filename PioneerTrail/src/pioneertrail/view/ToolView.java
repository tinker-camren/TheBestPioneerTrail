/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.ArrayList;
import java.util.Scanner;
import pioneertrail.PioneerTrail;
import pioneertrail.control.ToolControl;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Tool;
import pioneertrail.model.Wagon;

/**
 *
 * @author Camren
 */
class ToolView extends View {

    public ToolView() {
        displayMessage = buildMenu();
    }

    private String buildMenu() {
        String input = "***********"
                + "\nTool List"
                + "\n***********";

        Game game = PioneerTrail.getCurrentGame();
        Wagon wagon = game.getWagon();
        Tool hammer = wagon.getTools().get(0);
        Tool gun = wagon.getTools().get(1);
        Tool axe = wagon.getTools().get(2);

        if (axe.getDurability() > 0) {
            input += ("\nTool Type: " + axe.getToolType());
            input += ("\n\tTool Durability: " + axe.getDurability());
        } else {
            input += ("\nAxe broken or non-existent");
        }

        if (hammer.getDurability() > 0) {
            input += ("\nTool Type: " + hammer.getToolType());
            input += ("\n\tTool Durability: " + hammer.getDurability());
        } else {
            input += ("\nHammer broken or non-existent");
        }

        if (gun.getDurability() > 0) {
            input += ("\nTool Type: " + gun.getToolType());
            input += ("\n\tTool Durability: " + gun.getDurability());
        } else {
            input += ("\nGun broken or non-existent");
        }
        
        input += ("\n\nS - Save Report");

        input += ("\n\nPress Enter or enter Q to quit");

        return input;
    }

    @Override
    public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();

        switch (menuItem) {
            case "S":
                toolReportView();
                break;
            case "Q":
                return true;

            default:
                ErrorView.display(this.getClass().getName(), "Invalid input");

        }

        return false;
    }

    private void toolReportView() {
        ToolReportView toolReportView = new ToolReportView();
        toolReportView.display();
    }
}
