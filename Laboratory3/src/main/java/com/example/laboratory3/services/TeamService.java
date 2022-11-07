package com.example.laboratory3.services;

import com.example.laboratory3.entities.City;
import com.example.laboratory3.entities.Team;
import com.example.laboratory3.repositories.TeamRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Named
@NoArgsConstructor
@ApplicationScoped
public class TeamService {
    @Inject
    @Getter @Setter
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.getAllTeams();
    }

    public void addTeam(Team team) {
        teamRepository.addTeam(team);
    }

    public void deleteTeam(int id) { teamRepository.deleteTeam(id); }

    public void updateTeam(int id, String name, City city, Date founded) {
        teamRepository.updateTeam(id, name, city, founded);
    }
}
