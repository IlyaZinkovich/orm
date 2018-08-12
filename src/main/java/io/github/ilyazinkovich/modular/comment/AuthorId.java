package io.github.ilyazinkovich.modular.comment;

import java.io.Serializable;

public class AuthorId implements Serializable {

  private Long id;

  public AuthorId() {
  }

  public AuthorId(final Long id) {
    this.id = id;
  }

  public Long id() {
    return id;
  }
}
