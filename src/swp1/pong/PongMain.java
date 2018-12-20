/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp1.pong;

import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;

public class PongMain {

    //private int windowWidth, windowHeight;
    private static int windowWidth = 0;
    private static int windowHeight = 0;

    public static void main(String[] args) {

        windowWidth = Integer.valueOf(JOptionPane.showInputDialog("Width", "640"));
        windowHeight = Integer.valueOf(JOptionPane.showInputDialog("Height", "400"));
        PongFrame frame = new PongFrame();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
 
        frame.setResizable(false);
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }
}
