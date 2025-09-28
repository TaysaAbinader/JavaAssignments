module org.example.controller {
    requires org.example.model;

    requires java.base;
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.controller to javafx.fxml;

    exports org.example.controller;
}
