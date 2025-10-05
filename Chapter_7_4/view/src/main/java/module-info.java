module org.example.view {
    requires java.sql;
    
    requires javafx.graphics;
    requires javafx.controls;

    requires org.example.controller;

    exports org.example.view;
}
