package dao;

import connection.ConnectionFactory;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDao {

    public static ArrayList<Usuario> ListaUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario;";

        try (Connection con = new ConnectionFactory().criaConexao();
             PreparedStatement statement = con.prepareStatement(sql)) {

            var usuarios = new Usuario();

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                usuarios = new Usuario(nome, senha);
                listaUsuarios.add(usuarios);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }

    public static boolean autenticacaoLogin(String n, String s) {
        boolean res = false;
        ArrayList<Usuario> listaUsuarios = ListaUsuarios();

        for (Usuario u : listaUsuarios) {
            if (u.getNome().equals(n) && u.getSenha().equals(s)) {
                res = true;
            } else {
                res = false;
            }
        }
        return res;
    }

    public static void criaUsuario(String n, String s) {
        String sql = "INSERT INTO usuario (nome, senha) VALUES(?,?);";

        try (Connection con = new ConnectionFactory().criaConexao();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setString(1, n);
            statement.setString(2, s);
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
