package Visao;

import javax.swing.*;
import java.awt.*;

public class JogoDaVelha extends JFrame{
    public JogoDaVelha(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        Aviso aviso = new Aviso();
        aviso.setPreferredSize(new Dimension(200,70));
        add(aviso, BorderLayout.NORTH);

        Tela tela = new Tela();
        add(tela, BorderLayout.CENTER);
        setVisible(true);


    }
}
