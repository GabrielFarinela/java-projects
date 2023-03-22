package com.example.trabjogodavelha;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    final int JOGADOR1 = 1;
    final int JOGADOR2 = -1;
    int jogadorAtual = JOGADOR1;

    Tabuleiro<Integer> matriz = new Tabuleiro<>();

    int linhas = 3;
    int colunas = 3;

    @FXML
    public void zerarMatriz() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                int elemento = 0;
                matriz.set(i, j, elemento);
            }
        }
    }

    @FXML
    private void resetar() {
        button00.setText("");
        button01.setText("");
        button02.setText("");
        button10.setText("");
        button11.setText("");
        button12.setText("");
        button20.setText("");
        button21.setText("");
        button22.setText("");
        zerarMatriz();
        setarJogador1();
        label.setText("O jogador 1 inicia o jogo");
    }

    @FXML
    public void trocarJogador() {
        if(jogadorAtual == JOGADOR1) {
            jogadorAtual = JOGADOR2;
            label.setText("É a vez do jogador 2!");
        } else {
            jogadorAtual = JOGADOR1;
            label.setText("É a vez do jogador 1!");
        }
    }

    @FXML
    private void setarJogador1() {
        jogadorAtual = JOGADOR1;
    }

    @FXML
    private void resultado() {
        String vencedor1 = "O vencedor é o jogador 1!";
        String vencedor2 = "O vencedor é o jogador 2!";
        String acabou = "O jogo acabou, resete para jogar novamente";
        String empate = "O jogo empatou!";

        int valor00 = matriz.get(0,0);
        int valor01 = matriz.get(0,1);
        int valor02 = matriz.get(0,2);
        int valor10 = matriz.get(1,0);
        int valor11 = matriz.get(1,1);
        int valor12 = matriz.get(1,2);
        int valor20 = matriz.get(2,0);
        int valor21 = matriz.get(2,1);
        int valor22 = matriz.get(2,2);

        if(valor00 + valor01 + valor02 == 3 || valor10 + valor11 + valor12 == 3 || valor20 + valor21 + valor22 == 3 ||
            valor00 + valor10 + valor20 == 3 || valor01 + valor11 + valor21 == 3 || valor02 + valor12 + valor22 == 3 ||
                valor00 + valor11 + valor22 == 3 || valor20 + valor11 + valor02 == 3) {
            if(label.getText() == vencedor2) {
                label.setText(acabou);
            } else {
                label.setText(vencedor1);
            }
        } else if (valor00 + valor01 + valor02 == -3 || valor10 + valor11 + valor12 == -3 || valor20 + valor21 + valor22 == -3 ||
                valor00 + valor10 + valor20 == -3 || valor01 + valor11 + valor21 == -3 || valor02 + valor12 + valor22 == -3 ||
                valor00 + valor11 + valor22 == -3 || valor20 + valor11 + valor02 == -3) {
            if(label.getText() == vencedor1) {
                label.setText(acabou);
            } else {
                label.setText(vencedor2);
            }
        } else if ((!button00.getText().isEmpty()) && (!button01.getText().isEmpty()) && (!button02.getText().isEmpty()) && (!button10.getText().isEmpty()) && (!button11.getText().isEmpty()) && (!button12.getText().isEmpty()) && (!button20.getText().isEmpty()) && (!button21.getText().isEmpty()) && (!button22.getText().isEmpty())) {
            label.setText(empate);
        }
    }

    @FXML
    private void jogarButton00() {
        if(button00.getText().isEmpty()) {
            if(jogadorAtual == JOGADOR1) {
                button00.setText("X");
                matriz.set(0, 0,1);
                trocarJogador();
                resultado();
            } else {
                button00.setText("O");
                matriz.set(0, 0,-1);
                trocarJogador();
                resultado();
            }
        }
    }

    @FXML
    private void jogarButton01() {
        if(button01.getText().isEmpty()) {
            if(jogadorAtual == JOGADOR1) {
                button01.setText("X");
                matriz.set(0, 1,1);
                trocarJogador();
                resultado();
            } else {
                button01.setText("O");
                matriz.set(0, 1,-1);
                trocarJogador();
                resultado();
            }
        }
    }

    @FXML
    private void jogarButton02() {
        if(button02.getText().isEmpty()) {
            if(jogadorAtual == JOGADOR1) {
                button02.setText("X");
                matriz.set(0, 2,1);
                trocarJogador();
                resultado();
            } else {
                button02.setText("O");
                matriz.set(0, 2,-1);
                trocarJogador();
                resultado();
            }
        }
    }

    @FXML
    private void jogarButton10() {
        if(button10.getText().isEmpty()) {
            if(jogadorAtual == JOGADOR1) {
                button10.setText("X");
                matriz.set(1, 0,1);
                trocarJogador();
                resultado();
            } else {
                button10.setText("O");
                matriz.set(1, 0,-1);
                trocarJogador();
                resultado();
            }
        }
    }

    @FXML
    private void jogarButton11() {
        if(button11.getText().isEmpty()) {
            if(jogadorAtual == JOGADOR1) {
                button11.setText("X");
                matriz.set(1, 1,1);
                trocarJogador();
                resultado();
            } else {
                button11.setText("O");
                matriz.set(1, 1,-1);
                trocarJogador();
                resultado();
            }
        }
    }

    @FXML
    private void jogarButton12() {
        if(button12.getText().isEmpty()) {
            if(jogadorAtual == JOGADOR1) {
                button12.setText("X");
                matriz.set(1, 2,1);
                trocarJogador();
                resultado();
            } else {
                button12.setText("O");
                matriz.set(1, 2,-1);
                trocarJogador();
                resultado();
            }
        }
    }

    @FXML
    private void jogarButton20() {
        if(button20.getText().isEmpty()) {
            if(jogadorAtual == JOGADOR1) {
                button20.setText("X");
                matriz.set(2, 0,1);
                trocarJogador();
                resultado();
            } else {
                button20.setText("O");
                matriz.set(2, 0,-1);
                trocarJogador();
                resultado();
            }
        }
    }

    @FXML
    private void jogarButton21() {
        if(button21.getText().isEmpty()) {
            if(jogadorAtual == JOGADOR1) {
                button21.setText("X");
                matriz.set(2, 1,1);
                trocarJogador();
                resultado();
            } else {
                button21.setText("O");
                matriz.set(2, 1,-1);
                trocarJogador();
                resultado();
            }
        }
    }

    @FXML
    private void jogarButton22() {
        if(button22.getText().isEmpty()) {
            if(jogadorAtual == JOGADOR1) {
                button22.setText("X");
                matriz.set(2, 2,1);
                trocarJogador();
                resultado();
            } else {
                button22.setText("O");
                matriz.set(2, 2,-1);
                trocarJogador();
                resultado();
            }
        }
    }

    @FXML
    private Button button00;

    @FXML
    private Button button01;

    @FXML
    private Button button02;

    @FXML
    private Button button10;

    @FXML
    private Button button11;

    @FXML
    private Button button12;

    @FXML
    private Button button20;

    @FXML
    private Button button21;

    @FXML
    private Button button22;

    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        zerarMatriz();
    }
}