package io.github.ilyazinkovich.modular.ticket;

import java.io.Serializable;

public class ReporterId implements Serializable {

  private Long id;

  public ReporterId() {
  }

  public ReporterId(final Long id) {
    this.id = id;
  }

  public Long id() {
    return id;
  }
}
