package com.example.laboratory3.beans;

import com.example.laboratory3.dao.TeamsDao;
import com.example.laboratory3.dto.TeamDto;
import com.example.laboratory3.services.TeamService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.primefaces.context.PrimeRequestContext;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.NamingException;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Named
@SessionScoped
public class CreateTeamBean implements Serializable {
    @Inject
    private TeamService teamService;

    private String name;
    private String city;
    private Date founded;

    public CreateTeamBean() throws NamingException {}

    public void submit() {
        TeamDto team = new TeamDto(name, city, founded);
        teamService.addTeam(team);
    }
}
