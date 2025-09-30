module org.example.application {
    requires javafx.graphics;
    requires javafx.controls;

    requires org.example.controller;
    requires org.example.entity;
    requires org.example.view;
    requires java.sql;

    exports org.example.application;
}
