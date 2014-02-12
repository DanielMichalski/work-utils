package maska;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

/**
 * Author: Daniel
 */
public class BtnPanel extends JPanel {
    public BtnPanel() {
        final JFormattedTextField zipCodeField =
                createJFormattedTextField();

        zipCodeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(zipCodeField.getText());
            }
        });

        add(zipCodeField);
    }

    private JFormattedTextField createJFormattedTextField() {
        final JFormattedTextField zipCodeField = createZipCodeField();
        zipCodeField.setMinimumSize(new Dimension(100, 20));
        zipCodeField.setMaximumSize(new Dimension(100, 20));
        zipCodeField.setPreferredSize(new Dimension(100, 20));
        return zipCodeField;
    }

    private JFormattedTextField createZipCodeField() {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("##-###");
            mask.setPlaceholderCharacter(' ');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new JFormattedTextField(mask);
    }
}
