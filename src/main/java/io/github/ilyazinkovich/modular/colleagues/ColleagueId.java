package io.github.ilyazinkovich.modular.colleagues;

import java.io.Serializable;
import java.util.Objects;

public class ColleagueId implements Serializable {

  private Long id;

  public ColleagueId() {
  }

  public ColleagueId(final Long id) {
    this.id = id;
  }

  public Long id() {
    return id;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final ColleagueId that = (ColleagueId) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
