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
public class GraficsThread implements Runnable {
      
    @Override
    public void run() {
        //PongFrame pongFrame = new PongFrame();
        PongPanel pongPanel = new PongPanel();
        
        for (int i = 0; i < 450; i+=10) {  
            pongPanel.setPlayerOneHeight(i);
            
            pongPanel.revalidate();
            pongPanel.repaint();
           
           
           //pongFrame.revalidate();
           //pongFrame.repaint();
            
            
            System.out.println(i);
            
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GraficsThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
