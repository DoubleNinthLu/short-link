package com.omlucy.shortlink.assembler;

import com.omlucy.shortlink.common.BaseEnumConverter;
import com.omlucy.shortlink.dto.response.ShortLinkVO;
import com.omlucy.shortlink.shortlink.ShortLinkEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author lucy_
 * @date 2025/3/2
 **/
@Mapper(componentModel = "spring", uses = {BaseEnumConverter.class})
public interface ShortLinkAssembler {

    @Mapping(target = "shortUrl", expression = "java(shortLink.getShortUrl())")
    ShortLinkVO toVo(ShortLinkEntity shortLink);
}
