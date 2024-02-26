/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block10dockerizeapp.controller.dto.mappers;

import java.util.List;

/**
 * IGenericDTOMapper interface. Contains all base methods to map InputDTOs > Domain > OutputDTOs.
 * @param <InputDTO> InputDTO Class
 * @param <Domain> Domain Class
 * @param <OutputDTO> OutputDTO Class
 */
public interface IGenericDTOMapper<InputDTO, Domain, OutputDTO> {
    // Input -> Domain
    Domain inputToDomain(InputDTO inputDTO);
    List<Domain> inputsToDomain(List<InputDTO> inputDTOs);

    // Domain -> Output
    OutputDTO domainToOutput(Domain domain);
    List<OutputDTO> domainsToOutput(List<Domain> domains);

    // Output -> Domain
    Domain outputToDomain(OutputDTO outputDTO);
    List<Domain> outputsToDomain(List<OutputDTO> outputDTOs);

    // Domain -> Input
    InputDTO domainToInput(Domain domain);
    List<InputDTO> domainsToInput(List<Domain> domains);

    // Input -> Output
    OutputDTO inputToOutput(InputDTO inputDTO);
    List<OutputDTO> inputsToOutput(List<InputDTO> inputDTOs);

    // Output -> Input (Maybe unnecessary)
    InputDTO outputToInput(OutputDTO outputDTO);
    List<InputDTO> outputsToInput(List<OutputDTO> outputDTOs);
}
