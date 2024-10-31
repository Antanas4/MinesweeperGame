package org.example.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitGame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Exiting game");
        System.exit(0);
    }
}
