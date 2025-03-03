package com.omlucy.shortlink.shortlink;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lucy_
 * @date 2025/3/2
 **/
@Data
@TableName("short_link")
public class ShortLinkPO {
    @TableId(type = IdType.AUTO)
    private Long shortLinkId;

    private Long userId;

    private String originalUrl;

    private String domain;


    private String shortCode;


    private LocalDateTime expirationTime;

    private String description;

    private Integer status;


    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
