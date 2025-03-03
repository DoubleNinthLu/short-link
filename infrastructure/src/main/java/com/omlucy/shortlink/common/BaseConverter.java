package com.omlucy.shortlink.common;

/**
 * @author lucy_
 * @date 2025/3/2
 **/
public interface BaseConverter<E, P> {
    E toEntity(P po);

    P toPo(E entity);
}
