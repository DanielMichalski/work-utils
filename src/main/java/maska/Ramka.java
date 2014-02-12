package maska;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Daniel
 */
public class Ramka extends JFrame {
    public Ramka() {
        setUpFrame();
        initializeComponents();
    }

    private void setUpFrame() {
        setSize(300, 200);
        setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        BtnPanel panel = new BtnPanel();
        add(panel);
    }
}
