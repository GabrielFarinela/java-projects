module com.example.trabjogodavelha {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trabjogodavelha to javafx.fxml;
    exports com.example.trabjogodavelha;
}