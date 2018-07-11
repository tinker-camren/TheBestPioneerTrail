/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.time.Clock.system;
import java.util.logging.Level;
import java.util.logging.Logger;
import pioneertrail.model.Actor;
import pioneertrail.model.Answer;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Location;
import pioneertrail.model.Map;
import pioneertrail.model.Player;
import pioneertrail.model.Tool;
import pioneertrail.model.Wagon;
import pioneertrail.model.Question;
import pioneertrail.model.QuestionScene;
import pioneertrail.model.RegularScene;
import pioneertrail.model.ResourceScene;
import pioneertrail.model.SicknessScene;
import pioneertrail.view.StartProgramView;

/**
 *
 * @author CTinker
 */
public class PioneerTrail {

    /**
     * @param args the command line arguments
     */
    private static Game currentGame = null;
    private static Player player = null;
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        PioneerTrail.logFile = logFile;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        PioneerTrail.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        PioneerTrail.inFile = inFile;
    }
    
    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        PioneerTrail.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        PioneerTrail.player = player;
    }

    public static void main(String[] args) {
        
        try {
        //Open character stream files for end user input and output
            inFile = new BufferedReader(new InputStreamReader(System.in));
            outFile = new PrintWriter(System.out, true);
            logFile = new PrintWriter("logFile.txt");
            
            //Start Program
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();
        
        } catch (Throwable me) {
            System.out.println("\nException " + me.toString()
                    + "\nCause: " + me.getCause()
                    + "\nMessage: " + me.getMessage());
            me.printStackTrace();
            
        } finally {
            try {
                if (PioneerTrail.inFile != null)
                    PioneerTrail.inFile.close();
                
                if (PioneerTrail.outFile != null)
                    PioneerTrail.outFile.close();
                
                if (PioneerTrail.logFile != null)
                    PioneerTrail.logFile.close();
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
        }

    }

}
