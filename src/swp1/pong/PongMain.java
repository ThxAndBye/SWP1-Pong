/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp1.pong;

/**
 *
 * @author thxandbye
 */
public class PongMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PongFrame frame = new PongFrame();
        frame.setVisible(true);
        
        Thread graficsThread = new Thread(new GraficsThread());
	graficsThread.run();
    }
    
}
