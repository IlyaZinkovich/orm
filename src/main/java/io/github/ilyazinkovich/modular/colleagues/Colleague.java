package io.github.ilyazinkovich.modular.colleagues;

public class Colleague {

  private ColleagueId colleagueId;
  private String name;

  public Colleague() {
  }

  public Colleague(final ColleagueId colleagueId, final String name) {
    this.colleagueId = colleagueId;
    this.name = name;
  }

  public ColleagueId colleagueId() {
    return colleagueId;
  }

  public String name() {
    return name;
  }

}
