package com.example.laboratory3.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "teams")
public class Team extends AbstractEntity<Integer> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String name;

    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @OneToOne
    private City city;
    private Date founded;

    public Team(String name, City city_id, Date founded) {
        this.name = name;
        this.city = city_id;
        this.founded = founded;
    }
}