package io.github.ilyazinkovich.traditional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.wix.mysql.EmbeddedMysql;
import io.github.ilyazinkovich.MySQL;
import io.github.ilyazinkovich.traditional.config.SessionFactoryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

class IntegrationTest {

  private static EmbeddedMysql mysql = MySQL.mysql;
  private final SessionFactory sessionFactory =
      new SessionFactoryBuilder().build();

  @Test
  void test() {
    try (final Session session = sessionFactory.openSession()) {
      final Colleague colleague = new Colleague("Bob");
      session.save(colleague);
      assertEquals(1L, colleague.colleagueId().longValue());
      final Ticket ticket = new Ticket("description", colleague);
      session.save(ticket);
      assertEquals(1L, ticket.ticketId().longValue());
      final Comment comment = new Comment("comment", ticket, colleague);
      final Ticket persistedTicket = session.byId(Ticket.class).load(1L);
      persistedTicket.comments().add(new Comment("comment", persistedTicket, colleague));
      session.save(ticket);
      assertEquals(1L, comment.commentId().longValue());
    }
  }
}
