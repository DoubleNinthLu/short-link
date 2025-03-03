package com.omlucy.shortlink.shortlink;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author lucy_
 * @date 2025/3/4
 **/
public class ShortUrlGenerator {

    private ShortUrlGenerator() {
    }

    // 定义短链字符集（62 个字符：0-9, a-z, A-Z）
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 生成短链
     *
     * @param longUrl 长 URL
     * @param length  短链长度
     * @return 短链
     */
    public static String generate(String longUrl, int length) {
        try {
            // 使用 MD5 哈希算法
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(longUrl.getBytes(StandardCharsets.UTF_8));

            // 将哈希值转换为正整数
            long hashValue = 0;
            for (byte b : hashBytes) {
                hashValue = (hashValue << 8) | (b & 0xFF);
            }

            // 将正整数转换为 Base62 字符串
            StringBuilder shortUrl = new StringBuilder();
            for (int i = 0; i < length; i++) {
                // 使用 Math.abs 确保取模结果为正数
                int index = (int) (Math.abs(hashValue % BASE62.length()));
                shortUrl.append(BASE62.charAt(index));
                hashValue /= BASE62.length();
            }

            return shortUrl.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }
}
