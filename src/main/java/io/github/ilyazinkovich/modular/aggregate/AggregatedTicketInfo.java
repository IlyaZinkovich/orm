package io.github.ilyazinkovich.modular.aggregate;

import io.github.ilyazinkovich.modular.ticket.ReporterId;
import io.github.ilyazinkovich.modular.ticket.TicketId;
import java.util.List;

class AggregatedTicketInfo {

  private final TicketId ticketId;
  private final String description;
  private final ReporterId reporterId;
  private final String reporterName;
  private final List<CommentWithAuthor> comments;

  AggregatedTicketInfo(final TicketId ticketId, final String description,
      final ReporterId reporterId, final String reporterName,
      final List<CommentWithAuthor> comments) {
    this.ticketId = ticketId;
    this.description = description;
    this.reporterId = reporterId;
    this.reporterName = reporterName;
    this.comments = comments;
  }
}
