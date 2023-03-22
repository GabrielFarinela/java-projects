package com.example.trabcadastro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button buttonCancelar;

    @FXML
    private void close() {
        Stage stage = (Stage) buttonCancelar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private ComboBox comboBoxSistema;

    @FXML
    private void carregarComboSistema() {
        ObservableList<String> optionsSistema = FXCollections.observableArrayList("Totvs", "Discord", "Instagram");
        comboBoxSistema.setItems(optionsSistema);
    }

    @FXML
    private ComboBox comboBoxPrioridade;

    @FXML
    private void carregarComboPrioridade() {
        ObservableList<String> optionsPrioridade = FXCollections.observableArrayList("Baixa", "Media", "Alta");
        comboBoxPrioridade.setItems(optionsPrioridade);
    }

    @FXML
    private void openDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro de Bug");
        alert.setHeaderText("Bug Cadastrado com Sucesso!!");
        alert.setContentText("Data: " + LocalDate.now() + "\n" + "Hora: " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":" + LocalDateTime.now().getSecond());

        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarComboPrioridade();
        carregarComboSistema();
    }
}