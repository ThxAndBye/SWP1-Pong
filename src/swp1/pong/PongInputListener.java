/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp1.pong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author thxandbye
 */
public class PongInputListener extends KeyAdapter {

    private playerStatus playerOne;
    private playerStatus playerTwo;

    public PongInputListener(){
        playerOne = new playerStatus();
        playerTwo = new playerStatus();
    }
    
    public playerStatus getPlayerOne() {
        return playerOne;
    }

    public playerStatus getPlayerTwo() {
        return playerTwo;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case (KeyEvent.VK_DOWN):
                playerOne.setMovingDown(true);
                break;
            case (KeyEvent.VK_UP):
                playerOne.setMovingUp(true);
                break;
            case (KeyEvent.VK_S):
                playerTwo.setMovingDown(true);
                break;
            case (KeyEvent.VK_W):
                playerTwo.setMovingUp(true);
            default:
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case (KeyEvent.VK_DOWN):
                playerOne.setMovingDown(false);
                break;
            case (KeyEvent.VK_UP):
                playerOne.setMovingUp(false);
                break;
            case (KeyEvent.VK_S):
                playerTwo.setMovingDown(false);
                break;
            case (KeyEvent.VK_W):
                playerTwo.setMovingUp(false);
            default:
                break;
        }

    }

}

class playerStatus {

    boolean movingUp = false;
    boolean movingDown = false;

    public int getStatus() {
        if (movingDown && movingUp) {
            return 0;
        } else if (movingUp) {
            return -10;
        } else if (movingDown) {
            return 10;
        } else {
            return 0;
        }

    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }
}
