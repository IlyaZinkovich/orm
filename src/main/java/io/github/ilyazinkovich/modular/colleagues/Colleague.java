package io.github.ilyazinkovich.modular.colleagues;

public class Colleague {

  private ColleagueId colleagueId;
  private String name;

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

}
