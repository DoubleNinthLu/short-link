package com.omlucy.shortlink.common;

/**
 * @author lucy_
 * @date 2025/3/3
 **/
public interface BaseEnum {

    int getCode();

    /**
     * 根据编码解析枚举值
     *
     * @param code      编码
     * @param enumClass 枚举类
     * @return 对应的枚举实例
     */
    static <T extends BaseEnum> T fromCode(int code, Class<T> enumClass) {
        for (T enumConstant : enumClass.getEnumConstants()) {
            if (enumConstant.getCode() == code) {
                return enumConstant;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
