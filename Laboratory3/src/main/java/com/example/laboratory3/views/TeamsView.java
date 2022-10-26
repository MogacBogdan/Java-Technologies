package com.example.laboratory3.views;

import com.example.laboratory3.entities.Team;
import com.example.laboratory3.services.TeamService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("teamsView")
@ViewScoped
public class TeamsView implements Serializable {
    @Getter private List<Team> teams;

    @Inject
    @Setter private TeamService teamService;

    @PostConstruct
    public void init() {
        teams = teamService.getAllTeams();
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

}
