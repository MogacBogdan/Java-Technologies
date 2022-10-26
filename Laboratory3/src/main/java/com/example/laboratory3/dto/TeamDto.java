package com.example.laboratory3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class TeamDto {
    private int id;
    private String name;
    private String city;
    private Date founded;

    public TeamDto(String name, String city, Date founded) {
        this.name = name;
        this.city = city;
        this.founded = founded;
    }
}
