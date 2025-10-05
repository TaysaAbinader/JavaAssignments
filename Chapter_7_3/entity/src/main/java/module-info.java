module org.example.entity {
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    exports org.example.entity;

    opens org.example.entity to org.hibernate.orm.core, jakarta.persistence;
}
