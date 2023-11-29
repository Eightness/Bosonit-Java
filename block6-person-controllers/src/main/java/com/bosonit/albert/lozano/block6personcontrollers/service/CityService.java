/**
 * @author Albert Lozano Blasco
 * @version 2.0
 */

package com.bosonit.albert.lozano.block6personcontrollers.service;

import com.bosonit.albert.lozano.block6personcontrollers.model.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class CityService. Contains all business logic methods associated with a city.
 */
@Service    //Define this class as a service. Business logic.
public class CityService implements CityServiceInterface {
    //Attributes.
    private final List<City> cities = new ArrayList<>();

    /**
     * Method addCity.
     * @param city city to add to the list.
     */
    @Override
    public void addCity(City city) {
        this.cities.add(city);
    }

    /**
     * Method getCities.
     * @return the current existing cities.
     */
    @Override
    public List<City> getCities() {
        return this.cities;
    }
}
