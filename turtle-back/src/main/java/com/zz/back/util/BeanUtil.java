package com.zz.back.util;

import com.zz.back.model.ArticleEntity;
import com.zz.back.model.TagArticleEntity;
import com.zz.back.model.vo.ArticleVo;
import com.zz.back.model.vo.BaseVo;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author pierce
 */
public class BeanUtil {

    public static ArticleVo toArticle(ArticleEntity articleEntity) {
        return toArticle(articleEntity, null);
    }

    public static ArticleVo toArticle(ArticleEntity articleEntity, List<TagArticleEntity> tagList) {
        ArticleVo vo = new ArticleVo();
        BeanUtils.copyProperties(articleEntity, vo);
        if (tagList != null && tagList.size() > 0) {
            StringBuilder builder = new StringBuilder();
            for (int index = 0; index < tagList.size(); index ++) {
                builder.append(tagList.get(index).getTag().getName());
                if (index < tagList.size() - 1) {
                    builder.append(",");
                }
                vo.setTags(builder.toString());
            }
        }
        return vo;
    }

    public static <T> BaseVo<T> success(T t, String message) {
        BaseVo<T> baseVo = new BaseVo<>();
        baseVo.setCode(TurtleConstants.RESULT_SUCCESS);
        baseVo.setMessage(message);
        baseVo.setData(t);
        return baseVo;
    }

    public static <T> BaseVo<T> fail(T t, String message) {
        BaseVo<T> baseVo = new BaseVo<>();
        baseVo.setCode(TurtleConstants.RESULT_FAIL);
        baseVo.setMessage(message);
        baseVo.setData(t);
        return baseVo;
    }

    public static <T> BaseVo<T> success(String message) {
        return success(null, message);
    }

    public static <T> BaseVo<T> fail(String message) {
        return fail(null, message);
    }

}
