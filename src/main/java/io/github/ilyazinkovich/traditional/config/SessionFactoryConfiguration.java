package io.github.ilyazinkovich.traditional.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryConfiguration {

  private SessionFactory sessionFactory() {
    final Configuration configuration = new Configuration();
    configuration.configure("hibernate-annotation.cfg.xml");

    final ServiceRegistry serviceRegistry =
        new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties()).build();

    return configuration.buildSessionFactory(serviceRegistry);
  }
}
