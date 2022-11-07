package com.example.laboratory3.beans;

import com.example.laboratory3.services.CityService;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Getter
@Setter
@Named
@SessionScoped
public class DeleteCityBean implements Serializable {
    @Inject
    private CityService cityService;
    private int id;

    public void submit() {
        cityService.deleteCity(id);
    }
}
