package com.omlucy.shortlink.shortlink;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author lucy_
 * @date 2025/2/28
 **/
@Getter
@Builder
public class ShortLinkEntity {

    private Long shortLinkId;

    private Long userId;

    private String originalUrl;

    private String domain;

    private String shortCode;

    private LocalDateTime expirationTime;

    private String description;

    private ShortLinkStatusEnum status;


    public String getShortUrl() {
        if (domain.endsWith("/")) {
            return domain + "s/" + shortCode;
        }
        return domain + "/s/" + shortCode;
    }
}
