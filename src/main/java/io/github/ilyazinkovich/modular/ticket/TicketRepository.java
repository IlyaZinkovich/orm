package io.github.ilyazinkovich.modular.ticket;

public interface TicketRepository {

  TicketId nextIdentity();

  void save(final Ticket ticket);

  Ticket findById(final TicketId ticketId);
}
