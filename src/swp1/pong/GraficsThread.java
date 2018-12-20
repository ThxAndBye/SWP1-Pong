/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp1.pong;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author thxandbye
 */
public class GraficsThread implements Runnable {

    PongPanel pongPanel;
    PongInputListener pongInputListener;
    playerStatus playerOne;
    playerStatus playerTwo;

    public GraficsThread(PongPanel pongPanel, PongInputListener pongInputListener) {
        this.pongPanel = pongPanel;
        this.pongInputListener = pongInputListener;

        playerOne = pongInputListener.getPlayerOne();
        playerTwo = pongInputListener.getPlayerTwo();
    }

    @Override
    public void run() {

        while (true) {
            

            pongPanel.movePlayerOneHeight(playerOne.getStatus());
            pongPanel.movePlayerTwoHeight(playerTwo.getStatus());

            pongPanel.revalidate();
            pongPanel.repaint();

            try {
                Thread.sleep(16, 67);
            } catch (InterruptedException ex) {
                Logger.getLogger(GraficsThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
