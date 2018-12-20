/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp1.pong;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author thxandbye
 */
class PongPanel extends JPanel {

    int playerOneHeight;
    int playerTwoHeight;

    int paddleSize = 32;
    PongMain pongMain = new PongMain();

    public PongPanel() {
        
        setBackground(Color.BLACK);
        playerOneHeight = 100;
        playerTwoHeight = playerOneHeight;
    }

    @Override
    public void paintComponent(Graphics grafics) {
        super.paintComponent(grafics);

        //get window dimensions
        
        int width = this.getWidth();
        int height = this.getHeight();
        int middle = width / 2;

        //pattern for the field devider
        float[] dashedPattern = {10f, 10f};
        Stroke dashed = new BasicStroke(10f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 1.0f, dashedPattern, 0.0f);

        //set the parameters for the drawing
        Graphics2D g2 = (Graphics2D) grafics;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(10));

        //draw top and bottom line
        g2.drawLine(width - 10, 10, 10, 10);
        g2.drawLine(width - 10, height - 10, 10, height - 10);

        //draw player paddles
        //player 1
        g2.drawLine(25, playerOneHeight - paddleSize, 25, playerOneHeight + paddleSize);
        //player 2
        g2.drawLine(width - 25, playerTwoHeight - paddleSize, width - 25, playerTwoHeight + paddleSize);

        //draw field devider
        g2.setStroke(dashed);
        g2.drawLine(middle, 25, middle, height - 25);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(pongMain.getWindowWidth(), pongMain.getWindowHeight());
    }
    
    public void setPlayerOneHeight(int playerOneHeight) {
        this.playerOneHeight = playerOneHeight;

    }

    public void setPlayerTwoHeight(int playerTwoHeight) {
        this.playerTwoHeight = playerTwoHeight;
    }
    
}
