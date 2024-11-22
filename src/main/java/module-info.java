module com.example.tracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tracker to javafx.fxml;
    exports com.example.tracker;
}