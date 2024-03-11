/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.application.services;

import java.util.List;

/**
 * GenericService interface. Contains methods that defines most business' logic in this app.
 * @param <InputDTO> Input class
 * @param <OutputDTO> Output class
 * @param <PK> Primary key
 */
public interface GenericService<InputDTO, OutputDTO, PK> {
    // Get methods
    OutputDTO getEntityById(PK id);
    List<OutputDTO> getEntitiesByIds(List<PK> ids);
    List<OutputDTO> getAllEntities(int pageNumber, int pageSize);

    // Post methods
    OutputDTO addEntity(InputDTO inputEntity);
    List<OutputDTO> addEntities(List<InputDTO> inputEntities);

    // Put methods
    OutputDTO updateEntityById(PK id, InputDTO inputEntity);
    List<OutputDTO> updateEntitiesByIds(List<PK> ids, List<InputDTO> inputEntities);

    // Patch methods
    OutputDTO modifyEntityById(PK id, InputDTO inputEntity);
    List<OutputDTO> modifyEntitiesByIds(List<PK> ids, List<InputDTO> inputEntities);

    // Delete methods
    void deleteEntityById(PK id);
    void deleteEntitiesByIds(List<PK> ids);
    void deleteAllEntities();
}
