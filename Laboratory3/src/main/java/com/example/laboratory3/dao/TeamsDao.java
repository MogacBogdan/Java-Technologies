package com.example.laboratory3.dao;

import com.example.laboratory3.dto.TeamDto;
import com.example.laboratory3.entities.Team;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeamsDao extends Dao {
    private static final String SELECT_ALL_TEAMS = "SELECT * FROM teams;";
    private static final String SELECT_TEAM_BY_ID = "SELECT * FROM teams WHERE id = ?;";
    private static final String CREATE_TEAM = "INSERT INTO teams(name, city, founded) VALUES(?, ?, TO_DATE(?, 'YYYY-MM-DD'));";
    private static final String UPDATE_TEAM = "UPDATE teams SET name = ?, city = ?, founded = TO_DATE(?, 'YYYY-MM-DD') WHERE id = ?;";
    private static final String DELETE_TEAM = "DELETE FROM teams WHERE id = ?;";

    public TeamsDao() throws NamingException {
    }

    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();

        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_TEAMS);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                Date founded = resultSet.getDate("founded");
                teams.add(new Team(id, name, city, founded));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teams;
    }

    public Team getTeamById(int id) {
        Team team = null;
        try(PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_TEAM_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                Date founded = resultSet.getDate("founded");
                team = new Team(id, name, city, founded);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return team;
    }

    public void createTeam(TeamDto team) {
        try (PreparedStatement statement = getConnection().prepareStatement(CREATE_TEAM)){
            statement.setString(1, team.getName());
            statement.setString(2, team.getCity());
            java.sql.Date sqlDate = new java.sql.Date(team.getFounded().getTime());
            statement.setDate(3, sqlDate);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTeam(TeamDto team) {
        try(PreparedStatement statement = getConnection().prepareStatement(UPDATE_TEAM)) {
            statement.setString(1, team.getName());
            statement.setString(2, team.getCity());
            java.sql.Date sqlDate = new java.sql.Date(team.getFounded().getTime());
            statement.setDate(3, sqlDate);
            statement.setInt(4, team.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTeam(int id) {
        try (PreparedStatement statement = getConnection().prepareStatement(DELETE_TEAM)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
