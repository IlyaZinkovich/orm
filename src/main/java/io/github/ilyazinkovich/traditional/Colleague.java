package io.github.ilyazinkovich.traditional;

import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COLLEAGUES")
public class Colleague {

  @EmbeddedId
  private ColleagueId colleagueId;
  private String name;
  @OneToMany(mappedBy = "author")
  private List<Comment> comments;

  public Colleague() {
  }

  public Colleague(final String name) {
    this.name = name;
  }

  public ColleagueId colleagueId() {
    return colleagueId;
  }

  public String name() {
    return name;
  }

  public List<Comment> comments() {
    return comments;
  }
}
