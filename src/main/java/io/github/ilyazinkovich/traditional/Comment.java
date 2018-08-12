package io.github.ilyazinkovich.traditional;

public class Comment {

  private Long commentId;
  private String text;
  private Ticket ticket;
  private Colleague author;

  public Comment() {
  }

  public Comment(final Long commentId, final String text,
      final Ticket ticket, final Colleague author) {
    this.commentId = commentId;
    this.text = text;
    this.ticket = ticket;
    this.author = author;
  }

  public Long commentId() {
    return commentId;
  }

  public String text() {
    return text;
  }

  public Ticket ticket() {
    return ticket;
  }

  public Colleague author() {
    return author;
  }
}
