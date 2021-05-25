package com.utility.util;

import java.util.List;
import java.util.Set;

/**
 * @author Harshal Patil
 */
public interface DtoTransformer<A, B> {
    B toDto(A entity);

    A toEntity(B dto);

    Set<B> toDtoSet(Set<A> entityList);

    Set<A> toEntitySet(Set<B> dtoList);

    List<B> toDtoList(List<A> entityList);

    List<A> toEntityList(List<B> dtoList);
}
