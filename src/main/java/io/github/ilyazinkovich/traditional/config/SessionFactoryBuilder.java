package io.github.ilyazinkovich.traditional.config;

import io.github.ilyazinkovich.traditional.Colleague;
import io.github.ilyazinkovich.traditional.Comment;
import io.github.ilyazinkovich.traditional.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryBuilder {

  public SessionFactory build() {
    final Configuration configuration = new Configuration()
        .configure("/hibernate/traditional/hibernate.cfg.xml");

    final ServiceRegistry serviceRegistry =
        new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties()).build();

    return new MetadataSources(serviceRegistry)
        .addAnnotatedClass(Colleague.class)
        .addAnnotatedClass(Comment.class)
        .addAnnotatedClass(Ticket.class)
        .buildMetadata().buildSessionFactory();
  }
}
