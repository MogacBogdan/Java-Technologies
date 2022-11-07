package com.example.laboratory3.repositories;

import com.example.laboratory3.entities.City;
import com.example.laboratory3.entities.Team;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TeamRepositoryTest {
    @Mock
    TeamRepository teamRepository;
    List<Team> teams;
    List<City> cities;
    Date date;

    @BeforeEach
    void setUp() {
        teamRepository = Mockito.mock(TeamRepository.class);
        teamRepository.setEntityManager(mock(EntityManager.class));

        teams = new ArrayList<>();
        cities = new ArrayList<>();
        date = new Date();

        cities.add(new City(0,"Manchester"));
        cities.add(new City(1,"Liverpool"));
        cities.add(new City(2,"London"));

        teams.add(new Team(0, "FC Manchester United", cities.get(0), date));
        teams.add(new Team(1, "FC Liverpool", cities.get(1), date));
        teams.add(new Team(2, "FC Chelsea", cities.get(2), date));
    }

    @Test
    void getAllTeamsTest() {
        when(teamRepository.getAllTeams()).thenReturn(teams);
        List<Team> teamList = teamRepository.getAllTeams();
        assertEquals(teams, teamList);
    }

    @Test
    void getTeamById() {
        when(teamRepository.getTeamById(0)).thenReturn(teams.get(0));
        assertEquals(teamRepository.getTeamById(0), teams.get(0));
    }

    @Test
    void deleteTeam() {
        when(teamRepository.deleteTeam(0)).thenReturn(teams.remove(0));
        Team team = teamRepository.deleteTeam(0);
        assertNotEquals(team, teams.get(0));
        assertNotEquals(teams.size(), 3);
    }

    @Test
    void updateTeam() {
        when(teamRepository.updateTeam(0, "Manchester United", cities.get(1), date)).thenReturn(
            new Team(
                0,
                "Manchester United",
                cities.get(1),
                date
            ));
        Team team = teamRepository.updateTeam(0, "Manchester United", cities.get(1), date);
        assertNotEquals(team, teams.get(0));
    }

}