package io.github.ilyazinkovich.modular.comment;

import java.io.Serializable;
import java.util.Objects;

public class CommentId implements Serializable {

  private Long id;

  public CommentId() {
  }

  public CommentId(final Long id) {
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
    final CommentId that = (CommentId) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
