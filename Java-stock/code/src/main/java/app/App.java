package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Stage stage;

    private static Scene mainScene;
    private static Scene loginScene;
    private static Scene cadastroScene;
    private static Scene inserirScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;

        stage.setTitle("Entrar");

        FXMLLoader fxmlLogin = new FXMLLoader(App.class.getResource("login.fxml"));
        loginScene = new Scene(fxmlLogin.load());

        FXMLLoader fxmlCadastro = new FXMLLoader(App.class.getResource("cadastro.fxml"));
        cadastroScene = new Scene(fxmlCadastro.load());

        FXMLLoader fxmlMain = new FXMLLoader(App.class.getResource("main.fxml"));
        mainScene = new Scene(fxmlMain.load());

        FXMLLoader fxmlInserir = new FXMLLoader(App.class.getResource("inserir.fxml"));
        inserirScene = new Scene(fxmlInserir.load());

        stage.setScene(loginScene);
        stage.show();
    }

    public static void mudarTela(String scr) {
        switch (scr) {
            case "login":
                stage.setTitle("Entrar");
                stage.setScene(loginScene);
                break;
            case "cadastro":
                stage.setTitle("Cadastrar");
                stage.setScene(cadastroScene);
                break;
            case "main":
                stage.setTitle("Finanças");
                stage.setScene(mainScene);
                break;
            case "inserir":
                stage.setTitle("Inserir");
                stage.setScene(inserirScene);

        }
    }

    public static void main(String[] args) {
        launch();
    }
}