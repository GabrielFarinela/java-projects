package controller;

import app.App;
import dao.MovimentacaoDao;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.util.Date;


public class inserirController {
    @FXML
    private CheckBox CBnao;

    @FXML
    private CheckBox CBsim;

    @FXML
    private Label LabelErroLogin;

    @FXML
    private DatePicker dataPicker;

    @FXML
    private TextArea descricaoTextArea;

    @FXML
    private TextField textFieldCategoria;

    @FXML
    private TextField textFieldTipo;

    @FXML
    private TextField textFieldValor;

    @FXML
    protected void trocarParaMain() {
        App.mudarTela("main");
    }

    @FXML
    protected void insereMovimentacao() {
        if(textFieldTipo.getText().isEmpty() || textFieldCategoria.getText().isEmpty() || textFieldValor.getText().isEmpty()) {
            LabelErroLogin.setTextFill(Color.web("#DC0000"));
            LabelErroLogin.setText("Preencha os campos por favor!");
        } else {
            int tipo = Integer.parseInt(textFieldTipo.getText());
            int categoria = Integer.parseInt(textFieldCategoria.getText());
            int valor = Integer.parseInt(textFieldValor.getText());
            Date date = java.sql.Date.valueOf(dataPicker.getValue());
            MovimentacaoDao.criaMovimentacao(tipo, categoria, valor, descricaoTextArea.getText(), date, testaPago());
            App.mudarTela("main");
            textFieldCategoria.setText(""); textFieldValor.setText(""); textFieldTipo.setText(""); descricaoTextArea.setText("");
        }
    }

    @FXML
    protected boolean testaPago() {
        boolean res = true;
        if(CBsim.isSelected()) {
            res = true;
        }
        if (CBnao.isSelected()) {
            res = true;
        }
        return res;
    }

}