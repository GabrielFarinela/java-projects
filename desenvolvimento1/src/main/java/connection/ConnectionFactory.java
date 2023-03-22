package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection criaConexao() {
        String str = "jdbc:mysql://localhost/financas";
        String user = "root";
        String password = "Ggf789ires$";

        try {
            System.out.println("Conectado!");
            return DriverManager.getConnection(str, user, password);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar!");
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void main(String[] args) {
        criaConexao();
    }
}