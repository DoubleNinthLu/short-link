package com.omlucy.shortlink.shortlink;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lucy_
 * @date 2025/2/28
 **/
@Data
public class ShortLinkCreateCmd {

    @NotBlank(message = "originalUrl 不能为空")
    @Size(min = 1, max = 1024, message = "originalUrl 长度过长")
    private String originalUrl;

    /**
     * 域名
     */
    @Size(max = 50, message = "domain 长度过长")
    private String domain;

    /**
     * 过期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expirationTime;

    /**
     * 描述
     */
    private String description;

}
