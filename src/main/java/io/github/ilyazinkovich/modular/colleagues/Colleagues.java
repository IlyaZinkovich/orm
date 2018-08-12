package io.github.ilyazinkovich.modular.colleagues;

public class Colleagues {

  private final ColleagueRepository colleagueRepository;

  public Colleagues(final ColleagueRepository colleagueRepository) {
    this.colleagueRepository = colleagueRepository;
  }

  public ColleagueId registerColleague(final String colleagueName) {
    final Colleague colleague = new Colleague(colleagueName);
    colleagueRepository.save(colleague);
    return colleague.colleagueId();
  }
}
