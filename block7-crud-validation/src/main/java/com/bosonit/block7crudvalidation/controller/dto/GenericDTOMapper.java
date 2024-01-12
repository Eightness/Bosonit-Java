package com.bosonit.block7crudvalidation.controller.dto;

import java.util.List;

public interface GenericDTOMapper<E1, E2, E3> {
    //Generic mapper methods.
    E1 domainToInput(E2 domain);
    List<E1> domainToInput(List<E2> domain);

    E2 inputToDomain(E1 persistence);
    E2 outputToDomain(E3 persistence);
    List<E2> inputToDomain(List<E1> persistence);
    List<E2> outputToDomain(List<E3> persistence);

    E3 domainToOutput(E2 domain);
    List<E3> domainToOutput(List<E2> domain);
}
