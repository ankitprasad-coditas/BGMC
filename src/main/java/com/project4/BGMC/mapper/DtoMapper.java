package com.project4.BGMC.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Set;

/**
 * Generic Interface to convert New Grid domain entity to response DTO and vice versa.
 *
 * @param <A> Domain View Entity Type
 * @param <B> Response DTO Type
 */
public interface DtoMapper<A, B> {

    /**
     * Method to convert View Entity to Response DTO.
     *
     * @param entity           New Grid View Entity
     * @return Response DTO
     */
    B toDto(A entity) throws JsonProcessingException;

    /**
     * Method to convert Response DTO to entity.
     *
     * @param dto Response DTO
     * @return View Entity Object
     */
    A toEntity(B dto);

    /**
     * Method to convert set of entity objects to corresponding set of response DTOs.
     *
     * @param entityList       set of new grid view entities
     * @return set of response DTOs
     */
    Set<B> toDtoSet(Set<A> entityList);

    /**
     * Method to convert set of response DTOs to set of entities.
     *
     * @param dtoList Set of response DTOs.
     * @return Set of view entities
     */
    Set<A> toEntitySet(Set<B> dtoList);

    /**
     * Method to convert list of entity objects to corresponding set of response DTOs.
     *
     * @param entityList       list of new grid view entities
     * @return list of response DTOs
     */
    List<B> toDtoList(List<A> entityList);

    /**
     * Method to convert list of response DTOs to set of entities.
     *
     * @param dtoList list of response DTOs.
     * @return list of view entities
     */
    List<A> toEntityList(List<B> dtoList);
}