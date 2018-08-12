package io.github.ilyazinkovich.modular.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryBuilder {

  public SessionFactory build() {
    return new Configuration()
        .configure("/hibernate/modular/hibernate.cfg.xml")
        .buildSessionFactory();
  }
}
