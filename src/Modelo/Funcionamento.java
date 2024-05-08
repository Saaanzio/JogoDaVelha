package Modelo;

import Visao.Campos;

import java.util.ArrayList;
import java.util.List;

public class Funcionamento {
    private static final Funcionamento instancia = new Funcionamento();
    private boolean vitoria;
    private boolean jogada;
    private final List<Observador> observadores = new ArrayList<>();
    private final List<ObservadorStatusPartida> observadoresVitoria = new ArrayList<>();
    private List<Campos> campos = new ArrayList<>();

    public void AdicionarObservador(Observador observador){
        observadores.add(observador);
    }
    public void AdicionarObservadorVitoria(ObservadorStatusPartida observador){
        observadoresVitoria.add(observador);
    }
    public void adicionarCampo(Campos campo){
        campos.add(campo);
    }
    private Funcionamento(){
        this.vitoria = false;
        this.jogada = false;
    }
    public boolean isVitoria() {
        return vitoria;
    }

    public void setVitoria(boolean vitoria) {
        this.vitoria = vitoria;
    }
    public static Funcionamento getInstancia(){
        return instancia;
    }
    public void avancarTurno(){
        verificarVitoria();
        verificarVelha();
        jogada = !jogada;
        observadores.forEach(c -> c.alterar(jogada));
    }

    private void verificarVelha() {
        if(campos.stream().noneMatch(c -> c.getText().equals(" "))){
            chamarVitoria("Deu velha!");
        }
    }

    public String marcacao(){
        if(jogada)
            return "X";
        else
            return "O";
    }
    private void verificarVitoria() {
        String ganhador;
        // Maior que 5 por ser o minimo de turnos necessários para um jogador alcançar a vitória
        if(campos.stream().filter(c -> !c.getText().equals(" ")).count() > 4){
            for(int i = 0; i < 7; i+=3){
                if(campos.get(i).getText().equals(campos.get(i + 1).getText())
                        && campos.get(i).getText().equals(campos.get(i + 2).getText())
                        && !campos.get(i).getText().equals(" ")){
                    chamarVitoria(ganhador = campos.get(i).getText());
                }
            }

            for(int i = 0; i < 3; i++){
                if(campos.get(i).getText().equals(campos.get(i + 3).getText())
                        && campos.get(i).getText().equals(campos.get(i + 6).getText())
                        && !campos.get(i).getText().equals(" ")){
                    chamarVitoria(ganhador = campos.get(i).getText());
                }
            }
            if(campos.get(0).getText().equals(campos.get(4).getText())
                    && campos.get(0).getText().equals(campos.get(8).getText())
                    && !campos.get(0).getText().equals(" ")){
                chamarVitoria(ganhador = campos.get(0).getText());
            }
            else if(campos.get(2).getText().equals(campos.get(4).getText())
                    && campos.get(2).getText().equals(campos.get(6).getText())
                    && !campos.get(0).getText().equals(" ")){
                chamarVitoria(ganhador = campos.get(2).getText());
            }

        }

    }

    private void chamarVitoria(String s) {
        //Reutilização de código 10/10, funciona para
        if(s.length() == 1){
            String mensagemVitoria = "Ganhador: " + s;
            observadoresVitoria.forEach(c -> c.vitoriaAlcancada(mensagemVitoria));
        }
        else{
            observadoresVitoria.forEach(c -> c.vitoriaAlcancada(s));
        }
        campos.forEach(c -> c.setText(" "));
    }
}
