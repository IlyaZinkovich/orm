package io.github.ilyazinkovich.traditional;

import java.util.List;

public class Ticket {

  private Long ticketId;
  private String description;
  private Colleague reporter;
  private List<Comment> comments;

  public Ticket() {
  }

  public Ticket(final Long ticketId, final String description,
      final Colleague reporter, final List<Comment> comments) {
    this.ticketId = ticketId;
    this.description = description;
    this.reporter = reporter;
    this.comments = comments;
  }

  public Long ticketId() {
    return ticketId;
  }

  public String description() {
    return description;
  }

  public Colleague reporter() {
    return reporter;
  }

  public List<Comment> comments() {
    return comments;
  }
}
