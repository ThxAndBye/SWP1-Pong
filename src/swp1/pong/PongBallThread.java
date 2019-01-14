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
 * @author secret
 */
public class PongBallThread implements Runnable {

    int ballSpeed = 25;
    PongPanel pongPanel;
    BallPosition bp;
    int paddleSize;
    int height;
    int width;
    String currentBallDirX = "+";
    String currentBallDirY = "-";

    public PongBallThread(PongPanel pongPanel) {

        this.pongPanel = pongPanel;
        height = pongPanel.getHeight();
        width = pongPanel.getWidth();
        bp = pongPanel.bp;
    }

    @Override
    public void run() {

        while (true) {
            moveBall();

//            pongPanel.revalidate();
//            pongPanel.repaint();
            try {
                Thread.sleep(ballSpeed, 67);
            } catch (InterruptedException ex) {
                Logger.getLogger(PongBallThread.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void increaseSpeed() {
        if (ballSpeed >= 3) {
            ballSpeed -= 2;
        }
    }

    private void moveBall() {
        paddleSize = pongPanel.paddleSize + 5;
        //does the ball hit the border?
        if (bp.getY() <= 20 || bp.getY() >= height - 20) {

            if (currentBallDirY.equals("+")) {
                bp.setY(bp.getY() - pongPanel.getHeight() / 100);
                currentBallDirY = "-";
            } else if (currentBallDirY.equals("-")) {
                bp.setY(bp.getY() + pongPanel.getHeight() / 100);
                currentBallDirY = "+";
            }

        } else if (bp.getX() <= 32 || bp.getX() >= width - 32) {
            if (currentBallDirX.equals("+")) {
                //ball hits the paddle (playerOne || right)
                if (bp.getY() > pongPanel.currentPlayerOneHeight - paddleSize && bp.getY() < pongPanel.currentPlayerOneHeight + paddleSize) {
                    bp.setX(bp.getX() - pongPanel.getWidth() / 100);
                    currentBallDirX = "-";
                    increaseSpeed();
                } //set ball postion back to the middle
                else {
                    pongPanel.setScorePlayerOne();
                    bp.setX(width / 2);
                    bp.setY(height / 2);
                    currentBallDirX = "-";
                    ballSpeed = 25;
                }
            } else if (currentBallDirX.equals("-")) {
                //ball hits the paddle (playerOne || right)
                if (bp.getY() > pongPanel.currentPlayerTwoHeight - paddleSize && bp.getY() < pongPanel.currentPlayerTwoHeight + paddleSize) {
                    bp.setX(bp.getX() + pongPanel.getWidth() / 100);
                    currentBallDirX = "+";
                    increaseSpeed();
                } //set ball back to the middle
                else {
                    pongPanel.setScorePlayerTwo();
                    bp.setX(width / 2);
                    bp.setY(height / 2);
                    currentBallDirX = "+";
                    ballSpeed = 25;
                }
            }
        } else {
            if (currentBallDirY.equals("+")) {
                bp.setY(bp.getY() + pongPanel.getHeight() / 100);
            } else if (currentBallDirY.equals("-")) {
                bp.setY(bp.getY() - pongPanel.getHeight() / 100);
            }

            if (currentBallDirX.equals("-")) {
                bp.setX(bp.getX() - pongPanel.getWidth() / 100);
            } else if (currentBallDirX.equals("+")) {
                bp.setX(bp.getX() + pongPanel.getWidth() / 100);
            }
        }

    }
}
