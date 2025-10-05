module org.example.dao {
    requires org.example.entity;
    requires org.example.datasource;

    requires jakarta.persistence;

    exports org.example.dao;
}
