package com.omlucy.shortlink.assembler;

import com.omlucy.shortlink.shortlink.ShortLinkCreateCmd;
import com.omlucy.shortlink.shortlink.ShortLinkValue;
import org.mapstruct.Mapper;

/**
 * @author lucy_
 * @date 2025/3/2
 **/
@Mapper
public interface ShortLinkAssembler {
    ShortLinkValue toShortLinkValue(ShortLinkCreateCmd createCmd);
}
