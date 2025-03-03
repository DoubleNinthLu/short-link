package com.omlucy.shortlink.shortlink;

import com.omlucy.shortlink.common.BaseConverter;
import com.omlucy.shortlink.common.BaseEnumConverter;
import org.mapstruct.Mapper;

/**
 * @author lucy_
 * @date 2025/3/2
 **/
@Mapper(componentModel = "spring", uses = {BaseEnumConverter.class})
public interface ShortLinkConverter extends BaseConverter<ShortLinkEntity, ShortLinkPO> {

}
