package com.zz.back.util;

import com.zz.back.model.ArticleEntity;
import com.zz.back.model.vo.ArticleVo;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;

/**
 * @author pierce
 */
public class BeanUtil {

    public static ArticleVo toArticle(ArticleEntity articleEntity) {
        ArticleVo vo = new ArticleVo();
        BeanUtils.copyProperties(articleEntity, vo);
        return vo;
    }

}
