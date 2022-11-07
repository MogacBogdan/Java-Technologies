package com.example.laboratory3.beans;

import com.example.laboratory3.dto.TeamDto;
import com.example.laboratory3.entities.City;
import com.example.laboratory3.entities.Team;
import com.example.laboratory3.services.CityService;
import com.example.laboratory3.services.TeamService;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Named
@SessionScoped
public class UpdateTeamBean implements Serializable {
    @Inject
    private TeamService teamService;
    @Inject
    private CityService cityService;

    private int id;
    private String name;
    private String city;
    private Date founded;

    public void submit() {
        City temp = cityService.getCityByName(city);
        teamService.updateTeam(id, name, temp, founded);
    }
}
