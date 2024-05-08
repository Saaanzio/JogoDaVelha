package Visao;

import Modelo.Funcionamento;
import Modelo.ObservadorStatusPartida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JPanel implements ActionListener, ObservadorStatusPartida {
    public Tela() {
        setBackground(Color.ORANGE);
        setLayout(new GridLayout(3, 3));
        Funcionamento.getInstancia().AdicionarObservadorVitoria(this);
        for (int i = 0; i < 9; i++) {
            Campos campos = new Campos();
            campos.addActionListener(this);
            add(campos);
            Funcionamento.getInstancia().adicionarCampo(campos);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            String marca = Funcionamento.getInstancia().marcacao();
            if(button.getText().equals(" ")) {
                button.setText(marca);
                Funcionamento.getInstancia().avancarTurno();
            }
        }
    }

    @Override
    public void vitoriaAlcancada(String ganhador) {
        JOptionPane.showMessageDialog(this,ganhador);
    }
}
