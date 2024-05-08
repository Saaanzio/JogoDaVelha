package Visao;

import javax.swing.*;
import java.awt.*;

public class Campos extends JButton {
    public Campos(){
        setText(" ");
        setOpaque(true);
        setBackground(Color.ORANGE);
        setFont(new Font("courier", Font.PLAIN, 50));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setForeground(Color.BLACK);
        setFocusPainted(false);
    }
}
