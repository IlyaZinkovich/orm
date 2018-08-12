package io.github.ilyazinkovich.traditional;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TICKETS")
public class Ticket {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long ticketId;
  private String description;
  @ManyToOne
  @JoinColumn(name = "REPORTER_ID")
  private Colleague reporter;
  @OneToMany(mappedBy = "ticket")
  private List<Comment> comments;

  public Ticket() {
  }

  public Ticket(final String description, final Colleague reporter) {
    this.description = description;
    this.reporter = reporter;
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
    return Optional.ofNullable(comments).orElseGet(ArrayList::new);
  }
}
