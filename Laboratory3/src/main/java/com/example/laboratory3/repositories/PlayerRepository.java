package com.example.laboratory3.repositories;

import com.example.laboratory3.entities.Player;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PlayerRepository {
    @Getter
    @Setter
    @PersistenceContext(unitName = "TPU")
    private EntityManager entityManager;

    public List<Player> getAllPlayers() {
        return entityManager.createNamedQuery("findAllPlayers", Player.class).getResultList();
    }
}
