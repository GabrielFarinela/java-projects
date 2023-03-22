package dao;

import connection.ConnectionFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Movimentacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class MovimentacaoDao {
    public static ObservableList<Movimentacao> buscaMovimentacao() {
        String sql = "SELECT * FROM movimentacao;";

        try(Connection con = new ConnectionFactory().criaConexao();
            PreparedStatement statement = con.prepareStatement(sql))
        {

            var l =  new ArrayList<Movimentacao>();

            ResultSet rs =  statement.executeQuery();

            while(rs.next()) {

                int tipo = rs.getInt("tipo");
                int categoria = rs.getInt("categoria");
                Date data = rs.getDate("data");
                int valor = rs.getInt("valor");

                var movimentacao = new Movimentacao(tipo, categoria, data, valor);

                l.add(movimentacao);
            }

            return FXCollections.observableArrayList(l);

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static ObservableList<Movimentacao> buscaUltimaMovimentacao() {
        String sql = "SELECT * FROM movimentacao ORDER BY id DESC LIMIT 1;";

        try(Connection con = new ConnectionFactory().criaConexao();
            PreparedStatement statement = con.prepareStatement(sql))
        {

            var l =  new ArrayList<Movimentacao>();

            ResultSet rs =  statement.executeQuery();

            while(rs.next()) {

                int tipo = rs.getInt("tipo");
                int categoria = rs.getInt("categoria");
                Date data = rs.getDate("data");
                int valor = rs.getInt("valor");

                var movimentacao = new Movimentacao(tipo, categoria, data, valor);

                l.add(movimentacao);
            }

            return FXCollections.observableArrayList(l);

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static ArrayList<Movimentacao> trazMovimentacao() {
        String sql = "SELECT * FROM movimentacao;";

        try(Connection con = new ConnectionFactory().criaConexao();
            PreparedStatement statement = con.prepareStatement(sql))
        {

            var l =  new ArrayList<Movimentacao>();

            ResultSet rs =  statement.executeQuery();

            while(rs.next()) {

                int tipo = rs.getInt("tipo");
                int categoria = rs.getInt("categoria");
                Date data = rs.getDate("data");
                int valor = rs.getInt("valor");

                var movimentacao = new Movimentacao(tipo, categoria, data, valor);

                l.add(movimentacao);
            }

            return l;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void criaMovimentacao(int t, int c, int v, String desc, Date data, boolean p) {
        String sql = "INSERT INTO movimentacao (tipo, categoria, valor, descricao, data, pago) VALUES(?,?,?,?,?,?);";

        try (Connection con = new ConnectionFactory().criaConexao();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setInt(1, t);
            statement.setInt(2, c);
            statement.setInt(3, v);
            statement.setString(4, desc);
            statement.setDate(5, (java.sql.Date) data);
            statement.setBoolean(6, p);
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void excluiMovimentacao(Movimentacao m) {
        String sql = "DELETE FROM movimentacao WHERE `tipo` = ? AND `categoria` = ? AND `valor` = ? AND `data` = ?;";

        try (Connection con = new ConnectionFactory().criaConexao();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setInt(1, m.getTipo());
            statement.setInt(2, m.getCategoria());
            statement.setInt(3, m.getValor());
            statement.setDate(4,(java.sql.Date) m.getData());
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
