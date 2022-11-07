package com.example.laboratory3.entities;

import com.example.laboratory3.beans.DataViewBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@MappedSuperclass
public class Person extends AbstractEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    protected String firstName;

    @Column(name = "lastName")
    protected String lastName;

    @Column(name = "team_id")
    protected int teamId;

    @Column(name = "birth_date")
    protected Date date;

    public Person(String firstName, String lastName, int teamId, Date date) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.teamId = teamId;
       this.date = date;
    }

}
