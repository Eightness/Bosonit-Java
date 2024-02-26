/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block10dockerizeapp.application.implementations;

import com.bosonit.block10dockerizeapp.application.services.IGenericService;
import com.bosonit.block10dockerizeapp.controller.dto.inputDto.CarInputDTO;
import com.bosonit.block10dockerizeapp.controller.dto.mappers.CarMapper;
import com.bosonit.block10dockerizeapp.controller.dto.outputDto.CarOutputDTO;
import com.bosonit.block10dockerizeapp.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class CarServiceImpl. Implements IGenericService interface and contains all methods related to Car's CRUD.
 */
@Service
public class CarServiceImpl implements IGenericService<CarInputDTO, CarOutputDTO, Long> {
    // Dependencies injection
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarMapper carMapper;

    // CRUD Methods
    // Create methods
    @Override
    public CarOutputDTO addEntity(CarInputDTO inputEntity) {
        return null;
    }

    @Override
    public List<CarOutputDTO> addEntities(List<CarInputDTO> inputEntities) {
        return null;
    }

    // Read Methods
    @Override
    public CarOutputDTO getEntityById(Long id) {
        return null;
    }

    @Override
    public List<CarOutputDTO> getEntitiesByIds(List<Long> ids) {
        return null;
    }

    @Override
    public List<CarOutputDTO> getAllEntities(int pageNumber, int pageSize) {
        return null;
    }

    // Update methods
    @Override
    public CarOutputDTO updateEntityById(Long id, CarInputDTO inputEntity) {
        return null;
    }

    @Override
    public List<CarOutputDTO> updateEntitiesByIds(List<Long> ids, List<CarInputDTO> inputEntities) {
        return null;
    }

    @Override
    public CarOutputDTO modifyEntityById(Long id, CarInputDTO inputEntity) {
        return null;
    }

    @Override
    public List<CarOutputDTO> modifyEntitiesByIds(List<Long> ids, List<CarInputDTO> inputEntities) {
        return null;
    }

    // Delete methods
    @Override
    public void deleteEntityById(Long id) {

    }

    @Override
    public void deleteEntitiesByIds(List<Long> ids) {

    }

    @Override
    public void deleteAllEntities() {

    }
}
