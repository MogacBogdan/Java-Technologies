package com.example.laboratory3.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Team implements Serializable {
    private int id;
    private String name;
    private String city;
    private Date founded;
}