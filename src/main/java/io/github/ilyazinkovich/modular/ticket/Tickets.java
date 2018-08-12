package io.github.ilyazinkovich.modular.ticket;

public class Tickets {

  private final TicketRepository ticketRepository;

  public Tickets(final TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }

  public TicketId createTicket(final ReporterId reporterId, final String description) {
    final TicketId ticketId = ticketRepository.nextIdentity();
    final Ticket ticket = new Ticket(ticketId, description, reporterId);
    ticketRepository.save(ticket);
    return ticketId;
  }
}
