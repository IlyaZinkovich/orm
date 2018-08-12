package io.github.ilyazinkovich.modular.aggregate;

import io.github.ilyazinkovich.modular.comment.AuthorId;
import io.github.ilyazinkovich.modular.comment.CommentId;

class CommentWithAuthor {

  private final CommentId commentId;
  private final String text;
  private final AuthorId authorId;
  private final String colleagueName;

  CommentWithAuthor(final CommentId commentId, final String text,
      final AuthorId authorId, final String colleagueName) {
    this.commentId = commentId;
    this.text = text;
    this.authorId = authorId;
    this.colleagueName = colleagueName;
  }
}
