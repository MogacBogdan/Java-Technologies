package com.example.laboratory3.views;

import com.example.laboratory3.entities.Team;
import com.example.laboratory3.services.TeamService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@Named
@ViewScoped
public class AutoCompleteView implements Serializable {
    private String txt1;
    private String txt2;
    private String txt3;
    private String txt4;
    private String txt5;
    private String txt6;
    private String txt7;
    private String txt8;
    private String txt9;
    private String txt10;
    private String txt11;

    private Team team1;
    private Team team2;
    private Team team3;
    private Team team4;
    private Team team5;

    private List<Team> selectedTeams;

    @Inject
    private TeamService teamService;

    private LazyDataModel<Team> lazyModel;

    @PostConstruct
    public void init() {
    }

    public List<String> completeText(String query) {
        String queryLowerCase = query.toLowerCase();
        List<String> teamList = new ArrayList<>();
        List<Team> teams = teamService.getAllTeams();
        for (Team team : teams) {
            teamList.add(team.getName());
        }
        return  teamList.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }

    public List<Team> noResults(String query) {
        return Collections.emptyList();
    }

    public List<Team> completeTeam(String query) {
        String queryLowerCase = query.toLowerCase();
        List<Team> countries = teamService.getAllTeams();
        return countries.stream().filter(t -> t.getName().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
    }

    public void onItemSelect(SelectEvent<String> event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Team Selected", event.getObject()));
    }

    public void onEmptyMessageSelect() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empty message selected"));
    }

    public void onMoreTextSelect() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("More text selected"));
    }

}
