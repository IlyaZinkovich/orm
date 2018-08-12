package io.github.ilyazinkovich.modular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.wix.mysql.EmbeddedMysql;
import io.github.ilyazinkovich.MySQL;
import io.github.ilyazinkovich.modular.colleagues.Colleague;
import io.github.ilyazinkovich.modular.colleagues.ColleagueId;
import io.github.ilyazinkovich.modular.comment.AuthorId;
import io.github.ilyazinkovich.modular.comment.Comment;
import io.github.ilyazinkovich.modular.comment.CommentId;
import io.github.ilyazinkovich.modular.config.SessionFactoryBuilder;
import io.github.ilyazinkovich.modular.ticket.ReporterId;
import io.github.ilyazinkovich.modular.ticket.Ticket;
import io.github.ilyazinkovich.modular.ticket.TicketId;
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
      final ColleagueId colleagueId = colleague.colleagueId();
      final ReporterId reporterId = new ReporterId(colleagueId.id());
      assertEquals(1L, colleagueId.id().longValue());
      final Ticket ticket = new Ticket("description", reporterId);
      session.save(ticket);
      final TicketId ticketId = ticket.ticketId();
      assertEquals(1L, ticketId.id().longValue());
      final AuthorId authorId = new AuthorId(colleagueId.id());
      final Comment comment = new Comment("comment", ticketId, authorId);
      session.save(comment);
      final CommentId commentId = comment.commentId();
      assertEquals(1L, commentId.id().longValue());
    }
  }
}
