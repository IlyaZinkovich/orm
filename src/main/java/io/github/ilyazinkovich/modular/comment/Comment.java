package io.github.ilyazinkovich.modular.comment;

import io.github.ilyazinkovich.modular.ticket.TicketId;

public class Comment {

  private CommentId commentId;
  private String text;
  private TicketId ticketId;
  private AuthorId authorId;

  public Comment() {
  }

  public Comment(final String text,
      final TicketId ticketId, final AuthorId authorId) {
    this.text = text;
    this.ticketId = ticketId;
    this.authorId = authorId;
  }

  public CommentId commentId() {
    return commentId;
  }

  public String text() {
    return text;
  }

  public TicketId ticketId() {
    return ticketId;
  }

  public AuthorId authorId() {
    return authorId;
  }
}
