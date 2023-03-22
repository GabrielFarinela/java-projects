package controller;

import app.App;
import dao.UsuarioDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LoginController {
    @FXML
    protected TextField textFieldNome;

    @FXML
    protected PasswordField textFieldSenha;

    @FXML
    protected Label LabelErroLogin;

    @FXML
    protected void entrarButton() {
        if(textFieldNome.getText().isEmpty() || textFieldSenha.getText().isEmpty()) {
            LabelErroLogin.setTextFill(Color.web("#DC0000"));
            LabelErroLogin.setText("Preencha os campos por favor!");
        } else {
            if(UsuarioDao.autenticacaoLogin(textFieldNome.getText(), textFieldSenha.getText())) {
                App.mudarTela("main");
            }
            else {
                LabelErroLogin.setTextFill(Color.web("#DC0000"));
                LabelErroLogin.setText("Erro ao entrar, tente novamente!");
            }
        }
    }

    @FXML
    protected void trocarParaCadastro() {
        App.mudarTela("cadastro");
    }
}