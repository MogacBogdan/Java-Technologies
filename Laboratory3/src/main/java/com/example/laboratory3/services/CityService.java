package com.example.laboratory3.services;

import com.example.laboratory3.entities.City;
import com.example.laboratory3.repositories.CityRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class CityService {
    @Inject
    CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.getAllCities();
    }

    public void addCity(City city) { cityRepository.addCity(city); }

    public City getCityByName(String name) {
        return cityRepository.getCityByName(name);
    }

    public void deleteCity(int id) {
       cityRepository.deleteCity(id);
    }

    public void updateCity(int id, String name) {
        cityRepository.updateCity(id, name);
    }
}
