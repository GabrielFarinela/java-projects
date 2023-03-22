package controller;

import app.App;
import connection.ConnectionFactory;
import dao.MovimentacaoDao;
import dao.UsuarioDao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import model.Movimentacao;
import org.w3c.dom.ls.LSOutput;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private PieChart grafico;

    @FXML
    private TableView<Movimentacao> movimentacoesTV;

    @FXML
    private Label saldoAtualLabel;

    @FXML
    private Label saldoPrevistoLabel;

    @FXML
    private TableView<Movimentacao> ultimaMovimentacaoTV;

    @FXML
    private TableColumn<Movimentacao, Integer> tvCategoria1;

    @FXML
    private TableColumn<Movimentacao, Integer> tvCategoria2;

    @FXML
    private TableColumn<Movimentacao, Date> tvData1;

    @FXML
    private TableColumn<Movimentacao, Date> tvData2;

    @FXML
    private TableColumn<Movimentacao, Integer> tvTipo1;

    @FXML
    private TableColumn<Movimentacao, Integer> tvTipo2;

    @FXML
    private TableColumn<Movimentacao, Integer> tvValor1;

    @FXML
    private TableColumn<Movimentacao, Integer> tvValor2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refresh();
    }

    @FXML
    protected void trocarParaInserir() {
        App.mudarTela("inserir");
    }

    @FXML
    public void carregarTable1() {
        tvTipo1.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tvCategoria1.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tvData1.setCellValueFactory(new PropertyValueFactory<>("data"));
        tvValor1.setCellValueFactory(new PropertyValueFactory<>("valor"));

        movimentacoesTV.setItems(MovimentacaoDao.buscaMovimentacao());
    }

    @FXML
    public void carregarTable2() {
        tvTipo2.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tvCategoria2.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tvData2.setCellValueFactory(new PropertyValueFactory<>("data"));
        tvValor2.setCellValueFactory(new PropertyValueFactory<>("valor"));

        ultimaMovimentacaoTV.setItems(MovimentacaoDao.buscaUltimaMovimentacao());
    }

    @FXML
    protected void delete() {
        Movimentacao m = movimentacoesTV.getSelectionModel().getSelectedItem();
        if (m != null) {
            MovimentacaoDao.excluiMovimentacao(m);
            refresh();
        }
    }

    @FXML
    public void refresh() {
        carregarTable1();
        carregarTable2();
        grafico();
        calculaSaldos();
    }

    @FXML
    protected void grafico() {
        ArrayList<Movimentacao> list = MovimentacaoDao.trazMovimentacao();
        int valorReceitas = 0;
        int valorDespesas = 0;

        for (Movimentacao m : list) {
            if(m.getTipo() == 1) {
                valorReceitas += m.getValor();
            } else {
                valorDespesas += m.getValor();;
            }
        }

        PieChart.Data receitas = new PieChart.Data("Receitas", valorReceitas);
        PieChart.Data despesas = new PieChart.Data("Despesas", valorDespesas);

        grafico.setTitle("Gráfico das Finanças:");
        grafico.getData().clear();
        grafico.getData().addAll(receitas, despesas);
    }

    @FXML
    protected void calculaSaldos() {
        ArrayList<Movimentacao> list = MovimentacaoDao.trazMovimentacao();
        int saldoAtual = 0;
        int saldoPrevisto = 0;
        int s = 0;
        Calendar c = Calendar.getInstance();
        Date now = c.getTime();

        for (Movimentacao m : list) {
            if(m.getData().before(now) || m.getData().equals(now)) {
                saldoAtual += m.getValor();
            }
        }

        saldoPrevisto = saldoAtual;

        for (Movimentacao m : list) {
            if(m.getData().after(now)) {
                saldoPrevisto += m.getValor();
            }
        }

        saldoAtualLabel.setText("Saldo Atual: " + Integer.toString(saldoAtual));
        if(saldoAtual < 0) {
            saldoAtualLabel.setTextFill(Color.web("#DC0000"));
        } else if (saldoAtual == 0) {
            saldoAtualLabel.setTextFill(Color.web("#000000"));
        } else {
            saldoAtualLabel.setTextFill(Color.web("#367E18"));
        }

        saldoPrevistoLabel.setText("Saldo Previsto: " + Integer.toString(saldoPrevisto));
        if(saldoPrevisto < 0) {
            saldoPrevistoLabel.setTextFill(Color.web("#DC0000"));
        } else if (saldoPrevisto == 0) {
            saldoPrevistoLabel.setTextFill(Color.web("#000000"));
        } else {
            saldoPrevistoLabel.setTextFill(Color.web("#367E18"));
        }
    }
}
