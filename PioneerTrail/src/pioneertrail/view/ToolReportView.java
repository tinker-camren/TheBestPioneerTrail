/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import pioneertrail.PioneerTrail;
import static pioneertrail.PioneerTrail.getCurrentGame;
import pioneertrail.model.Game;
import pioneertrail.model.Tool;
import pioneertrail.model.Wagon;

/**
 *
 * @author Danica
 */
class ToolReportView extends View {

    public ToolReportView() {
        super("**********"
                + "\nTool Report"
                + "\n**********"
                + "\nEnter the file path where you would "
                + "\nlike to save this tool report, or "
                + "\nenter Q to return to the tool view: ");
    }

    @Override
    public boolean doAction(String inputs) {

        Game game = getCurrentGame();
        Wagon wagon = game.getWagon();
        String filePath = inputs;
        //Tool tools = PioneerTrail.getCurrentGame().getTool();

        //Create BufferedReader object for input file
        try (PrintWriter out = new PrintWriter(filePath)) {

            //Print title and column headings
            out.println("\n\n-------Tool Report-------");
            out.printf("%n%-14s%-10s", "Type", "Durability");
            out.printf("%n%-14s%-10s", "-----", "-----------");

            //get ToolType and Durability
            ArrayList<Tool> tools = PioneerTrail.getCurrentGame().getWagon().getTools();
            for (int i = 0; i < tools.size(); i++) {
                Tool tool = tools.get(i);
                out.printf("%n%-14s%-10s",
                        tool.getToolType(),
                        tool.getDurability());
            }

            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                ErrorView.display(this.getClass().getName(), "Error closing file");
                return true;
            }

        } catch (IOException ex) {
            this.console.println("I/O Error: " + ex.getMessage());
            return true;
        }

        this.console.println("\nReport was saved to " + filePath);
        return true;
    }
}
