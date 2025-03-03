package com.omlucy.shortlink.service;

import com.omlucy.shortlink.shortlink.ShortLinkCreateCmd;
import com.omlucy.shortlink.shortlink.ShortLinkDomainService;
import com.omlucy.shortlink.shortlink.ShortLinkEntity;
import com.omlucy.shortlink.shortlink.ShortLinkRepository;
import org.springframework.stereotype.Service;

/**
 * @author lucy_
 * @date 2025/2/28
 **/
@Service
public class ShortLinkService {

    private final ShortLinkDomainService shortLinkDomainService;
    private final ShortLinkRepository shortLinkRepository;

    public ShortLinkService(ShortLinkDomainService shortLinkDomainService, ShortLinkRepository shortLinkRepository) {
        this.shortLinkDomainService = shortLinkDomainService;
        this.shortLinkRepository = shortLinkRepository;
    }

    public String createShortLink(ShortLinkCreateCmd createCmd) {
        createCmd.setDomain("omlucy.com");

        // 创建短链接
        ShortLinkEntity shortLinkEntity = shortLinkDomainService.generateShortLink(createCmd);

        // 持久化短链接
        shortLinkRepository.save(shortLinkEntity);

        return shortLinkEntity.getShortLink();
    }
}
