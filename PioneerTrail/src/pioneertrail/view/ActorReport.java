/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

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
        
        String menuItem = inputs.toUpperCase();

        if ("Q".equals(menuItem)) {
            return true;
        } else {
            ErrorView.display(this.getClass().getName(), "Invalid input");
        }
        
        return false;
    }
}


