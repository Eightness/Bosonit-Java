/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block10dockerizeapp.application.services;

import java.util.List;

/**
 * Interface IGenericService. This interface contains methods that define most business' logic.
 * Service layer gets and returns DTOs, not Business' instances (Domain).
 * @param <InputDTO> InputDTO Class
 * @param <OutputDTO> OutputDTO Class
 * @param <PK> PrimaryKey
 */
public interface IGenericService<InputDTO, OutputDTO, PK> {
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
