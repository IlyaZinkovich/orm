package io.github.ilyazinkovich.modular.comment;

import io.github.ilyazinkovich.modular.ticket.TicketId;

public class Comments {

  private final CommentRepository commentRepository;

  public Comments(final CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public CommentId writeComment(final TicketId ticketId, final AuthorId authorId,
      final String text) {
    final Comment comment = new Comment(text, ticketId, authorId);
    commentRepository.save(comment);
    return comment.commentId();
  }
}
