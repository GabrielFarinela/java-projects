package controller;

import app.App;
import dao.UsuarioDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class CadastroController {

    @FXML
    private Label LabelErroLogin;

    @FXML
    private TextField textFieldNome;

    @FXML
    private PasswordField textFieldSenha;

    @FXML
    protected void voltarButton() {
        App.mudarTela("login");
    }

    @FXML
    protected void cadastrarButton() {
        if(textFieldNome.getText().isEmpty() || textFieldSenha.getText().isEmpty()) {
            LabelErroLogin.setTextFill(Color.web("#DC0000"));
            LabelErroLogin.setText("Preencha os campos por favor!");
        } else {
            UsuarioDao.criaUsuario(textFieldNome.getText(), textFieldSenha.getText());
            LabelErroLogin.setTextFill(Color.web("#367E18"));
            LabelErroLogin.setText("Usuário adicionado com sucesso!");
            textFieldNome.setText("");
            textFieldSenha.setText("");
        }
    }
}