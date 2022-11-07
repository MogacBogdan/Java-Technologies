package com.example.laboratory3.services;

import com.example.laboratory3.entities.Player;
import com.example.laboratory3.repositories.PlayerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class PlayerService {
    @Inject
    PlayerRepository playerRepository;

    public List<Player> getAllPlayers() { return playerRepository.getAllPlayers(); }
}
