package com.example.laboratory3.entities;

import com.example.laboratory3.beans.DataViewBean;
import com.example.laboratory3.enums.Position;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "players")
@NamedQuery(
        name = "findAll",
        query = "SELECT p FROM Player p"
)
public class Player extends Person implements Serializable {

    @Column(name = "position")
    protected Position position;

    public Player(String firstName,
                  String lastName,
                  int teamId,
                  Date date,
                  Position position) {
        super(firstName, lastName, teamId, date);
        this.position = position;
    }
}
