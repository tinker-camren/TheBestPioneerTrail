/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail;

import static java.time.Clock.system;
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

    public static void main(String[] args) {
        
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayStartProgramView();
    }

}
