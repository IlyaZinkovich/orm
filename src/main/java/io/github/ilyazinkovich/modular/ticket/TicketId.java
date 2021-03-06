package io.github.ilyazinkovich.modular.ticket;

import java.io.Serializable;
import java.util.Objects;

public class TicketId implements Serializable {

  private Long id;

  public TicketId() {
  }

  public TicketId(final Long id) {
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
    final TicketId that = (TicketId) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
