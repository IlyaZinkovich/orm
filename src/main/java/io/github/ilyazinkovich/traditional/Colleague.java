package io.github.ilyazinkovich.traditional;

import java.util.List;

public class Colleague {

  private Long colleagueId;
  private String name;
  private List<Comment> comments;

  public Colleague() {
  }

  public Colleague(final Long colleagueId, final String name,
      final List<Comment> comments) {
    this.colleagueId = colleagueId;
    this.name = name;
    this.comments = comments;
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
