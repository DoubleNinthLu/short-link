package com.omlucy.shortlink.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author lucy_
 * @date 2025/3/5
 **/
@Data
public class ShortLinkPageQuery {
    @NotNull(message = "userId不能为空")
    private Long userId;

    @NotNull(message = "pageNum不能为空")
    @Min(value = 1, message = "pageNum必须大于等于1")
    private Integer pageNum;

    @NotNull(message = "pageSize不能为空")
    @Min(value = 1, message = "pageNum必须大于等于1")
    @Max(value = 20, message = "pageSize不能大于21")
    private Integer pageSize;
}
