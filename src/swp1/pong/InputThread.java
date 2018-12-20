/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp1.pong;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thxandbye
 */
public class InputThread implements Runnable {

    PongInputListener input;

    public InputThread(PongInputListener input) {
        this.input = input;
    }

    @Override
    public void run() {
        while (true) {

            if (input.getPlayerOne().movingDown) {
                System.out.println("P1 moving Down");
            } else if (input.getPlayerOne().movingUp) {
                System.out.println("P1 moving up");
            }
            
            if (input.getPlayerTwo().movingDown) {
                System.out.println("P2 moving Down");
            } else if (input.getPlayerTwo().movingUp) {
                System.out.println("P2 moving up");
            }

            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }

}
