/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.io.IOException;
import java.io.PrintWriter;
import pioneertrail.PioneerTrail;
import pioneertrail.control.ActorControl;
import pioneertrail.control.GameControl;
import pioneertrail.exceptions.ActorControlException;
import pioneertrail.exceptions.GameControlException;
import pioneertrail.model.ActorObject;
import pioneertrail.model.Game;

/**
 *
 * @author tinkerc
 */
public class ActorReport extends View {

    public ActorReport() {
        super("**********"
                + "\nActor Report"
                + "\n**********\n"
                + "\nEnter the file path where you would "
                + "like to save your report, or enter Q to quit: ");
    }

    @Override
    public boolean doAction(String inputs) {

        String filePath = inputs;
        ActorObject[] actors = PioneerTrail.getCurrentGame().getActors();
        
        //Create BufferedReader object for input file
        try (PrintWriter out = new PrintWriter(filePath)) {

            //Print title and column headings
            out.println("\n\n           Actor Report            ");
            out.printf("%n%-12s%6s%20s", "Name", "Health", "Sickness");
            out.printf("%n%-12s%6s%20s", "--------", "------", "--------");
            
            //Print Name, Health, and Sickness
            for (ActorObject actor : actors) {
                out.printf("%n%-12s%6d%20s", actor.getName(), 
                        actor.getHealth(), actor.getSickness());
            }
        } catch (IOException ex) {
            this.console.println("I/O Error: " + ex.getMessage());
            return true;
        }

        this.console.println("Report was saved to " + filePath);
        return true;
    }
}
