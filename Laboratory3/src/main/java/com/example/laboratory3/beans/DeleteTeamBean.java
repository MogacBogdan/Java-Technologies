package com.example.laboratory3.beans;

import com.example.laboratory3.services.TeamService;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Getter
@Setter
@Named
@SessionScoped
public class DeleteTeamBean implements Serializable {
    @Inject
    private TeamService teamService;
    private int id;

    public void submit() {
        teamService.removeTeam(id);
    }
}
