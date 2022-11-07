package com.example.laboratory3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CityDto {
    private int id;
    private String name;

    public CityDto(String name) {
        this.name = name;
    }
}
