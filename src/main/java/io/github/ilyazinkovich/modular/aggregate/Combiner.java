package io.github.ilyazinkovich.modular.aggregate;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import io.github.ilyazinkovich.modular.colleagues.Colleague;
import io.github.ilyazinkovich.modular.colleagues.ColleagueId;
import io.github.ilyazinkovich.modular.colleagues.ColleagueRepository;
import io.github.ilyazinkovich.modular.comment.AuthorId;
import io.github.ilyazinkovich.modular.comment.Comment;
import io.github.ilyazinkovich.modular.comment.CommentRepository;
import io.github.ilyazinkovich.modular.ticket.ReporterId;
import io.github.ilyazinkovich.modular.ticket.Ticket;
import io.github.ilyazinkovich.modular.ticket.TicketId;
import io.github.ilyazinkovich.modular.ticket.TicketRepository;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Combiner {

  private final ColleagueRepository colleagueRepository;
  private final TicketRepository ticketRepository;
  private final CommentRepository commentRepository;

  public Combiner(final ColleagueRepository colleagueRepository,
      final TicketRepository ticketRepository,
      final CommentRepository commentRepository) {
    this.colleagueRepository = colleagueRepository;
    this.ticketRepository = ticketRepository;
    this.commentRepository = commentRepository;
  }

  public AggregatedTicketInfo aggregateTicketInfo(final TicketId ticketId) {
    final Ticket ticket = ticketRepository.findById(ticketId);
    final String description = ticket.description();
    final ReporterId reporterId = ticket.reporterId();
    final String reporterName = grabReporterName(reporterId);
    final List<CommentWithAuthor> commentsWithAuthor = grabCommentsWithAuthor(ticketId);
    return new AggregatedTicketInfo(ticketId, description, reporterId,
        reporterName, commentsWithAuthor);
  }

  private String grabReporterName(final ReporterId reporterId) {
    final ColleagueId colleagueId = new ColleagueId(reporterId.id());
    final Colleague reporter = colleagueRepository.findById(colleagueId);
    return reporter.name();
  }

  private List<CommentWithAuthor> grabCommentsWithAuthor(final TicketId ticketId) {
    final List<Comment> comments = commentRepository.findByTicketId(ticketId);
    final Set<ColleagueId> colleagueIds = comments.parallelStream()
        .map(comment -> new ColleagueId(comment.authorId().id())).collect(toSet());
    final Set<Colleague> authors = colleagueRepository.findByIds(colleagueIds);
    final Map<AuthorId, Colleague> authorById = authors.parallelStream()
        .collect(toMap(author -> new AuthorId(author.colleagueId().id()), author -> author));
    return comments.parallelStream()
        .map(comment -> toCommentWithAuthor(authorById, comment))
        .collect(toList());
  }

  private CommentWithAuthor toCommentWithAuthor(final Map<AuthorId, Colleague> authorById,
      final Comment comment) {
    final AuthorId authorId = comment.authorId();
    final String authorName = authorById.get(authorId).name();
    return new CommentWithAuthor(comment.commentId(), comment.text(), authorId, authorName);
  }
}
