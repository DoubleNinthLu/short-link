package com.omlucy.shortlink.web;

import com.omlucy.shortlink.dto.response.ApiResponse;
import com.omlucy.shortlink.service.ShortLinkService;
import com.omlucy.shortlink.shortlink.ShortLinkCreateCmd;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lucy_
 * @date 2025/2/28
 **/
@RequestMapping("/v1/short-link")
@RestController
public class ShortLinkController {

    private final ShortLinkService shortLinkService;

    public ShortLinkController(ShortLinkService shortLinkService) {
        this.shortLinkService = shortLinkService;
    }

    @PostMapping("/create")
    public ApiResponse<String> create(@RequestBody @Valid ShortLinkCreateCmd createCmd) {
        return ApiResponse.success(shortLinkService.createShortLink(createCmd));
    }

}
