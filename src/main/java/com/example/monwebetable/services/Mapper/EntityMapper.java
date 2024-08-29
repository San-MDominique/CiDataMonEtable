package com.example.monwebetable.services.Mapper;

public interface EntityMapper<D, E> {
    D toDto(E  entity);
    E toEntity(D  dto);

}
