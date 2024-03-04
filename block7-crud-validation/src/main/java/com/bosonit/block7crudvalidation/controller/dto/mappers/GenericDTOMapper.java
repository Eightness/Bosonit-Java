/**
 * @author Albert Lozano Blasco
 * @version 11.0
 */

package com.bosonit.block7crudvalidation.controller.dto.mappers;

import java.util.List;

/**
 * GenericDTOMapper interface. Contains all base methods to map InputDTOs > Domain > OutputDTOs.
 * @param <InputDTO> Input layer
 * @param <Domain> Business' layer
 * @param <OutputDTO> Output layer
 */
public interface GenericDTOMapper<InputDTO, Domain, OutputDTO> {
    // Input -> Domain
    Domain inputToDomain(InputDTO inputDTO);
    List<Domain> inputToDomain(List<InputDTO> inputDTOs);

    // Domain -> Output
    OutputDTO domainToOutput(Domain domain);
    List<OutputDTO> domainToOutput(List<Domain> domains);

    // Output -> Domain
    Domain outputToDomain(OutputDTO outputDTO);
    List<Domain> outputToDomain(List<OutputDTO> outputDTOs);

    // Domain -> Input
    InputDTO domainToInput(Domain domain);
    List<InputDTO> domainToInput(List<Domain> domains);

    // Input -> Output (Maybe unnecessary)
    OutputDTO inputToOutput(InputDTO inputDTO);
    List<OutputDTO> inputToOutput(List<InputDTO> inputDTOs);

    // Output -> Input (Maybe unnecessary)
    InputDTO outputToInput(OutputDTO outputDTO);
    List<InputDTO> outputToInput(List<OutputDTO> outputDTOs);
}
