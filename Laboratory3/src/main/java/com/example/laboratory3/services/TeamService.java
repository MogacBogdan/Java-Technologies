package com.example.laboratory3.services;

import com.example.laboratory3.dao.TeamsDao;
import com.example.laboratory3.dto.TeamDto;
import com.example.laboratory3.entities.Team;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.naming.NamingException;
import java.util.List;

@Named
@ApplicationScoped
public class TeamService {
    TeamsDao teamsDao;

    public TeamService() {
        try {
            teamsDao = new TeamsDao();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Team> getAllTeams() {
        return teamsDao.getAllTeams();
    }

    public void addTeam(TeamDto team) {
        teamsDao.createTeam(team);
    }

    public void updateTeam(TeamDto team) {
        teamsDao.updateTeam(team);
    }

    public void removeTeam(int id) { teamsDao.deleteTeam(id); }
}
