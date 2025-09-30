module org.example.dao {
    requires javafx.graphics;
    requires javafx.controls;

    requires java.base;
    requires java.sql;

    requires org.example.entity;
    requires org.example.datasource;

    exports org.example.dao;
}
