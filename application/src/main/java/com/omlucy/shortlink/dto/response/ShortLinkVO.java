package com.omlucy.shortlink.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lucy_
 * @date 2025/3/5
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ShortLinkVO {
    private Long shortLinkId;

    private String originalUrl;


    private String shortUrl;

    /**
     * 过期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expirationTime;

    private Integer status;

    /**
     * 描述
     */
    private String description;
}
