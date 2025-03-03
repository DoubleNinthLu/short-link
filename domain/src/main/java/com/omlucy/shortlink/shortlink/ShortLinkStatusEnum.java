package com.omlucy.shortlink.shortlink;

import com.omlucy.shortlink.common.BaseEnum;
import lombok.Getter;

/**
 * @author lucy_
 * @date 2025/3/2
 **/
@Getter
public enum ShortLinkStatusEnum implements BaseEnum {

    DISABLED(0),

    NORMAL(1),
    ;

    private final int code;

    ShortLinkStatusEnum(int code) {
        this.code = code;
    }
}
