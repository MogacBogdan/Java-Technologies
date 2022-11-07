package com.example.laboratory3.views;

import com.example.laboratory3.entities.City;
import com.example.laboratory3.entities.Team;
import com.example.laboratory3.services.CityService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
@Setter
@Named
@RequestScoped
public class SelectIdMenuView {
    private String selectedOption;

    private String city;
    private List<City> cityList;
    private Map<String, String> cities;

    @Inject
    private CityService cityService;

    @PostConstruct
    public void init() {
        cityList = cityService.getAllCities();
        cities = new HashMap<>();
        for (City city: cityList) {
            cities.put(city.getName(), city.getName());
        }
    }
}
