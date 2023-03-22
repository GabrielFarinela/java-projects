module com.example.trabcadastro {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trabcadastro to javafx.fxml;
    exports com.example.trabcadastro;
}