package com.omlucy.shortlink.shortlink;

import cn.hutool.core.date.StopWatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author lucy_
 * @date 2025/3/2
 **/
@Slf4j
@Service
public class ShortLinkDomainServiceImpl implements ShortLinkDomainService {

    private static final int SHORT_CODE_LENGTH = 6;

    private final ShortLinkRepository shortLinkRepository;

    public ShortLinkDomainServiceImpl(ShortLinkRepository shortLinkRepository) {
        this.shortLinkRepository = shortLinkRepository;
    }


    @Override
    public ShortLinkEntity generateShortLink(ShortLinkCreateCmd createCmd) {
        // 1、业务规则校验
        // nothing to do


        StopWatch watch = new StopWatch();
        watch.start();
        // 2、生成短链接
        String shortCode = generateShortCode(createCmd.getOriginalUrl());
        watch.stop();
        log.info("generateShortCode cost: {}", watch.getTotalTimeSeconds());

        return ShortLinkEntity.builder()
                .shortCode(shortCode)
                .domain(createCmd.getDomain())
                .originalUrl(createCmd.getOriginalUrl())
                .expirationTime(createCmd.getExpirationTime())
                .description(createCmd.getDescription())
                .build();

    }


    private String generateShortCode(String originalUrl) {
        String uuid = originalUrl + UUID.randomUUID();
        String shortCode = ShortUrlGenerator.generate(uuid, SHORT_CODE_LENGTH);

        while (shortLinkRepository.existsByShortCode(shortCode)) {
            shortCode = generateShortCode(originalUrl);
        }

        return shortCode;
    }
}
