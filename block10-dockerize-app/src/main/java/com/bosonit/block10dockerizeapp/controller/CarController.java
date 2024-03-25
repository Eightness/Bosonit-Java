/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block10dockerizeapp.controller;

import com.bosonit.block10dockerizeapp.application.services.IGenericService;
import com.bosonit.block10dockerizeapp.controller.dto.inputDto.CarInputDTO;
import com.bosonit.block10dockerizeapp.controller.dto.outputDto.CarOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CarController class. RestController to manage all Car's HTTP methods.
 */
@RestController
@RequestMapping("/car")
public class CarController {
    // Dependencies injection
    @Autowired
    private IGenericService<CarInputDTO, CarOutputDTO, Long> carService;

    // HTTP methods
    // Get methods
    @GetMapping("/get")
    public ResponseEntity<CarOutputDTO> getCar(@RequestParam long id) {
        CarOutputDTO carOutputDTO = carService.getEntityById(id);
        return new ResponseEntity<>(carOutputDTO, HttpStatus.OK);
    }

    // Post methods
    @PostMapping("/post")
    public ResponseEntity<CarOutputDTO> postCar(@RequestBody CarInputDTO carInputDTO) {
        CarOutputDTO carOutputDTO = carService.addEntity(carInputDTO);
        return new ResponseEntity<>(carOutputDTO, HttpStatus.CREATED);
    }

    // Put methods
    @PutMapping("/put")
    public ResponseEntity<CarOutputDTO> putCar(@RequestParam long id, @RequestBody CarInputDTO carInputDTO) {
        CarOutputDTO carOutputDTO = carService.updateEntityById(id, carInputDTO);
        return new ResponseEntity<>(carOutputDTO, HttpStatus.OK);
    }

    // Patch methods
    @PatchMapping("/patch")
    public ResponseEntity<CarOutputDTO> patchCar(@RequestParam long id, @RequestBody CarInputDTO carInputDTO) {
        CarOutputDTO carOutputDTO = carService.modifyEntityById(id, carInputDTO);
        return new ResponseEntity<>(carOutputDTO, HttpStatus.OK);
    }

    // Delete methods
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCar(@RequestParam long id) {
        carService.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllCars() {
        carService.deleteAllEntities();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
