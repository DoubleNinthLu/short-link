package com.omlucy.shortlink.shortlink;

/**
 * @author lucy_
 * @date 2025/2/28
 **/
public interface ShortLinkDomainService {

    ShortLinkEntity generateShortLink(ShortLinkCreateCmd createCmd);

}
