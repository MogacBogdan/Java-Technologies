package com.example.laboratory3.repositories;


import com.example.laboratory3.entities.City;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Stateless
public class CityRepository {
    @PersistenceContext(unitName = "TPU")
    private EntityManager entityManager;

    public List<City> getAllCities() {
        return entityManager.createQuery("select c from City c", City.class).getResultList();
    }

    public void addCity(City city) {
        entityManager.persist(city);
    }

    public City getCityByName(String name) {
        List<City> cities = getAllCities();
        for (City city: cities) {
            if (city.getName().equals(name)) return city;
        }
        return cities.get(0);
    }

    public void deleteCity(int id) {
        List<City> cities = getAllCities();
        for (City city: cities) {
            if(city.getId() == id) {
                entityManager.remove(city);
                return;
            }
        }
    }

    public void updateCity(int id, String name) {
        Query q = entityManager.createQuery(
                "UPDATE City c SET c.name = :name WHERE c.id = :id"
        );
        q.setParameter("name", name);
        q.setParameter("id", id);
        q.executeUpdate();
    }

}
