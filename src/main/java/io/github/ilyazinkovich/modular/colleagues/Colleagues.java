package io.github.ilyazinkovich.modular.colleagues;

public class Colleagues {

  private final ColleagueRepository colleagueRepository;

  public Colleagues(final ColleagueRepository colleagueRepository) {
    this.colleagueRepository = colleagueRepository;
  }

  public ColleagueId registerColleague(final String colleagueName) {
    final ColleagueId colleagueId = colleagueRepository.nextIdentity();
    final Colleague colleague = new Colleague(colleagueId, colleagueName);
    colleagueRepository.save(colleague);
    return colleagueId;
  }
}
