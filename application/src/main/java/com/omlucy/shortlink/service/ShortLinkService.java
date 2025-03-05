package com.omlucy.shortlink.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.omlucy.shortlink.assembler.ShortLinkAssembler;
import com.omlucy.shortlink.dto.request.ShortLinkPageQuery;
import com.omlucy.shortlink.dto.response.ShortLinkVO;
import com.omlucy.shortlink.shortlink.ShortLinkCreateCmd;
import com.omlucy.shortlink.shortlink.ShortLinkDomainService;
import com.omlucy.shortlink.shortlink.ShortLinkEntity;
import com.omlucy.shortlink.shortlink.ShortLinkRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author lucy_
 * @date 2025/2/28
 **/
@Service
public class ShortLinkService {

    private final ShortLinkDomainService shortLinkDomainService;
    private final ShortLinkRepository shortLinkRepository;
    private final ShortLinkAssembler shortLinkAssembler;

    public ShortLinkService(ShortLinkDomainService shortLinkDomainService, ShortLinkRepository shortLinkRepository, ShortLinkAssembler shortLinkAssembler) {
        this.shortLinkDomainService = shortLinkDomainService;
        this.shortLinkRepository = shortLinkRepository;
        this.shortLinkAssembler = shortLinkAssembler;
    }

    public ShortLinkVO createShortLink(ShortLinkCreateCmd createCmd) {
        createCmd.setDomain("omlucy.com");

        // 创建短链接
        ShortLinkEntity shortLinkEntity = shortLinkDomainService.generateShortLink(createCmd);

        // 持久化短链接
        shortLinkRepository.save(shortLinkEntity);

        return shortLinkAssembler.toVo(shortLinkEntity);
    }

    public IPage<ShortLinkVO> listShortLink(ShortLinkPageQuery pageQuery) {
        IPage<ShortLinkEntity> page = shortLinkRepository.findByUserId(pageQuery.getUserId(), PageRequest.of(pageQuery.getPageNum(), pageQuery.getPageSize()));

        return page.convert(shortLinkAssembler::toVo);
    }
}
