package io.github.ilyazinkovich.traditional;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COLLEAGUES")
public class Colleague {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long colleagueId;
  private String name;
  @OneToMany(mappedBy = "author")
  private List<Comment> comments;

  public Colleague() {
  }

  public Colleague(final String name) {
    this.name = name;
  }

  public Long colleagueId() {
    return colleagueId;
  }

  public String name() {
    return name;
  }

  public List<Comment> comments() {
    return comments;
  }
}
