package swp1.pong;

import java.awt.*;
import javax.swing.*;

public class PongFrame extends javax.swing.JFrame {

    private javax.swing.JPanel pongPanel;

    public PongFrame() {
        initComponents();

        setState(Frame.NORMAL);
        PongInputListener input = new PongInputListener();
        Thread graficsThread = new Thread(new GraficsThread((PongPanel) pongPanel, input));
        addKeyListener(input);

        graficsThread.start();
    }

    private void initComponents() {
        pongPanel = new PongPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GroupLayout pongPanelLayout = new GroupLayout(pongPanel);
        pongPanel.setLayout(pongPanelLayout);
        getContentPane().add(pongPanel, BorderLayout.CENTER);

        pack();
    }
}
