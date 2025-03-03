package com.omlucy.shortlink.shortlink;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.data.domain.Pageable;

/**
 * @author lucy_
 * @date 2025/3/2
 **/
public interface ShortLinkRepository {

    IPage<ShortLinkEntity> findByUserId(Long userId, Pageable pageable);

    ShortLinkEntity findByShortCode(String shortCode);

    void save(ShortLinkEntity shortLinkEntity);

    boolean existsByShortCode(String shortCode);

}
