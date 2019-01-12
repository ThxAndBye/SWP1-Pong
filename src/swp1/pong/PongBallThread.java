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
            
            pongPanel.revalidate();
            pongPanel.repaint();
            
            try {
                Thread.sleep(50, 67);
            } catch (InterruptedException ex) {
                Logger.getLogger(PongBallThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    private void moveBall() {
        paddleSize = pongPanel.paddleSize;
        //does the ball hit the border?
        if (bp.getY() <= 20 || bp.getY() >= height - 20) {
            
            if (currentBallDirY.equals("+")) {
                bp.setY(bp.getY() - pongPanel.getHeight() / 100);
                currentBallDirY = "-";
            } else if (currentBallDirY.equals("-")) {
                bp.setY(bp.getY() + pongPanel.getHeight() / 100);
                currentBallDirY = "+";
            }

            //does the ball hit the paddle?
            //right/up
//            if (currentBallDirX.equals("+") && currentBallDirY.equals("-")) {
//
//                bp.setY(bp.getY() + pongPanel.getHeight() / 100);
//                bp.setX(bp.getX() + pongPanel.getWidth() / 100);
//                currentBallDirY = "+";
//
//                //left/up
//            } else if (currentBallDirX.equals("-") && currentBallDirY.equals("-")) {
//
//                bp.setY(bp.getY() + pongPanel.getHeight() / 100);
//                bp.setX(bp.getX() - pongPanel.getWidth() / 100);
//                currentBallDirY = "+";
//            } //left/down
//            else if (currentBallDirX.equals("-") && currentBallDirY.equals("+")) {
//
//                bp.setY(bp.getY() - pongPanel.getHeight() / 100);
//                bp.setX(bp.getX() - pongPanel.getWidth() / 100);
//                currentBallDirY = "-";
//            } //right/down
//            else if (currentBallDirX.equals("+") && currentBallDirY.equals("+")) {
//
//                bp.setY(bp.getY() - pongPanel.getHeight() / 100);
//                bp.setX(bp.getX() + pongPanel.getWidth() / 100);
//                currentBallDirY = "-";
//
//            }

        } 
        
                else if (bp.getX() <= 32 || bp.getX() >= width - 32) {
            if (currentBallDirX.equals("+")) {
                //ball hits the paddle (playerOne || right)
                if (bp.getY() > pongPanel.currentPlayerOneHeight - paddleSize && bp.getY() < pongPanel.currentPlayerOneHeight + paddleSize) {
                    bp.setX(bp.getX() - pongPanel.getWidth() / 100);
                    currentBallDirX = "-";
                } //set ball postion back to the middle
                else {
                    System.exit(0);
                }
            } else if (currentBallDirX.equals("-")) {
                //ball hits the paddle (playerOne || right)
                if (bp.getY() > pongPanel.currentPlayerTwoHeight - paddleSize && bp.getY() < pongPanel.currentPlayerTwoHeight + paddleSize) {
                    bp.setX(bp.getX() + pongPanel.getWidth() / 100);
                    currentBallDirX = "+";
                } else {
                    System.exit(0);
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
