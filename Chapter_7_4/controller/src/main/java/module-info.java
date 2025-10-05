module org.example.controller {
    requires java.sql;

    requires org.example.entity;
    requires org.example.dao;

    exports org.example.controller;
}
