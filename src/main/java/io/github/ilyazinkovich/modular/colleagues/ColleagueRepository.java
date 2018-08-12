package io.github.ilyazinkovich.modular.colleagues;

import java.util.Set;

public interface ColleagueRepository {

  void save(final Colleague colleague);

  Colleague findById(final ColleagueId colleagueId);

  Set<Colleague> findByIds(final Set<ColleagueId> colleagueIds);
}
