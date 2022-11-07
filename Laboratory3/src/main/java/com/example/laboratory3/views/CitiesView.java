package com.example.laboratory3.views;

import com.example.laboratory3.beans.DataViewBean;
import com.example.laboratory3.entities.City;
import com.example.laboratory3.services.CityService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("citiesView")
@ApplicationScoped
public class CitiesView extends DataViewBean<City, Integer> {
    @Inject
    private CityService cityService;

    @PostConstruct
    public void init() {
        entities = cityService.getAllCities();
    }

    public List<City> getEntities() {
        entities = cityService.getAllCities();
        return entities;
    }
}
