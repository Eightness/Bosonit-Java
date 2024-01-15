package com.bosonit.block7crudvalidation.application.services;

import java.util.List;

/**
 * Interface GenericService. This interface contains methods that define most business' logic.
 */
public interface GenericService<E1, E2> {
    //REMEMBER: Service layer gets and returns DTOs, not Business's instances (domain).
    //Being E1 -> Input Class and E2 -> Output Class
    //Get methods.
    E2 getEntityById(int id);
    List<E2> getEntitiesByName(String name);
    List<E2> getAllEntities(int pageNumber, int pageSize);
    //Post methods.
    E2 addEntity(E1 inputEntity);
    List<E2> addEntities(List<E1> inputEntities);
    //Put methods.
    E2 updateEntityById(int id, E1 inputEntity);
    List<E2> updateEntitiesByIds(List<Integer> ids, List<E1> inputEntities);
    //Patch methods.
    E2 modifyEntityById(int id, E1 inputEntity);
    List<E2> modifyEntitiesByIds(List<Integer> ids, List<E1> inputEntities);
    //Delete methods.
    void deleteEntityById(int id);
    void deleteEntitiesByIds(List<Integer> ids);
}
