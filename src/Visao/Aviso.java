package Visao;

import Modelo.Funcionamento;
import Modelo.Observador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Aviso extends JPanel implements Observador {
    JLabel turno = new JLabel("Turno: O");
    public Aviso(){
        setVisible(true);
        setLayout(new FlowLayout());
        setBackground(Color.LIGHT_GRAY);
        turno.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        add(turno);
        Funcionamento.getInstancia().AdicionarObservador(this);
    }

    @Override
    public void alterar(boolean jogador) {
        if(jogador)
            turno.setText("Turno: X");
        else
            turno.setText("Turno: O");

    }
}
