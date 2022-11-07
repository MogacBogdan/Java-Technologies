package com.example.laboratory3.repositories;

import com.example.laboratory3.entities.City;
import com.example.laboratory3.entities.Team;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Stateless
public class TeamRepository {
    @Getter
    @Setter
    @PersistenceContext(unitName = "TPU")
    private EntityManager entityManager;

    public List<Team> getAllTeams() {
        return entityManager.createQuery("select t from Team t", Team.class).getResultList();
    }

    public Team addTeam(Team team) {
        entityManager.persist(team);
        return team;
    }

    public Team getTeamById(int id) {
        List<Team> teams = getAllTeams();
        for (Team team: teams) {
            if(team.getId() == id) {
                return team;
            }
        }
        return null;
    }

    public Team deleteTeam(int id) {
        Team team = getTeamById(id);
        entityManager.remove(getTeamById(id));
        return team;
    }

    public Team updateTeam(int id, String name, City city, Date founded) {
        Query q = entityManager.createQuery(
                "UPDATE Team t SET t.name = :name, t.city = :city, t.founded = :founded WHERE t.id = :id"
        );
        q.setParameter("name", name);
        q.setParameter("city", city);
        q.setParameter("founded", founded);
        q.setParameter("id", id);
        q.executeUpdate();
        return new Team(id, name, city, founded);
    }

}
