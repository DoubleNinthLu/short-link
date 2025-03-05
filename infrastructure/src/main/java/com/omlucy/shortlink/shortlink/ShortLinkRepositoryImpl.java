package com.omlucy.shortlink.shortlink;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Objects;


/**
 * @author lucy_
 * @date 2025/3/2
 **/
@Repository
public class ShortLinkRepositoryImpl extends ServiceImpl<ShortLinkMapper, ShortLinkPO> implements ShortLinkRepository {

    private final ShortLinkConverter shortLinkConverter;

    public ShortLinkRepositoryImpl(ShortLinkConverter shortLinkConverter) {
        this.shortLinkConverter = shortLinkConverter;
    }

    @Override
    public IPage<ShortLinkEntity> findByUserId(Long userId, Pageable pageable) {
        return lambdaQuery()
                .eq(ShortLinkPO::getUserId, userId)
                .orderByDesc(ShortLinkPO::getCreateTime)
                .page(new Page<>(pageable.getPageNumber(), pageable.getPageSize()))
                .convert(shortLinkConverter::toEntity);
    }

    @Override
    public ShortLinkEntity findByShortCode(String shortCode) {
        return shortLinkConverter.toEntity(
                lambdaQuery().eq(ShortLinkPO::getShortCode, shortCode).one()
        );
    }

    @Override
    public void save(ShortLinkEntity shortLinkEntity) {
        ShortLinkPO shortLinkPo = shortLinkConverter.toPo(shortLinkEntity);
        if (Objects.isNull(shortLinkEntity.getShortLinkId())) {
            baseMapper.insert(shortLinkPo);
            shortLinkPo.setShortLinkId(shortLinkPo.getShortLinkId());
        } else {
            baseMapper.updateById(shortLinkPo);
        }
    }

    @Override
    public boolean existsByShortCode(String shortCode) {
        return lambdaQuery().eq(ShortLinkPO::getShortCode, shortCode).exists();
    }
}
