package com.example.laboratory3.views;

import com.example.laboratory3.beans.DataViewBean;
import com.example.laboratory3.entities.Player;
import com.example.laboratory3.services.PlayerService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("playersView")
@ApplicationScoped
public class PlayersView extends DataViewBean<Player, Integer> {
    @Inject
    private PlayerService playerService;

    @PostConstruct
    public void init() { entities = playerService.getAllPlayers(); }

    public List<Player> getEntities() {
        entities = playerService.getAllPlayers();
        return entities;
    }
}
