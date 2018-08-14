package io.github.ilyazinkovich.traditional;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTS")
public class Comment {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long commentId;
  private String text;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TICKET_ID")
  private Ticket ticket;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "AUTHOR_ID")
  private Colleague author;

  public Comment() {
  }

  public Comment(final String text,
      final Ticket ticket, final Colleague author) {
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
