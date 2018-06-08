/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.control;

import pioneertrail.model.Player;

/**
 *
 * @author tinkerc
 */
public class GameControl {

    public static Player savePlayer(String playersName) {
        System.out.println("*** savePlayer() called ***");
        return new Player();
    }
    
}
