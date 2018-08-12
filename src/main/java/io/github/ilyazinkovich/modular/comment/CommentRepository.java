package io.github.ilyazinkovich.modular.comment;

import io.github.ilyazinkovich.modular.ticket.TicketId;
import java.util.List;

public interface CommentRepository {

  void save(final Comment comment);

  List<Comment> findByTicketId(final TicketId ticketId);
}
