package io.github.ilyazinkovich.modular.ticket;

public interface TicketRepository {

  void save(final Ticket ticket);

  Ticket findById(final TicketId ticketId);
}
