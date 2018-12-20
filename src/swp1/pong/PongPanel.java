/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp1.pong;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JPanel;

/**
 *
 * @author thxandbye
 */
class PongPanel extends JPanel {

    BallPosition bp;

    int playerOneHeight;
    int playerTwoHeight;
    int scorePlayerOne = 0;
    int scorePlayerTwo = 0;
    Font bitFont;

    int paddleSize = 32;
    PongMain pongMain = new PongMain();

    public PongPanel() {

        setBackground(Color.BLACK);
        playerOneHeight = pongMain.getWindowHeight() / 2;
        playerTwoHeight = playerOneHeight;

        try {
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("8bit16.ttf");
            bitFont = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(60f);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void paintComponent(Graphics grafics) {

        bp = new BallPosition(pongMain.getWindowWidth() / 2, pongMain.getWindowHeight() / 2);

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
        g2.drawLine(25, playerTwoHeight - paddleSize, 25, playerTwoHeight + paddleSize);
        //player 2
        g2.drawLine(width - 25, playerOneHeight - paddleSize, width - 25, playerOneHeight + paddleSize);

        //draw field devider
        g2.setStroke(dashed);
        g2.drawLine(middle, 25, middle, height - 25);

        //draw score
        g2.setStroke(new BasicStroke(10));
        FontMetrics metrics = g2.getFontMetrics(bitFont);
        g2.setFont(bitFont);      
   
        int xOne = ((width/2 - metrics.stringWidth(String.valueOf(scorePlayerOne)))/ 2);
        int xTwo = width/2 + ((width/2 - metrics.stringWidth(String.valueOf(scorePlayerTwo)))/ 2);

        g2.drawString(String.valueOf(scorePlayerOne),xOne, (height / 4));
        g2.drawString(String.valueOf(scorePlayerTwo),xTwo, (height / 4));


        //draw the ball    
        g2.setColor(Color.red);
        g2.drawRect(bp.getX(), bp.getY(), 5, 5);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(pongMain.getWindowWidth(), pongMain.getWindowHeight());
    }

    public void movePlayerOneHeight(int playerOneHeight) {

        boolean isValidBot = (this.playerOneHeight + playerOneHeight) < (this.getHeight() - (20 + (paddleSize)));
        boolean isValidTop = (this.playerOneHeight + playerOneHeight) > 20 + paddleSize;
        if (isValidBot && isValidTop) {
            this.playerOneHeight += playerOneHeight;
        }

    }

    public void movePlayerTwoHeight(int playerTwoHeight) {
        boolean isValidBot = (this.playerTwoHeight + playerTwoHeight) < (this.getHeight() - (20 + (paddleSize)));
        boolean isValidTop = (this.playerTwoHeight + playerTwoHeight) > 20 + paddleSize;
        if (isValidBot && isValidTop) {
            this.playerTwoHeight += playerTwoHeight;
        }
    }

    public void setScorePlayerOne(int scorePlayerOne) {
        this.scorePlayerOne = scorePlayerOne;
    }

    public void setScorePlayerTwo(int scorePlayerTwo) {
        this.scorePlayerTwo = scorePlayerTwo;
    }
    
    

}
