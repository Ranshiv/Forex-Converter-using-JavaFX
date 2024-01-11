module com.example.forex {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.forex to javafx.fxml;
    exports com.example.forex;
}