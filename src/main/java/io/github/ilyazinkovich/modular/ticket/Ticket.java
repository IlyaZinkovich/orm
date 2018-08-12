package io.github.ilyazinkovich.modular.ticket;

public class Ticket {

  private TicketId ticketId;
  private String description;
  private ReporterId reporterId;

  public Ticket() {
  }

  public Ticket(final String description,
      final ReporterId reporterId) {
    this.description = description;
    this.reporterId = reporterId;
  }

  public TicketId ticketId() {
    return ticketId;
  }

  public String description() {
    return description;
  }

  public ReporterId reporterId() {
    return reporterId;
  }
}
