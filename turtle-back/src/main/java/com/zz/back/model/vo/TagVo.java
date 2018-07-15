package com.zz.back.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author pierce
 */
@Data
public class TagVo {

    @ApiModelProperty("标签ID")
    private Long id;
    @ApiModelProperty("标签名")
    private String name;

}
