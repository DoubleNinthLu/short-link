package com.omlucy.shortlink.shortlink;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lucy_
 * @date 2025/3/2
 **/
@Data
public class ShortLinkValue {

    private String originalUrl;

    private String shortCode;

    private LocalDateTime expirationTime;

    private String description;
}
