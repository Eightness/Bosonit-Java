/**
 * @author Albert Lozano Blasco
 * @version 2.0
 */

package com.bosonit.albert.lozano.block6personcontrollers.service;

import com.bosonit.albert.lozano.block6personcontrollers.model.City;
import java.util.List;

/**
 * Interface CityServiceInterface. Contracts methods with determined classes.
 */
public interface CityServiceInterface {
    void addCity(City city);
    List<City> getCities();
}
