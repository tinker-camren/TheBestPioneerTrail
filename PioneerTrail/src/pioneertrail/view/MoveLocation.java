/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import pioneertrail.PioneerTrail;
import static pioneertrail.control.MapControl.movePlayer;
import pioneertrail.exceptions.MapControlException;
import pioneertrail.model.Map;
import pioneertrail.model.Scene;

/**
 *
 * @author Danica
 */
class MoveLocation extends View {

    public MoveLocation() {
        super("**********"
                + "\nMove Location View"
                + "\n**********\n"
                + "\nAre you sure you want to move to the next location? (Y / N): ");
    }

//    public String[] getInputs() {
//        
//    }
    @Override
    public boolean doAction(String inputs) {

        Map map = PioneerTrail.getCurrentGame().getMap();
        Scene scene = map.getCurrentLocation().getScene();
        String menuItem = inputs.toUpperCase();

        if ("Y".equals(menuItem)) {
            try {
                movePlayer(map, map.getCurrentRow(), map.getCurrentColumn()); // or instead of 0,0 you can select a different starting location
            } catch (MapControlException te) {
                ErrorView.display(this.getClass().getName(), te.getMessage());
                return true;
            }
            System.out.println("Moving to " + scene.getSceneName()
                    + "\n" + scene.getDescription());
        } else if ("N".equals(menuItem)) {
            return true;
        } else {
            ErrorView.display(this.getClass().getName(), "Invalid input");
        }

        return true;
    }
}
