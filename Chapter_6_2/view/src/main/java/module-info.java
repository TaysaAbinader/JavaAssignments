module org.example.view {
    requires javafx.graphics;
    requires javafx.controls;

    requires org.example.controller;
    requires org.example.model;

    exports org.example.view;
}