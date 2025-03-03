package com.omlucy.shortlink.common;

import org.mapstruct.Mapper;
import org.mapstruct.TargetType;

/**
 * @author lucy_
 * @date 2025/3/3
 **/
@Mapper(componentModel = "spring")
public interface BaseEnumConverter {

    default <E extends BaseEnum> E toEnum(Integer code, @TargetType Class<E> enumClass) {
        return (code != null) ? BaseEnum.fromCode(code, enumClass) : null;
    }

    default <E extends BaseEnum> Integer toCode(E enumObj) {
        return (enumObj != null) ? enumObj.getCode() : null;
    }

}
